package partition2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_04811_알약 {
	static int N;
	static long cache[][][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			cache = new long[N + 1][N + 1][2 * N + 1];
			sb.append(solve(0, N,0)).append("\n");
		}

		System.out.println(sb.toString());
	}

	private static long solve(int h, int w, int day) {
		if (day == 2 * N) {
			return cache[h][w][day] = 1;
		}
		if (cache[h][w][day] != 0)
			return cache[h][w][day];
		long res = 0L;

		if (w > 0)
			res += solve(h + 1, w - 1, day + 1);
		if (h > 0)
			res += solve(h - 1, w, day + 1);
		return cache[h][w][day] =res;
	}
}
