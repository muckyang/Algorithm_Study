package Study_0515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {
	static int N, M;
	static int map[][];
	static boolean v[][];
	static Queue<Point> q;

	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static int time, piece;

	
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
		map = new int[N][M];
		q = new LinkedList<>();
		piece = 0;
		time = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve();
		System.out.println(time);
		System.out.println(piece);
	}

	private static void solve() {
		while (true) {
			int num = counting();
			if (num == 0)
				return;
			piece = num;
			time++;
			decay();
		}
	}

	private static void decay() {
		v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i == 0 || j == 0 || i == N - 1 || j == M - 1) { // 테두리
					if (v[i][j])
						continue;
					v[i][j] = true;
					q.add(new Point(i, j));
					bfs();
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == -1)
					map[i][j] = 0;
			}
		}

	}

	private static void bfs() {
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int ix = p.x + dx[d];
				int jy = p.y + dy[d];
				if (!safe(ix, jy) || v[ix][jy])
					continue;
				v[ix][jy] = true;
				if (map[ix][jy] != 0) {
					map[ix][jy] = -1;
					continue;
				}
				q.add(new Point(ix, jy));
			}
		}

	}

	private static int counting() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1)
					cnt++;
			}
		}
		return cnt;
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < M)
			return true;
		return false;
	}
}
