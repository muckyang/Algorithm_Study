package Study_0502;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_Unknown_1949_등산로조성 {
	static int T, N, K;
	static int map[][];
	static boolean v[][];
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static Queue<Point> q;
	static int res;
	static int max;

	public static class Point {
		int x;
		int y;
		int length;
		int boom;

		public Point(int x, int y, int length, int boom) {
			this.x = x;
			this.y = y;
			this.length = length;
			this.boom = boom;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][N];
			v = new boolean[N][N];
			q = new LinkedList<>();
			max = 0;
			res = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (max < map[i][j])
						max = map[i][j];
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == max) {
						v[i][j] = true;
						dfs(i, j, 1, max, 0);
						v[i][j]= false;
//						 bfs();
					}
				}
			}

			System.out.println("#" + t + " " + res);
		}
	}

	private static void dfs(int x, int y, int count, int length, int boom) {
		if (res < count)
			res = count;
		for (int d = 0; d < 4; d++) {
			int ix = x + dx[d];
			int jy = y + dy[d];
			if (!safe(ix, jy))
				continue;

			if (boom == 0) {
				for (int k = 1; k <= K; k++) {
					if (map[ix][jy] - k < length && !v[ix][jy]) {
						v[ix][jy] = true;
						dfs(ix, jy, count + 1, map[ix][jy] - k, 1);
						v[ix][jy] = false;
					}
				}
			}
			
			if (map[ix][jy] < length && !v[ix][jy]) {
				v[ix][jy] = true;
				dfs(ix, jy, count + 1, map[ix][jy], boom);
				v[ix][jy] = false;
			}
		}
	}

//		private static void bfs() {
//			int depth = 0;
//			while (!q.isEmpty()) {
//				int size = q.size();
//				depth++;
//				for (int i = 0; i < size; i++) {
//					Point p = q.poll();
//					for (int d = 0; d < 4; d++) {
//						int ix = p.x + dx[d];
//						int jy = p.y + dy[d];
//						if (!safe(ix, jy))
//							continue;
//						if (map[ix][jy] < p.length) {
//							q.add(new Point(ix, jy, map[ix][jy], p.boom));
//						}
//						if (p.boom == 0) {
//							for (int k = 1; k <= K; k++) {
//								if (map[ix][jy] - k < p.length  && map[ix][jy] - k >= 0) {
//									q.add(new Point(ix, jy, map[ix][jy] - k, 1));
//								}
//							}
//						}
//					}
//				}
//			}
//			if (depth > res)
//				res = depth;
//		}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		return false;
	}
}
