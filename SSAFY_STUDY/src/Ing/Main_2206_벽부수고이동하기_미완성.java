package Ing;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2206_벽부수고이동하기_미완성 {
	static int N, M;
	static int matrix[][];
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static Queue<Point> que;
	static int res;

	public static class Point {
		int x;
		int y;
		int depth;
		int check;

		public Point(int x, int y, int depth, int check) {
			super();
			this.x = x;
			this.y = y;
			this.depth = depth;
			this.check = check;
		}

	}

	private static void bfs(int x, int y) {
		matrix[x][y] = -1;
		while (!que.isEmpty()) {
			int k = que.size();
			for (int i = 0; i < k; i++) {
				Point p = que.poll();

				if (p.x == N - 1 && p.y == M - 1) {
					res = p.depth + 1;
					return;
				}

				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (ix >= 0 && jy >= 0 && ix < N && jy < M) {
						if (matrix[ix][jy] == 0) {
							que.add(new Point(ix, jy, p.depth + 1, p.check));
							matrix[ix][jy] = -1;
						} else if (p.check == 0 && matrix[ix][jy] == 1) {
							que.add(new Point(ix, jy, p.depth + 1, 1));
							matrix[ix][jy] = -1;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		res = -1;
		que = new LinkedList<Point>();
		matrix = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++) {
				matrix[i][j] = s.charAt(j) - 48;
			}
		}
		
		// 입력확인
		que.add(new Point(0, 0, 0, 0));
		bfs(0, 0);
		System.out.println(res);
	}

}