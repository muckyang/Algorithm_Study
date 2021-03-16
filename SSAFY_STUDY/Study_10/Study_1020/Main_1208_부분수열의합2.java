package Study_1020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1208_부분수열의합2 {
	static int N, S;
	static int list[];
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		list = new int[N];
		for (int i = 0; i < N; i++)
			list[i] = Integer.parseInt(st.nextToken());
		cnt = 0;
		for (int i = 0; i < N; i++) {
			int start = i;
			int end = N - 1;
			while (start != end) {
				int size = end - start;
				if (S == sum(start, end)) {
					cnt++;
				}
			}
		}
	}

	private static int sum(int st, int ed) {
		int sum = 0;
		for (int i = st; i < ed; i++)
			sum += list[i];
		return sum;
	}
}
