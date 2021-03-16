package Month03_Week03;

import java.util.Scanner;

public class Main_1003_피보나치함수 {
	static int T, N;
	static long dp[];
	static int zc[];
	static int oc[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			N = sc.nextInt();
			dp = new long[N + 1];
			zc = new int[N + 1];
			oc = new int[N + 1];

			if (N > -1) {
				dp[0] = 0;
				zc[0] = 1;
				oc[0] = 0;
			}
			if (N > 0) {
				dp[1] = 1;
				zc[1] = 0;
				oc[1] = 1;
			}
			zsolve(N);
			osolve(N);
			System.out.println(zc[N] + " " + oc[N]);
		}
	}

	private static int osolve(int su) {
		if (su == 0) {
			return 0;
		} else if (su == 1) {
			return 1;
		}
		if (oc[su] != 0)
			return oc[su];
		return oc[su] = osolve(su - 1) + osolve(su - 2);
	}

	private static int zsolve(int su) {
		if (su == 0) {
			return 1;
		} else if (su == 1) {
			return 0;
		}
		if (zc[su] != 0)
			return zc[su];
		return zc[su] = zsolve(su - 1) + zsolve(su - 2);
	}
}
