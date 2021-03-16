package Study_0402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607_페르마의소정리 {
	private static final int MOD = 1234567891;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tcase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			long factorial[] = new long[n + 1];
			factorial[0] = 1;
			for (int i = 1; i <= n; i++)
				factorial[i] = (factorial[i - 1] * i) % MOD;

			long bottom = (factorial[r] * factorial[n - r]) % MOD;
			long reBottom = ferma(bottom, MOD - 2);

			System.out.println("#" + t + " " + (factorial[n] * reBottom) % MOD);
		}
	}

	private static long ferma(long n, int x) {
		if (x == 0)
			return 1;
		long tmp = ferma(n, x / 2);
		long ret = (tmp * tmp) % MOD;
		if (x % 2 == 0)
			return ret;
		else
			return (ret * n) % MOD;
	}
}