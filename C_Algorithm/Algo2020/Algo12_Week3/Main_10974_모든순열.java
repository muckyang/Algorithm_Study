package Algo12_Week3;

import java.util.Scanner;

public class Main_10974_모든순열 {

	static int N;
	static int[] list;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		list = new int[N];
		perm(0, 0);
		System.out.print(sb);
	}

	private static void perm(int flag, int count) {
		if (count == N) {
			for (int i = 0; i < N; i++)
				sb.append(list[i]).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) == 0) {
				list[count] = i + 1;
				perm((flag | 1 << i), count + 1);
			}
		}

	}
}
