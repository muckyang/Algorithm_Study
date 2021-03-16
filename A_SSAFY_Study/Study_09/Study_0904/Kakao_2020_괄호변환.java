package Study_0904;

import java.util.LinkedList;
import java.util.Queue;

public class Kakao_2020_괄호변환 {
	public static void main(String[] args) {
		String p = "))()))((((";
		System.out.println(solution(p));
	}

	public static String solution(String p) {
		String result = "";
		Queue<Character> q = new LinkedList<>();
		int num = 0;
		int index = 0;
		while (index != p.length()) {
			if (num == 0 && q.size() == 0) {
				if (p.charAt(index) == '(') {
					q.add('(');
					num++;
				} else {
					q.add('(');
					num--;
				}
			} else if (num > 0) {
				if (p.charAt(index) == '(') {
					q.add('(');
					num++;
				} else {
					q.add(')');
					num--;
				}
			} else if (num < 0) {
				if (p.charAt(index) == ')') {
					q.add('(');
					num--;
				} else {
					q.add(')');
					num++;
				}
			}
			if (num == 0) {
				while (!q.isEmpty()) {
					Character c = q.poll();
					result += "" + c;
				}
			}
			index++;
		}
		
		return result;
	}
	
	public static void str() {
		String s = "123";
		String s1 = "123sd";
		int num = 213;
		String num1 = ""+num;
		System.out.println(s+s1);
	}
}
