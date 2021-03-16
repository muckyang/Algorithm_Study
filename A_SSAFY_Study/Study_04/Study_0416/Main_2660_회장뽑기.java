package Study_0416;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main_2660_회장뽑기 {
	static int matrix[][];
	static ArrayList<Integer> al;
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(matrix[i], Integer.MAX_VALUE);
		}
		while (true) {
			int from = sc.nextInt() - 1;
			int to = sc.nextInt() - 1;
			if (from == -2 && to == -2) {
				break;
			}
			matrix[from][to] = matrix[to][from] = 1;
		}

		min = Integer.MAX_VALUE;
		for (int l = 0; l < N; l++) {
			for (int to = 0; to < N; to++) {
				if (to == l)
					continue;
				for (int from = 0; from < N; from++) {
					if (l == from || from == to)
						continue;
					if (matrix[from][l] == Integer.MAX_VALUE || matrix[l][to] == Integer.MAX_VALUE)
						continue;
					matrix[from][to] = Math.min(matrix[from][l] + matrix[l][to], matrix[from][to]);
				}
			}
		}


		int value[] = new int[N];
		for (int i = 0; i < N; i++) {
			int max = 0;
			for (int j = 0; j < N; j++) {
				if (max < matrix[i][j] && matrix[i][j] != Integer.MAX_VALUE) {
					max = matrix[i][j];
					value[i] = max;
				}
			}
			if (max < min)
				min = max;
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (min == value[i])
				cnt++;
		}
		System.out.println(min + " " + cnt);
		for (int i = 0; i < N; i++) {
			if (min == value[i])
				System.out.print(i + 1 + " ");
		}

	}
}
