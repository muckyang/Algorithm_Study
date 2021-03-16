package Study_0218;

import java.util.Scanner;

public class Solution_D4_1219_길찾기 {
	static int s, e;
	static int N;
	static boolean[][] matrix;
	static boolean res;

	private static void func(int x, int y, int c) {
		if (x == 99) {
			res = true;
			return;
		}
		for (int j = y; j < 100; j++) {
			if (matrix[x][j] == true) {
				matrix[x][j] = false;
				func(j, 0, c + 1);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case < 11; test_case++) {
			int T = sc.nextInt();
			int N = sc.nextInt();
			res = false;
			matrix = new boolean[100][100];
			for (int i = 0; i < N; i++) {
				s = sc.nextInt();
				e = sc.nextInt();
				matrix[s][e] = true;
			}

			func(0, 0, 0);

			System.out.println("#" + test_case + " " + (res == true ? 1 : 0));
		}
	}


}
