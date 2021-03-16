package Study_0414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1786_찾기 {

	static StringBuilder sb = new StringBuilder();
	static int[] getPi(String pat) {
		int[] pi = new int[pat.length()];
		int j = 0;
		for (int i = 1; i < pat.length(); i++) {
			while (j > 0 && pat.charAt(i) != pat.charAt(j)) {
				j = pi[j - 1];
			}
			if (pat.charAt(i) == pat.charAt(j)) {
				pi[i] = ++j;
			}
		}
		return pi;
	}

	static int KMP(String parent, String pattern) {
		int[] table = getPi(pattern);
		int ret = 0;
		int j = 0;
		for (int i = 0; i < parent.length(); i++) {
			while (j > 0 && parent.charAt(i) != pattern.charAt(j)) {
				j = table[j - 1];
			}
			if (parent.charAt(i) == pattern.charAt(j)) {
				if (j == pattern.length() - 1) {
					sb.append((i - pattern.length() + 2)).append(" ");
					ret++;
					j = table[j];
				} else {
					j++;
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String parent = br.readLine();
		String pattern = br.readLine();
		int ans = KMP(parent, pattern);
		System.out.println(ans);
		System.out.println(sb);
	}

}