package Study_0201;

import java.util.Scanner;

public class Solution_D3_8016_홀수피라미드 {
	static long T, N;
	static long r_s, r_e;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		T = sc.nextLong();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextLong();
			
//			r_s = (long)Math.pow(N-1,2) * 2L + 1;//1000000000 입력시 2부족현상발생
//			r_e = (long)Math.pow(N,2) *2 -1;
			
			r_s = (N - 1) * (N - 1) * 2 + 1;
			r_e = N * N * 2 - 1;

			System.out.println("#" + test_case + " " + r_s + " " + r_e);
		}

	}
}