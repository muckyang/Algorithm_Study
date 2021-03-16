package Algo12_Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11723_집합 {
	static int N;
	static boolean[] v;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		v = new boolean[20];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if (s.equals("all")) {
				Arrays.fill(v, true);
				continue;
			} else if (s.equals("empty")) {
				Arrays.fill(v, false);
				continue;
			}
			int num = Integer.parseInt(st.nextToken())-1;
			if (s.equals("add")) {
				v[num] = true;
			} else if (s.equals("remove")) {
				v[num] = false;
			} else if (s.equals("check")) {
				if (v[num])
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
			} else if (s.equals("toggle")) {
				if (v[num])
					v[num] = false;
				else
					v[num] = true;
			}
		}

		System.out.println(sb.toString());
	}

}
