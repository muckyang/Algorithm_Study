package Study_0416;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class exam01 {
	static int T;
	static int dx[] = { 0, 1, 0, -1, 1, 1, -1, -1 };
	static int dy[] = { 1, 0, -1, 0, 1, -1, 1, -1 };
	static Queue<Point> q;
	static int map[][];
	static boolean v[][];

	static class Point {
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
		for (int tc = 0; tc < T; tc++) {
			int cnt = 0;
			q = new LinkedList<Point>();
			map = new int[10][10];
			v = new boolean[10][10];
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (!v[i][j] && map[i][j] == 1) {
						v[i][j] = true;
						cnt++;
						q.add(new Point(i, j));
						bfs();
					}
				}
			}
			System.out.println("#" + (1 + tc) + " " + cnt);
		}

	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				int x = p.x;
				int y = p.y;
				for (int d = 0; d < 8; d++) {
					int ix = x + dx[d];
					int jy = y + dy[d];
					if (safe(ix, jy) && !v[ix][jy] && map[ix][jy] == 1) {
						v[ix][jy] = true;
						q.add(new Point(ix, jy));
					}
				}

			}
		}
	}

	private static boolean safe(int ix, int jy) {
		if (ix >= 0 && jy >= 0 && ix < 10 && jy < 10)
			return true;
		return false;
	}
}
