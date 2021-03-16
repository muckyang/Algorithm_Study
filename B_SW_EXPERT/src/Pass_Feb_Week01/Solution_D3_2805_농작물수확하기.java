package Pass_Feb_Week01;

import java.util.Scanner;

public class Solution_D3_2805_농작물수확하기 {
	static int [][] matrix;
	static int N;
	static int sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;

		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			int su = (N - 1) / 2; // 원점 재설정 
			sum = 0;
			matrix = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				for (int j = 0; j < N; j++) {
					matrix[i][j] = (int) s.charAt(j);
					if (Math.abs(i - su) + Math.abs(j - su) <= su) {
						sum += matrix[i][j] - 48 ;
					}
				}
			}
			System.out.println("#" + test_case + " " + sum);
		}

	}
}
