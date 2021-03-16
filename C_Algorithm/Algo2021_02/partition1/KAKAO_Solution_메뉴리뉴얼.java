package partition1;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;


public class KAKAO_Solution_메뉴리뉴얼 {
	public static void main(String[] args) {
		String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
		int[] course = { 2, 3, 4 };
		solution(orders, course);
		// result = ["AC", "ACDE", "BCFG", "CDE"]
	}

	static HashMap<String, Integer>[] hm;

	public static class Menu implements Comparable<Menu> {
		String str;
		int count;

		public Menu(String str, int count) {
			this.str = str;
			this.count = count;

		}

		public int compareTo(Menu m) {
			return m.count -this.count;
		}

	}

	public static String[] solution(String[] orders, int[] course) {
		String[] answer;
		LinkedList<String> list = new LinkedList<>();
		hm = new HashMap[11];
		for (int i = 0; i < 11; i++) {
			hm[i] = new HashMap<>();
		}
		for (int i = 0; i < orders.length; i++) {
			String str = orders[i];
			char c[] = new char[str.length()];
			c = str.toCharArray();
			Arrays.sort(c);
			solve(c, 0, 0, "");
		}
		for (int i = 0; i < course.length; i++) {
			int k = course[i];
			PriorityQueue<Menu> pq = new PriorityQueue<>();
			Iterator<String> it = hm[k].keySet().iterator();
			while (it.hasNext()) {
				String str = (String) it.next();
				pq.add(new Menu(str, hm[k].get(str)));
			}
			int max = Integer.MIN_VALUE;
			if (!pq.isEmpty()) {
				max = pq.peek().count;
			}
			while (!pq.isEmpty()) {
				Menu m = pq.poll();
				if (m.count == 1) {
					break;
				} else if (m.count == max) {
					list.add(m.str);
				} else {
					break;
				}
			}
		}
		Collections.sort(list);
		answer = new String[list.size()];
		int cnt = 0 ;
		for (String s : list) {
			answer[cnt++] = s;
			System.out.println(s);
		}
		
		return answer;

	}

	private static void solve(char[] c, int cnt, int start, String res) {
		if (cnt > 1) {
			if (hm[cnt].containsKey(res)) {
				hm[cnt].put(res, hm[cnt].get(res) + 1);
			} else {
				hm[cnt].put(res, 1);
			}
		}
		for (int i = start; i < c.length; i++) {
			solve(c, cnt + 1, i + 1, res + c[i]);
		}
	}
}
