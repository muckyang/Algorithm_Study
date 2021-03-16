package Study_0305;

import java.util.Scanner;

public class Solution_D4_2105_디저트카페 {
	static int T, N;
	static int[][] m;
	static boolean[] v;
	static int[] dx = { -1, 1, 1, -1 };
	static int[] dy = { 1, 1, -1, -1 };
	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			m = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					m[i][j] = sc.nextInt();
				}
			}
			res = -1;
			for (int su = N - 1; su > 1; su--) {
				func(su);
				if (res != -1)
					break;
			}

			System.out.println("#" + tc + " " + res);
		}
	}

	private static void func(int su) {
		for (int x = su - 1; x > 0; x--) {

			int y = su - x;
			for (int sx = x; sx < N - y; sx++) {
				for (int sy = 0; sy < N - (x + y); sy++) {
					rotate(x, y, sx, sy);
					if (res != -1)
						return;
				}
			}
		}
	}

	private static void rotate(int x, int y, int sx, int sy) {
		v = new boolean[101];
		for (int d = 0; d < 4; d++) {
			if (d % 2 == 0) {
				for (int i = 0; i < x; i++) {
					sx = sx + dx[d];
					sy = sy + dy[d];
					if (v[m[sx][sy]]) {
						return;
					}
					v[m[sx][sy]] = true;
				}
			} else {
				for (int i = 0; i < y; i++) {
					sx = sx + dx[d];
					sy = sy + dy[d];
					if (v[m[sx][sy]]) {
						return;
					}
					v[m[sx][sy]] = true;
				}
			}
		}
		res = 2 * (x + y);
		return;

	}
}
