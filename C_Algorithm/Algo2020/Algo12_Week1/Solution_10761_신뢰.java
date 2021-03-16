package Algo12_Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_10761_신뢰 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int b = 1;
			int o = 1;
			String now = "";
			int during = 0;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				String color = st.nextToken();
				int index = Integer.parseInt(st.nextToken());
				if (now.equals(color)) {
					int time = 0;
					if (color.equals("B")) {
						time = Math.abs(index - b) + 1;
						b = index;
					} else {
						time = Math.abs(index - o) + 1;
						o = index;
					}

					during += time;
					cnt += time;
				} else {
					int time = 0;
					if (color.equals("B")) {
						time = Math.abs(index - b) + 1;
						b = index;
					} else {
						time = Math.abs(index - o) + 1;
						o = index;
					}
					if (during < time) {
						cnt += time - during;
						during = time-during;
					}
					else {
						cnt++;
						during = 1;
					}
				}
				now = color;
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
}
