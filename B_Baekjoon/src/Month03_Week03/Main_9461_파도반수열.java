package Month03_Week03;

import java.util.Scanner;

public class Main_9461_파도반수열 {

	static int T, N;
	static long dp[];
	static long res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			N = sc.nextInt();
			dp = new long[N];
			res = 0;
			if (N >= 1)
				dp[0] = 1;
			if (N >= 2)
				dp[1] = 1;
			if (N >= 3)
				dp[2] = 1;
			if (N >= 4)
				solve(N-1);
			res = dp[N-1];
			System.out.println(res);
		}
	}

	private static long solve(int su) {
		if (dp[su] != 0)
			return dp[su];
		
		return dp[su] = solve(su-3) + solve(su-2);

	}
}
