
package Main_14001_to_16000;

import java.util.Arrays;
import java.util.Scanner;

public class Main_15655_N과M7 {
	static int N, R;
	static int[] list;
	static int[] check;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		R = sc.nextInt();
		list = new int[N];
		check = new int[R];
		for (int i = 0; i < N; i++)
			list[i] = sc.nextInt();
		Arrays.sort(list);
		perm(0);
		System.out.print(sb);
	}

	private static void perm(int count) {
		
		if (count == R) {
			for (int i = 0; i < R; i++)
				sb.append(check[i]).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			check[count] = list[i];
			perm(count + 1);
		}

	}
}
