package Study_0226;

import java.util.Scanner;
import java.util.Stack;

public class Main_5397_키로거 {
	static int T;
	static Stack<Character> stack;
	static Stack<Character> stackp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			stack = new Stack<>();
			stackp = new Stack<>();
			String s = sc.next();
			char [] c = s.toCharArray();
			int len = c.length;
			for (int i = 0; i < len; i++) {
				if(c[i]=='<') {
					if(!stack.isEmpty()) {
						stackp.add(stack.pop());
					}
				}else if(c[i]=='>') {
					if(!stackp.isEmpty()) {
						stack.add(stackp.pop());
					}
				}else if(c[i]=='-') {
					if(!stack.isEmpty()) {
						stack.pop();
					}
				}else {
					stack.add(s.charAt(i));
				}
			}
			s = "";
			StringBuilder sb = new StringBuilder();
			while(!stackp.isEmpty())
				stack.add(stackp.pop());

			int k= stack.size();
			for(int i = 0; i < k;i++)
				sb.append(stack.get(i));
			System.out.println(sb);
		}
	}
}
