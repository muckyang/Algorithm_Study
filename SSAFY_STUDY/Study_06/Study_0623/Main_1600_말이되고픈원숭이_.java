package Study_0623;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이_ {
	static int K, N, M;
	static boolean[][][] v;
	static int map[][];
	static Queue<Point> q;

	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static int hx[] = { 2, 2, 1, 1, -1, -1, -2, -2 };
	static int hy[] = { 1, -1, -2, 2, -2, 2, -1, 1 };
	static int res;

	static class Point {
		int x, y, k;

		public Point(int x, int y, int k) {
			this.x = x;
			this.y = y;
			this.k = k;

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[K + 1][N][M];
		q = new LinkedList<>();
		res = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		q.add(new Point(0, 0, K));
		solve();
		System.out.println(res);
	}

	private static void solve() {
		int depth = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				if (p.x == N - 1 && p.y == M - 1) {
					res = depth;
					return;
				}
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (!safe(ix, jy) || v[p.k][ix][jy] || map[ix][jy] == 1)
						continue;
					v[p.k][ix][jy] = true;
					q.add(new Point(ix, jy, p.k));
				}
				if (p.k > 0) {
					for (int d = 0; d < 8; d++) {
						int ix = p.x + hx[d];
						int jy = p.y + hy[d];
						if (!safe(ix, jy) || v[p.k - 1][ix][jy] || map[ix][jy] == 1)
							continue;
						v[p.k - 1][ix][jy] = true;
						q.add(new Point(ix, jy, p.k - 1));
					}
				}
			}
			depth++;
		}
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < M)
			return true;
		return false;
	}
}
