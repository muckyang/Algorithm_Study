
package Month03_Week01;

import java.util.Arrays;
import java.util.Scanner;

public class Main_15658_N과M10 {
	static int N, R, C;
	static int[] list;
	static int[] check;
	static int[] cnt;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		R = sc.nextInt();
		list = new int[N];
		check = new int[R];
		cnt = new int[10001];
		C = 0;

		for (int i = 0; i < N; i++) {
			int k = sc.nextInt();
			if (cnt[k] == 0) {
				list[C] = k;
				C++;
			}
			cnt[k]++;
		}
		Arrays.sort(list);
		combi(N-C, 0);
		System.out.print(sb);
	}

	private static void combi(int start, int count) {

		if (count == R) {
			for (int i = 0; i < R; i++)
				sb.append(check[i]).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = start; i < N; i++) {
			if (cnt[list[i]] > 0) {
				check[count] = list[i];
				cnt[list[i]]--;
				combi(i, count + 1);
				cnt[list[i]]++;
			}
		}

	}
}
