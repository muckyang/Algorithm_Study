package Main_02001_to_4000;

import java.util.Scanner;

public class Main_2789_블랙잭 {
	static int N, M;
	static int[] list;
	static int max;
	static int[] k;

	public static void nCr(int N, int R, int start, int count) {
		if (R == count) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += k[i];
			}
			if (sum <= M)
				max = Math.max(max, sum);

			return;
		}

		for (int i = start; i < N; i++) {
			k[count] = list[i];
			nCr(N, R, i + 1, count + 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		max = Integer.MIN_VALUE;
		list = new int[N];
		k = new int[3];
		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();

		}

		nCr(N, 3, 0, 0);
		
		
		System.out.println(max);
	}
}
