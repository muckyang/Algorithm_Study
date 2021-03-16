package Study_0224;

import java.util.Scanner;

public class Main_1316_그룹단어체커 {
	static boolean[] list;
	static int N;
	static final char[] alpha = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
			'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			list = new boolean[26];
			int check =0;
			aa: for (int k = 0; k < s.length(); k++) {
				char c = s.charAt(k);
				for (int a = 0; a < 26; a++) {
					if ((alpha[a] == c && !list[a]) ) {
						list[a] = true;
						break;
					} else if (list[a] && alpha[a] == c && c != s.charAt(k - 1)) {
						check = 1;
						break aa;
					}
				}
				
			}
			if(check ==0)
				cnt++;
		}
		System.out.println(cnt);
	}
}
