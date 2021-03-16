package Study_0920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1948_임계경로 {
	static int N, M;
	static int maxw[];
	static int count[];

	static List<Vec>[] l;
	static PriorityQueue<Vec> pq;
	static int res, resC;
	static int sp, ep;

	public static class Vec implements Comparable<Vec> {
		int from;
		int to;
		int value;
		int c;

		public Vec(int from, int to, int value) {
			this.from = from;
			this.to = to;
			this.value = value;
		}

		@Override
		public int compareTo(Vec o) {
			return this.value - o.value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		l = new LinkedList[N + 1];
		maxw = new int[N + 1];
		count = new int[N + 1];
		pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			l[i] = new LinkedList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			l[f].add(new Vec(f, t, w));
		}
		st = new StringTokenizer(br.readLine());
		sp = Integer.parseInt(st.nextToken());
		ep = Integer.parseInt(st.nextToken());
		res = 0;
		resC = 0;
		count[sp] = 1;
		pq.add(new Vec(sp, 0, 0));
		solve();
		print();
	}

	private static void print() {
		for (int i = 1; i <= N; i++) {
			System.out.println(maxw[i] + " ," + count[i]);
		}
	}

	private static void solve() {
		int cnt = 0;
		while (!pq.isEmpty()) {
			System.out.println("cnt : " + cnt++);
			int size = pq.size();
			for (int k = 0; k < size; k++) {
				Vec v = pq.poll();
				System.out.println("v :" + v.value);
				for (Vec vp : l[v.from]) {
					System.out.println(vp.from + ","+ vp.to +"  "+vp.value);
					int sum = vp.value + v.value;
					if (sum > maxw[vp.to]) {
						count[vp.to] = 1;
						maxw[vp.to] = sum;
						pq.add(new Vec(vp.to, 0, sum));
					} else if (sum == maxw[vp.to]) {
						System.out.println(vp.to);
						count[vp.to]++;
					}else {
						System.out.println("why?");
					}
				}
			}
		}
	}
}
