package Month03_Week03;
import java.util.Scanner;

public class Main_2748_피보나치수2 {
	static int N;
	static long dp[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new long[N + 1];
		dp[0] = 0;
		dp[1] = 1;
		long res = 1;
		if (N > 1) {
			res = solve(N);
		}
		System.out.println(res);
	}

	private static long solve(int su) {
		if (dp[su] != 0 || su == 0) {
			return dp[su];	
		}

		return dp[su] = solve(su - 1) + solve(su - 2);
	}
}