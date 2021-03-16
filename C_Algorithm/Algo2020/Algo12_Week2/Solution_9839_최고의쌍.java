package Algo12_Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9839_최고의쌍 {
	static String s;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int[] arr;
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int res = -1;
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < N ; i++) {
				for (int j = i + 1; j < N; j++) {
					int x = arr[i] * arr[j];
					
					if (res < x && isGood(x))
						res =  x;
				}
			}
			System.out.println("#" + t + " " + res);
		}
	}

	private static boolean isGood(int x) {
		s = x + "";
		int prev = (int) s.charAt(0);
		for (int i = 1; i < s.length(); i++) {
			if(prev +1 != (int)s.charAt(i))
				return false;
			prev ++;
		}
		return true;
	}

}
