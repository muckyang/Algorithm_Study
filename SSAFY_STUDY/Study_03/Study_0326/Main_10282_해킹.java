package Study_0326;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_10282_해킹 {
	static int T, N, M, S;
	static List<Point>[] Link;
	static int[] dist;
	static boolean[] v;
	static PriorityQueue<Point> pq;
	static int res, max;

	static class Point implements Comparable<Point> {
		int link;
		int v;

		public Point(int link, int v) {
			this.link = link;
			this.v = v;
		}

		@Override
		public int compareTo(Point o) {
			return this.v - o.v;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			S = sc.nextInt() - 1;
			pq = new PriorityQueue<>();
			v = new boolean[N];
			Link = new LinkedList[N];
			res = 1;
			max = Integer.MIN_VALUE;
			dist = new int[N];
			for (int i = 0; i < N; i++) {
				Link[i] = new LinkedList<>();
			}
			Arrays.fill(dist, Integer.MAX_VALUE);
			v[S] = true;
			for (int i = 0; i < M; i++) {
				int to = sc.nextInt() - 1;
				int from = sc.nextInt() - 1;
				int value = sc.nextInt();
				Link[from].add(new Point(to, value));
				if (from == S) {
					dist[to] = value;
					pq.add(new Point(to, value));
				}
			}
			solve();
			for(int i = 0 ; i < N ; i++) {
				if(dist[i] != Integer.MAX_VALUE && max < dist[i])
					max=dist[i];
			}
			System.out.println(res + " " + (max == Integer.MIN_VALUE ? 0 : max));
		}
	}

	private static void solve() {
		while (!pq.isEmpty()) {
			Point p = pq.poll();
			if (!v[p.link]) {
				v[p.link] = true;
				res++;
			}
			if (res == N)
				return;
			for (Point next : Link[p.link]) {
				if (dist[next.link] > p.v + next.v) {
					dist[next.link] = p.v + next.v;
					pq.add(new Point(next.link, p.v + next.v));
				}
			}
		}
	}
}
