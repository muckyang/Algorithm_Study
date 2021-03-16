package Platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9376_탈옥 {
	static int T, N, M;
	static int map[][];
	static int ckey[][];
	static boolean v[][];
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

	static int res, sx, sy, ex, ey;
	static Queue<Point> q;

	public static class Point {
		int x;
		int y;
		int ukey;
		Point prev;

		public Point(int x, int y, int ukey, Point prev) {
			this.x = x;
			this.y = y;
			this.ukey = ukey;
			this.prev = prev;

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		String s;
		for (int t = 0; t < T; t++) {
			boolean check = false;
			sx = sy = ex = ey = -1;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N + 2][M + 2];
			ckey = new int[N + 2][M + 2];
			v = new boolean[N + 2][M + 2];
			q = new LinkedList<>();
			res = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				s = br.readLine();
				for (int j = 1; j <= M; j++) {
					char c = s.charAt(j);
					ckey[i][j] = Integer.MAX_VALUE;
					if (c == '.') {

					} else if (c == '#') {
						map[i][j] = 1;// 문
					} else if (c == '*') {
						map[i][j] = -1;// 벽
					} else if (c == '$') {// 죄수
						if (!check) {
							sx = i;
							sy = j;
							check = true;
						} else {
							ex = i;
							ey = j;
						}
					}
				}
			}
			// 입력 끝
			q.add(new Point(0, 0, 0, null));
			bfs();
			print();
			System.out.println(res);
		}
	}

	private static void print() {
		for (int i = 0; i <= N + 1; i++) {
			for (int j = 0; j <= M + 1; j++) {
				System.out.print(ckey[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (!safe(ix, jy) || map[ix][jy] == -1)
						continue;
					if (ckey[ix][jy] > p.ukey && map[ix][jy] == 0) {
						ckey[ix][jy] = p.ukey;
						q.add(new Point(ix, jy, p.ukey, p));
					} else if (ckey[ix][jy] == p.ukey && !v[ix][jy] && map[ix][jy] == 0) {
						v[ix][jy] = true;
						q.add(new Point(ix, jy, p.ukey, p));
					} else if (map[ix][jy] == 1 && ckey[ix][jy] > p.ukey + 1) {
						ckey[ix][jy] = p.ukey + 1;
						q.add(new Point(ix, jy, p.ukey + 1, p));
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
