package Study_0517;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2070_목걸이수열 {
	static String s;
	static int count[];
	static int zcount[];
	static StringBuilder sb;
	static boolean v[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		sb = new StringBuilder();
		v = new boolean[s.length()];
		count = new int[s.length()];
		zcount = new int[s.length()];
		int index = -1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				if (i != 0)
					zcount[i] = zcount[i - 1] + 1;
				index = i;
			} else {
				if (index != -1)
					count[index]++;
			}
		}
		for (int i = 0; i < s.length(); i++)
			System.out.print(count[i]);
		System.out.println();
		for (int i = 0; i < s.length(); i++)
			System.out.print(zcount[i]);
		System.out.println();
		int maxv = 0;
		int maxz = 1;
		int st = s.charAt(0);
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				if (st == '1') {
					v[i] = true;
					st = '0';
					continue;
				}
				if (maxv != 0 || count[i] < maxv || zcount[i] > maxz) {
					v[i] = true;
					maxz = 1;
					maxv = 0;
					continue;
				}
				maxz++;
				maxv = count[i];
			} else {
				
				continue;
			}
		}

		sb.append("(");
		for (int i = 0; i < s.length(); i++) {
			if (v[i])
				sb.append(")(");
			sb.append(s.charAt(i));
		}

		sb.append(")");
		System.out.println(sb.toString());
	}
}
