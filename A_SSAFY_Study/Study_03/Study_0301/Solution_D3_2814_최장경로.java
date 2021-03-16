package Study_0301;

import java.util.Scanner;

public class Solution_D3_2814_최장경로 {
	static int N, M, T, res;
	static boolean[][] m;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			m = new boolean[N][N];
	
			res = 0;
			for (int i = 0; i < M; i++) {
				int x = sc.nextInt() - 1;
				int y = sc.nextInt() - 1;
				m[x][y] = m[y][x] = true;
			}
			for (int i = 0; i < N; i++) {
				v[i] = true;
				dfs(i, 1);
				v[i] = false;
			}
			System.out.println("#"  + test_case + " " +res);
		}
	}

	private static void dfs(int x, int c) {

		for (int i = 0; i < N; i++) {
			if (!v[i] && m[x][i]) {
				v[i] = true;
				m[x][i] = m[i][x] = false;
				dfs(i, c + 1);
				v[i] = false;
				m[x][i] = m[i][x] = true;
			}
		}
		if (res < c)
			res = c;
	}
}
