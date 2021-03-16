package Main_00001_to_2000;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_1931_회의실배정 {
	static int N;
	static PriorityQueue<Point> pq;

	private static class Point implements Comparable<Point> {
		int s;
		int e;

		public Point(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Point o) {
			if (this.e > o.e)
				return 1;
			else if (this.e == o.e) {
				if (this.s > o.s)
					return 1;
				else
					return -1;
			} else
				return -1;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int res = 0;
		int nowe = -1;
		pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			pq.add(new Point(s, e));
		}

		while (!pq.isEmpty()) {
			Point p = pq.poll();
			if (p.s >= nowe) {
				res++;
				nowe = p.e;
			}
		}
		System.out.println(res);
	}
}
