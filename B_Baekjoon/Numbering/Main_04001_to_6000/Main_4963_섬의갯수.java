package Main_04001_to_6000;

import java.util.Scanner;

public class Main_4963_섬의갯수 {
	static int N, M;
	static int[][] matrix;
	static boolean[][] visited;
	static int[] dx = { 0, 1, -1, 0, 1, 1, -1, -1 };
	static int[] dy = { 1, 0, 0, -1, 1, -1, -1, 1 };
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			M = sc.nextInt();
			N = sc.nextInt();
			matrix = new int[N][M];
			visited = new boolean[N][M];
			if (N == M && N == 0)
				return;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (matrix[i][j] == 1 && !visited[i][j]) {
//						System.out.println(i+" ," + j);
						visited[i][j] = true;
						cnt++;
						dfs(i, j);
					}
				}
			}

			System.out.println(cnt);
		}

	}

	private static void dfs(int x, int y) {
		for (int d = 0; d < 8; d++) {
			int ix = x + dx[d];
			int jy = y + dy[d];
			if (ix >= 0 && jy >= 0 && ix < N && jy < M && matrix[ix][jy] == 1 && !visited[ix][jy]) {
				visited[ix][jy] = true;
				dfs(ix, jy);
			}

		}
	}
}
