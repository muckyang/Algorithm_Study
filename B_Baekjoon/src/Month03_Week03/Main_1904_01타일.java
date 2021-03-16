package Month03_Week03;

import java.util.Scanner;

public class Main_1904_01타일 {
	static int N;
	static int dp[];
	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new int[N];
		if (N > 0)
			dp[0] = 1;
		if (N > 1)
			dp[1] = 2;
		solve(N - 1);

		res = dp[N - 1] % 15746;
		System.out.println(res);
	}

	private static int solve(int n) {
		if (dp[n] != 0)
			return dp[n];
		if (n > 1)
			return dp[n] = (solve(n - 1) + solve(n - 2)) % 15746;
		return dp[n] = solve(n - 1) % 15746;
	}
}
