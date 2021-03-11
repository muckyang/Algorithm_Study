package NAVER_2020_2_2;

import java.util.LinkedList;
import java.util.Queue;

import NAVER_2020_2_2.sol3.Edge;

public class sol3_2 {
	static Queue<Edge> q;
	static LinkedList<Integer>[] list;
	static int linkCnt[];
	static int die[];
	static int max;
	static int res;

	public static void main(String[] args) {
		int n = 19;

		int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 }, { 1, 5 }, { 2, 6 }, { 3, 7 }, { 3, 8 }, { 3, 9 },
				{ 4, 10 }, { 4, 11 }, { 5, 12 }, { 5, 13 }, { 6, 14 }, { 6, 15 }, { 6, 16 }, { 8, 17 }, { 8, 18 } };
		System.out.println(solution(n, edges));
	}

	public static int solution(int n, int[][] edges) {
		res = 0;
		max = 0;
		for (int i = 0; i < edges.length; i++) {
			int f = edges[i][0];
			if (max < f)
				max = f;
		}
		max++;
		list = new LinkedList[max];
		die = new int[max];
		for (int i = 0; i < max; i++)
			list[i] = new LinkedList<>();

		linkCnt = new int[edges.length + 1];
		for (int i = 0; i < edges.length; i++) {
			int f = edges[i][0];
			int t = edges[i][1];
			list[f].add(t);
		}
		LinkedList<Integer> l = new LinkedList<>();
		for (Integer k : list[0])
			l.add(k);
		solve(0, 0, l);

		return res;
	}

	private static void solve(int index, int cnt, LinkedList<Integer> ls) {
		if (index == max) {
			res = Math.max(res, cnt);
			return;
		}
		LinkedList<Integer> l = new LinkedList<>();
		for (int k : ls)
			for (int n : list[k])
				l.add(n);
		for (int i = 0; i < l.size(); i++) {
			die[index] = i;
		}

	}

}
