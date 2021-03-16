package Study_0224;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1103_게임_런타임에러 {
	static int N, M;
	static int[][] matrix;
	static boolean[][] visited;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int res;
	static Queue<Point> que;

	private static void bfs() {
		int cnt = 0;
		while (!que.isEmpty()) {
			int k = que.size();
			for (int i = 0; i < k; i++) {
				Point p = que.poll();
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d] * p.size;
					int jy = p.y + dy[d] * p.size;
					if (ix >= 0 && jy >= 0 && ix < N && jy < M && !visited[ix][jy] && matrix[ix][jy] != -1) {
						visited[ix][jy] = true;
						que.offer(new Point(ix, jy, matrix[ix][jy]));
					}
				}

			}

			cnt++;
			res = cnt;
		}
	}

	public static class Point {
		int x;
		int y;
		int size;

		public Point(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		que = new LinkedList<Point>();
		matrix = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++) {
				if (s.charAt(j) == 'H') {
					matrix[i][j] = -1;
					continue;
				}
				matrix[i][j] = s.charAt(j) - 48;
			}
		}
		res = Integer.MIN_VALUE;
		que.offer(new Point(0, 0, matrix[0][0]));
		visited = new boolean[N][M];
		visited[0][0] = true;
		bfs();
		System.out.println(res);
	}
}
