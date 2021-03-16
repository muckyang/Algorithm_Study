package Month03_Week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1932_정수삼각형 {
	static int N;
	static int matrix[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			matrix[i] = new int[i + 1];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < i + 1; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i + 1; j++) {
				if (j == 0) {
					matrix[i][j] += matrix[i - 1][j];
				} else if (j == i) {
					matrix[i][j] += matrix[i - 1][j - 1];
				} else {
					int a = matrix[i - 1][j];
					int b = matrix[i - 1][j - 1];
					matrix[i][j] += a > b ? a : b;
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int j = 0; j < N; j++) {
			if (max < matrix[N - 1][j])
				max = matrix[N - 1][j];
		}
		System.out.println(max);
	}
}
