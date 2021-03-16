package Study_0222;

import java.util.Scanner;

public class Main_2178_미로탐색미완성 {
	static int N, M;
	static int[][] matrix;
	static boolean[][] visited;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++) {
				matrix[i][j] = s.charAt(j) - 48 ;
			}
		}
	}
}
