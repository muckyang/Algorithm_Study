package Study_0514;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10711_모래성 {
	static int N, M;
	static int map[][];
	static int sand[][];
	static boolean v[][];
	static Queue<Point> q;

	static int dx[] = { 0, 1, 0, -1, 1, 1, -1, -1 };
	static int dy[] = { 1, 0, -1, 0, -1, 1, 1, -1 };
	static int cnt;

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		q = new LinkedList<>();
		map = new int[N][M];
		sand = new int[N][M];
		v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = s.charAt(j);
				if (c == '.') {
					map[i][j] = 0;
					for (int d = 0; d < 8; d++) {
						int ix = i + dx[d];
						int jy = j + dy[d];
						if (!safe(ix, jy))
							continue;
						sand[ix][jy]++;

					}
				} else
					map[i][j] = Integer.parseInt(c + "");
			}
		}
		 cnt = 0;
//		print();
		solve();
		System.out.println(cnt);

	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < M)
			return true;
		return false;
	}

	private static void solve() {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && map[i][j] <= sand[i][j]) {
					v[i][j] = true;
					q.add(new Point(i, j));
				}
			}
		}
		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				map[p.x][p.y] = 0;
				for (int d = 0; d < 8; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (!safe(ix, jy) || map[ix][jy] == 0 || v[ix][jy])
						continue;
					sand[ix][jy]++;
					if (map[ix][jy] <= sand[ix][jy]) {
						v[ix][jy] = true;
						q.add(new Point(ix, jy));
					}
				}
			}
		}
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(sand[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
