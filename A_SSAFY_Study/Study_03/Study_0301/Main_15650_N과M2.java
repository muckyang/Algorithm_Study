package Study_0301;

import java.util.Scanner;

public class Main_15650_N과M2 {
	static int N, R;
	static int[] list;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		R = sc.nextInt();
		list = new int[R];
		combi(0, 0);
		System.out.print(sb);
	}

	private static void combi(int start, int count) {
		if (count == R) {
			for (int i = 0; i < R; i++)
				sb.append(list[i] + " ");
			sb.append("\n");
			return;
		}

		for (int i = start; i < N; i++) {
			list[count] = i + 1;
			combi(i + 1, count + 1);
		}

	}
}
