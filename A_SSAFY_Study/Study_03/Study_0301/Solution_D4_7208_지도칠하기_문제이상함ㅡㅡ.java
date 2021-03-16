package Study_0301;

import java.util.Scanner;

public class Solution_D4_7208_지도칠하기_문제이상함ㅡㅡ {
	static int T, N;
	static boolean[][] map;
	static int[] list;
	static int res;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			map = new boolean[N][N];
			list = new int[N];
			res = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++)
				list[i] = sc.nextInt();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int k = sc.nextInt();
					if (k == 1)
						map[i][j] = true;
				}
			}
			
			

		}
	}
}
