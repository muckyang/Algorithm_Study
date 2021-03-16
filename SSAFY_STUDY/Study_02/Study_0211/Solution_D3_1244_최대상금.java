package Study_0211;

import java.util.Scanner;

public class Solution_D3_1244_최대상금 {

	static int T;
	static int[] list;
	static int N;// N번 교환가능
	static int max;
	static char[] num;
	static int result;

	public static void dfs(int sp, int c) {
		if (c == N) {
			result = Math.max(result, Integer.parseInt(String.valueOf(num)));
			return;
		}
		for (int i = sp; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {

				char temp = num[i];
				num[i] = num[j];
				num[j] = temp;

				dfs(i, c + 1);

				temp = num[i];
				num[i] = num[j];
				num[j] = temp;

			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			result = 0;
			num = sc.next().toCharArray();
			N = sc.nextInt();
			dfs(0, 0);
			System.out.println("#" + test_case + " " + result);

		}
	}
}