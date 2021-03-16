package Study_1020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1654_랜선자르기 {
	static int N, K;
	static int list[];
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		res = 1;
		BinarySearch(1, Integer.MAX_VALUE);
		System.out.println(res);
	}

	private static void BinarySearch(int st, int ed) {
		// TODO Auto-generated method stub
		int size = ed - st + 1;
		if (size == 0)
			return;
		int mid = size / 2 + st;

		int su = solve(mid);
		if (su >= K) {
			res = Math.max(res, mid);
			BinarySearch(mid + 1, ed);
		} else {
			BinarySearch(st, mid - 1);
		}
		return;
	}

	private static int solve(int mid) {
		int sum = 0;
		for (int i = 0; i < N; i++)
			sum += list[i] / mid;
		return sum;
	}
}
