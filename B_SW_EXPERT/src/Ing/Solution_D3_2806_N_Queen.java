package Ing;

import java.util.Scanner;

public class Solution_D3_2806_N_Queen {
	static int T, N;
	static int[] list;
	static boolean[][] matrix;
	static int[] dx = { 0, 1, 0, 1 };
	static int[] dy = { 1, 1, 1, -1 };
	static int result;

	public static void Queen(int N, int count) {
		if (count == N) {
			result++;
			return;
		}


	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			list = new int[N];
			matrix = new boolean[N][N];
			result = 0;
			Queen(N, 0);

		}
	}
}
