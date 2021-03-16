package Pass_Feb_Week02;

import java.util.Scanner;

public class Solution_D3_4615_오셀로게임 {
	static int T, N, C;
	static int[][] matrix;
	static int check;
	static int[] dx = { 0, 1, 0, -1, 1, 1, -1, -1 };
	static int[] dy = { 1, 0, -1, 0, -1, 1, 1, -1 };
	static boolean[] flag;

	public static void func(int x, int y, int v) {
		int check;
		int ev;
		if (v == 1) {
			ev = 2;
		} else {
			ev = 1;
		}

		for (int d = 0; d < 8; d++) {
			int ix = x + dx[d];
			int jy = y + dy[d];

			if (ix > 0 && jy > 0 && ix <= N && jy <= N && matrix[ix][jy] == ev) {
				checkLine(ix, jy, v, dx[d], dy[d]);
			}
		}
	}

	public static void checkLine(int x, int y, int target, int dx, int dy) {
		int ix = x + dx;
		int jy = y + dy;

		if (ix <= 0 || jy <= 0 || ix > N || jy > N || matrix[ix][jy] == 0) {// 벽이나 0을 만난다면?
			check = -1;
			return;
		} else if (target == matrix[ix][jy]) {// 처음 놓은돌과 같은돌을 만난다면?
			matrix[x][y] = target;
			check = 1;
			return;
		} else {
			checkLine(ix, jy, target, dx, dy);// 그외 전부 (상대돌 만난경우)
		}

		if (check == -1)// 벽을 만나서 돌아올떄
			return;
		if (check == 1) {// 처음놓은돌과 같은돌을 만난경우
			if (target == 2) {
				matrix[x][y] = 2;
				return;
			} else {
				matrix[x][y] = 1;
				return;
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			C = sc.nextInt();
			flag = new boolean[8];
			matrix = new int[N + 1][N + 1];
			matrix[N / 2][N / 2] = matrix[N / 2 + 1][N / 2 + 1] = 2;
			matrix[N / 2 + 1][N / 2] = matrix[N / 2][N / 2 + 1] = 1;

			int x, y, v;

			for (int i = 0; i < C; i++) {
				y = sc.nextInt();
				x = sc.nextInt();
				v = sc.nextInt();
				matrix[x][y] = v;
				func(x, y, v);

			}

			int b_count = 0;
			int w_count = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (matrix[i][j] == 1)
						b_count++;
					if (matrix[i][j] == 2)
						w_count++;
				}
			}

			System.out.println("#" + test_case + " " + b_count + " " + w_count);
		}

	}
}
