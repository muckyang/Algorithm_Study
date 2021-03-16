package Study_0304;

import java.util.Scanner;

public class Solution_D4_1808_지희의고장난계산기 {
	static int T;
	static int target;
	static int yaksu[];
	static boolean[] canUse;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			canUse = new boolean[10];
			yaksu = new int[100001];
			for (int i = 0; i < 10; i++) {
				int k = sc.nextInt();
				if (k == 1)
					canUse[i] = true;
			}
			target = sc.nextInt();
			ans = 3;// 1 , * , 연산버튼 : 3개

			String s = Integer.toString(target);
			if (!canMakeNumber(target) || !canUse[1])
				ans = 1;
			else
				ans = s.length() + 1;

			if (ans != 1)
				ans = Math.min(ans, solve(1, target, 0));
			else
				ans = solve(1, target, ans);

			System.out.println("#" + tc + " " + (ans == Integer.MAX_VALUE ? -1 : ans));
		}
	}

	private static int solve(int start, int end, int len) {
		int res = Integer.MAX_VALUE;
		int sb = Integer.MAX_VALUE;
		int eb = Integer.MAX_VALUE;
		// 약수 구하고 dfs
		int s = (int) Math.sqrt(start);
		int e = (int) Math.sqrt(end);
		// start , end 둘다 만들 수 있을때
		for (int i = 2; i <= s; i++) {
			int s_num = Integer.MAX_VALUE;
			int e_num = Integer.MAX_VALUE;
			if (start % i == 0) {
				if (canMakeNumber(i)) {
					if (s_num > Integer.toString(i).length())
						s_num = Integer.toString(i).length();

				} else {
					s_num = Math.min(s_num, solve(1, i, 0) + 1);
				}
				if (canMakeNumber(start / i)) {
					if (e_num > Integer.toString(start / i).length())
						e_num = Integer.toString(start / i).length();
				} else {
					e_num = Math.min(e_num, solve(1, start / i, 0) + 1);
				}

			}
			int k = s_num + e_num + 1;
//			if (s_num == Integer.MAX_VALUE || e_num == Integer.MAX_VALUE) {
//				k = Integer.MAX_VALUE;
//			}
			if (sb > k)
				sb = k;
		}

		for (int i = 2; i <= e; i++) {
			int s_num = Integer.MAX_VALUE;
			int e_num = Integer.MAX_VALUE;
			if (end % i == 0) {
				if (canMakeNumber(i)) {
					if (s_num > Integer.toString(i).length())
						s_num = Integer.toString(i).length();

				} else {
					s_num = Math.min(s_num, solve(1, i, 0) + 1);
				}
				if (canMakeNumber(end / i)) {
					if (e_num > Integer.toString(end / i).length())
						e_num = Integer.toString(end / i).length();
				} else {
					e_num = Math.min(e_num, solve(1, end / i, 0) + 1);
				}

			}
			int k = s_num + e_num + 1;
//			if (s_num == Integer.MAX_VALUE || e_num == Integer.MAX_VALUE) {
//				k = Integer.MAX_VALUE;
//			}
			if (eb > k)
				eb = k;
		}
//		if (eb == Integer.MAX_VALUE || sb == Integer.MAX_VALUE)
//			return Integer.MAX_VALUE - 1;
		return eb + sb ;

	}

	private static boolean canMakeNumber(int num) {
		String s = Integer.toString(num);
		for (int i = 0; i < s.length(); i++) {
			if (!canUse[s.charAt(i) - '0']) {
				return false;
			}
		}
		return true;
	}
}
