package Study_0506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14442_벽부수고이동하기2 {
	static int N, M, K;
	static int map[][];
	static int v[][][];

	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static Queue<Point> q;
	static int res;

	public static class Point {
		int x, y, boom;

		public Point(int x, int y, int boom) {
			this.x = x;
			this.y = y;
			this.boom = boom;

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()) + 1;
		map = new int[N][M];
		v = new int[K][N][M];// 쓴 폭탄수 , x,y
		res = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		for (int k = 0; k < K; k++) {
			for (int i = 0; i < N; i++) {
				Arrays.fill(v[k][i], Integer.MAX_VALUE);
			}
		}
		q = new LinkedList<>();
		q.add(new Point(0, 0, 0));
		v[0][0][0] = 0;

		solve();
		System.out.println(res == Integer.MAX_VALUE ? -1 : res + 1);
	}

	private static void solve() {
		int depth = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				int b = p.boom;
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (!safe(ix, jy))
						continue;
					if (b == K - 1 && map[ix][jy] == 1)
						continue;
					if (map[ix][jy] == 1 && v[b + 1][ix][jy] > depth) {
						v[b + 1][ix][jy] = depth;
						q.add(new Point(ix, jy, b + 1));
					} else if (map[ix][jy] == 0 && v[b][ix][jy] > depth) {
						v[b][ix][jy] = depth;
						q.add(new Point(ix, jy, b));
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
