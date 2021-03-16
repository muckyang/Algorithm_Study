package Main_16001_to_18000;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_17142_연구소3 {
	static int N, M;
	static int[][] matrix;
	static boolean[][] visited;
	static int xlist[], ylist[];
	static int cnt;
	static int cx[], cy[];
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static Queue<Point> que;
	static int min;

	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	private static void func(int c, int s) {
		if (c == M) {
			int[][] mat = new int[N][N];
			for (int i = 0; i < N; i++)
				System.arraycopy(matrix[i], 0, mat[i], 0, mat[i].length);
			visited = new boolean[N][N];
			for (int i = 0; i < c; i++) {
				visited[cx[i]][cy[i]] = true;
				que.add(new Point(cx[i], cy[i]));
			}
			int res = bfs(mat);

			if (isClear(mat))
				res = Integer.MAX_VALUE;
			if (min > res)
				min = res;
			// 뎁스 수 구하기
			return;
		}
		for (int i = s; i < cnt; i++) {
			cx[c] = xlist[i];
			cy[c] = ylist[i];
			func(c + 1, i + 1);
		}

	}

	private static boolean isClear(int mat[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (mat[i][j] == 0)
					return true;
			}
		}
		return false;// 다 퍼졌다면
	}

	private static int bfs(int[][] mat) {
		int depth = 0;
		while (!que.isEmpty()) {
			if (!isClear(mat)) {
				que.clear();
				return depth;
			}

			int k = que.size();
			for (int i = 0; i < k; i++) {
				Point p = que.poll();
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (ix >= 0 && jy >= 0 && ix < N && jy < N && !visited[ix][jy] && mat[ix][jy] != 1) {
						visited[ix][jy] = true;
						mat[ix][jy] = 2;
						que.add(new Point(ix, jy));
					}

				}
			}
			depth++;
		}
		return depth - 1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		matrix = new int[N][N];
		xlist = new int[10];
		ylist = new int[10];
		cx = new int[10];
		cy = new int[10];
		que = new LinkedList<Point>();
		cnt = 0;
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = sc.nextInt();
				if (matrix[i][j] == 2) {
					xlist[cnt] = i;
					ylist[cnt] = j;
					cnt++;
				}
			}
		}
		func(0, 0);
		if (min == Integer.MAX_VALUE)
			min = -1;
		System.out.println(min);

	}

}
