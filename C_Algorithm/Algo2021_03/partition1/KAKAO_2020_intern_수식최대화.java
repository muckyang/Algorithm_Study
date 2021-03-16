package partition1;

import java.util.Stack;

public class KAKAO_2020_intern_수식최대화 {
	static long number[];
	static int pri[];
	static int exp[];
	static Stack<Long> ns;
	static Stack<Integer> cs;

	static boolean v[];
	static int ncnt;
	static long res;

	public static void main(String[] args) {
		long res = solution("50*6-3*2");
		System.out.println(res);
	}

	private static long solution(String expression) {

		number = new long[50];
		exp = new int[50];
		ncnt = 0;
		res = 0;
		String num = "";
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if ('0' <= c && c <= '9') {
				num += c;
			} else {
				number[ncnt] = Long.parseLong(num);
				if (c == '-')
					exp[ncnt] = 0;
				else if (c == '+')
					exp[ncnt] = 1;
				else if (c == '*')
					exp[ncnt] = 2;

				ncnt++;
				num = "";
			}
		}
		number[ncnt] = Integer.parseInt(num);
		ncnt++;
		pri = new int[3]; // + ,- ,* 순서
		v = new boolean[3];
		perm(0);

		return res;
	}

	private static void perm(int cnt) {
		if (cnt == 3) {
			// 연산진행
			res = Math.max(res, solve());

			return;

		}
		for (int i = 0; i < 3; i++) {
			if (!v[i]) {
				v[i] = true;
				pri[cnt] = i;
				perm(cnt + 1);
				v[i] = false;
			}
		}
	}

	private static long solve() {
		ns = new Stack<>();
		cs = new Stack<>();
		ns.add(number[0]);
		int pointer = 1;
		while (pointer <= ncnt) {// 아직 스택에 다 넣지 않은 경우
			Long next = number[pointer];
			int c = exp[pointer-1];
			while (true) {
				if (cs.isEmpty() || pri[cs.peek()] >= pri[c]) {
					StackPush(next, c);
					break;
				} else {
					StackPop(next,c);
					next = ns.pop();
				}
			}
			System.out.println(ns.toString());
			System.out.println(cs.toString());
			pointer++;
		}

		// 스택에 다 넣고 나서
		while (ns.size() > 1) {
			StackPop(-1,-1);
		}
		System.out.println(ns.peek());
		return Math.abs(ns.pop());
	}

	private static void StackPop(long top,int exp) {
		if (top == -1) {
			top = ns.pop();
			exp = cs.pop();
		}
		Long next = ns.pop();
		if (exp == 0)
			ns.push(next - top);
		if (exp == 1)
			ns.push(next + top);
		if (exp == 2)
			ns.push(next * top);
	}

	private static void StackPush(Long next, int c) {
		ns.push(next);
		cs.push(c);
	}

}
