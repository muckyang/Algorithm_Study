package Study_0325;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main_1753_최단경로_재인 {

	static int V, E, K;
	static List<Ver>[] list;
	static int[] dist;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		K = sc.nextInt() - 1;
		list = new LinkedList[V];
		dist = new int[V];
		for (int i = 0; i < V; i++) {
			list[i] = new LinkedList<>();
		}
		for (int i = 0; i < E; i++) {
			list[sc.nextInt() - 1].add(new Ver(sc.nextInt() - 1, sc.nextInt()));
		}
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Ver> pq = new PriorityQueue<>();

		dist[K] = 0;
		pq.add(new Ver(K, 0));
		while (!pq.isEmpty()) {
			Ver cur = pq.poll();
			for (Ver ver : list[cur.v]) {
				if (dist[ver.v] > dist[cur.v] + ver.w) {
					dist[ver.v] = dist[cur.v] + ver.w;
					pq.add(new Ver(ver.v, dist[ver.v]));
				}
			}
		}
		for (int i = 0; i < V; i++)
			sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");
		System.out.print(sb.toString());
	}

	static class Ver implements Comparable<Ver> {
		int v, w;

		public Ver(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Ver arg0) {
			return this.w - arg0.w;
		}

	}
}