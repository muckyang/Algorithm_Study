package Main_02001_to_4000;

import java.util.Scanner;

public class Main_2980_도로와신호등 {
	static int N, L;
	static int[] l;
	static int[] r;
	static int[] g;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		l = new int[N];
		r = new int[N];
		g = new int[N];

		for (int i = 0; i < N; i++) {
			l[i] = sc.nextInt();
			r[i] = sc.nextInt();
			g[i] = sc.nextInt();
		}
		int nowdist = 0;
		int times = 0;

		for (int i = 0; i < N; i++) {
			times += l[i] - nowdist;
			nowdist = l[i];

			int k = r[i] + g[i];
			int nam = times % k;
			if (nam > r[i]) {
				continue;
			} else {
				times += r[i] - nam;
			}
		}
		times += L - nowdist;
		System.out.println(times);

	}
}
