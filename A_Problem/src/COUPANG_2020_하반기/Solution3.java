package COUPANG_2020_하반기;

import java.util.HashMap;

public class Solution3 {
	public static void main(String[] args) {
//		int k = 3;
//		int[] score = { 24, 22, 20, 10, 5, 3, 2, 1 };
		int k = 2;
		int[] score = { 1300000000, 700000000, 668239490, 618239490, 568239490, 568239486, 518239486, 157658638,
				157658634, 100000000, 100 };
		System.out.println(solution(k, score));
	}

	public static int solution(int k, int[] score) {
		int num = 0;
		HashMap<Integer, Integer> hm = new HashMap<>();
		int[] chai = new int[score.length - 1];
		boolean[] v = new boolean[score.length];
		for (int i = 0; i < score.length - 1; i++) {
			int minus = score[i + 1] - score[i];
			hm.put(minus, 0);
			chai[i] = minus;
		}

		for (int i = 0; i < score.length - 1; i++) {
			hm.put(chai[i], hm.get(chai[i]) + 1);
		}

		for (int i = 0; i < chai.length; i++) {
			if (hm.get(chai[i]) >= k) {
				if (!v[i]) {
					v[i] = true;
					num++;
				}
				if (!v[i + 1]) {
					v[i + 1] = true;
					num++;
				}
			}
		}

		return score.length - num;
	}

}
