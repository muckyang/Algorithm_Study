package Study_0208;

import java.util.Scanner;

public class Solution_D3_1206_View {
	static int[][] matrix;

	static int T, N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case < 11; test_case++) {

			N = sc.nextInt();
			int count = 0;
			matrix = new int[255][1000];
			for (int i = 0; i < N; i++) {
				int k = sc.nextInt();
				for (int j = 0; j < k; j++) {
					matrix[j][i] = 1;
				}
			}

			for (int i = 2; i < N-2; i++) {
				for (int j = 0; j < 255; j++) {
					if (matrix[j][i] == 1 && matrix[j][i + 1] == 0 && matrix[j][i + 2] == 0 && matrix[j][i - 1] == 0
							&& matrix[j][i - 2] == 0)
						count++;
				}
			}
			System.out.println("#" + test_case + " " + count);
		}
	}
}
