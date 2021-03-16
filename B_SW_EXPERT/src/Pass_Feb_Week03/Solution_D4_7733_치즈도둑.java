package Pass_Feb_Week03;

import java.util.Scanner;

public class Solution_D4_7733_치즈도둑 {
	static int[][] matrix;
	static boolean[][] visited;
	static int T, N;
	static int count;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int max;

	public static void func(int day) {
		if (!ischeeze()) {
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[i][j] == day)
					matrix[i][j] = 0;
			}
		}
		int c = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && matrix[i][j] != 0) {
					c++;
					visited[i][j] = true;
					count(i, j);
				}
			}
		}

		if (c > max) {
			max = c;
		}
		func(day + 1);
	}

	private static void count(int x, int y) {
		for (int d = 0; d < 4; d++) {
			int ix = x + dx[d];
			int jy = y + dy[d];
			if (ix >= 0 && jy >= 0 && ix < N && jy < N && !visited[ix][jy] && matrix[ix][jy] != 0) {
				visited[x][y] = true;
				count(ix, jy);
			}
		}
	}

	public static boolean ischeeze() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[i][j] != 0)
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			max = 1;
			matrix = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = sc.nextInt();

				}
			}
			func(1);
			System.out.println("#" + test_case + " " + max);
		}
	}

}
