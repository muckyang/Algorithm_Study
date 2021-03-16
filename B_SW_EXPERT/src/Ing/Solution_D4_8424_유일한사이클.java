package Ing;

import java.util.Scanner;

public class Solution_D4_8424_유일한사이클 {
	static int T, N;
	static boolean[] list;
	static int [][] visited;
	static int result;
	
	public static void func() {
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			result = 0;
			list = new boolean[N];
			visited = new int[N][N];
			for (int i = 0; i < N; i++) {
				int x =sc.nextInt();
				int y= sc.nextInt();
				visited[x][y] = 1;
				
			}
			
			func();
		}
	}
}
