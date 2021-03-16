package Study_0216;

import java.util.Scanner;

public class Main_11403_경로찾기_미완성 {
	static int N;
	static int[][] matrix;
	static int[] visited;

	public static void func(int sp) {
		if (visited[sp] == 1) {
			for (int i = 0; i < visited.length; i++) {
				if (visited[i] == 1)
					matrix[sp][i] = 1;
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if (matrix[sp][i] == 1) {
				visited[sp] = 1;
				func(i);
				visited[sp] = 0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		matrix = new int[N][N];
		visited = new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < N; i++)
			func(i);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
