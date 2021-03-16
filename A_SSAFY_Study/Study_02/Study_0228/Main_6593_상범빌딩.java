package Study_0228;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_6593_상범빌딩 {
	static int L, R, C;
	static boolean[][][] v;
	static int[] dx = { 1, -1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, 1, -1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };
	static int sx, sy, sz, ex, ey, ez, escape, res;
	static Queue<Point> que;

	private static class Point {
		int x;
		int y;
		int z;

		public Point(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			escape = 0;
			res = 0;
			L = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			sx = sy = sz = ex = ey = ez = -1;
			if (L == 0 && R == 0 && C == 0)
				return;

			v = new boolean[L][R][C];
			que = new LinkedList<Point>();
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String s = sc.next();
					for (int k = 0; k < C; k++) {
						char c = s.charAt(k);
						if (c == '#') {
							v[i][j][k] = true;
						} else if (c == '.') {
							v[i][j][k] = false;

						} else if (c == 'S') {
							sz = i;
							sx = j;
							sy = k;
							v[i][j][k] = false;
						} else if (c == 'E') {
							ez = i;
							ex = j;
							ey = k;
							v[i][j][k] = false;
						}

					}
				}
			}
			v[sz][sx][sy] = true;
			que.add(new Point(sx, sy, sz));
			// 입력끝
			bfs();
			if (escape == 1)
				System.out.println("Escaped in " + res + " minute(s).");
			else
				System.out.println("Trapped!");
		}
	}

	private static void bfs() {
		while (!que.isEmpty()) {
			int k = que.size();
			for (int i = 0; i < k; i++) {
				Point p = que.poll();
				for (int d = 0; d < 6; d++) {
					int iz = p.z + dz[d];
					int iy = p.y + dy[d];
					int ix = p.x + dx[d];
					if (safe(ix, iy, iz) && !v[iz][ix][iy] ) {
						if (iz == ez && ix == ex && iy == ey) {
							escape = 1;
							res++;
							return;
						}
						v[iz][ix][iy] = true;
						que.add(new Point(ix, iy, iz));
					}
				}
			}
			res++;
		}

	}

	private static boolean safe(int x, int y, int z) {
		if (x >= 0 && y >= 0 && z >= 0 && x < R && y < C && z < L)
			return true;
		return false;

	}
}
