package Study_0208;

import java.util.Scanner;

public class Main_2567_색종이2 {
	static int T, N;
	static int[][] matrix;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int count = 0;
		matrix = new int[100][100];
		visited = new boolean[100][100];
		int x, y;
		for (int t = 0; t < N; t++) {
			x = sc.nextInt();
			y = sc.nextInt();

			for (int i = x ; i <= x + 9; i++) {
				for (int j = y; j <= y + 9; j++) {
					matrix[i][j] = 1;
				}
			}

		}

//		for (int i = 0; i < 100; i++) {
//			for (int j = 0; j < 100; j++) {
//				if (matrix[i][j] != 0) {
//					for (int d = 0; d < 4; d++) {
//						int ix = i + dx[d];
//						int jy = j + dy[d];
//						if (ix < 0 && jy < 0 && ix >= 100 && jy >= 100) {
//							continue;
//						} else if (visited[ix][jy] == false && matrix[ix][jy] == 0) {
//							visited[ix][jy] = true;
//						}
//					}
//				}
//			}
//		}

		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 30; j++) {
				System.out.print(matrix[j][i] + " ");
			}
			System.out.println();
		}


		for (int i = 0; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if (visited[i][j] == true && visited[i][j - 1] == true) {
					count++;
				}
				if (visited[j][i] == true && visited[j - 1][i] == true) {
					count++;
				}
			}
		}
		System.out.println(count);

	}
}
