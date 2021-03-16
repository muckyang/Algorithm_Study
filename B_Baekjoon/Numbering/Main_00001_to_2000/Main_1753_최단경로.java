package Main_00001_to_2000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_1753_최단경로 {
	static int V, E;
	static int start;
	static ArrayList<ArrayList<Point>> map;
	static boolean list[];
	static int dist[];
	static PriorityQueue<Point> pq;
	static int res;

	static class Point implements Comparable<Point> {
		int y;
		int v;

		public Point(int y, int v) {
			this.y = y;
			this.v = v;
		}

		@Override
		public int compareTo(Point o) {
			return this.v - o.v;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		start = sc.nextInt() - 1;
		dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		map = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			map.add(new ArrayList<Point>());
		}
		for (int i = 0; i < E; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			int v = sc.nextInt();
			map.get(x).add(new Point(y, v));
		}

		for (int i = 0; i < V; i++) {

			res = 0;
			list = new boolean[V];
			pq = new PriorityQueue<Point>();
			for (int k = 0; k < map.get(start).size(); k++) {
				Point p = map.get(start).get(k);
				list[p.y] = true;
				pq.add(new Point(p.y, p.v));
			}
			solve(i);

		}
		for (int i = 0; i < V; i++) {
			if (i == start)
				System.out.println("0");
			else if (dist[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}
	}

	private static void solve(int target) {
		while (!pq.isEmpty()) {
			Point p = pq.poll();
			if (p.y == target) {
				if (dist[p.y] > p.v)
					dist[p.y] = p.v;
				continue;
			} else {
				for (int i = 0; i < map.get(p.y).size(); i++) {
					Point pp = map.get(p.y).get(i);
					pq.add(new Point(pp.y, pp.v + p.v));
				}
			}
		}
	}
}
