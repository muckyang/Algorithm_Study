package partition2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_09613_GCD합 {
	static int T;
	static int N;
	static int list[];
	static int select[];
	static long res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			list = new int[N];
			select = new int[2];
			for (int i = 0; i < N; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
			res = 0;
			combi(0, 0);
			sb.append(res).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void combi(int start, int cnt) {
		if (cnt == 2) {
			res += solve(select[0], select[1]);
			return;
		}
		for (int i = start; i < N; i++) {
			select[cnt] = list[i];
			combi(i + 1, cnt + 1);
		}
	}

	private static long solve(int a, int b) {

		while (true) {
			if (a > b) {
				int temp = a;
				a = b;
				b = temp;
			}
			if (b % a == 0)
				return a;
			b = b % a;
		}
	}
}
