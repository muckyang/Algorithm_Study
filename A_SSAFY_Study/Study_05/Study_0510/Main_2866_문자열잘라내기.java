package Study_0510;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main_2866_문자열잘라내기 {
	static int R, C;
	static String input[];
	static String list[];
	static Set<String> set;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		input = new String[R];
		list = new String[C];
		for (int i = 0; i < R; i++)
			input[i] = sc.next();
		int res = 0;

		set = new TreeSet<>();
		for (int i = 0; i < C; i++) {
			String s = "";
			for (int j = 0; j < R; j++) {
				s += input[j].charAt(i);
			}
			list[i] = s;
		}
		for (int i = 1; i < R; i++) {
			set = new TreeSet<>();
			for (int j = 0; j < C; j++) {
				set.add(list[j].substring(i, list[j].length()));
			}
			if (set.size() != C)
				break;
			res++;
		}
		System.out.println(res);
	}
}