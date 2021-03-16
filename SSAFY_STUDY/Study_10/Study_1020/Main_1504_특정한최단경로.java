package Study_1020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1504_특정한최단경로 {
	static int N, E;
	static LinkedList<Ver>[] list;
	static PriorityQueue<Ver> pq;

	public static class Ver implements Comparable<Ver> {
		int from, to, value;

		public Ver(int from, int to, int value) {
			this.from = from;
			this.to = to;
			this.value = value;
		}

		public int compareTo(Ver o) {
			return this.value - o.value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new LinkedList[N];
		pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++)
			list[i] = new LinkedList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken()) - 1;
			int t = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken());
			list[f].add(new Ver(f, t, v));
			list[t].add(new Ver(t, f, v));
		}
		st = new StringTokenizer(br.readLine());
		int fp = Integer.parseInt(st.nextToken())-1;
		int sp = Integer.parseInt(st.nextToken())-1;
		int end = N - 1;
		int res = Math.min(solve(0, fp) + solve(fp, sp) + solve(sp, end),
				solve(0, sp) + solve(sp, fp) + solve(fp, end));
		if (res <0)
			res = -1;
		System.out.println(res);
	}

	private static int solve(int start, int end) {
		pq = new PriorityQueue<>();
		boolean[] v = new boolean[N];
		pq.add(new Ver(0, start, 0));
		while (!pq.isEmpty()) {
			int size = pq.size();
			for (int i = 0; i < size; i++) {
				Ver ver = pq.poll();
				if (ver.to == end)
					return ver.value;
				if (v[ver.to])
					continue;
				v[ver.to] = true;
				for (Ver next : list[ver.to]) {
					int value = ver.value + next.value;
					pq.add(new Ver(next.from, next.to, value));

				}

			}
		}
		
		return Integer.MIN_VALUE;
	}
}
