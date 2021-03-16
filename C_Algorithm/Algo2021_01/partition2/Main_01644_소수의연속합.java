package partition2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_01644_소수의연속합 {
	static final int MAX = 4000000;
	static int[] arr = new int[300000];
	static boolean[] bool = new boolean[MAX + 1];
	static int sp, ep, N;
	static int cnt, sum, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cnt = sp = ep = res = sum = 0;
		calPrime();
		setPrime();
		while (ep < cnt) {
			if (sum < N) {
				sum += arr[ep++];
				continue;
			}
			if (sum == N)
				++res;
			sum -= arr[sp++];
		}
		System.out.println(res);
	}

	public static void calPrime() {
		int sqrt = (int) Math.sqrt(MAX);
		for (int i = 2; i <= sqrt; i++) {
			if (bool[i]) {
				continue;
			}

			for (int j = i + i; j <= MAX; j += i) {
				bool[j] = true;
			}
		}
	}

	public static void setPrime() {
		for (int i = 2; i <= MAX; i++) {
			if (!bool[i]) {
				arr[cnt++] = i;
			}
		}
	}

}
