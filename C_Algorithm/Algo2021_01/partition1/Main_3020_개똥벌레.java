package partition1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3020_개똥벌레 {
	static int N, H;
	static int[] s;// 석순
	static int[] j;// 종유석
	static int min, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		min = Integer.MAX_VALUE;
		res = 0;
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		s = new int[H];
		j = new int[H];
		for (int i = 0; i < N; i++) {
			int high = Integer.parseInt(br.readLine());// 범위 :1 ~ (H-1)
			if (i % 2 == 0) {
				s[high]++;
			} else {
				j[high]++;
			}
		}
		int cnt = N / 2;
		for (int i = 1; i < H; i++) {
			if (min > cnt) {
				res = 1;
				min = cnt;
			} else if (min == cnt) {
				res++;
			}
			cnt -= j[i];
			cnt += s[H - i];
		}
		if (min == N / 2)
			res++;
		System.out.println(min+ " "+ res);
	}
}
