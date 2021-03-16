package Study_0223;

import java.util.Scanner;

public class Main_14502_연구소 {
	static int N, M;
	static int[][] matrix;
	static boolean[][] visited;
	static int[] zx, wx;
	static int[] zy, wy;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int cnt, res;

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		res = -1;
		matrix = new int[N][M];
		zx = new int[64];
		zy = new int[64];
		wx = new int[3];
		wy = new int[3];
		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				matrix[i][j] = sc.nextInt();
				if (matrix[i][j] == 0) {
					zx[cnt] = i;
					zy[cnt] = j;
					cnt++;
				}
			}
		}
		combi(0, 0);
		System.out.println(res);

	}
	
	private static void combi(int start, int c) {
		if (c == 3) {
			
			int[][] mat = new int[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				System.arraycopy(matrix[i], 0, mat[i], 0, matrix[i].length);
			}
			for (int k = 0; k < 3; k++) {
				// 벽 세우기
				mat[wx[k]][wy[k]] = 1;
			}
			// 바이러스 퍼지고 갯수구하는 부분
			checkvirus(mat);
			countzero(mat);
			return;
		}

		for (int i = start; i < cnt; i++) {
			wx[c] = zx[i];
			wy[c] = zy[i];
			combi(i + 1, c + 1);

		}

	}

	private static void countzero(int[][] mat) {
		int zero=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(mat[i][j] == 0)
					zero++;
			}
		}
		if(res < zero)
			res = zero;
	}

	private static void checkvirus(int[][] mat) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (mat[i][j] == 2 && !visited[i][j]) {
					visited[i][j] = true;
					spray(mat, i, j);
				}
			}
		}
	}

	private static void spray(int[][] mat, int i, int j) {
		for (int d = 0; d < 4; d++) {
			int ix = i + dx[d];
			int jy = j + dy[d];
			if (ix >= 0 && jy >= 0 && ix < N && jy < M && !visited[ix][jy] && mat[ix][jy] != 1) {
				visited[ix][jy] = true;
				mat[ix][jy] = 2;
				spray(mat, ix, jy);
			}
		}
	}



}
