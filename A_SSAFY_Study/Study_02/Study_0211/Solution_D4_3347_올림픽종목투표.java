package Study_0211;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D4_3347_올림픽종목투표 {
	static int T, N, M;
	static int[] A;
	static int[] count;
	static Integer[] B;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			count = new int[N];
			M = sc.nextInt();
			A = new int[N];
			B = new Integer[M];

			for (int i = 0; i < N; i++)
				A[i] = sc.nextInt();
			for (int i = 0; i < M; i++)
				B[i] = sc.nextInt();

			Arrays.sort(B); // sorting 완료

			int start = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (A[j] <= B[i]) {
						count[j]++;
						break;
					}

				}
			}
			int res = 0 ;
			int result =-1;
			for(int i = 0 ; i < N; i ++) {
				int k = res;
				res = res < count[i] ? count[i] : res;
				if(k !=res)
					result = i;
			}
			System.out.println(result);
		}
	}
}
