package Study_0301;

import java.util.Scanner;

public class Main_15652_N과M4 {
	static int N, R;
	static int[] list;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		R = sc.nextInt();
		list = new int[R];
		perm(0, 0);
		System.out.print(sb);
	}

	private static void perm(int start, int count) {
		if (count == R) {
			for (int i = 0; i < R; i++)
				sb.append(list[i]).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = start; i < N; i++) {
			list[count] = i + 1;
			perm(i , count + 1);
		}

	}
}