package Programmers;

import java.util.PriorityQueue;

//  https://programmers.co.kr/learn/courses/30/lessons/62050?language=java
public class Solution_지형이동 {

	static PriorityQueue<Point> pq;
	static int[][] map;

	static boolean[][] v;
	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, -1, 0, 1 };
	static int vc;
	static int cutvalue;
	static int res;

	public static class Point implements Comparable<Point> {
		int y, x;
		int value;

		public Point(int y, int x, int value) {
			this.y = y;
			this.x = x;
			this.value = value;
		}

		@Override
		public int compareTo(Point o) {
			return this.value - o.value;
		}
	}

	public static void main(String[] args) {
//		int[][] land = { { 1, 4, 8, 10 }, { 5, 5, 5, 5 }, { 10, 10, 10, 10 }, { 10, 10, 10, 20 } };
//		int height = 3;
		// return : 15
		int [][] land = {{10, 11, 10, 11}, {2, 21, 20, 10}, {1, 20, 21, 11}, {2, 1, 2, 1}};
		int height = 1;
		// return18
		System.out.println(solution(land, height));

	}

	public static int solution(int[][] land, int height) {
		int answer = 0;
		res = 0;
		vc = land.length * land[0].length;
		cutvalue = height;
		map = new int[land.length][land[0].length];
		v = new boolean[land.length][land[0].length];
		pq = new PriorityQueue<>();

		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land[i].length; j++) {
				map[i][j] = land[i][j];
			}
		}
		pq.add(new Point(0, 0, 0));

		solve();
		return res;
	}

	private static void solve() {
		while (!pq.isEmpty()) {
			Point p = pq.poll();
			if (v[p.y][p.x])
				continue;
			if(p.value > cutvalue)
				res += p.value;
			vc--;
			v[p.y][p.x] = true;
			if (vc == 0)
				return;
			for (int d = 0; d < 4; d++) {
				int jy = p.y + dy[d];
				int ix = p.x + dx[d];
				if (safe(jy, ix) || v[jy][ix])
					continue;
				int chai = Math.abs(map[p.y][p.x] - map[jy][ix]);
				pq.add(new Point(jy, ix, chai));
			}
		}
	}

	private static boolean safe(int jy, int ix) {
		if (ix < 0 || jy < 0 || ix >= map[0].length || jy >= map.length)
			return true;
		return false;
	}
}
