package Study_1020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1992_쿼드트리 {
	static int N;
	static int map[][];
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		solve(0, 0, N);

		System.out.println(sb.toString());

	}

	private static void solve(int y, int x, int size) {
		int sum = 0;
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				sum += map[i][j];
			}
		}
		if (sum == 0) {
			sb.append("0");
		} else if (sum == size * size) {
			sb.append("1");
		} else {
			sb.append("(");
			for (int a = 0; a < 2; a++) {
				for (int b = 0; b < 2; b++) {
					solve(y + (a * size / 2), x + (b * size / 2), size / 2);
				}
			}
			sb.append(")");
		}
	}
}
