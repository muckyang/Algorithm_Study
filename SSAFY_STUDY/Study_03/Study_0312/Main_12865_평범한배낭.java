package Study_0312;

import java.util.Arrays;
import java.util.Scanner;

public class Main_12865_평범한배낭 {
	static int N, K;
	static int[] weight;
	static int[] value;
	static int res;
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		weight = new int[N];
		value = new int[N];

		dp = new int[N];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for (int i = 0; i < N; i++) {
			weight[i] = sc.nextInt();
			value[i] = sc.nextInt();
		}
	}
}
