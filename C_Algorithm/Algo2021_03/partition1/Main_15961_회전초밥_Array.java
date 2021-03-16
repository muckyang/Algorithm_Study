package partition1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main_15961_회전초밥_Array {
	static int N, d, k, c;// 갯수 종류 연속 쿠폰
	static int sushi[];
	static int visit[];
//	static HashMap<Integer, Integer> hm;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		hm = new HashMap<>();

		N = Integer.parseInt(st.nextToken());

		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		sushi = new int[N];
		visit = new int[d+1];
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			int eat = sushi[i];
			if (visit[eat] == 0) {
				cnt++;
			}
			visit[eat]++;
		}
		answer = cnt;

		for (int i = 0; i < N; i++) {
			int del = sushi[i];
			int ins = sushi[(i + k) % N];

			if (visit[del] == 1)
				cnt--;
			visit[del]--;

			if (visit[ins] == 0)
				cnt++;
			visit[ins]++;
			answer = Math.max(answer, cnt + bonus());
		}

		System.out.println(answer);
	}

	private static int bonus() {
		if (visit[c] > 0) {
			return 0;
		}
		return 1;
	}
}
