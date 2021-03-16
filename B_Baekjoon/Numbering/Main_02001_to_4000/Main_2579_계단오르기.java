package Main_02001_to_4000;

import java.util.Scanner;

public class Main_2579_계단오르기 {
	static int N;
	static int[] list;
	static int[][][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		list = new int[N];
		dp = new int[2][2][N];
		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		dp[0][0][0] = list[0];
		if (N >= 2) {
			dp[0][1][1] = list[1] + list[0];
			dp[0][0][1] = list[1];
		}
		if (N >= 3) {
			dp[0][1][2] = list[2] + list[1];
			dp[1][0][2] = list[2] + list[0];
		}
		if (N >= 4) {
			dp[0][1][3] = list[3] + dp[1][0][2];
			dp[1][0][3] = list[3] + Math.max(dp[0][1][1], dp[1][0][1]);
		}
		for (int i = 4; i < N; i++) {
			dp[0][1][i] = list[i] + dp[1][0][i - 1];
			dp[1][0][i] = list[i] + Math.max(dp[0][1][i - 2], dp[1][0][i - 2]);
		}
		int max;
		if (N >= 3)
			max = Math.max(dp[0][1][N - 1], dp[1][0][N - 1]);
		else if (N == 2)
			max = dp[0][1][1];
		else
			max = list[0];
		System.out.println(max);

	}
}
