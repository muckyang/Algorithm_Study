package Study_0301;

import java.util.Scanner;

public class Main_15649_N과M1 {
	static int N, R;
	static int[] list;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		N = sc.nextInt();
		R = sc.nextInt();
		list = new int[R];
		perm(0, 0);
		System.out.print(sb);
	}

	private static void perm(int flag, int count) {
		if (count == R) {
			for (int i = 0; i < R; i++)
				sb.append(list[i] + " ");
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
