package Main_00001_to_2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1726_로봇 {
	static int N, M;
	static int map[][];
	static int v[][][];

	static int sx, sy, sd;
	static int ex, ey, ed;
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	static Queue<Point> q;
	static int min;

	public static class Point {
		int x;
		int y;
		int d;
		int depth;

		public Point(int x, int y, int d, int depth) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.depth = depth;

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new int[4][N][M];
		q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int k = 0; k < 4; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					v[k][i][j] = Integer.MAX_VALUE;
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken()) - 1;
		sy = Integer.parseInt(st.nextToken()) - 1;
		sd = Integer.parseInt(st.nextToken()) - 1;
		v[sd][sx][sy] = 0;
		q.add(new Point(sx, sy, sd, 0));
		st = new StringTokenizer(br.readLine());
		ex = Integer.parseInt(st.nextToken()) - 1;
		ey = Integer.parseInt(st.nextToken()) - 1;
		ed = Integer.parseInt(st.nextToken()) - 1;

		min = Integer.MAX_VALUE;
		bfs();

		System.out.println(min);
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			Point p = q.poll();
			if (p.x == ex && p.y == ey) {
				int chai = 0;
				if (ed == p.d) {
					chai = 0;
				} else if (ed < 2 && p.d > 1) {
					chai = 1;
				} else if (ed > 1 && p.d < 2) {
					chai = 1;
				} else {
					chai = 2;
				}

				p.depth += chai;
				if (min > p.depth)
					min = p.depth;
				continue;
			}

			for (int d = 0; d < 4; d++) {
				int x = p.x;
				int y = p.y;
				int depth = p.depth;

				int chai = 0;

				/// left : 0 right : 1 up : 2 down : 3
				if (d == p.d) {
					chai = 0;
				} else if (d < 2 && p.d > 1) {
					chai = 1;
				} else if (d > 1 && p.d < 2) {
					chai = 1;
				} else {
					chai = 2;
				}

				depth += chai;

				for (int k = 0; k < 3; k++) {
					int ix = x + dx[d];
					int jy = y + dy[d];
					if (!safe(ix, jy) || map[ix][jy] == 1)
						break;
					else if (map[ix][jy] == 0) {
						if (v[d][ix][jy] > depth) {
							v[d][ix][jy] = depth;
							q.add(new Point(ix, jy, d, depth + 1));
						}
						x = ix;
						y = jy;
					}
				}
			}

		}
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < M)
			return true;
		return false;
	}
}
