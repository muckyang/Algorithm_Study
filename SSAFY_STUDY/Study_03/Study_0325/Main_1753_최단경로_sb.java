package Study_0325;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_1753_최단경로_sb {
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
		StringBuilder sb = new StringBuilder();
		V = sc.nextInt();// 정점
		E = sc.nextInt();// 간선
		start = sc.nextInt() - 1;// 시작점
		map = new ArrayList<>();
		dist = new int[V];
		pq = new PriorityQueue<>();
		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 0; i < V; i++) {
			map.add(new ArrayList<Point>());
		}
		for (int i = 0; i < E; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			int v = sc.nextInt();
			map.get(x).add(new Point(y, v));
		}

		pq.add(new Point(start, 0));
		while (!pq.isEmpty()) {
			Point p = pq.poll();
			for (Point k : map.get(p.y)) {
				if (dist[k.y] > p.v + k.v) {
					dist[k.y] = p.v + k.v;
					pq.add(new Point(k.y, k.v + p.v));
				}
			}
		}
		
		for (int i = 0; i < V; i++) {
			if (i == start)
				sb.append("0").append("\n");
			else if (dist[i] == Integer.MAX_VALUE)
				sb.append("INF\n");
			else
				sb.append(dist[i]).append("\n");
		}
		System.out.println(sb.toString());
	}	
}