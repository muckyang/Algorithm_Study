package Study_0315;

import java.util.Scanner;

public class Main_12865_평범한배낭 {
	static int N, K;
	static int dp[][];
	static int w[];
	static int v[];
	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		w = new int[N];
		v = new int[N];
		dp = new int[N+1][K+1];
		for (int i = 0; i < N; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		res = solve(0, 0);
		System.out.println(res);
	}

	private static int solve(int now, int weight) {
		if (now == N) {
			return 0;
		}
		if (dp[now][weight] != 0)
			return dp[now][weight];

		int ans1 = solve(now + 1, weight);
		int ans2 = 0;
		if (K >= weight + w[now])
			ans2 = solve(now + 1, weight + w[now]) + v[now];

		return dp[now][weight] = Math.max(ans1, ans2);
	}
}
