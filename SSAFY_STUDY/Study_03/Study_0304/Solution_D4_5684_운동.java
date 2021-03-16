package Study_0304;

import java.util.Scanner;

public class Solution_D4_5684_운동 {
	static int T, N, M;
	static int[][] matrix;
	static boolean[] visited;
	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			res = Integer.MAX_VALUE;
			matrix = new int[N + 1][N + 1];
			for (int i = 0; i < M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int v = sc.nextInt();
				matrix[x][y] = v;
			}

			for (int i = 1; i < N + 1; i++) {
				visited = new boolean[N + 1];
				dfs(i, i, 0);
			}
			System.out.println("#" + tc + " " + (res == Integer.MAX_VALUE ? -1 : res));
		}

	}

	private static void dfs(int sp, int node, int sum) {
		if (sp == node && visited[sp]) {
			if (sum < res)
				res = sum;
			return;
		}
		if (visited[node])
			return;
		if (sum >= res)
			return;
		
		visited[node] = true;
		for (int i = 1; i < N + 1; i++) {
			if (matrix[node][i] > 0) {
				dfs(sp, i, sum + matrix[node][i]);
			}
		}
	}
}
