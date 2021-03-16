package Study_0216;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2667_단지번호붙이기 {
	static int N;
	static int[][] matrix;
	static int[] danji;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int c;

	private static void func(int i, int j) {
		for (int d = 0; d < 4; d++) {
			int ix = i + dx[d];
			int jy = j + dy[d];
			if (ix >= 0 && jy >= 0 && ix < N && jy < N && matrix[ix][jy] == 1) {
				matrix[ix][jy] = -1;
				c++;
				func(ix, jy);
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int danjinum = 0;
		N = sc.nextInt();
		matrix = new int[N][N];
		danji = new int[N * N];
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < N; j++) {
				matrix[i][j] = s.charAt(j) -48;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				c = 0;
				if (matrix[i][j] == 1) {
					matrix[i][j] = -1;
					c++;
					func(i, j);
					danji[danjinum] = c;
					danjinum++;
				}
			}
		}
		System.out.println(danjinum);
		Arrays.sort(danji);
		for (int i = 0; i < N * N; i++)
			if (danji[i] != 0)
				System.out.println(danji[i]);
	}
}
