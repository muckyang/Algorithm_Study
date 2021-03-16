package Study_0316;

import java.util.Scanner;

public class Main_5015_Ls {
	static String P;
	static int N;
	static String word;
	static StringBuilder sb;
	static int v[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		P = sc.next();
		N = sc.nextInt();
		sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			v = new int[101][101];
			word = sc.next();
			if (solve(0, 0) == 1) {
				sb.append(word).append("\n");
			}
		}
		System.out.println(sb.toString());

	}

	private static int solve(int w, int p) {
		int res = v[w][p];
		if (res != 0) {
			return res;
		}
		// 두 문자가 같을 때
		if (w < word.length() && p < P.length() && (P.charAt(p) == word.charAt(w))) {
			v[w][p] = solve(w + 1, p + 1);
			return v[w][p];
		} else if (P.length() == p) {
			if (w== word.length()) {
				v[w][p] = 1;
				return res = v[w][p];
			}
		} else if (P.charAt(p) == '*') {
			if (solve(w + 1, p) == 1 || (P.length() > p && solve(w, p + 1) == 1)) {
				v[w][p] = 1;
				return res = v[w][p];
			}
			v[w][p] = -1;
			return res = v[w][p];
		}
		v[w][p] = -1;
		return res = v[w][p];
	}
}