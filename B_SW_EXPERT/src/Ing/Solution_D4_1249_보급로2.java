package Ing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution_D4_1249_보급로2 {
	static int T, N;
	static int[][] matrix;
	static int[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int re;

	public static void T_4way(int x, int y) {
		for (int d = 0; d < 4; d++) {
			if (x + dx[d] < N && y + dy[d] < N && x + dx[d] >= 0 && y + dy[d] >= 0)
				visited[x + dx[d]][y + dy[d]] = 1;
		}
	}

	public static void F_4way(int x, int y) {
		for (int d = 0; d < 4; d++) {
			if (x + dx[d] < N && y + dy[d] < N && x + dx[d] >= 0 && y + dy[d] >= 0)
				visited[x + dx[d]][y + dy[d]] = 0;
		}
	}

	public static int func(int x, int y, int sum) {
// System.out.println("sum : " + sum );
		if ((x == N - 1 && y == N - 1) || re < sum) {
			return sum;
		} else {
			for (int d = 0; d < 4; d++) {
				if (x + dx[d] < N && y + dy[d] < N && x + dx[d] >= 0 && y + dy[d] >= 0
						&& visited[x + dx[d]][y + dy[d]] == 0) {
					T_4way(x, y);
					re = Math.min(re, func(x + dx[d], y + dy[d], sum + matrix[x + dx[d]][y + dy[d]]));
					F_4way(x, y);
				} else {
					return re;
				}
			}
		}
		return re;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// Scanner sc = new Scanner(System.in);
		T = Integer.parseInt(br.readLine());
		// T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			// N=sc.nextInt();
			N = Integer.parseInt(br.readLine());

			matrix = new int[N][N];
			visited = new int[N][N];

			for (int i = 0; i < N; i++) {
				// String s = sc.next();
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					matrix[i][j] = s.charAt(j) - 48;
				}
			}

			re = Integer.MAX_VALUE;

			visited[0][0] = 1;
			int result = func(0, 0, matrix[0][0]);

			System.out.println("#" + test_case + " " + result);

		}
	}
}
