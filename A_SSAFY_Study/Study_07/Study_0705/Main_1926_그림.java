package Study_0705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1926_그림 {
	static int N, M;
	static int map[][];
	static boolean v[][];
	static Queue<Point> q;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static int count, res;

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
		v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		count = 0;
		res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !v[i][j]) {
					q.add(new Point(i, j));
					v[i][j] = true;
					solve(i, j);
					count++;
				}
			}
		}
		System.out.println(count);
		System.out.println(res);
	}

	private static void solve(int x, int y) {
		int k = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Point p = q.poll();
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (!safe(ix, jy) || v[ix][jy] || map[ix][jy] == 0)
						continue;
					v[ix][jy] = true;
					k++;
					q.add(new Point(ix, jy));

				}
			}
		}
		res = Math.max(res, k);
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < M)
			return true;
		return false;
	}
}