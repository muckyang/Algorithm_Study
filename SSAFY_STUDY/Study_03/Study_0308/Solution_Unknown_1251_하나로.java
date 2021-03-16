package Study_0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_Unknown_1251_하나로 {
	static int T, N;
	static double E;
	static int mx[];
	static int my[];
	static long[][] map;
	static int[] v;
	static long res;
	static PriorityQueue<Point> pq;
	private static class Point implements Comparable<Point>{
		int from;
		int to;
		long dist;

		private Point(int from, int to, long dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
		@Override
		public int compareTo(Point o) {
			if (this.dist < o.dist) {
				return -1;
			} else if (this.dist > o.dist) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		T = Integer.parseInt(s);
		for (int tc = 1; tc <= T; tc++) {
			s = br.readLine();
			N = Integer.parseInt(s);
			map = new long[N][N];
			mx = new int[N];
			my = new int[N];
			v = new int[N];
			pq = new PriorityQueue<Point>();
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < N; i++) {
				mx[i] = Integer.parseInt(st.nextToken());
			}
			st= new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < N; i++) {
				my[i] = Integer.parseInt(st.nextToken());
			}
			s= br.readLine();
			E = Double.parseDouble(s);
			res = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					long su = (long) Math.pow(mx[i] - mx[j], 2) + (long) Math.pow(my[i] - my[j], 2);
					pq.add(new Point(i, j, su));
				}
			}
			
			int union = 1;
			int cnt = 0;
			for(int i = 0; i < v.length;i++)
				v[i] = union++;
			int size = pq.size();
			for (int i = 0; i < size; i++) {
				Point p = pq.poll();
				if (cnt == N - 1)
					break;
				if (v[p.to] == v[p.from]) {
					continue;
				} else if (v[p.to] != v[p.from]) {
					int t = v[p.to];
					int f = v[p.from];
					res += p.dist;
					cnt++;
					for (int k = 0; k < v.length; k++) {
						if (v[k] == f) {
							v[k] = t;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + (long) (Math.round(res * E)));
		}
	}
}
