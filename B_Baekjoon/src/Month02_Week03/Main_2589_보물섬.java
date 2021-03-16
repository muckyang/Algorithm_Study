package Month02_Week03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2589_보물섬 {
	static int N, M;
	static boolean[][] matrix;
	static boolean[][] visited;
	static int cnt, max;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static Queue<Point> que;

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
		N = sc.nextInt();
		M = sc.nextInt();
		matrix = new boolean[N][M];
		que = new LinkedList<Point>();
		max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++) {
				if (s.charAt(j) == 'W') // 바다
					matrix[i][j] = true;
				else if (s.charAt(j) == 'L')
					matrix[i][j] = false;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!matrix[i][j]) {
					cnt = 0;
					visited = new boolean[N][M];
					visited[i][j] =true;
					que.add(new Point(i, j));
					bfs();
					if (max < cnt)
						max = cnt;
				}

			}
		}
		System.out.println(max -1 );
	}

	private static void bfs() {
		while (!que.isEmpty()) {
			int qs = que.size();
			for (int k = 0; k < qs; k++) {
				Point p = que.poll();
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (ix >= 0 && jy >= 0 && ix < N && jy < M && !visited[ix][jy] && !matrix[ix][jy]) {
						visited[ix][jy] =true;
						que.add(new Point(ix,jy));
					}
				}
			}
			cnt++;
		}
	}
}
