package partition3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16933_벽부수고이동하기3 {

	static int N, M, K;
	static Queue<Wall> q;
	static boolean map[][];
	static boolean v[][][][];
	static int dy[] = { 0, 0, 1, 0, -1 };
	static int dx[] = { 0, 1, 0, -1, 0 };
	static int res;

	public static class Wall {
		int y, x;
		boolean daynight;
		int k, depth;

		public Wall(int y, int x, boolean daynight, int k, int depth) {
			this.y = y;
			this.x = x;
			this.daynight = daynight;
			this.k = k;
			this.depth = depth;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		v = new boolean[K + 1][2][N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				if (s.charAt(j) == '0') {
					map[i][j] = true;
				}
			}
		}
		q = new LinkedList<>();
		q.add(new Wall(0, 0, true, K, 1));
		v[K][1][0][0] = true;
		res = -1;
		solve();
		System.out.println(res);
	}

	private static void solve() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Wall w = q.poll();
				if (w.y == N - 1 && w.x == M - 1) {
					res = w.depth;
					return;
				}
				for (int d = 0; d < 5; d++) {
					int jy = w.y + dy[d];
					int ix = w.x + dx[d];
					if (!safe(jy, ix))
						continue;
					if (d == 0) {
						if ( !v[w.k][w.daynight ? 0 : 1][jy][ix]) {
							v[w.k][w.daynight ? 0 : 1][jy][ix] = true;
							q.add(new Wall(jy, ix, !w.daynight, w.k, w.depth + 1));
						}
					} else {
						if (w.k > 0 && w.daynight && !map[jy][ix] && !v[w.k - 1][w.daynight ? 0 : 1][jy][ix]) {
							v[w.k - 1][w.daynight ? 0 : 1][jy][ix] = true;
							q.add(new Wall(jy, ix, !w.daynight, w.k - 1, w.depth + 1));
						}
						if (map[jy][ix] && !v[w.k][w.daynight ? 0 : 1][jy][ix]) {
							v[w.k][w.daynight ? 0 : 1][jy][ix] = true;
							q.add(new Wall(jy, ix, !w.daynight, w.k, w.depth + 1));
						}
					}
				}

			}
		}
	}

	private static boolean safe(int jy, int ix) {
		if (jy >= 0 && ix >= 0 && jy < N && ix < M)
			return true;
		return false;
	}
}
