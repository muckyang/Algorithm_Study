
package Month03_Week01;

import java.util.Arrays;
import java.util.Scanner;

public class Main_15656_N과M8 {
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
		combi(0,0);
		System.out.print(sb);
	}

	private static void combi(int start,int count) {
		
		if (count == R) {
			for (int i = 0; i < R; i++)
				sb.append(check[i]).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = start; i < N; i++) {
			check[count] = list[i];
			combi(i,count + 1);
		}

	}
}
