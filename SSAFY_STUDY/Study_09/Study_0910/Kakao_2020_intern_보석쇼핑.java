package Study_0910;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Kakao_2020_intern_보석쇼핑 {
	public static void main(String[] args) {
//		String[] gems = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };// [3,7]
//		String []gems = {"AA", "AB", "AC", "AA", "AC"};//[1,3]
//		String []gems = {"XYZ", "XYZ", "XYZ"};//[1,1]
		String[] gems = { "ZZZ", "YYY", "NNNN", "YYY", "BBB" };// [1,5]
		System.out.println(solution(gems));

	}

	public static int[] solution(String[] gems) {
		int[] answer = new int[2];
		int count = 0;
		HashSet<String> hs = new HashSet<>();
		HashMap<String, Integer> hm = new HashMap<>();
		for (int i = 0; i < gems.length; i++) {
			hs.add(gems[i]);
		}
		count = hs.size();
		int sp = 0;
		int len = 0;
		int resSp = 0;
		int reslen = Integer.MAX_VALUE;
		for (int i = 0; i < gems.length; i++) {
			if (!hm.containsKey(gems[i])) {// hm에 포함되어 있지않다면
				hm.put(gems[i], 1);
			} else {
				hm.put(gems[i], hm.get(gems[i]) + 1);
			}
			len = i - sp;
			while (hm.size() == count) {// 모든 보석을 다 갖고 있다면 ?
				if (reslen > len) {
					reslen = len;
					resSp = sp + 1;
				}
				if (hm.get(gems[sp]) > 1) {
					hm.put(gems[sp], hm.get(gems[sp]) - 1);
				} else {
					hm.remove(gems[sp]);
				}
				len--;
				sp++;
			}

		}
		System.out.println(resSp + " , " + (resSp + reslen));
		answer[0] = resSp;
		answer[1] = resSp + reslen;
		return answer;
	}
}
