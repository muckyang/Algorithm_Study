package Study_0531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_3425_고스택 {
	static List<String> Slist;
	static List<Long> Nlist;
	static Stack<Long> stack;
	static boolean quit;
	static BufferedReader br;
	static StringTokenizer st;
	static boolean error;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			Slist = new LinkedList<String>();
			Nlist = new LinkedList<Long>();
			Input();
			if (quit)
				break;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				stack = new Stack<Long>();
				Calc();
			}
			br.readLine();// 공백 처리부분
			System.out.println();
		}

	}

	private static void Calc() throws IOException {
		st = new StringTokenizer(br.readLine());
		error = false;
		int numcount = 0;
		stack.add(Long.parseLong(st.nextToken()));
		for (String s : Slist) {
			if (s.equals("NUM")) {
				stack.add(Nlist.get(numcount));
				numcount++;
			} else if (s.equals("POP")) {
				if (stack.size() == 0) {
					error = true;
					break;
				}
				stack.pop();
			} else if (s.equals("INV")) {
				if (stack.size() == 0) {
					error = true;
					break;
				}
				long num = stack.pop();
				num *= -1;
				stack.add(num);
			} else if (s.equals("DUP")) {
				if (stack.size() == 0) {
					error = true;
					break;
				}
				long num = stack.peek();
				stack.add(num);
			} else if (s.equals("SWP")) {
				if (stack.size() < 2) {
					error = true;
					break;
				}
				long num1 = stack.pop();
				long num2 = stack.pop();
				stack.add(num1);
				stack.add(num2);
			} else if (s.equals("ADD")) {
				if (stack.size() < 2) {
					error = true;
					break;
				}
				long num = stack.pop();
				num += stack.pop();
				if (Math.abs(num) > 1000000000) {
					error = true;
					break;
				}
				stack.add(num);
			} else if (s.equals("SUB")) {
				if (stack.size() < 2) {
					error = true;
					break;
				}
				long num1 = stack.pop();
				long num2 = stack.pop();
				if (Math.abs(num2 - num1) > 1000000000) {
					error = true;
					break;
				}
				stack.add(num2 - num1);
			} else if (s.equals("MUL")) {
				if (stack.size() < 2) {
					error = true;
					break;
				}
				long num = stack.pop();
				num *= stack.pop();
				if (Math.abs(num) > 1000000000) {
					error = true;
					break;
				}
				stack.add(num);
			} else if (s.equals("MOD")) {
				if (stack.size() < 2) {
					error = true;
					break;
				}
				long num1 = stack.pop();
				long num2 = stack.pop();
				long num = num2 % num1;
				stack.add(num);
			}else if (s.equals("DIV")) {
				if (stack.size() < 2) {
					error = true;
					break;
				}
				long num1 = stack.pop();
				long num2 = stack.pop();
				long num = num2 / num1;
				stack.add(num);
			}
		}
		if(stack.size() != 1) {
			error = true;
		}
		if (error)
			System.out.println("ERROR");
		else
			System.out.println(stack.get(0));
	}

	private static void Input() throws IOException {
		while (true) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if (s.equals("NUM")) {
				long num = Long.parseLong(st.nextToken());
				Nlist.add(num);
			}
			Slist.add(s);
			if (s.equals("END"))
				return;
			if (s.equals("QUIT")) {
				quit = true;
				return;
			}
		}
	}
}
