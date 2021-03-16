package Main_14001_to_16000;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_11559_PuyPuyo {
	static int[][] matrix;
	static boolean[][] visited;
	static int res, pc;// pc : 이어진 뿌요 갯수
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static Queue<Point> que;

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
		matrix = new int[12][6];
		que = new LinkedList<Point>();
		for (int i = 0; i < 12; i++) {
			String s = sc.next();
			for (int j = 0; j < 6; j++) {
				char c = s.charAt(j);
				if (c == '.')
					matrix[i][j] = 0;
				if (c == 'R')
					matrix[i][j] = 1;
				if (c == 'G')
					matrix[i][j] = 2;
				if (c == 'B')
					matrix[i][j] = 3;
				if (c == 'P')
					matrix[i][j] = 4;
				if (c == 'Y')
					matrix[i][j] = 5;
			}
		}
		/// 입력 완료!
		res = 0;

		while (true) {
			visited = new boolean[12][6];
			boolean nowboom = false;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (matrix[i][j] != 0 && !visited[i][j]) {
						visited[i][j] = true;
						pc = 1;
						que.add(new Point(i, j));
						dfs(i, j, matrix[i][j]);
						if (pc >= 4) { // 4개이상 이어진 경우
							boomPuyo();
							nowboom = true;
						}
						que.clear();
					}
				}
			}
		
			if (nowboom) {//4개이상인게 있을 떄 중력작용
				gravity();
				res++;
			} else
				break;
	
		}
		System.out.println(res);
	}

	private static void dfs(int x, int y, int k) {
		for (int d = 0; d < 4; d++) {
			int ix = x + dx[d];
			int jy = y + dy[d];
			if (safe(ix, jy) && !visited[ix][jy] && matrix[ix][jy] == k) {
				visited[ix][jy] = true;
				pc++;
				que.add(new Point(ix, jy));
				dfs(ix, jy, k);
			}

		}
	}

	private static boolean safe(int ix, int jy) {
		if (ix >= 0 && jy >= 0 && ix < 12 && jy < 6)
			return true;
		return false;
	}

	private static void boomPuyo() {
		while (!que.isEmpty()) {
			Point p = que.poll();
			matrix[p.x][p.y] = 0;
		}
	}

	private static void gravity() {

		for (int i = 0; i < 6; i++) {
			int[] list = new int[12];
			int c = 11;
			for (int j = 11; j >=0; j--) {
				if (matrix[j][i] != 0) {
					list[c--] = matrix[j][i];
				}
			}
			for (int j = 0; j < 12; j++) {
				 matrix[j][i]=list[j];
			}
		}
	}
}
