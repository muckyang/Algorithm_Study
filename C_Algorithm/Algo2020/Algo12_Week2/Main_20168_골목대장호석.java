package Algo12_Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//메모리 : , 시간: 
public class Main_20168_골목대장호석 {
	static int N, M, sp, ep, Money;
	static LinkedList<Ver>[] list;
	static int min[];
	static PriorityQueue<Ver> pq;

	static int res;

	public static class Ver implements Comparable<Ver> {
		int to, max, money;
		boolean[] visit;

		public Ver(int to, int max, int money, boolean[] visit) {
			this.to = to;
			this.max = max;
			this.money = money;
			this.visit = visit;
		}

		public Ver(int to, int max, int money) {
			this.to = to;
			this.max = max;
			this.money = money;
			this.visit = new boolean[N];
		}

		public int compareTo(Ver o) {
			return this.max - o.max;
		}

		@Override
		public String toString() {
			return "Ver [to=" + to + ", max=" + max + ", money=" + money + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sp = Integer.parseInt(st.nextToken()) - 1;
		ep = Integer.parseInt(st.nextToken()) - 1;
		Money = Integer.parseInt(st.nextToken());
		list = new LinkedList[N];
		min = new int[N];
		pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			list[i] = new LinkedList<>();
			min[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int stp = Integer.parseInt(st.nextToken()) - 1;
			int edp = Integer.parseInt(st.nextToken()) - 1;
			int pay = Integer.parseInt(st.nextToken());
			list[stp].add(new Ver(edp, 0, pay));
			list[edp].add(new Ver(stp, 0, pay));
		}
		pq.add(new Ver(sp, 0, Money));
		solve();

		System.out.println(min[ep] != Integer.MAX_VALUE ? min[ep] : -1);
	}

	private static void solve() {
		while (!pq.isEmpty()) {
			Ver p = pq.poll();
			if (p.max > min[p.to])
				continue;
			if (p.to == ep) {
				min[p.to] = Math.min(min[p.to], p.max);
				continue;
			}
			p.visit[p.to] = true;
			for (Ver v : list[p.to]) {
				if (p.money >= v.money && !p.visit[v.to]) {
					pq.add(new Ver(v.to, p.max > v.money ? p.max : v.money, p.money - v.money,p.visit));
				}
			}
		}
	}

}
