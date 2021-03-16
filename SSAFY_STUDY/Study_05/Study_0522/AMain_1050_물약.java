package Study_0522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
//45%까지 돌다가 틀림 ㅡㅡ

public class AMain_1050_물약 {
	static int N, M;
	static String menu[];
	static HashMap<String, Long> hm;
	static boolean check;
	static long res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		hm = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			long num = Long.parseLong(st.nextToken());
			hm.put(s, num);
		}
		menu = new String[M];
		for (int i = 0; i < M; i++)
			menu[i] = br.readLine();

		check = false;
		while (!check) {
			check = true;
			Solve();
		}
		if (!hm.containsKey("LOVE"))
			res = -1;
		else
			res = hm.get("LOVE");
		System.out.println(hm.toString());
		
		System.out.println(res > 1000000000 ? 1000000001 : res);
	}

	private static void Solve() {
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(menu[i], "=");
			String S = st.nextToken();
			long SumPay = 0L;
			st = new StringTokenizer(st.nextToken(), "+");
			while (st.hasMoreTokens()) {
				String element = st.nextToken();
				int weight = element.charAt(0) - '0';
				element = element.substring(1);
				if (!hm.containsKey(element)) {
					SumPay = -1;
					break;
				}
				SumPay += (long) weight * hm.get(element);
			}
			if (SumPay != -1) {
				if (!hm.containsKey(S)) {
					check = false;
					hm.put(S, SumPay);
				} else if (hm.get(S) > SumPay) {
					check = false;
					hm.put(S, SumPay);
				}
			}

		}
	}
}
