package Study_0324;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1600_말이되고픈원숭이 {
	static int K, H, W;
	static int matrix[][];
	static boolean v[][][];
	static int kx[] = { 2, 2, 1, 1, -1, -1, -2, -2 };
	static int ky[] = { -1, 1, 2, -2, -2, 2, -1, 1 };
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static Queue<Point> q;
	static int res;
	static boolean cango;

	static class Point {
		int x;
		int y;
		int kv;

		public Point(int x, int y, int kv) {
			this.x = x;
			this.y = y;
			this.kv = kv;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		res = 0;
		cango = false;
		q = new LinkedList<Point>();
		matrix = new int[H][W];
		v = new boolean[H][W][K + 1];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		q.add(new Point(0, 0, K));
		v[0][0][K] = true;
		bfs();

		if (cango)
			System.out.println(res);
		else
			System.out.println(-1);
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				int x = p.x;
				int y = p.y;
				if (x == H - 1 && y == W - 1) {
					cango = true;
					return;
				}
				if (p.kv > 0) {
					for (int d = 0; d < 8; d++) {
						int ix = x + kx[d];
						int jy = y + ky[d];
						if (safe(ix, jy) && !v[ix][jy][p.kv-1] && matrix[ix][jy] == 0) {
							v[ix][jy][p.kv-1] = true;
							q.add(new Point(ix, jy, p.kv - 1));
						}
					}
				}

				for (int d = 0; d < 4; d++) {
					int ix = x + dx[d];
					int jy = y + dy[d];
					if (safe(ix, jy) && !v[ix][jy][p.kv] && matrix[ix][jy] == 0) {
						v[ix][jy][p.kv] = true;
						q.add(new Point(ix, jy, p.kv));
					}
				}
			}
			res++;
		}
	}

	private static boolean safe(int ix, int jy) {
		if (ix >= 0 && jy >= 0 && ix < H && jy < W) {
			return true;
		}
		return false;
	}
}
