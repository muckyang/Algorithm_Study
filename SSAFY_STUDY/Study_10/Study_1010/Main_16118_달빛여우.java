package Study_1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16118_달빛여우 {
	static int N, M;
	static LinkedList<Point>[] list;
	static boolean v[][];
	static PriorityQueue<Point> pq;

	public static class Point implements Comparable<Point> {
		int to, value;
		int check;

		public Point(int to, int value, int check) {
			this.to = to;
			this.value = value;
			this.check = check;
		}

		@Override
		public int compareTo(Point o) {
			if (this.value == o.value) {
				return Math.abs(o.check) - Math.abs(this.check);
			}
			return this.value - o.value;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		pq = new PriorityQueue<>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		v = new boolean[3][N];
		list = new LinkedList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new LinkedList<>();
		}
		for (int j = 0; j < M; j++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int value = Integer.parseInt(st.nextToken()) * 2;
			list[from].add(new Point(to, value, 0));
			list[to].add(new Point(from, value, 0));
		}

		pq.add(new Point(0, 0, 1));// 늑대
		pq.add(new Point(0, 0, 0));// 여우
		int res = 0;
		while (!pq.isEmpty()) {
			Point p = pq.poll();
			if (v[p.check][p.to]) {
				continue;
			}
			if (p.check == 0 && !v[1][p.to] && !v[2][p.to] && !v[0][p.to]) {
				res++;
			}
			v[p.check][p.to] = true;
			for (Point k : list[p.to]) {
				int value = k.value;
				if (p.check == 1) {
					if (v[p.check+1][k.to])
						continue;
					value /= 2;
					pq.add(new Point(k.to, p.value + value, p.check + 1));
				} else if (p.check == 2) {
					if (v[p.check-1][k.to])
						continue;
					value *= 2;
					pq.add(new Point(k.to, p.value + value, p.check - 1));
				} else {
					if (v[p.check][k.to])
						continue;
					pq.add(new Point(k.to, p.value + value, p.check));
				}
			}
		}

		System.out.println(res);
	}
}
