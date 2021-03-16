package Main_10001_to_12000;

import java.util.Arrays;
import java.util.Scanner;

public class Main_11404_플로이드 {
	static int mat[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		mat = new int[N][N];
		int K = sc.nextInt();
		for (int i = 0; i < N; i++) {
			Arrays.fill(mat[i], Integer.MAX_VALUE);
		}
		for (int i = 0; i < K; i++) {
			int from = sc.nextInt() - 1;
			int to = sc.nextInt() - 1;
			int v = sc.nextInt();
			if (mat[from][to] > v)
				mat[from][to] = v;
		}

		for (int link = 0; link < N; link++) {
			for (int to = 0; to < N; to++) {
				if (link == to)
					continue;
				for (int from = 0; from < N; from++) {
					if (link == from || to == from)
						continue;
					if (mat[from][link] == Integer.MAX_VALUE || mat[link][to] == Integer.MAX_VALUE)
						continue;

					mat[from][to] = Math.min(mat[from][to], mat[from][link] + mat[link][to]);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (mat[i][j] == Integer.MAX_VALUE)
					System.out.print(0 + " ");
				else
					System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
}
