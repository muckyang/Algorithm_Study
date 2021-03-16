package Month03_Week02;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_2565_전깃줄 {
	static int N;
	static int dp[][];
	static int list[];
	static PriorityQueue<Point> l;
	static class Point implements Comparable<Point> {
		int from;
		int to;
		private Point(int from, int to) {
			this.from = from;
			this.to = to;
		}
		@Override
		public int compareTo(Point o) {
			return this.from - o.from;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		list = new int[N];
		dp = new int[N][501];
		l = new PriorityQueue<Point>();
		for (int i = 0; i < N; i++) {
			int f = sc.nextInt();
			int t = sc.nextInt();
			l.offer(new Point(f, t));
		}
		int size = l.size();
		for (int i = 0; i < size; i++) {
			Point p = l.poll();
			list[i] = p.to;
		}
		int res = solve(0, 0);
		System.out.println(N - res);
	}

	private static int solve(int i, int end) {
		int n1 = 0;
		int n2 = 0;
		if (i == N)
			return 0;
		if (dp[i][end] != 0)
			return dp[i][end];
		if (end <= list[i]) {
			n1 = solve(i + 1, list[i]) + 1;
		}
		n2 = solve(i + 1, end);
		return dp[i][end] = Math.max(n1, n2);
	}
}
