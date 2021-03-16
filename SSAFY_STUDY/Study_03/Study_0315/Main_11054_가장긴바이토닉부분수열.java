package Study_0315;

import java.util.Scanner;

public class Main_11054_가장긴바이토닉부분수열 {
	static int N;
	static int dp[][][];
	static int list[];
	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new int[1001][1001][3]; // 현재 , 이전 선택 값 , (1 : 상승중, 2: 하강중, 0 : 미선택)
		list = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		res = solve(0, 0, 0);
		System.out.println(res);
	}

	private static int solve(int now, int last, int mode) {
		if(now == N)
			return 0;
		if (dp[now][last][mode] != 0)
			return dp[now][last][mode];
		
		if (mode == 0) {
			int ans1 = solve(now + 1, last, 0);
			int ans2 = solve(now + 1, list[now], 1) + 1;
			return dp[now][last][mode] = Math.max(ans1, ans2);
		}else if(mode ==1) {
			int ans1 = solve(now + 1, last, 1);
			int ans2 = 0;
			if(last < list[now])
				ans2 = solve(now + 1, list[now], 1) + 1;
			else if( last > list[now])
				ans2 = solve(now + 1, list[now], 2) + 1;
			return dp[now][last][mode] = Math.max(ans1, ans2);
		}else {
			int ans1 = solve(now + 1, last, 2);
			int ans2 = 0;
			if( last > list[now])
				ans2 = solve(now + 1, list[now], 2) + 1;
			return dp[now][last][mode] = Math.max(ans1, ans2);
			
		}
	}
}
