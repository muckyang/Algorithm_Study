package Study_0409;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_1197_최소스패닝트리 {
	static int N, M;
	static int v[];
	static PriorityQueue<Point> pq;
	static long res;

	static class Point implements Comparable<Point> {
		int x;
		int y;
		long value;

		public Point(int x, int y, long value) {
			this.x = x;
			this.y = y;
			this.value = value;

		}

		@Override
		public int compareTo(Point o) {
			if (this.value > o.value)
				return 1;
			else
				return -1;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		v = new int[N];
		pq = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			int v = sc.nextInt();
			pq.add(new Point(x, y, v));
		}
		int cnt = 0;
		res = 0;
		for (int i = 0; i < N; i++) {
			v[i] = i;
		}
		while (!pq.isEmpty()) {
			if (cnt == N - 1)
				break;
			Point p = pq.poll();
			if (v[p.x] == v[p.y]) {
				continue;
			} else if (v[p.x] != v[p.y]) {
				int from = v[p.x];
				int to = v[p.y];
				for (int i = 0; i < N; i++) {
					if (v[i] == from)
						v[i] = to;
				}
				res += p.value;
				cnt++;
			}
		}
		System.out.println(res);
	}
}
