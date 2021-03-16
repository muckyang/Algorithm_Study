package Main_00001_to_2000;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1697_숨바꼭질 {
	static int N, K;
	static int[] list;
	static int minc;
	static Queue<Point> que;
	static boolean visited[];

	static class Point {
		int n;
		int k;
		int c;

		public Point(int n, int k, int c) {
			this.n = n;
			this.k = k;
			this.c = c;
		}

	}

	public static void bfs() {
		while (true) {
			Point p = que.poll();
			if (minc < p.c)
				return;
			if (p.n == p.k) {
				minc = p.c;
				return;
			}

			if (p.k % 2 == 0 && p.n < p.k && !visited[p.k / 2]) {
				visited[p.k / 2] = true;
				que.add(new Point(p.n, p.k / 2, p.c + 1));
			}
			if (p.k + 1 <= 100000 && !visited[p.k + 1]) {
				visited[p.k + 1] = true;
				que.add(new Point(p.n, p.k + 1, p.c + 1));
			}
			if ( p.k - 1 >= 0 && !visited[p.k - 1] ) {
				visited[p.k - 1] = true;
				que.add(new Point(p.n, p.k - 1, p.c + 1));

			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		que = new LinkedList<Point>();
		visited = new boolean[100001];
		N = sc.nextInt();
		K = sc.nextInt();
		minc = Integer.MAX_VALUE;
		que.add(new Point(N, K, 0));
		bfs();
		System.out.println(minc);
	}
}
