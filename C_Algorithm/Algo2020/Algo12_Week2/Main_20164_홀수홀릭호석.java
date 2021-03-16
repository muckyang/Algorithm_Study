package Algo12_Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//12040 , 88
public class Main_20164_홀수홀릭호석 {
	static int max, min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		solve(N, 0);
		System.out.println(min + " " + max);
	}

	private static void solve(int number, int cnt) {
		String snum = "" + number;
		for (int i = 0; i < snum.length(); i++) {
			if ((int) snum.charAt(i) % 2 == 1)
				cnt++;
		}

		if (snum.length() == 1) {
			max = Math.max(max, cnt);
			min = Math.min(min, cnt);
			return;
		} else if (snum.length() == 2) {
			solve(Integer.parseInt(snum.substring(0, 1)) + Integer.parseInt(snum.substring(1, 2)), cnt);
		} else if (snum.length() > 2) {// 길이 3이상
			select(snum, 0, 0, cnt, new int[2]);
		}

	}

	private static void select(String snum, int ccnt, int start, int cnt, int[] sel) {
		if (ccnt == 2) {
			int next = Integer.parseInt(snum.substring(0, sel[0] + 1))
					+ Integer.parseInt(snum.substring(sel[0] + 1, sel[1] + 1))
					+ Integer.parseInt(snum.substring(sel[1] + 1, snum.length()));
			solve(next, cnt);
			return;
		}
		for (int i = start; i < snum.length() - 1; i++) {

			sel[ccnt] = i;
			select(snum, ccnt + 1, i + 1, cnt,sel);
		}
	}
}
