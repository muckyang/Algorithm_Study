package Algo12_Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1182_부분수열의합 {
	static int N, S;
	static int arr[];
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		res = 0;
		solve(0, 0, 0);
		System.out.println(res);
	}

	private static void solve(int start, int cnt, int sum) {
		if (sum == S && cnt > 0)
			res++;
		for (int i = start; i < N; i++) {
			solve(i + 1, cnt + 1, sum + arr[i]);
		}

	}
}
