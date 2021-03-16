package Study_0208;

import java.util.Scanner;

public class Solution_D3_7234_안전기지 {
	static int T, N, B;
	static int[][] matrix;
	static int[] dx = { 1, 2, -1, -2, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, 0, 0, 1, 2, -1, -2 };
	static int max;

	public static void func(int x, int y) {
		for (int d = 0; d < 8; d++) {
			int ix = x + dx[d];
			int jy = y + dy[d];
			if (ix >= 0 & jy >= 0 & ix < N && jy < N)
				matrix[ix][jy]++;

		}
	}

	public static void check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (max < matrix[i][j])
					max = matrix[i][j];
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			B = sc.nextInt();
			max = Integer.MIN_VALUE;
			matrix = new int[N][N];

			for (int i = 0; i < B; i++) {
				int x = sc.nextInt() - 1;
				int y = sc.nextInt() - 1;
				matrix[x][y]++;
				func(x, y);
			}
			check();
			System.out.println("#" + test_case + " " + max);
		}
	}
}
