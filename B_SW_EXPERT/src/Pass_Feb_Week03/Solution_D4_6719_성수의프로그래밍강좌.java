package Pass_Feb_Week03;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D4_6719_성수의프로그래밍강좌 {
	static int T, N, K;
	static int[] list;
	static double res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			K = sc.nextInt();
			list = new int[N];
			res = 0.0;
			for (int i = 0; i < N; i++) {
				list[i] = sc.nextInt();
			}
			Arrays.sort(list);
			for (int i = N - K; i < N; i++) {
				res = (res + list[i]) / 2.0;
			}
			System.out.printf("#" + test_case + " %f\n", res);
		}
	}
}
