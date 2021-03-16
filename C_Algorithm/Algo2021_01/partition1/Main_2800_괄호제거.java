package partition1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeSet;

public class Main_2800_괄호제거 {
	static Stack<Integer> sk;
	static LinkedList<Bracket> list;
	static LinkedList<Integer> dlist;
	static TreeSet<String> answer;
	static String s;
	static int bcnt;

	public static class Bracket {
		int open;
		int close;

		public Bracket(int open, int close) {
			this.close = close;
			this.open = open;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		sk = new Stack<>();
		list = new LinkedList<>();
		answer = new TreeSet<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				sk.add(i);
				bcnt++;
			} else if (s.charAt(i) == ')') {
				list.add(new Bracket(sk.pop(), i));
			}
		}
		solve(0, 0, new LinkedList<Integer>());
		StringBuilder sb = new StringBuilder();
		
		for(String k : answer) {
			sb.append(k).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void solve(int st, int count, LinkedList<Integer> del) {
		if (bcnt < count)
			return;
		if (count != 0) {
			LinkedList<Integer> deltemp = del;
			Collections.sort(deltemp, Collections.reverseOrder());
			String temp = s;

			for (int k : deltemp) {
				if (k == temp.length() -1) {
					temp = temp.substring(0, temp.length() - 1);
				} else if (k == 0) {
					temp = temp.substring(1, temp.length() );
				} else {
					temp = temp.substring(0, k ) + temp.substring(k + 1, temp.length());
				}

			}
			answer.add(temp);
		}
		for (int i = st; i < bcnt; i++) {
			Bracket b = list.get(i);
			del.add(b.close);
			del.add(b.open);
			solve(i + 1, count + 1, del);
			del.remove((Integer)b.close);
			del.remove((Integer)b.open);
		}
	}
}
