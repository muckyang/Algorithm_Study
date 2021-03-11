package KAKAO_2020_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class sol2 {
	static String res;

	public static void main(String[] args) {
		String[] orders = { "XYZ", "XWY", "WXA" };
		int[] course = { 2, 3, 4 };

		String[] result = solution(orders, course);
		System.out.println();
	}

	static HashMap<String, Integer>[] hm;
	static char[] word;

	public static String[] solution(String[] orders, int[] course) {
		String[] answer = {};
		LinkedList<String> resultlist = new LinkedList<>();
		hm = new HashMap[11];
		int count[] = new int[11];
		for (int i = 0; i < 11; i++)
			hm[i] = new HashMap<>();

		for (int i = 0; i < orders.length; i++) {
			String s = orders[i];
			res = "";
			solve(s, 0, 0);
		}
		for (int i = 0; i < course.length; i++) {
			int num = course[i];
			Iterator<String> iterator = hm[num].keySet().iterator();

			LinkedList<String> list = new LinkedList<>();

			while (iterator.hasNext()) {
				String iter = iterator.next();
				if (hm[num].get(iter) < 2)
					continue;
				if (count[num] < hm[num].get(iter)) {
					count[num] = hm[num].get(iter);
					list = new LinkedList<>();
					list.add(iter);
				} else if (count[num] == hm[num].get(iter)) {
					list.add(iter);
				}
			}

			for (int k = 0; k < list.size(); k++)
				resultlist.add(list.get(k));

		}
		answer = new String[resultlist.size()];
		for (int i = 0; i < resultlist.size(); i++)
			answer[i] = resultlist.get(i);
		Arrays.sort(answer);

		return answer;
	}

	private static void solve(String s, int start, int cnt) {
		if (cnt == s.length() + 1)
			return;
		if (cnt > 1) {
			char[] c = res.toCharArray();
			Arrays.sort(c);
			
			String res2 = "";
			for (int i = 0; i < cnt; i++)
				res2 += c[i];
			
			if (!hm[cnt].containsKey(res2)) {
				hm[cnt].put(res2, 1);
			} else {
				System.out.println(res2);
				hm[cnt].put(res2, hm[cnt].get(res2) + 1);
			}

		}
		for (int i = start; i < s.length(); i++) {
			res += s.charAt(i);
			solve(s, i + 1, cnt + 1);
			res = res.substring(0, res.length() - 1);
		}
	}
}
