package Main_02001_to_4000;

import java.util.Scanner;

public class Main_3985_롤케이크 {
	static int N;
	static int T;
	static int[] cake;
	static boolean[] eat;// 1번부터 N번까지
	static int res1,res2;
	static int[] s;
	static int[] e;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		T = sc.nextInt();// 방청객도 1번부터임
		cake = new int[N + 1];
		eat = new boolean[N + 1];
		s = new int[T + 1];
		e = new int[T + 1];

		int r1 = -1;
		for (int i = 1; i < T + 1; i++) {
			s[i] = sc.nextInt();
			e[i] = sc.nextInt();
			if (e[i] - s[i] + 1 > r1) {
				r1 = e[i] - s[i] + 1;
				res1 = i;
			}
		}
		int r2 = -1;
		for (int i = 1; i < T + 1; i++) {
			int cnt = 0;
			for (int k = s[i]; k <= e[i]; k++) {
				if (!eat[k]) {
					eat[k] = true;
					cnt++;
				}
			}
			if(r2 < cnt) {
				r2 = cnt;
				res2 = i;
			}
		}
		System.out.println(res1);
		System.out.println(res2);

	}
}
