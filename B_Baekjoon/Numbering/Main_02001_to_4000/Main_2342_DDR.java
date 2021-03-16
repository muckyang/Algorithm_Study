package Main_02001_to_4000;

import java.util.LinkedList;
import java.util.Scanner;

public class Main_2342_DDR {
	static int N;
	static int list[];
	static int dp[][][];// 몇번째 이동 , 왼발좌표,오른발좌표, 이동한 발
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		list = new int [100001];
		cnt = 0;
		while (true) {
			int su = sc.nextInt();
			if (su == 0)
				break;
			list[cnt] = su;
			cnt++;
		}
		dp = new int[cnt + 1][5][5];
		int res = solve(0, 0, 0);
		System.out.println(res);
	}

	private static int solve(int now, int l, int r) {
		if (now == cnt)
			return 0;
		if (dp[now][l][r] != 0)
			return dp[now][l][r];
		int su = list[now];
		int ans1 = solve(now + 1, su, r) + plus(l, su);
		int ans2 = solve(now + 1, l, su) + plus(r, su);
		return dp[now][l][r] = Math.min(ans1, ans2);

	}

	private static int plus(int l, int su) {
		if (l == 0)
			return 2;
		if (l == su)
			return 1;
		if (l + 1 == su || su + 1 == l)
			return 3;
		if ((su == 4 && l == 1) || (su == 1 && l == 4))
			return 3;
		if (l + 2 == su || l - 2 == su)
			return 4;

		return 0;
	}
}
