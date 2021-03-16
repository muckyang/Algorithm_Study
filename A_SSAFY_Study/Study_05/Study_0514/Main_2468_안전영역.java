package Study_0514;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {
	static int N;
	static int map[][];
	static boolean v[][];
	static Queue<Point> q;

	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

	static int res;

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
		map = new int[N][N];
		res = 1;
		q= new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int day = 1;
		while (true) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == day)
						map[i][j] = 0;
				}
			}
			int cnt = countall();
			if(cnt == 0 || day == 101)
				break;
			res = Math.max(cnt, res);
			day++;
			
		}
		System.out.println(res);
	}

	private static int countall() {
		v = new boolean[N][N];
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0 && !v[i][j]) {
					v[i][j] = true;
					count++;
					q.add(new Point(i, j));
					bfs();
				}
			}
		}

		return count;
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int ix = p.x + dx[d];
				int jy = p.y + dy[d];
				if (!safe(ix, jy) || map[ix][jy] == 0 || v[ix][jy])
					continue;
				v[ix][jy] = true;
				q.add(new Point(ix, jy));
			}
		}

	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		return false;
	}
}
