package Study_0520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4386_별자리만들기 {
	static int N;
	static double[][] list;

	static int v[];
	static PriorityQueue<Point> pq;

	static double sum;

	public static class Point implements Comparable<Point> {
		int x, y;
		double distance;

		public Point(int x, int y, double distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

		@Override
		public int compareTo(Point o) {
			if (this.distance > o.distance )
				return 1;
			else if (this.distance < o.distance)
				return -1;
			else
				return 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		pq = new PriorityQueue<>();
		v = new int[N];
		sum = 0.0;
		list = new double[N][2];
		for (int i = 0; i < N; i++) {
			v[i] = i;
			st = new StringTokenizer(br.readLine());
			list[i][0] = Double.parseDouble(st.nextToken());
			list[i][1] = Double.parseDouble(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				double di = Math.sqrt(Math.pow(list[i][0] - list[j][0], 2) + Math.pow(list[i][1] - list[j][1], 2));
				pq.add(new Point(i, j, di));
			}
		}
		solve();
		System.out.printf("%.2f",sum);
	}

	private static void solve() {
		while (!pq.isEmpty()) {
			Point p = pq.poll();
			if (v[p.x] == v[p.y])
				continue;
			int from = v[p.x];
			int to = v[p.y];
			for (int i = 0; i < N; i++) {
				if (v[i] == to)
					v[i] = from;
			}
			sum += p.distance;
		}
	}
}
