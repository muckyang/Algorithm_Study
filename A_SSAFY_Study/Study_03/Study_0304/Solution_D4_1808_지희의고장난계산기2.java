package Study_0304;

import java.util.Scanner;

public class Solution_D4_1808_지희의고장난계산기2 {
	static int T;
	static int target;
	static boolean[] canUse;
	static int[] list;
	static int ans;
	static int size;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			canUse = new boolean[10];
			for (int i = 0; i < 10; i++) {
				int k = sc.nextInt();
				if (k == 1)
					canUse[i] = true;
			}
			target = sc.nextInt();
			ans = Integer.MAX_VALUE;
			size = (int) Math.sqrt(target) + 1;
			list = new int[size];
			ans = solve(target, 0);

			System.out.println("#" + tc + " " + (ans == Integer.MAX_VALUE ? -1 : ans));
		}
	}

	private static int solve(int x, int cnt) {
		if (x < size && list[x] != 0) {
			return list[x];
		}
		if (canMakeNumber(x)) {
			int count = Integer.toString(x).length() + 1;
			if (cnt == 0) {
				ans = count;
			}
			if (x < size) {
				list[x] = count;
			}
			return count;
		}
		int e = (int) Math.sqrt(x);
		int result = -1;
		for (int i = 2; i <= e; i++) {
			if (x % i == 0 && canMakeNumber(i)) {
				int len1 = Integer.toString(i).length() + 1;// 곱하기버튼 추가
				int len2 = solve(x / i, cnt + 1);
				if (len2 > -1) {
					result = len1 + len2;
					if (result < ans && x == target) {
						ans = result;
					}
				}

			}

		}
//		System.out.println("=========")
		if (x < size) {
			list[x] = result;
		}

		return result;

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
