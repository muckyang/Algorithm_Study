package Study_1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_19590_비드맨 {
	static int N;
	static int list[];
	static PriorityQueue<Bid> pq;

	public static class Bid implements Comparable<Bid> {
		int bidnum;

		public Bid(int bidnum) {
			this.bidnum = bidnum;
		}

		@Override
		public int compareTo(Bid o) {
			return o.bidnum - this.bidnum;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new int[N];
		int res = 0;
		pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			pq.add(new Bid(Integer.parseInt(br.readLine())));
		}
		while (!pq.isEmpty()) {
			if (pq.size() == 1) {
				res = pq.poll().bidnum;
				break;
			}
			Bid now = pq.poll();
			Bid next = pq.poll();
			int chai = now.bidnum - next.bidnum;
			if (chai == 0)
				continue;
			pq.add(new Bid(chai));
		}
		System.out.println(res);
	}
}
