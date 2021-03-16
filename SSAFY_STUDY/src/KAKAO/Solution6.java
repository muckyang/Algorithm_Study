package KAKAO;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution6 {
	static List<Integer>[] list;// 이어진 곳
	static HashMap<Integer, Integer> hm;
	static Queue<Integer> q;
	static boolean visit[];
//	static boolean v[];
	static int key[];

	static int count, bcount;
	static boolean answer;

	public static void main(String[] args) {
		int n = 9;
		int[][] path = { { 0, 1 }, { 0, 3 }, { 0, 7 }, { 8, 1 }, { 3, 6 }, { 1, 2 }, { 4, 7 }, { 7, 5 } };
		int[][] order = { { 8, 5 }, { 6, 7 }, { 4, 1 } };
		int N = n;
		list = new LinkedList[N];
		hm = new HashMap<>();
		q = new LinkedList<>();
		key = new int[N];
		visit = new boolean[N];
		for (int i = 0; i < N; i++) {
			list[i] = new LinkedList<>();
		}

		for (int i = 0; i < path.length; i++) {
			list[path[i][0]].add(path[i][1]);
			list[path[i][1]].add(path[i][0]);
		}

		for (int i = 0; i < order.length; i++) {
			hm.put(order[i][0], order[i][1]);
			key[order[i][0]] = order[i][1];
		}
		count = 0;
		bcount = 0;
		q.add(0);
		visit[0] = true;
		count++;
		solve();
		if (count == N)
			answer = true;
		System.out.println(count);

	}

	private static void solve() {
		while (!q.isEmpty()) {
			if (count == bcount)
				return;
			bcount = count;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int p = q.poll();
				for (int k : list[p]) {
					System.out.print(k + " ");
					if (key[k] != 0) {
						continue;
					}
					System.out.println();
					Integer ch = hm.remove(k);
					if (ch != null && !visit[k]) {
						System.out.println(k + "풀림");
						visit[key[k]] = true;
						visit[ch] = true;
						q.add(ch);
						count++;
					} else {
						if (!visit[k]) {
							visit[k] = true;
							q.add(k);
							count++;
						}
					}
				}
				System.out.println();
			}

		}
	}
}
