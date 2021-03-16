package Study_0705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916_최소비용구하기 {
	static int N, M;
	static int city[];
	static List<Bus> list[];
	static PriorityQueue<Bus> pq;
	static int res;

	public static class Bus implements Comparable<Bus> {
		int to;
		int value;

		public Bus(int to, int value) {
			this.to = to;
			this.value = value;
		}

		@Override
		public int compareTo(Bus o) {
			return this.value - o.value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		list = new LinkedList[N];
		city = new int[N];
		for (int i = 0; i < N; i++) {
			city[i] = Integer.MAX_VALUE;
			list[i] = new LinkedList<>();
		}

		pq = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new Bus(to, weight));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()) - 1;
		int end = Integer.parseInt(st.nextToken()) - 1;
		pq.add(new Bus(start, 0));
		city[start] = 0;
		solve(end);
		System.out.println(res);
	}

	private static void solve(int end) {
		while (!pq.isEmpty()) {
			Bus p = pq.poll();
			if (p.to == end) {
				res = p.value;
				return;
			}
			for (Bus i : list[p.to]) {
				int sumv = i.value + p.value;
				if (city[i.to] > sumv) {
					city[i.to] = sumv;
					pq.add(new Bus(i.to, sumv));
				}
			}
		}
	}
}
