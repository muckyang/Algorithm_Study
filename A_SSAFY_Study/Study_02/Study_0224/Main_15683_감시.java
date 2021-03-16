package Study_0224;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_15683_감시 {
	static int N, M;
	static int[][] matrix;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[] cx, cy, cv, cd;
	static Queue<Point> que;
	static int min;
	static int camerac;

	public static class Point {
		int x;
		int y;
		int d;

		public Point(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		que = new LinkedList<Point>();
		matrix = new int[N][M];
		visited = new boolean[N][M];
		min = Integer.MAX_VALUE;
		cx = new int[8];
		cy = new int[8];
		cd = new int[8];
		cv = new int[8];
		camerac = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				matrix[i][j] = sc.nextInt();
				if (matrix[i][j] == 5) {
					que.add(new Point(i, j, -1));
				} else if (matrix[i][j] > 0 && matrix[i][j] < 5) {
					cx[camerac] = i;
					cy[camerac] = j;
					cv[camerac] = matrix[i][j];
					camerac++;
				}
			}
		}
		// 1~4 카메라수 세기

//		int mat[][] = new int[N][M];
//		for (int i = 0; i < N; i++) {
//			System.arraycopy(matrix[i], 0, mat[i], 0, mat[i].length);
//		}

		while (!que.isEmpty()) {
			Point p = que.poll();
			boolean[] b = new boolean[4];
			func(matrix, p.x, p.y, b);
		}
		// 여기까진 맞음
		allcheck(matrix, 0);
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matrix[i][j] == 0)
					count++;
			}
		}
		if (min == Integer.MAX_VALUE) {
			min = count;
		}

		System.out.println(min);

	}

	private static void allcheck(int[][] mat, int c) {

		if (c == camerac) {
			int countmat[][] = new int[N][M];
			for (int i = 0; i < N; i++) {
				System.arraycopy(mat[i], 0, countmat[i], 0, mat[i].length);
			}
			for (int k = 0; k < c; k++) {
				boolean[] ban = new boolean[4];
				if (cv[k] == 1) {
					for (int d = 0; d < 4; d++) {
						if (cd[k] == d)//한 방향 제외하고 모두 꺼버림
							continue;
						ban[d] = true;
					}
					func(countmat, cx[k], cy[k], ban);
				} else if (cv[k] == 2) {
					if (2 > cd[k]) {// 가로 or세로
						ban[cd[k]] = true;
						ban[cd[k] + 2] = true;
					} else {
						ban[cd[k]] = true;
						ban[cd[k] - 2] = true;
					}
					func(countmat, cx[k], cy[k], ban);
				} else if (cv[k] == 3) {
					ban[cd[k]] = true;
					if (cd[k] == 3)
						ban[0] = true;
					else
						ban[cd[k] + 1] = true;
					func(countmat, cx[k], cy[k], ban);
				} else if (cv[k] == 4) {
					ban[cd[k]] = true;
					func(countmat, cx[k], cy[k], ban);
				}

			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (countmat[i][j] == 0)
						cnt++;
				}
			}

			if (min > cnt)
				min = cnt;
			return;
		} else {
			for (int d = 0; d < 4; d++) {
				cd[c] = d;
				allcheck(mat, c + 1);
			}
		}

	}

	private static void func(int[][] matr, int x, int y, boolean[] ban) {
		for (int d = 0; d < 4; d++) {
			if (!ban[d]) {
				killLine(matr, x, y, dx[d], dy[d]);
			}
		}
	}

	private static void killLine(int[][] matr, int x, int y, int dx, int dy) {
		while (true) {
			x += dx;
			y += dy;
			if (x < 0 || y < 0 || x >= N || y >= M || matr[x][y] > 5) {
				break;
			} else {
				matr[x][y] = -1;
			}
		}
	}
}
