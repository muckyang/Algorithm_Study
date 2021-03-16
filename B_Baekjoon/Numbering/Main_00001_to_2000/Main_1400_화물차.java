package Main_00001_to_2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1400_화물차 {
	static int N, M;
	static int map[][];
	static int v[][];
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static Queue<Point> q;
	static Traffic[] tlist;

	static int tcnt, sx, sy, ex, ey, min;

	public static class Point {
		int x, y, time;

		public Point(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;

		}
	}

	public static class Traffic {
		int x, y;
		boolean def;
		int a, b;

		public Traffic(int x, int y, boolean def, int a, int b) {
			this.x = x;
			this.y = y;
			this.def = def;
			this.a = a;
			this.b = b;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0)
				break;
			tcnt = 0;
			map = new int[N][M];
			v = new int[N][M];
			tlist = new Traffic[10];
			q = new LinkedList<>();
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				Arrays.fill(v[i], Integer.MAX_VALUE);
				for (int j = 0; j < M; j++) {
					char c = s.charAt(j);
					if (c == 'A') {
						sx = i;
						sy = j;
					} else if (c == 'B') {
						ex = i;
						ey = j;
					} else if (c == '.') {
						map[i][j] = -1;
					} else if (c == '#') {
						map[i][j] = 0;
					} else {
						int num = c - '0';
						tlist[num] = new Traffic(0, 0, true, 0, 0);
						tcnt++;
						tlist[num].x = i;
						tlist[num].y = j;
						map[i][j] = num + 1;// 1~ 9
					}
				}
			}
			for (int i = 0; i < tcnt; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				char c = st.nextToken().charAt(0);
				if (c == '-')
					tlist[num].def = false;// -
				else if (c == '|')
					tlist[num].def = true;// |
				tlist[num].a = Integer.parseInt(st.nextToken());
				tlist[num].b = Integer.parseInt(st.nextToken());
			}
//			// 입력 끝

			q.add(new Point(sx, sy, 0));
			v[sx][sy] = 0;
			solve();

			System.out.println(min != Integer.MAX_VALUE ? min : "impossible");
			br.readLine();
		}
	}

	private static void solve() {
		while (!q.isEmpty()) {
			Point p = q.poll();
			if (min < p.time)
				continue;
			if (p.x == ex && p.y == ey) {
				if (min > p.time)
					min = p.time;
				continue;
			}
			for (int d = 0; d < 4; d++) {
				int ix = p.x + dx[d];
				int jy = p.y + dy[d];
				if (!safe(ix, jy) || map[ix][jy] == -1)
					continue;
				if (map[ix][jy] == 0 && v[ix][jy] > p.time + 1) {
					v[ix][jy] = p.time + 1;
					q.add(new Point(ix, jy, p.time + 1));
				} else if (v[ix][jy] > p.time + 1) {// 진행할곳이 교차로 일때
					int num = map[ix][jy] - 1;
					int a = tlist[num].a; // 동서
					int b = tlist[num].b; // 남북
					int s = a + b;
					int st = p.time % s;
					if (d % 2 == 0) {// 세로진행시
						if (tlist[num].def) { // 시작이 | 일떄
							if (st < b) {
								if (v[ix][jy] > p.time + 1) {
									v[ix][jy] = p.time + 1;
									q.add(new Point(ix, jy, p.time + 1));
								}
							} else if (v[ix][jy] > p.time + s - st + 1) {
								v[ix][jy] = p.time + s - st + 1;
								q.add(new Point(ix, jy, p.time + s - st + 1));
							}
						} else { // 시작이 - 일때
							if (st < a) {
								if (v[ix][jy] > p.time + a - st + 1) {
									v[ix][jy] = p.time + a - st + 1;
									q.add(new Point(ix, jy, p.time + a - st + 1));
								}
							} else if (v[ix][jy] > p.time + 1) {
								v[ix][jy] = p.time + 1;
								q.add(new Point(ix, jy, p.time + 1));
							}
						}
					} else {// 가로진행시
						if (!tlist[num].def) { // 시작이 - 일떄
							if (st < a) {
								if (v[ix][jy] > p.time + 1) {
									v[ix][jy] = p.time + 1;
									q.add(new Point(ix, jy, p.time + 1));
								}
							} else if (v[ix][jy] > p.time + s - st + 1) {
								v[ix][jy] = p.time + s - st + 1;
								q.add(new Point(ix, jy, p.time + s - st + 1));
							}
						} else { // 시작이 | 일때
							if (st < b) {
								if (v[ix][jy] > p.time + b - st + 1) {
									v[ix][jy] = p.time + b - st + 1;
									q.add(new Point(ix, jy, p.time + b - st + 1));
								}
							} else if (v[ix][jy] > p.time + 1) {
								v[ix][jy] = p.time + 1;
								q.add(new Point(ix, jy, p.time + 1));
							}
						}
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
