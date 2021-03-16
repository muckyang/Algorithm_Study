package Study_0503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1938_통나무옮기기 {
	static int N;
	static int map[][];
	static int v[][][];
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static int sx, sy, ex, ey, bst, est;
	static Queue<Point> q;
	static int min;

	public static class Point {
		int x, y, st, depth;

		public Point(int x, int y, int st, int depth) {
			this.x = x;
			this.y = y;
			this.st = st;
			this.depth = depth;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		v = new int[2][N][N];
		int bcnt = 0;
		int ecnt = 0;
		min = Integer.MAX_VALUE;
		bst = -1;// 0이면 가로방향 1 이면 세로방향
		est = -1;

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				char c = s.charAt(j);
				if (c == '1')
					map[i][j] = 1;
				else if (c == 'B') {
					if (bcnt == 1) {
						sx = i;
						sy = j;
					} else if (bcnt == 2) {
						if (sx == i)
							bst = 0;
						else
							bst = 1;
					}
					bcnt++;
				} else if (c == 'E') {
					if (ecnt == 1) {
						ex = i;
						ey = j;
					} else if (ecnt == 2) {
						if (ex == i)
							est = 0;
						else
							est = 1;
					}
					ecnt++;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			Arrays.fill(v[0][i], Integer.MAX_VALUE);
			Arrays.fill(v[1][i], Integer.MAX_VALUE);
		}
		v[bst][sx][sy] = 0;
		q = new LinkedList<>();
		q.add(new Point(sx, sy, bst, 0));
		solve();
		System.out.println(min != Integer.MAX_VALUE ? min : 0);
	}

	private static void solve() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				if (p.depth >= min) // 이미 구한 값보다 더 크면 의미 없음
					continue;
				if (p.x == ex && p.y == ey) {
					if (est != p.st) {
						if (poss9(ex, ey)) {
							p.depth += 1;
						} else {
							continue;
						}
					}
					if (min > p.depth)
						min = p.depth;
					continue;// 계속 진행
				}
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (p.st == 0) {// 가로방향
						if (poss(ix, jy, 0) && v[0][ix][jy] > p.depth + 1) {
							v[0][ix][jy] = p.depth + 1;
							q.add(new Point(ix, jy, 0, p.depth + 1));
						}
						if (poss9(p.x, p.y) && poss(ix, jy, 1) && v[1][ix][jy] > p.depth + 2) {
							v[1][ix][jy] = p.depth + 2;
							q.add(new Point(ix, jy, 1, p.depth + 2));
						}
					} else {// 세로방향
						if (poss9(p.x, p.y) && poss(ix, jy, 0) && v[0][ix][jy] > p.depth + 2) {
							v[0][ix][jy] = p.depth + 2;
							q.add(new Point(ix, jy, 0, p.depth + 2));
						}
						if (poss(ix, jy, 1) && v[1][ix][jy] > p.depth + 1) {
							v[1][ix][jy] = p.depth + 1;
							q.add(new Point(ix, jy, 1, p.depth + 1));
						}
					}
				}

			}
		}
	}

	private static boolean poss9(int ix, int jy) {
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (!safe(ix + i, jy + j) || map[ix + i][jy + j] == 1)
					return false;
			}
		}
		return true;
	}

	private static boolean poss(int x, int y, int st) {
		if (st == 0) {
			for (int i = -1; i < 2; i++) {
				if (!safe(x, y + i) || map[x][y + i] == 1)
					return false;
			}
		} else {
			for (int i = -1; i < 2; i++) {
				if (!safe(x + i, y) || map[x + i][y] == 1)
					return false;
			}
		}
		return true;
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		return false;
	}
}
