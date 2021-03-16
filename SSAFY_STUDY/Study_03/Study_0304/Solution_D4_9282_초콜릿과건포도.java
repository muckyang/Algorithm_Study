package Study_0304;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D4_9282_초콜릿과건포도 {
	static int T, N, C;
	static int[][] choco;
	static int[][][][] dp; // x,y,h,w 에 대한
	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			res = Integer.MAX_VALUE;
			N = sc.nextInt();
			C = sc.nextInt();
			choco = new int[N][C];
			dp = new int[N + 1][C + 1][N + 1][C + 1];
			for (int[][][] d1 : dp) {
				for (int[][] d2 : d1) {
					for (int[] d3 : d2) {
						Arrays.fill(d3, Integer.MAX_VALUE);
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < C; j++) {
					choco[i][j] = sc.nextInt();

				}
			}

			res = dfs(0, 0, N, C);
			System.out.println("#" + tc + " " + res);
		}
	}

	private static int dfs(int x, int y, int h, int w) {
		if (w == 1 && h == 1) {
			return 0;
		}
		if (dp[x][y][h][w] != Integer.MAX_VALUE) {
			return dp[x][y][h][w];
		}
		int sum = 0;
		for (int i = x; i < x + h; i++) {
			for (int j = y; j < y + w; j++) {
				sum += choco[i][j];
			}
		}

		// 가로로 나눌떄 최소비옹
		for (int i = 1; i < h; i++) {
			// 위쪽에 대한 비용 , 아래쪽에 대한 비용
			if (dp[x][y][i][w] == Integer.MAX_VALUE)
				dp[x][y][i][w] = dfs(x, y, i, w);
			if (dp[x + i][y][h - i][w] == Integer.MAX_VALUE)
				dp[x + i][y][h - i][w] = dfs(x + i, y, h - i, w);
			int sum3 = sum + dp[x][y][i][w] + dp[x + i][y][h - i][w];
				dp[x][y][h][w] = Math.min(dp[x][y][h][w], sum3);

		}

		for (int i = 1; i < w; i++) {
			if (dp[x][y][h][i] == Integer.MAX_VALUE)
				dp[x][y][h][i] = dfs(x, y, h, i);
			if (dp[x][y + i][h][w - i] == Integer.MAX_VALUE)
				dp[x][y + i][h][w - i] = dfs(x, y + i, h, w - i);
			int sum3 = sum + dp[x][y][h][i] + dp[x][y + i][h][w - i];
				dp[x][y][h][w] = Math.min(dp[x][y][h][w], sum3);
		}
		return dp[x][y][h][w];
	}
}
