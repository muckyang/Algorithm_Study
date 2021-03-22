package Line2021;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class pro2 {

	//
//	[1] 알파벳 대문자(A~Z)
//	[2] 알파벳 소문자(a~z)
//	[3] 숫자(0~9)
//	[4] 특수문자(~!@#$%^&*)
	/// 3종류 이상포함해야함
	// 동일문자 4개연속 x
	// 동일문자 5개 들어가면 x
	/// 1 ≤ inp_str의 길이 ≤ 1,000,000
	// password로 허용되지 않는 특수문자(()-_=+)가 inp_str에는 나타날 수 있습니다.

//	1.8 ≤ password 길이 ≤ 15
//	2.password는 아래 4 종류의 문자 그룹을 제외한, 다른 어떤 문자도 포함해서는 안됩니다.
//	[1] 알파벳 대문자(A~Z)
//	[2] 알파벳 소문자(a~z)
//	[3] 숫자(0~9)
//	[4] 특수문자(~!@#$%^&*)
//	3.password는 (2.)에서 명시된 4 종류의 문자 그룹 중에서 3 종류 이상을 포함해야 합니다.
//	4.password에 같은 문자가 4개 이상 연속될 수 없습니다.
//	5.password에 같은 문자가 5개 이상 포함될 수 없습니다.
	// 위배되는 번호 저장[1,2,3,4,5]// 정상비번이면 0
	public static void main(String[] args) {
		int[] arr = solution("UUUUU");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");

		}
		System.out.println();
	}

	public static int[] solution(String inp_str) {
		List<Integer> list = new ArrayList<>();
		int len = inp_str.length();
		HashMap<Character, Integer> hm = new HashMap();

		if (15 < len || len < 8) {// 1번
			list.add(1);
		}

		boolean second = true;
		boolean[] third = new boolean[4];
		boolean forth = true;
		boolean fifth = true;
		int linkcnt = 0;
		char before = '\u0000';
		for (int i = 0; i < len; i++) {

			char c = inp_str.charAt(i);

			if (isTrue(c)) {
				if (hm.containsKey(c)) {
					hm.put(c, hm.get(c) + 1);
				} else {
					if (!third[0] && 'A' <= c && c <= 'Z') {
						third[0] = true;
					} else if (!third[1] && 'a' <= c && c <= 'z') {
						third[1] = true;
					} else if (!third[2] && '0' <= c && c <= '9') {
						third[2] = true;
					} else if (!third[3]) {
						third[3] = true;
					}
					hm.put(c, 1);
				}

			} else if (second) {
				list.add(2);
				second = false;
			}

			if (forth) {
				if (c == before) {
					linkcnt++;

				}
				if (linkcnt > 3) {
					list.add(4);
					forth = false;
				}

			}
			if (c != before) {
				linkcnt = 1;
			}
			before = c;

		}

		int thirdcnt = 0;
		for (int i = 0; i < third.length; i++) {
			if (third[i])
				thirdcnt++;
		}
		if (thirdcnt < 3) {
			list.add(3);
		}

		Iterator<Character> it = hm.keySet().iterator();

		while (it.hasNext()) {
			if (fifth) {
				if (hm.get(it.next()) >= 5) {
					fifth = false;
					list.add(5);
					break;
				}
			}

		}

		Collections.sort(list);
		int[] answer = new int[1];
		answer[0] = 0;
		if (list.size() > 0) {
			answer = new int[list.size()];
			for (int num = 0; num < list.size(); num++) {
				answer[num] = list.get(num);
			}
		}

		return answer;
	}

	// ()-_=+
	public static boolean isTrue(char c) {
		switch (c) {
		case '(':
			return false;
		case ')':
			return false;
		case '+':
			return false;
		case '-':
			return false;
		case '=':
			return false;
		case '_':
			return false;
		}
		return true;
	}
}
