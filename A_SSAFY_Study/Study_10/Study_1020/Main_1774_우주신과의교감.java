package Study_1020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1774_우주신과의교감 {
	static int N, M;
	static PriorityQueue<Ver> pq;
	static double dist[][];
	static int[][] yx;
	static int v[];
	static int res;

	public static class Ver implements Comparable<Ver> {
		int f, t;
		double dist;

		public Ver(int f, int t, double dist) {
			this.f = f;
			this.t = t;
			this.dist = dist;
		}

		public int compareTo(Ver o) {
			if (this.dist > o.dist)
				return 1;
			return -1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dist = new double[N][N];
		v = new int[N];
		yx = new int[2][N];
		res = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			yx[0][i] = Integer.parseInt(st.nextToken());
			yx[1][i] = Integer.parseInt(st.nextToken());
			v[i] = i;
		}
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				dist[i][j] = distance(i, j);
				pq.add(new Ver(i,j,dist[i][j]));
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			if (v[s] != v[e]) {
				int union = v[e];
				for (int d = 0; d < N; d++) {
					if (v[d] == union) {
						v[d] = v[s];
					}
				}
			}
		}
		double res = 0.0;
		while(!pq.isEmpty()) {
			Ver p =  pq.poll();
			if(v[p.f]==v[p.t]) {
				
			}else {
				res+= p.dist;
			}
		}
		System.out.println(res);

	}

	private static double distance(int i, int j) {
		double d = Math.pow(yx[0][i] - yx[0][j], 2) + Math.pow(yx[1][i] - yx[1][j], 2);
		return Math.sqrt(d);
	}
}
