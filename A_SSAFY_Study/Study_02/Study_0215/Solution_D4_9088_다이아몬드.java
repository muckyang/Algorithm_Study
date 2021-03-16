package Study_0215;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D4_9088_다이아몬드 {
	static int T, N, cover;
	static int[] dia;
	static int[] cnt;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			cover = sc.nextInt();
			dia = new int[N];
			cnt = new int[N];
			for (int i = 0; i < N; i++)
				dia[i] = sc.nextInt();

			Arrays.sort(dia);
			int count = 0;
			int sp = 0;
			for (int i = 0; i < N; i++) {
				for(int j = 0; j <= count;j++) {
					if(dia[j]+cover <= dia[i]) {
						cnt[j]++;
					}
				}
				count++;
			}
			int max = 0;
			for(int i = 0; i < cnt.length;i++) {
				if(max < cnt[i])
					max=cnt[i];
			}
			System.out.println("#" + test_case + " " + max);
		}
	}
}
