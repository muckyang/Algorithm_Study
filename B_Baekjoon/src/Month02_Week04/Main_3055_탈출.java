package Month02_Week04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_3055_탈출 {
	static int N, M;
	static int matrix[][];
	static boolean visited[][];
	static boolean wvisited[][];
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int sx, sy, ex, ey, res;
	static Queue<Point> wque;
	static Queue<Point> sque;
	static int day, check;

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
		N = sc.nextInt();
		M = sc.nextInt();
		sx = sy = ex = ey = -1;
		wque = new LinkedList<Point>();
		sque = new LinkedList<Point>();
		visited = new boolean[N][M];
		wvisited = new boolean[N][M];
		matrix = new int[N][M];
		day = 0;
		check = 0;
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++) {
				if (s.charAt(j) == '.')
					matrix[i][j] = 0;
				if (s.charAt(j) == 'X')
					matrix[i][j] = -1;
				if (s.charAt(j) == '*') {
					matrix[i][j] = 1;
					wque.add(new Point(i, j));
					wvisited[i][j] = true;
					visited[i][j] = true;
				}
				if (s.charAt(j) == 'S') {
					matrix[i][j] = 0;
					visited[i][j] = true;
					sx = i;
					sy = j;
				}
				if (s.charAt(j) == 'D') {
					matrix[i][j] = 2;
					ex = i;
					ey = j;
				}
			}
		}
		sque.add(new Point(sx, sy));
		bfs();

		if (day != -1 && check == 1)
			System.out.print(day);
		else
			System.out.print("KAKTUS");
			

	}

	private static void bfs() {
		while (!wque.isEmpty() || !sque.isEmpty()) {
			int wk = wque.size();

			for (int k = 0; k < wk; k++) {
				Point p = wque.poll();
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (ix >= 0 && jy >= 0 && ix < N && jy < M && matrix[ix][jy] == 0) {
						matrix[ix][jy] = 1;
						wque.add(new Point(ix, jy));
					}
				}
			}
			int sk = sque.size();
			for (int k = 0; k < sk; k++) {
				Point p = sque.poll();
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (ix >= 0 && jy >= 0 && ix < N && jy < M && !visited[ix][jy] && matrix[ix][jy] != -1
							&& matrix[ix][jy] != 1) {
						visited[ix][jy] = true;
						if (ix == ex && jy == ey) {
							day++;
							check = 1;
							return;
						}
						sque.add(new Point(ix, jy));
					}
				}
			}
			day++;
			int c = 0;
			for (int d = 0; d < 4; d++) {
				int ix = ex + dx[d];
				int jy = ey + dy[d];
				if (ix < 0 || jy < 0 || ix >= N || jy >= M || matrix[ix][jy] != 0)
					c++;
			}
			if (c == 4) {
				day = -1;
				return;
			}
		}

	}
}
