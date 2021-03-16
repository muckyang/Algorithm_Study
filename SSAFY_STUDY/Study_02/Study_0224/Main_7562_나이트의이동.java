package Study_0224;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_7562_나이트의이동 {
	static int T, N;
	static int sx, sy, ex, ey, cnt;
	static boolean[][] visited;
	static int[] dx = { 2, 2, 1, 1, -1, -1, -2, -2 };
	static int[] dy = { 1, -1, 2, -2, -2, 2, -1, 1 };
	static Queue<Point> que;

	private static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			N = sc.nextInt();
			visited = new boolean[N][N];

			que = new LinkedList<Point>();
			sx = sc.nextInt();
			sy = sc.nextInt();
			ex = sc.nextInt();
			ey = sc.nextInt();
			visited[sx][sy] = true;
			que.add(new Point(sx, sy));
			cnt = 0;
			bfs();
			System.out.println(cnt);
		}
	}

	private static void bfs() {
		while (!que.isEmpty()) {
			int s = que.size();
			for (int k = 0; k < s; k++) {
				Point p = que.poll();
				if(p.x ==ex && p.y ==ey) {
					return;
				}
				for (int d = 0; d < 8; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (safe(ix, jy) && !visited[ix][jy]) {
						visited[ix][jy] = true;
						que.add(new Point(ix, jy));
					}
				}
			}
			cnt++;
		}

	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		return false;
	}
}
