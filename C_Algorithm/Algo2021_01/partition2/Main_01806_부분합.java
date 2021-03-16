package partition2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_01806_부분합 {
	static int N, S;
	static int list[];
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		min = Integer.MAX_VALUE;
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		list = new int[N];

		for (int i = 0; i < N; i++)
			list[i] = Integer.parseInt(st.nextToken());
		solve(0, 0, list[0]);

		System.out.println(min == Integer.MAX_VALUE ? 0 : min);
	}

	private static void solve(int st, int ed, int value) {
		if (ed >= N || st >= N)
			return;
		if (value >= S) {
			min = Math.min(min, ed - st + 1);
			solve(st + 1, ed, value - list[st]);
			return;
		}
		if (ed < N-1)
			solve(st, ed + 1, value + list[ed + 1]);
	}
}
