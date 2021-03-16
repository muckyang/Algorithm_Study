package Uncomplete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class AMain_2001_보석줍기 {
	static int N, M, K;
	static boolean jew[];
	static List<Island>[] list;
	static Queue<Point> q;

	public static class Island {
		int to, weight;

		public Island(int to, int weight) {
			this.to = to;
			this.weight = weight;

		}
	}

	public static class Point {
		int to, min, jewcnt;

		public Point(int to, int min, int jewcnt) {
			this.to = to;
			this.min = min;
			this.jewcnt = jewcnt;

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new LinkedList[N];
		jew = new boolean[N]; 
		q = new LinkedList<>();

		for (int i = 0; i < N; i++)
			list[i] = new LinkedList<>();
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			jew[Integer.parseInt(st.nextToken())] = true;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new Island(to, weight));
			list[to].add(new Island(from, weight));
		}
		q.add(new Point(0, Integer.MAX_VALUE, 0)); // Min = MAXVALUE
		solve();

	}

	private static void solve() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				for (Island k : list[p.to]) {
					if (jew[k.to]) {
						q.add(new Point(k.to, Math.min(p.min, k.weight), p.jewcnt + 1));
					} else {
						q.add(new Point(k.to, Math.min(p.min, k.weight), p.jewcnt));
					}

				}
			}
		}
	}
}
