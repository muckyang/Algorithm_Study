package Main_00001_to_2000;

import java.util.Scanner;

public class Main_1389_케빈베이컨의6단계법칙 {
	static int N, K;
	static int[][] matrix;
	static int[][] count;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		matrix = new int[N][N];
		count = new int[N][N];

		for (int i = 0; i < K; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			matrix[x][y] = 1;
			matrix[y][x] = 1;
		}
		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			dfs(i, i, 1);
		}
		int[] sumc = new int[N];
		int res = -1;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(count[i][j] + " ");
			}
			System.out.println();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sumc[i] += count[i][j];
			}
			System.out.println(sumc[i] + " ");
			if (sumc[i] < min) {
				min = sumc[i];
				res = i + 1;
			}
		}

		System.out.println(res);
	}

	private static void dfs(int sp, int linked, int c) {
		if (c != 1 && visited[linked])
			return;
		for (int i = 0; i < N; i++) {
			if (matrix[linked][i] == 1) {
				
				if ((count[sp][i] == 0 || count[sp][i] > c) &&  sp != i) {
					visited[linked] = true;
					count[sp][i] = c;
				}
				dfs(sp, i, c + 1);
			}

		}
	}
}
