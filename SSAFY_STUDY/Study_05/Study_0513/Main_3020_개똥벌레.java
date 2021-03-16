package Study_0513;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3020_개똥벌레 {
	static int N, H;
	static int suk[];
	static int jong[];
	static int scount[];
	static int jcount[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		suk = new int[H + 2];
		jong = new int[H + 2];
		scount = new int[H + 2];
		jcount = new int[H + 2];

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (i % 2 == 0) // 석순 ㅗ
				suk[num]++;
			else // 종유석 ㅜ
				jong[num]++;
		}

		for (int i = H; i > 0; i--) {
			scount[i] = scount[i + 1] + suk[i];
			jcount[H - i + 1] += jcount[H - i] + jong[i];
		}
		int min = Integer.MAX_VALUE;
		int minc = 0;
		for (int i = H; i >= 1; i--) {
			int k = scount[i] + jcount[i];
			if (min > k) {
				min = k;
				minc = 1;
			} else if (min == k) {
				minc++;
			}
		}
		System.out.println(min + " " + minc);
	}

}
