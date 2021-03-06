package Study_0224;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_4179_불2 {
	static int N, M;
	static int[][] matrix;
	static boolean[][] visited;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
//	static Queue<Point> fque;
	static Queue<Point> que;
	static int c, check;

	public static class Point {
		int x;
		int y;
		int f;

		public Point(int x, int y, int f) {
			this.x = x;
			this.y = y;
			this.f = f;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		matrix = new int[N][M];
		visited = new boolean[N][M];
//		fque = new LinkedList<Point>();
		que = new LinkedList<Point>();
		check = 0;
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++) {
				char c = s.charAt(j);
				if (c == '.')// 길
					matrix[i][j] = 0;
				if (c == '#')// 벽
					matrix[i][j] = -1;
				if (c == 'F') {
					matrix[i][j] = 1;
//					fque.offer(new Point(i, j));
					que.offer(new Point(i, j, 1));
				}
				if (c == 'J') {
					matrix[i][j] = 0;
					visited[i][j] = true;
					que.offer(new Point(i, j, 0));
				}
			}
		}
		c = 0;
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(matrix[i][j] + " ");
//			}
//			System.out.println();
//		}
		bfs();
		if (check == 1)
			System.out.println(c);
		else
			System.out.println("IMPOSSIBLE");

	}

	private static void bfs() {
//		while (!fque.isEmpty() || !que.isEmpty()) {
		while (!que.isEmpty()) {
			int fk = que.size();
			for (int i = 0; i < fk; i++) {
				Point p = que.poll();
				if (p.f == 1) {
					for (int d = 0; d < 4; d++) {
						int ix = p.x + dx[d];
						int jy = p.y + dy[d];
						if (ix >= 0 && jy >= 0 && ix < N && jy < M && matrix[ix][jy] == 0) {
							matrix[ix][jy] = 1;
							que.offer(new Point(ix, jy, 1));
						}
					}
				} else {
					for (int d = 0; d < 4; d++) {
						int ix = p.x + dx[d];
						int jy = p.y + dy[d];
						if (ix < 0 || jy < 0 || ix >= N || jy >= M) {
							c++;
							check = 1;
							return;
						}
						if (matrix[ix][jy] == 0 && !visited[ix][jy]) {
							visited[ix][jy] = true;
							que.offer(new Point(ix, jy, 0));
						}
					}
				}

			}
			c++;
		}

	}
}
