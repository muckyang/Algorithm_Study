package Study_0309;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_9205_맥주마시면서걸어가기 {
	static int N, K;
	static int[] mx;
	static int[] my;
	static boolean[] v;
	static int sx, sy, ex, ey;
	static Queue<Point> q;
	static String res;

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			N = sc.nextInt();
			mx = new int[N];
			my = new int[N];
			res = "sad";
			sx = sc.nextInt();
			sy = sc.nextInt();
			for (int i = 0; i < N; i++) {
				mx[i] = sc.nextInt();
				my[i] = sc.nextInt();
			}

			ex = sc.nextInt();
			ey = sc.nextInt();
			q = new LinkedList<Point>();
			v = new boolean[N];
			q.add(new Point(sx, sy));
			solve();
			System.out.println(res);
		}
	}

	private static void solve() {
		while (!q.isEmpty()) {
			int size = q.size();
			Point p = q.poll();
			if (Math.abs(p.x - ex) + Math.abs(p.y - ey) <= 1000) {
				res = "happy";
				return;
			}
			for (int s = 0; s < size; s++) {
				for (int i = 0; i < N; i++) {
					if (!v[i]) {
						int su = Math.abs(p.x - mx[i]) + Math.abs(p.y - my[i]);
						if (su <= 1000) {
							v[i] = true;
							q.add(new Point(mx[i], my[i]));
						}
					}
				}
			}
		}
	}
}
