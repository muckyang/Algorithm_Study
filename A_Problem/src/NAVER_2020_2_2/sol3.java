package NAVER_2020_2_2;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class sol3 {
	static PriorityQueue<Edge> pq;
	static LinkedList<Integer>[] list;
	static int linkCnt[];
	static int max;
	static int res;

	public static class Edge implements Comparable<Edge> {
		int f;
		int t;
		int number;
		public Edge(int f, int t, int number) {
			this.f = f;
			this.t = t;
			this.number = number;
		}
		@Override
		public int compareTo(Edge o) {
			return o.number - this.number;
		}
	}

	public static void main(String[] args) {
		int n = 19;

		int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 }, { 1, 5 }, { 2, 6 }, { 3, 7 }, { 3, 8 }, { 3, 9 },
				{ 4, 10 }, { 4, 11 }, { 5, 12 }, { 5, 13 }, { 6, 14 }, { 6, 15 }, { 6, 16 }, { 8, 17 }, { 8, 18 } };
		System.out.println(solution(n, edges));
	}

	public static int solution(int n, int[][] edges) {
		res = n;
		max = 0;
		for (int i = 0; i < edges.length; i++) {
			int f = edges[i][0];
			if (max < f)
				max = f;
		}
		max++;
		list = new LinkedList[max];
		for (int i = 0; i < max; i++)
			list[i] = new LinkedList<>();
		linkCnt = new int[edges.length + 1];
		for (int i = 0; i < edges.length; i++) {
			int f = edges[i][0];
			int t = edges[i][1];
			list[f].add(t);
		}

		linkCnt[0] = LinkNum(0);
		pq = new PriorityQueue<>();
		pq.add(new Edge(0, 0, linkCnt[0]));
		solve();
		return res;
	}

	private static void solve() {
		while (!pq.isEmpty()) {
			int size = pq.size();
			for (int i = 0; i < size; i++) {
				Edge e = pq.poll();
				if(max <= e.t)
					continue;
				for (int k : list[e.t]) 
					pq.add(new Edge(e.t, k, linkCnt[k]));
				
			}
			if(!pq.isEmpty()) {
				Edge k = pq.poll();
				res -= k.number + 1;
			}
		}
	}

	private static int LinkNum(int st) {
		int cnt = 0;
		if (st >= max) {
			linkCnt[st] = 0;
			return 1;
		}

		for (Integer i : list[st]) {
			cnt += LinkNum(i);
		}

		if (cnt == 0) {
			linkCnt[st] = 0;
			return 1;
		}
		linkCnt[st] = cnt;
		return cnt + 1;
	}
}
