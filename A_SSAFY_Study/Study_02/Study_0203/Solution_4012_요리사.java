package Study_0203;

import java.util.Scanner;

public class Solution_4012_요리사 {
	static int[][] matrix;
	static int T;
	static int N;
	static int[] k;
	static int min;

	public static void func(int r, int start, int cnt) {
		if (cnt == r) {
			
			int k1 = matrix[k[0]][k[1]] + matrix[k[1]][k[0]]; 
			int k2 = matrix[k[2]][k[3]] + matrix[k[3]][k[2]]; 
			int abs1 = Math.abs(k1 - k2);
			
			int k3 = matrix[k[2]][k[1]] + matrix[k[1]][k[2]]; 
			int k4 = matrix[k[0]][k[3]] + matrix[k[3]][k[0]]; 
			int abs2 = Math.abs(k3 - k4);
			int k5 = matrix[k[1]][k[3]] + matrix[k[3]][k[1]]; 
			int k6 = matrix[k[0]][k[2]] + matrix[k[2]][k[0]]; 
			int abs3 = Math.abs(k5 - k6);
			abs1 = Math.min(abs1, abs3);
			abs1 = Math.min(abs1, abs2);
			min = Math.min(min, abs1);
			return;
		} else {
			for (int i = start; i < N; i++) {
				k[cnt] = i;
				func(r, i + 1, cnt + 1);
			}
			return;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			k = new int[4];
			matrix = new int[N][N];
			min = Integer.MAX_VALUE;
			int count = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}


			func(4, 0, 0);

			System.out.println("#" + test_case + " " + min);
		}
	}
}
