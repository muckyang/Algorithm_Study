package Algo12_Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_10570_제곱팰린드롬수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		boolean[] isPalendrome = new boolean[32];
		for (int i = 1; i < 32; i++) {
			if (check(i) && check((int)Math.pow(i, 2))) {
				isPalendrome[i] = true;
			}
		}
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int res = 0;
			int start = (int)Math.ceil(Math.sqrt(Integer.parseInt(st.nextToken())));
			int end = (int)Math.floor(Math.sqrt(Integer.parseInt(st.nextToken())));
			for(int i = start; i <= end ; i++) {
				if(isPalendrome[i])
					res++;
			}
			System.out.println("#" + t + " " + res);
		}
	}

	private static boolean check(int num) {
		String s_num = num + "";
		int cnt = 0;
		while (cnt < s_num.length() / 2) {
			if (s_num.charAt(cnt) != s_num.charAt(s_num.length() - cnt-1))
				return false;
			cnt++;
		}

		return true;
	}
}
