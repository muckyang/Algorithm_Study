package wth;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution_D5_7206_숫자게임 {
	static int N;
	static LinkedList<Long> number;
	static LinkedList<Character> oper;
	static long result;

	public static void func(int count) {
		if (count == N / 2) {// 연산 기호 다쓴경우
			result = Math.max(result, number.get(0));
			return;
		} else {
			for (int i = 0; i < N / 2 - count; i++) {
				Long x = number.remove(i + 1);
				Long y = number.remove(i);
				char op = oper.remove(i);
				
				if (op == '*')
					number.add(i, x * y);
				else if (op == '-') {
					number.add(i, y - x);
				} else if (op == '+') {
					number.add(i, x + y);
				} else {
					System.out.println("왜죠???");
				}
//				System.out.println(number + "   " + i );
//				System.out.println(oper);
				func(count + 1);
				number.remove(i);
				number.add(i, x);
				number.add(i, y);
				oper.add(i,op);
				
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		String s = sc.next();
		result = Long.MIN_VALUE;

		number = new LinkedList<>();
		oper = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			if (i % 2 == 0)
				number.add((long) s.charAt(i) - 48);
			else
				oper.add(s.charAt(i));

		}
		func(0);
//		System.out.println(number.remove(1));
//		System.out.println(oper);
//		;
//		System.out.println(number);
//		number.add(1,number.get(1) * number.get(2));
//		System.out.println(number);
		
		System.out.println(result);

	}
}
