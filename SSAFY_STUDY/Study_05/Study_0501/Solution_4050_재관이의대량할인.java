package Study_0501;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution_4050_재관이의대량할인 {

	static int T;
	static int N;
	static Integer[] C;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int testcase = 1; testcase <= T; testcase++) {
			N = sc.nextInt();
			C = new Integer[N];
			for (int i = 0; i < N; i++) {
				C[i] = sc.nextInt();
			}
			Arrays.sort(C, Collections.reverseOrder());
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (i % 3 == 2) {
					continue;
				}
				sum += C[i];
			}
			System.out.println("#" + testcase + " " + sum);
		}
	}
}