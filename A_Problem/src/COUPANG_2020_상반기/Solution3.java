package COUPANG_2020_상반기;

import java.util.LinkedList;
import java.util.List;

public class Solution3 {
	static LinkedList<Point>[] list;
	static boolean v[];
	static int res;

	public static void main(String[] args) {
//		int r = 3;
//		int[][] delivery = { { 1, 5 }, { 8, 3 }, { 4, 2 }, { 2, 3 }, { 3, 1 }, { 3, 2 }, { 4, 2 }, { 5, 2 }, { 4, 1 } };
		int r = 4;
		int[][] delivery = { { 1, 10 }, { 8, 1 }, { 8, 1 }, { 3, 100 }, { 8, 1 }, { 8, 1 },{ 8, 1 },{ 8, 1 },{ 8, 1 },{ 8, 1 },{ 8, 1 },{ 9, 100 },{ 8, 1 },{ 8, 1 },{ 8, 1 }, };
		System.out.println(solution(r, delivery));
	}

	public static class Point {
		int from, to, time, value, weight;

		public Point(int from, int to, int time, int value, int weight) {
			this.from = from;
			this.to = to;
			this.time = time;
			this.value = value;
			this.weight = weight;
		}
	}

	public static int solution(int r, int[][] delivery) {
		int answer = 0;
		res = 0;
		v = new boolean[delivery.length];
		list = new LinkedList[delivery.length];
		for (int i = 0; i < delivery.length; i++) {
			list[i] = new LinkedList<>();
			for (int j = 0; j < delivery.length; j++) {
				int f1 = i / r;
				int f2 = i % r;
				int t1 = j / r;
				int t2 = j % r;
				int weight = Math.abs(f1 - t1) + Math.abs(f2 - t2);
				list[i].add(new Point(i, j, delivery[j][0], delivery[j][1], weight));
			}
		}
		
		res = delivery[0][1];
		v[0] = true;
		solve(0, 0, res, delivery.length);

		return res;
	}

	private static void solve(int now, int timer, int sum, int max) {
		res = Math.max(res, sum);

		for (int i = 0; i < max; i++) {
			Point move = list[now].get(i);
			if (v[i] || timer + move.weight > move.time)
				continue;
			v[i] = true;
			solve(i, timer + move.weight, sum + move.value, max);
			v[i] = false;
		}
	}
}
