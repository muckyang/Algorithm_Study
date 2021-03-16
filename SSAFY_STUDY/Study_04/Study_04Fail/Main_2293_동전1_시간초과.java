package Study_04Fail;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2293_동전1_시간초과 {
	static int N, K;
	static int[] list;
	static long[][] dp;
	static long res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		list = new int[N];
		dp = new long[N + 1][K + 1];
		res = 0;
		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		Arrays.sort(list);
		res = solve(0, K);

		System.out.println(res);
	}

	private static long solve(int now, int number) {
		if (number == 0)
			return dp[now][number] = 1;
		if (now == N)
			return dp[now][number] = 0;
		if (dp[now][number] != 0)
			return dp[now][number];
		long ans1 = solve(now + 1, number);// 선택안하고 진행
		long ans2 = 0;
		if (number >= list[now]) {
			ans2 = solve(now, number - (int)list[now]);// 현재 동전 선택 후 증가 x
		}
		return dp[now][number] = ans1 + ans2;
	}

}
