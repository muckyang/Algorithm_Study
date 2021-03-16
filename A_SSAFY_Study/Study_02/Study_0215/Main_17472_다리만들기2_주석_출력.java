package Study_0215;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_17472_다리만들기2_주석_출력 {
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

		int mapchange = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (link[i][j] == 1 && matrix[i][j] == 0) {
					matrix[i][j] = mapchange;
					dfs(i, j, mapchange);
					mapchange++;
				}
			}
		}

		// matrix 초기화 완료
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(matrix[i][j] + " ");
//			}
//			System.out.println();
//		}

		link = new int[mapchange][mapchange];// 다시 초기화 함 (x = 0 , y = 0 안쓸꺼임)

		for (int i = 1; i < link[0].length; i++) {
			Arrays.fill(link[i], 10000); // 10000으로 초기화
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matrix[i][j] != 0)
					func(i, j, matrix[i][j]);
			}
		}

//		for (int i = 1; i < link[0].length; i++) {
//			for (int j = 1; j < link[0].length; j++) {
//				if (link[i][j] == 10000)
//					System.out.print(-1 + " ");
//				else
//					System.out.print(link[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
		// 섬간의 최단거리 구해놓음 야발
		PriorityQueue<Point> que = new PriorityQueue<>();
		for (int i = 1; i < link[0].length; i++) {
			for (int j = i + 1; j < link[0].length; j++) {
				if (link[i][j] != 10000)
					que.add(new Point(i, j, link[i][j]));
			}
		}
		int[] visited = new int[link[0].length];
		int union = 1;
		int result = 0;
		while (!que.isEmpty()) {
			Point p = que.poll();
//			System.out.println( "x : "+p.x  + " y : "+ p.y + " weight : " + p.weight  );
//			for(int i = 1 ; i < visited.length;i++) {
//				System.out.print(visited[i] + " ");
//			}
//			System.out.println();

			if (visited[p.x] == 0 && visited[p.y] == 0) {
				visited[p.x] = union;
				visited[p.y] = union;
				result += p.weight;
				union++;
			} else if (visited[p.x] == 0 || visited[p.y] == 0) {
				int low = visited[p.x] == 0 ? visited[p.y] : visited[p.x];
				visited[p.x] = low;
				visited[p.y] = low;
				result += p.weight;
			} else if (visited[p.x] == visited[p.y]) {
				continue;
			} else if (visited[p.x] != visited[p.y]) {
				int low = visited[p.x];
				int high = visited[p.y];
				for (int i = 1; i < visited.length; i++) {
//					System.out.println("py : " + visited[p.y]);
					if (visited[i] == high) {
						visited[i] = low;
					}
				}
//				System.out.println(visited.length);
				visited[p.y] = low;
				result += p.weight;
			}else {
				
			}
//			System.out.println("result :  "+result);
		}

		int check = visited[1];
		for (int i = 1; i < visited.length; i++) {
			if (visited[i] != check || check == 0)
				result = -1;
//			System.out.println(visited[i] + " ");
		}
		System.out.println(result);
	}

}
