package Study_0228;

import java.util.Scanner;

public class Solution_D4_7208_지도칠하기 {
	static int T, N;
	static int[] color;
	static int[][] matrix;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			color = new int[N];
			matrix = new int[N][N];

			for (int i = 0; i < N; i++) {
				color[i] = sc.nextInt();
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}
			
			
		}
	}
}
