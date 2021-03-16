package Algo12_Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10819_차이를최대로 {
	static int N;
	static int arr[];
	static int temp[];
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		temp = new int[N];
		res = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		solve(0, new boolean[N]);
		System.out.println(res);
	}

	private static void solve(int cnt, boolean[] v) {
		if (cnt == N ) {
			int sum = 0;
			for (int i = 0; i < N - 1; i++) {
				sum += Math.abs(temp[i] - temp[i + 1]);
			}
			res = Math.max(res, sum);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!v[i]) {
				temp[cnt] = arr[i];
				v[i] = true;
				solve(cnt + 1, v);
				v[i] = false;
			}
		}
	}
}
