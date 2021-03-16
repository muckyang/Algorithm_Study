package Study_0507;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2665_미로만들기 {
	static int N;
	static int map[][];
	static int minc[][];
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

	static int res;
	static Queue<Point> q;

	public static class Point {
		int x, y, zc;

		public Point(int x, int y, int zc) {
			this.x = x;
			this.y = y;
			this.zc = zc;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		q = new LinkedList<>();
		map = new int[N][N];
		minc = new int[N][N];
		res = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			Arrays.fill(minc[i], Integer.MAX_VALUE);
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		minc[0][0] = 0;
		q.add(new Point(0, 0, 0));
		solve();
		System.out.println(res == Integer.MAX_VALUE ? 0 : res);

	}

	private static void solve() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				if (p.x == N - 1 && p.y == N - 1) {
					res = Math.min(res, p.zc);
					continue;
				}
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (!safe(ix, jy))
						continue;
					if (minc[ix][jy] > p.zc + 1 && map[ix][jy] == 0) {
						minc[ix][jy] = p.zc + 1;
						q.add(new Point(ix, jy, p.zc + 1));
					} else if (minc[ix][jy] > p.zc && map[ix][jy] == 1) {
						minc[ix][jy] = p.zc;
						q.add(new Point(ix, jy, p.zc));
					}

				}
			}
		}
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		return false;
	}
}
