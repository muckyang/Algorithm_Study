package Study_04Fail;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_2629_양팔저울_시간초과 {
	static int N, K;
	static int[] choo;
//	static boolean[] v;
	static Set<Integer> set;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		choo = new int[N];
		set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			choo[i] = sc.nextInt();
		}
		K = sc.nextInt();
		combi(0, 0, 0);
		
		for (int i = 0; i < K; i++) {
			int gooseul = sc.nextInt();
			if (set.contains(gooseul))
				System.out.print("Y ");
			else
				System.out.print("N ");
		}
	}

	private static void combi(int start, int count, int sum) {
		if (count > 0) {
			set.add(sum);
		}
		if (count == N)
			return;
		for (int i = start; i < N; i++) {
			count++;
			combi(i + 1, count, sum - choo[i]);
			combi(i + 1, count, sum + choo[i]);

		}
	}
}
