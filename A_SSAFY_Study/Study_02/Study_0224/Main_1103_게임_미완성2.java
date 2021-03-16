package Study_0224;

import java.util.Scanner;

public class Main_1103_게임_미완성2 {
	static int N, M;
	static int[][] matrix;
	static boolean[][] visited;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int res;

	private static void func(int x, int y, int move, int cnt) {
		for (int d = 0; d < 4; d++) {
			if (res == -1)
				return;
			int ix = x + (dx[d] * move);
			int jy = y + (dy[d] * move);
			if (ix >= 0 && jy >= 0 && ix < N && jy < M) {
				if (visited[ix][jy]) {
					res = -1;
					return;
				}

				if (matrix[ix][jy] == -1) {
					if (res < cnt+1)
						res = cnt+1;
					return;
				}

				visited[ix][jy] = true;
				func(ix, jy, matrix[ix][jy], cnt + 1);
				if (res == -1)
					return;
			}

		}
		if (res < cnt+1)
			res = cnt+1;
		return;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		matrix = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++) {
				if (s.charAt(j) == 'H') {
					matrix[i][j] = -1;
					continue;
				}
				matrix[i][j] = s.charAt(j) - 48;
			}
		}
		res = Integer.MIN_VALUE;
		visited = new boolean [N][M];
		func(0, 0, matrix[0][0], 0);
		System.out.println(res);
	}
}
