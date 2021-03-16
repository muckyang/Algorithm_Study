package Month03_Week03;

import java.util.Scanner;

public class Main_11053_가장긴증가하는부분수열 {
	static int N;
	static int list[];
	static int dp[][];
	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		list = new int[N];
		dp = new int[N][1001];
		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		res = solve(0, 0);
		System.out.println(res);
	}

	private static int solve(int now, int end) {
		if (now == N)
			return 0;
		if (dp[now][end] != 0)
			return dp[now][end];

		if (end < list[now])
			return dp[now][end] = Math.max(solve(now + 1, end), solve(now + 1, list[now]) + 1);
		return dp[now][end] = solve(now + 1, end);
	}
}
