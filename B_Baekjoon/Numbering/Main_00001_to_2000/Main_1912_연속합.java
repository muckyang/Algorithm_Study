package Main_00001_to_2000;

import java.util.Scanner;

public class Main_1912_연속합 {
	static int N;
	static int[] maxnow;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		maxnow = new int[N];
		max = sc.nextInt();
		maxnow[0] = max;
		for (int i = 1; i < N; i++) {
			int su = sc.nextInt();
			if (maxnow[i - 1] > 0) {
				maxnow[i] = maxnow[i - 1] + su;
			} else {
				maxnow[i] = su;
			}
			if (maxnow[i] > max)
				max = maxnow[i];
		}
		System.out.println(max);
	}
}
