package Algo12_Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_9095_123더하기 {
	static int N;
	static StringBuilder sb;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			res = 0;
			solve(0, Integer.parseInt(st.nextToken()));
			sb.append(res).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void solve(int cnt, int su) {
		if (su == 0) {
			res++;
			return;
		}
		for (int i = 1; i < 4; i++) {
			if (su - i < 0)
				return;
			solve(cnt + 1, su - i);
		}
	}
}
