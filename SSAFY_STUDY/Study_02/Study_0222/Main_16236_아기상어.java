package Study_0222;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_16236_아기상어 {
	static int N;
	static int level;
	static int levelUpC[] = { 0, 0, 2, 3, 4, 5, 6, 400 };
	static int[][] matrix;
	static boolean[][] visited;
	static int sx, sy, times;
	static int time;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static Queue<Point> que;

	private static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static void func() {
		visited = new boolean[N][N];
		visited[sx][sy] = true;
		if (hasMoreMinigogi()) {// 작은고기 있을때.
			while (!que.isEmpty()) {
				int k = que.size();
				boolean feed = false;
				int tx = Integer.MAX_VALUE;
				int ty = Integer.MAX_VALUE;
				for (int i = 0; i < k; i++) {
					Point p = que.poll();
					if (!feed && matrix[p.x][p.y] < level && matrix[p.x][p.y] != 0) {
						feed = true;
						tx = p.x;
						ty = p.y;
						
					} else if (feed && matrix[p.x][p.y] < level && matrix[p.x][p.y] != 0) {
						if (tx > p.x || (tx == p.x && ty > p.y)) {
							tx = p.x;
							ty = p.y;
						}

					}

					for (int d = 0; d < 4; d++) {
						int ix = p.x + dx[d];
						int jy = p.y + dy[d];
						if (ix >= 0 && jy >= 0 && ix < N && jy < N && !visited[ix][jy] && matrix[ix][jy] <= level) {
							visited[ix][jy] = true;
							que.add(new Point(ix, jy));
						}

					}

				}
				if (feed) {
					que.clear();
					if (levelUpC[level] == 1) {
						level++;
					} else {
						levelUpC[level]--;
					}
					que.offer(new Point(tx, ty));
					matrix[sx][sy] = 0;
					sx = tx;
					sy = ty;
					matrix[tx][ty] = 0;
					times += time;
					time= 0;
					if (hasMoreMinigogi())
						func();
					return;
				}

				time++;
			}

		}
	}

	private static boolean hasMoreMinigogi() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[i][j] < level && matrix[i][j] != 0)
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		matrix = new int[N][N];
		time = 0;
		que = new LinkedList<Point>();
		times = 0;
		level = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = sc.nextInt();
				if (matrix[i][j] == 9) {
					sx = i;
					sy = j;
				}
			}
		}

		que.offer(new Point(sx, sy));
		func();

		System.out.println(times);
	}

}
