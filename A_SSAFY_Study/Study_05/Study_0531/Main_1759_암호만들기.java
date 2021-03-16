package Study_0531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759_암호만들기 {

	static int L, C;
	static char list[];
	static char combi[];
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		list = new char[C];
		combi = new char[L];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < C; i++)
			list[i] = st.nextToken().charAt(0);

		Arrays.sort(list);

		solve(0, 0, 0, 0);// st , cnt
		System.out.print(sb.toString());
	}

	private static void solve(int st, int cnt, int ja, int mo) {
		if (cnt == L) {
			if (ja > 1 && mo > 0) {
				for (int i = 0; i < L; i++) {
					sb.append(combi[i]);
				}
				sb.append("\n");
			}
			return;
		}
		for (int i = st; i < C; i++) {
			combi[cnt] = list[i];
			if (isAEIOU(list[i])) {
				mo++;
			} else {
				ja++;
			}
			solve(i + 1, cnt + 1, ja, mo);
			if (isAEIOU(list[i])) {
				mo--;
			} else {
				ja--;
			}
		}

	}

	private static boolean isAEIOU(char d) {
		if (d == 'a' || d == 'e' || d == 'i' || d == 'o' || d == 'u')
			return true;
		return false;
	}
}
