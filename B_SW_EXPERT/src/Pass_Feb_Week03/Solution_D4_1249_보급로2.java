package Pass_Feb_Week03;


import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution_D4_1249_보급로2 {
	static int T, N;
	static int[][] matrix;
	static int res;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean[][] visited;
	static PriorityQueue<Point> que;

	static class Point implements Comparable<Point> {
		int x;
		int y;
		int cost;

		public Point(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			res = Integer.MAX_VALUE;
			matrix = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				for (int j = 0; j < N; j++) {
					matrix[i][j] = s.charAt(j) - 48;
				}
			}
			que = new PriorityQueue<>();
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(matrix[i][j] + " ");
//				}
//				System.out.println();
//			}
			que.add(new Point(0, 0, matrix[0][0]));
			matrix[0][0] = -1;
			bfs();
		System.out.println("#" + test_case + " " + res);
		}
	}

	private static void bfs() {
	
		while (!que.isEmpty()) {
			Point p = que.poll();
			if (p.x == N - 1 && p.y == N - 1) {
				res = p.cost;
				return;
			}
			for (int d = 0; d < 4; d++) {
				int ix = p.x + dx[d];
				int jy = p.y + dy[d];
				if (ix >= 0 && jy >= 0 && ix < N && jy < N && matrix[ix][jy] != -1) {
					que.add(new Point(ix, jy, matrix[ix][jy]+ p.cost));
					matrix[ix][jy] = -1;
				}
			}
		}
	}
}
