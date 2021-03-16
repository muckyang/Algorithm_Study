package Study_0926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1167_트리의지름 {
	static int N;
	static LinkedList<Point>[] l;
	static boolean v[];
	static Queue<Point> q;
	static int res;
	static int d;

	public static class Point {
		int from;
		int to;
		int weight;

		public Point(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		l = new LinkedList[N];
		res = 0;
		for (int i = 0; i < N; i++) {
			l[i] = new LinkedList<>();
		}
		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			while (true) {
				int to = Integer.parseInt(st.nextToken()) - 1;
				if (to == -2)
					break;
				int weight = Integer.parseInt(st.nextToken());
				l[from].add(new Point(from, to, weight));
			}
		}
		d = 0;
		q = new LinkedList<>();
		v = new boolean[N];
		v[0] = true;
		q.add(new Point(0, 0, 0));
		solve();
		res = 0;
		v = new boolean[N];
		v[d] = true;
		q.add(new Point(0, d, 0));
		solve();

		System.out.println(res);

	}

	public static void solve() {
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (Point i : l[p.to]) {
				if (!v[i.to]) {
					if (res < p.weight + i.weight) {
						res = p.weight + i.weight;
						d = i.to;
					}
					v[i.to] = true;
					q.add(new Point(i.from, i.to, p.weight + i.weight));
				}
			}
		}
	}
}
