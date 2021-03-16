package partition2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_05557_1학년 {
	static int N;
	static int list[];
	static long cache[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new int[N];
		cache = new long[N][21];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solve(1, list[0]));
	}

	private static long solve(int cnt, int num) {
		if (cnt == N - 1) {
			if (num == list[N - 1])
				return cache[cnt][num] = 1;
			return cache[cnt][num] = 0;
		}
		if (cache[cnt][num] != 0)
			return cache[cnt][num];
		long res = 0;
		if (num + list[cnt] <= 20)
			res += solve(cnt + 1, num + list[cnt]);
		if (num - list[cnt] >= 0)
			res += solve(cnt + 1, num - list[cnt]);
		return cache[cnt][num] = res;
	}
}
