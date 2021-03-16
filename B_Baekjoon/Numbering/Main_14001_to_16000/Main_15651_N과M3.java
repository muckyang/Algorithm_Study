package Main_14001_to_16000;

import java.util.Scanner;

public class Main_15651_N과M3 {
	static int N, R;
	static int[] list;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb= new StringBuilder();
		N = sc.nextInt();
		R = sc.nextInt();
		list = new int[R];
		perm(0);
		System.out.print(sb);
	}

	private static void perm(int count) {
		if (count == R) {
			for (int i = 0; i < R; i++)
				sb.append(list[i]).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			list[count] = i + 1;
			perm(count + 1);
		}

	}
}
