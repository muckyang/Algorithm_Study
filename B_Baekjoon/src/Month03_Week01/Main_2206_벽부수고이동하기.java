package Month03_Week01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2206_벽부수고이동하기 {

	static int N, M;
	static int matrix[][];
	static int Wmap[][];
	static int map[][];
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static Queue<Point> que;
	static int res;

	public static class Point {
		int x;
		int y;
		int check;

		public Point(int x, int y, int check) {
			super();
			this.x = x;
			this.y = y;
			this.check = check;
		}

	}

	private static void bfs(int x, int y) {
		while (!que.isEmpty()) {
			int k = que.size();
			for (int i = 0; i < k; i++) {
				Point p = que.poll();
				if (p.x == N - 1 && p.y == M - 1) {
					if (p.check == 0)
						res = map[p.x][p.y];
					else
						res = Wmap[p.x][p.y];
					return;
				}

				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (ix >= 0 && jy >= 0 && ix < N && jy < M && p.check == 0) {
						if (matrix[ix][jy] == 0 && map[ix][jy] == 0) {
							map[ix][jy] = map[p.x][p.y] + 1;
							que.add(new Point(ix, jy, 0));
						} else if (matrix[ix][jy] == 1 && Wmap[ix][jy] == 0) {
							Wmap[ix][jy] = map[p.x][p.y] + 1;
							que.add(new Point(ix, jy, 1));
						}

					} else if (ix >= 0 && jy >= 0 && ix < N && jy < M && p.check == 1 && Wmap[ix][jy] == 0) {
						if (matrix[ix][jy] == 0) {
							Wmap[ix][jy] = Wmap[p.x][p.y] + 1;
							que.add(new Point(ix, jy, 1));
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
		map = new int[N][M];
		Wmap = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++) {
				matrix[i][j] = s.charAt(j) - 48;
			}
		}

		que.add(new Point(0, 0, 0));
		map[0][0] = 1;
		bfs(0, 0);

		System.out.println(res);
	}

}
