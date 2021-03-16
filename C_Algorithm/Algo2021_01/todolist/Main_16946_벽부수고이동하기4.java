package todolist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16946_벽부수고이동하기4 {

		static int N, M;
		static int map[][];
		static boolean v[][];
		static Queue<Point> q;
		static int dy[] = { 0, 1, 0, -1 };
		static int dx[] = { 1, 0, -1, 0 };
		static int res;

		public static class Point {
			int y, x;

			public Point(int y, int x) {
				this.y = y;
				this.x = x;
			}
		}

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = s.charAt(j)-'0';
				}
			}
			v = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0 && !v[i][j]) {
						q = new LinkedList<>();
						v[i][j] = true;
						q.add(new Point(i, j));
						solve();
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					sb.append(map[i][j] % 10);
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
		}

		private static void solve() {
			int cnt = 1;
			Queue<Point> addQ = new LinkedList<>();
			boolean addv[][] = new boolean[N][M];
			while (!q.isEmpty()) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					Point p = q.poll();
					for (int d = 0; d < 4; d++) {
						int jy = p.y + dy[d];
						int ix = p.x + dx[d];
						if (!safe(jy, ix))
							continue;
						if (map[jy][ix] == 0) {
							if (!v[jy][ix]) {
								v[jy][ix] = true;
								cnt++;
								q.add(new Point(jy, ix));
							}
						} else {
							if (!addv[jy][ix]) {
								addv[jy][ix] = true;
								addQ.add(new Point(jy, ix));
							}
						}
					}
				}
				
			}
			while (!addQ.isEmpty()) {
				Point p = addQ.poll();
				map[p.y][p.x] += cnt;
			}
		}

		private static boolean safe(int jy, int ix) {
			if (jy >= 0 && ix >= 0 && jy < N && ix < M)
				return true;
			return false;
		}
	}
