package Study_04Fail;

import java.util.Scanner;

public class Main_1700_멀티탭스케줄링 {
	static int N, K;
	static int[] plug;
	static int[] list;
	static int[][] dp;
	static int pcnt, res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		plug = new int[N];
		list = new int[K];
		dp = new int[K + 1][N + 1];
		res = 0;
		pcnt = 0;

		for (int i = 0; i < K; i++) {
			list[i] = sc.nextInt();
		}
		res = solve(0, 0);
		System.out.println(res == Integer.MAX_VALUE ? 0 : res);
	}

	private static int solve(int now, int last) {
		if (now == K)
			return 0;
		if (dp[now][last] != 0)
			return dp[now][last];

		for (int i = 0; i < pcnt; i++) {
			if (list[now] == plug[i])
				return solve(now + 1, last);
		}

		if (pcnt != N) {
			plug[pcnt] = list[now];
			pcnt++;
			return solve(now + 1, last);
		}

		// 모든 포트 사용중인경우에 하나씩 뺴봄
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int temp = plug[i];
			plug[i] = list[now];
			int su = solve(now + 1, i) + 1;
			if (min > su)
				min = su;
			plug[i] = temp;
		}
		return dp[now][last] = min;
	}
}