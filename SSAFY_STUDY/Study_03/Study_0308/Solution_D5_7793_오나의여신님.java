package Study_0308;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D5_7793_오나의여신님 {
	static int T, N, M;
	static int[][] matrix;
	static boolean[][] v;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static int res,check;
	static int sx, sy, ex, ey;
	static Queue<Point> q;

	private static class Point {
		int x;
		int y;
		int v;

		private Point(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.v = v;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			q = new LinkedList<Point>();
			v = new boolean[N][M];
			matrix = new int[N][M];
			res = 0;
			check = 0;
			sx = sy = ex = ey = -1;
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				for (int j = 0; j < M; j++) {
					char c = s.charAt(j);
					if (c == 'S') {
						sx = i;
						sy = j;
					} else if (c == 'D') {
						ex = i;
						ey = j;
						matrix[i][j] = 2;
					} else if (c == 'X') {// 돌
						matrix[i][j] = -1;
					} else if (c == '*') {
						matrix[i][j] = 1;
						q.add(new Point(i, j, 1));
					}
				}
			}

			q.add(new Point(sx, sy, 0));
			v[sx][sy] = true;
			bfs();

			System.out.println("#" + tc + " " + (check == 0 ? "GAME OVER" : res));
		}
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();
			if(end(ex,ey)) {
				return;
			}
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				if (p.v == 1) {// 손아귀 이면
					for (int d = 0; d < 4; d++) {
						int ix = p.x + dx[d];
						int jy = p.y + dy[d];
						if (safe(ix, jy) && matrix[ix][jy] == 0) {
							matrix[ix][jy] = 1;
							q.add(new Point(ix, jy, 1));// 손아귀 추가
						}
					}
				} else {// 수연이 이동
					for (int d = 0; d < 4; d++) {
						int ix = p.x + dx[d];
						int jy = p.y + dy[d];
						if (safe(ix, jy) && (matrix[ix][jy] == 0 || matrix[ix][jy] == 2) && !v[ix][jy]) {
							v[ix][jy] = true;
							if (ix == ex && jy == ey) {
								check = 1;
								res++;
								return;
							}
							q.add(new Point(ix, jy, 0));// 수연이가 갈 수 있는곳 추가
						}
					}
				}
			}
			res++;
			
		}
	}

	private static boolean end(int x, int y) {
		for (int d = 0; d < 4; d++) {
			int ix = x + dx[d];
			int jy = y + dy[d];
			if (safe(ix, jy) && matrix[ix][jy] == 0) {
				return false;
			}
		}
		return true;
	}

	private static boolean safe(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= M) {
			return false;
		}
		return true;
	}
}
