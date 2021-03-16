package Main_16001_to_18000;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_17472_다리만들기2 {
	static int N, M;
	static int[][] matrix;
	static int[][] link;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	static int min;

	public static class Point implements Comparable<Point> {
		private int x;
		private int y;
		private int weight;

		public Point(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Point o) {
			return this.weight - o.weight;
		}
	}

	private static void dfs(int x, int y, int c) {
		for (int d = 0; d < 4; d++) {
			int ix = x + dx[d];
			int jy = y + dy[d];
			if (ix >= 0 && jy >= 0 && ix < N && jy < M && matrix[ix][jy] == 0 && link[ix][jy] == 1) {
				matrix[ix][jy] = c;
				dfs(ix, jy, c);
			}
		}
	}

	private static void func(int x, int y, int sp) {
		for (int d = 0; d < 4; d++) {
			checkLine(x, y, sp, d, 0);
		}
	}

	private static void checkLine(int x, int y, int sp, int d, int count) {
		int ix = x + dx[d];
		int jy = y + dy[d];
		if (ix < 0 || jy < 0 || ix >= N || jy >= M) {
			return;
		} else if (matrix[ix][jy] != 0 && matrix[ix][jy] != sp) { // 다른섬 찾았을때
			if (count >= 2 && link[sp][matrix[ix][jy]] > count) {
				link[sp][matrix[ix][jy]] = count;
				return;
			}
		} else if (matrix[ix][jy] == 0) {
			checkLine(ix, jy, sp, d, count + 1);
			return;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		matrix = new int[N][M];
		link = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				link[i][j] = sc.nextInt();// 잠깐 빌려씀
			}
		}

		int mc = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (link[i][j] == 1 && matrix[i][j] == 0) {
					matrix[i][j] = mc;
					dfs(i, j, mc);
					mc++;
				}
			}
		}


		link = new int[mc][mc];// 다시 초기화 함 (x = 0 , y = 0 안쓸꺼임)

		for (int i = 1; i < link[0].length; i++) {
			Arrays.fill(link[i], 10000); // 10000으로 초기화
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matrix[i][j] != 0)
					func(i, j, matrix[i][j]);
			}
		}

		PriorityQueue<Point> que = new PriorityQueue<>();
		for (int i = 1; i < link[0].length; i++) {
			for (int j = i + 1; j < link[0].length; j++) {
				if (link[i][j] != 10000)
					que.add(new Point(i, j, link[i][j]));
			}
		}
		int[] v = new int[link[0].length];
		int union = 1;
		int result = 0;
		while (!que.isEmpty()) {
			Point p = que.poll();
			if (v[p.x] == 0 && v[p.y] == 0) {
				v[p.x] = union;
				v[p.y] = union;
				result += p.weight;
				union++;
			} else if (v[p.x] == 0 || v[p.y] == 0) {
				int low = v[p.x] == 0 ? v[p.y] : v[p.x];
				v[p.x] = low;
				v[p.y] = low;
				result += p.weight;
			} else if (v[p.x] == v[p.y]) {
				continue;
			} else if (v[p.x] != v[p.y]) {
				int low = v[p.x];
				int high = v[p.y];
				for (int i = 1; i < v.length; i++) {
					if (v[i] == high) {
						v[i] = low;
					}
				}
				v[p.y] = low;
				result += p.weight;
			}else {
				
			}
		}

		int check = v[1];
		for (int i = 1; i < v.length; i++) {
			if (v[i] != check || check == 0)
				result = -1;
		}
		System.out.println(result);
	}

}
