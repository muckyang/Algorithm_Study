package Study_0216;

import java.util.Scanner;

public class Main_1012_유기농배추 {
	static int T, N, M, wormNum;
	static int[][] matrix;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	private static void func(int i, int j) {
		for(int d = 0 ;d < 4 ; d++) {
			int ix= i+dx[d];
			int jy= j+dy[d];
			if(ix >= 0 && jy >= 0 &&ix < N&& jy < M&& matrix[ix][jy] == 1) {
				matrix[ix][jy] = -1;
				func(ix,jy);
			}
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int worm = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			wormNum = sc.nextInt();
			matrix = new int[N][M];
			for (int i = 0; i < wormNum; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				matrix[x][y] = 1;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (matrix[i][j] == 1) {
						matrix[i][j] = -1;
						func(i, j);
						worm++;
					}
				}
			}
			System.out.println(worm);
		}
	}

}
