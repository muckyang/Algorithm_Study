package KAKAO_2020_2;

import java.util.LinkedList;
import java.util.Queue;

public class sol4 {

	static LinkedList<Point>[] list;
	static int[][] price;
	static Queue<Pay> q;
	static int res;

	public static class Point {
		int to;
		int weight;

		public Point(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

	}

	public static class Pay {
		int from;
		int weight;

		public Pay(int from, int weight) {
			this.from = from;
			this.weight = weight;
		}

	}

	public static void main(String[] args) {
		int n = 6;
		int s = 4;
		int a = 6;
		int b = 2;
		int[][] fares = { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, { 3, 1, 41 }, { 5, 1, 24 }, { 4, 6, 50 },
				{ 2, 4, 66 }, { 2, 3, 22 }, { 1, 6, 25 } };

		// result = 82
		System.out.println(solution(n, s, a, b, fares));
	}

	public static int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = 0;
		s = s - 1;
		a = a - 1;
		b = b - 1;
		price = new int[n][n];
		res = Integer.MAX_VALUE;
		list = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				price[i][j] = Integer.MAX_VALUE;
			list[i] = new LinkedList<>();
		}

		for (int i = 0; i < fares.length; i++) {
			int st = fares[i][0] - 1;
			int ed = fares[i][1] - 1;
			int weight = fares[i][2];
			list[st].add(new Point(ed, weight));
			list[ed].add(new Point(st, weight));
			// 20.09.17 추가 내용
			// 이때 price배열도 갱신시켜준다
			price[st][ed] = weight;
			price[ed][st] = weight;
		}
		for (int i = 0; i < n; i++) {
			q = new LinkedList<>();
			q.add(new Pay(i, 0));
			solve(i);
		}

		for (int i = 0; i < n; i++) {
			int stom = price[s][i];
			int mtoa = price[i][a];
			int mtob = price[i][b];
			if (s == i)
				stom = 0;
			if (a == i)
				mtoa = 0;
			if (b == i)
				mtob = 0;
			if (stom == Integer.MAX_VALUE || mtoa == Integer.MAX_VALUE || mtob == Integer.MAX_VALUE)
				continue;
			res = Math.min(res, stom + mtoa + mtob);

		}
		return res;
	}

	private static void solve(int sp) {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pay node = q.poll();
				// 20.09.17 최단경로 시간초과 문제 해결하면서 변경 
//				for (int j = 0; j < list[node.from].size(); j++) {
//					Point k = list[node.from].get(j);
				// 21.02.09 프로그래머스를 통해 제출 결과 효율성 30개중 6개 시간초과 
				for (Point k : list[node.from]) {
					if (k.weight + node.weight <= price[sp][k.to]) {
						int p = k.weight + node.weight;
						price[sp][k.to] = p;
						price[k.to][sp] = p;
						q.add(new Pay(k.to, p));
					}
				}
			}
		}

	}
}
