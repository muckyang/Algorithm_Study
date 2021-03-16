package partition2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main_14226_이모티콘 {
	static int res[][];
	static PriorityQueue<Emoticon> pq;

	static int N;
	static int answer;

	public static class Emoticon implements Comparable<Emoticon> {
		int cnt;
		int now;
		int clone;

		public Emoticon(int cnt, int now, int clone) {
			this.clone = clone;
			this.cnt = cnt;
			this.now = now;

		}

		@Override
		public int compareTo(Emoticon e) {
			return this.cnt - e.cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		res = new int[1001][1001];
		answer = Integer.MAX_VALUE;
		pq = new PriorityQueue<>();

		for (int i = 0; i < 1001; i++)
			Arrays.fill(res[i], Integer.MAX_VALUE);
		pq.add(new Emoticon(0, 1, 0));
		solve();// 횟수, 현재 수, 복사된 수
		System.out.println(answer);
	}

	private static void solve() {
		while (!pq.isEmpty()) {
			int size = pq.size();
			for (int i = 0; i < size; i++) {
				Emoticon p = pq.poll();
				if (p.now > 1000 || p.now < 1)
					continue;
				if (p.now == N) {
					answer = p.cnt;
					return;
				}
				if (p.clone != p.now && res[p.now][p.now] > p.cnt + 1) {
					res[p.now][p.now] = p.cnt + 1;
					pq.add(new Emoticon(p.cnt + 1, p.now, p.now));
				}
				if (res[p.now-1][p.now] > p.cnt + 1) {
					res[p.now - 1][p.clone] = p.cnt + 1;
					pq.add(new Emoticon(p.cnt + 1, p.now - 1, p.clone));
				}
				if (p.now + p.clone < 1001 && p.clone != 0 && res[p.now + p.clone][p.clone] > p.cnt + 1) {
					res[p.now + p.clone][p.clone] = p.cnt + 1;
					pq.add(new Emoticon(p.cnt + 1, p.now + p.clone, p.clone));
				}
			}

		}
	}
}
