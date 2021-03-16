package Complete;

import java.util.Scanner;
import java.util.Stack;

public class Solution_D4_1224_계산기3 {
	static int N;// 더미변수
	static String S;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String backlist;
		Stack<Character> C_stack = new Stack<>();
		Stack<Integer> C_Intstack = new Stack<>();
		
		for (int test_case = 1; test_case < 11; test_case++) {
			N = sc.nextInt();
			S = sc.next();
			backlist ="";
			for (int i = 0; i < S.length(); i++) {
				if (47 < S.charAt(i) && S.charAt(i) <= 57) { // 숫자받은 경우
					backlist = backlist + S.charAt(i);
				} else { // 연산자 받은경우
					if (S.charAt(i) == '+') {
						if (C_stack.isEmpty()) {
							C_stack.add(S.charAt(i));
						} else if (C_stack.peek() == '+' ) {
							backlist = backlist + C_stack.pop();
							C_stack.add(S.charAt(i));
						}else if(C_stack.peek() == '*') {
							backlist = backlist + C_stack.pop();
							C_stack.add(S.charAt(i));
						
						}else if(C_stack.peek() == '('){
							C_stack.add(S.charAt(i));
						}else {
							while(C_stack.peek() != '(') {
								backlist = backlist + C_stack.pop();
							}
							char dum = C_stack.pop();
						}
					} else if(S.charAt(i) == '*'){ // * 받은경우
						if (C_stack.isEmpty()) {
							C_stack.add(S.charAt(i));
						} else if (C_stack.peek() == '+') {
							C_stack.add(S.charAt(i));
						} else if (C_stack.peek() == '*') {
							backlist = backlist + C_stack.pop();
							C_stack.add(S.charAt(i));
						}else if(C_stack.peek() == '('){
							C_stack.add(S.charAt(i));
						}
					}else if(S.charAt(i) == '(') {
						C_stack.add(S.charAt(i));
					}else {
						while(C_stack.peek() != '(') {
							backlist = backlist + C_stack.pop();
						}
						char dum = C_stack.pop();
					}
				}
				
			}
			while (!C_stack.isEmpty()) { //스택에 남은 부호 뒤쪽으로 붙여준다.
				backlist = backlist + C_stack.pop();
			}

			//System.out.println(backlist);
			char [] c_list = backlist.toCharArray();
			int r1,r2;
			for(int i = 0 ; i < c_list.length; i++) {
				if(c_list[i] != '+' && c_list[i] != '*' )
					C_Intstack.add((int)c_list[i] - 48);
				else {
					r1 =C_Intstack.pop();
					r2 =C_Intstack.pop();
					
					if(c_list[i] == '+')
						C_Intstack.add(r1 + r2);
					if(c_list[i] == '*')
						C_Intstack.add(r1 * r2);
				}
			}
			System.out.println("#" + test_case + " " + C_Intstack.pop() );
			C_Intstack.clear();
			C_stack.clear();
		}
	}
}
