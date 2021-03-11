package COUPANG_2020_하반기;

import java.util.Stack;

public class Solution1 {
	public static void main(String[] args) {
		int N = 14;// res [6,4]
//		int N = 10;//res [6,4]
		int[] res = new int[2];
		res = solution(N);
		System.out.println(res[0] + " " + res[1]);
	}

	public static int[] solution(int N) {
		int[] res = new int[2];
		// 2吏꾨쾿 ~ 10吏꾨쾿 �굹���궡湲�

		for (int i = 2; i <= 10; i++) {
			int number = change(N, i);
			if (res[1] <= number) {
				res[0] = i;
				res[1] = number;
			}
		}
		return res;

	}

	public static int change(int number, int div) {
		Stack<Integer> stack = new Stack<>();
		while (number > 0) {
			stack.add(number % div);
			number /= div;
		}
		int res = 1;
		// �옄由우닔 怨�

		while (!stack.isEmpty()) {
			int k = stack.pop();
			if (k != 0)
				res *= k;
		}
		return res;
	}
}
