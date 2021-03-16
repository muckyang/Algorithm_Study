package Month03_Week03;

import java.util.Scanner;

public class Main_10844_쉬운계단수 {
	static int N;
	static long dp[][];
	static long res;
	static long cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new long[N + 1][10];
		for (int i = 1; i < 10; i++) {
			dp[0][i] = 1L;
		}
		res = 0L;
		for (int i = 0; i < 10; i++)
			res += solve(N - 1, i);
		cnt = res % 1000000000;
		System.out.println(cnt);
	}

	private static long solve(int su, int ch) {

		if (dp[su][ch] != 0 || su == 0)
			return dp[su][ch];
		if (ch == 0)
			return dp[su][ch] = solve(su - 1, ch + 1);
		if (ch == 9)
			return dp[su][ch] = solve(su - 1, ch - 1);
		return dp[su][ch] = (solve(su - 1, ch + 1) + solve(su - 1, ch - 1)) % 1000000000;

	}
}
