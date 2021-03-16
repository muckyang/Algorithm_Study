package Study_0326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_달이차오른다가자 {
	static int N, M;
	static boolean v[][][];
	static char map[][];
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static int sx, sy;
	static int res;
	static Queue<Point> q;
	static boolean check;

	static class Point {
		int x;
		int y;
		int key;

		public Point(int x, int y, int key) {
			this.x = x;
			this.y = y;
			this.key = key;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		res = 0;
		v = new boolean[N][M][64];
		q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == '0') {
					sx = i;
					sy = j;
				}
			}
		}

		v[sx][sy][0] = true;
		q.add(new Point(sx, sy, 0));
		bfs();
		if (check)
			System.out.println(res);
		else
			System.out.println(-1);
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				if (map[p.x][p.y] == '1') {
					check = true;
					return;
				}
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (safe(ix, jy) && map[ix][jy] != '#') {
						char c = map[ix][jy];
						if ((c == '.' || c == '1' || c == '0') && !v[ix][jy][p.key]) {
							v[ix][jy][p.key] = true;
							q.add(new Point(ix, jy, p.key));
						} else if (0 <= c - 'a' && c - 'a' <= 5 && !v[ix][jy][p.key | 1 << (c - 'a')]) {
							v[ix][jy][p.key | (1 << (c - 'a'))] = true;
							q.add(new Point(ix, jy, p.key | (1 << c - 'a')));
						} else if ((0 <= c - 'A' && c - 'A' <= 5) && ((p.key & (1 << c - 'A')) != 0)
								&& !v[ix][jy][p.key]) {
							v[ix][jy][p.key] = true;
							q.add(new Point(ix, jy, p.key));
						}
					}
				}
			}
			res++;
		}
	}

	private static boolean safe(int ix, int jy) {
		if (ix < 0 || jy < 0 || ix >= N || jy >= M)
			return false;
		return true;
	}
}
