package Month02_Week02;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2583_영역구하기 {
	static int N, M, K;
	static int[][] matrix;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int c;

	private static void dfs(int i, int j) {
		for (int d = 0; d < 4; d++) {
			int ix = i + dx[d];
			int jy = j + dy[d];
			if (ix >= 0 && jy >= 0 && ix < N && jy < M && !visited[ix][jy] && matrix[ix][jy] == 0) {
				visited[ix][jy] = true;
				c++;
				dfs(ix, jy);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();
		matrix = new int[N][M];
		for (int i = 0; i < K; i++) {
			int sx = sc.nextInt();
			int sy = sc.nextInt();
			int cx = sc.nextInt();
			int cy = sc.nextInt();

			for (int b = sy; b < cy; b++) {
				for (int a = sx; a < cx; a++) {
					matrix[a][b] = 1;
				}
			}
		}
		// 입력 ok
//		for (int a = 0; a < N; a++) {
//			for (int b = 0; b < M; b++) {
//				System.out.print(matrix[a][b] + " ");
//			}
//			System.out.println();
//		}
		int count = 0;
		int matc[] = new int[N * M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				c = 0;
				if (matrix[i][j] == 0 && !visited[i][j]) {
					c++;
					visited[i][j] = true;
					dfs(i, j);
					matc[count] = c;
					count++;
				}
			}
		}
		Arrays.sort(matc);
		System.out.println(count);
		for (int k : matc) {
			if (k != 0	)
				System.out.print(k + " ");
		}
	}

}
