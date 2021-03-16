package Study_0910;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Kakao_2020_intern_가장먼노드 {

	static boolean v[];
	static List<Integer>[] list;
	static Queue<Integer> q;
	static int answer;

	public static void main(String[] args) {
		int n = 6;
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
		System.out.println(solution(n, edge));
	}

	public static int solution(int n, int[][] edge) {

		list = new LinkedList[n];
		q = new LinkedList<>();
		v = new boolean[n];
		for (int i = 0; i < n; i++) {
			list[i] = new LinkedList<>();
		}
		for (int i = 0; i < edge.length; i++) {
			int s = edge[i][0] - 1;
			int e = edge[i][1] - 1;
			list[s].add(e);
			list[e].add(s);
		}
		v[0] = true;
		q.add(0);
		solve();

		return answer;
	}

	private static void solve() {
		while (!q.isEmpty()) {
			int size = q.size();
			int cnt = 0;
			for (int i = 0; i < size; i++) {
				int index = q.poll();
				for (int j = 0; j < list[index].size(); j++) {
					int next = list[index].get(j);
					if (v[next])
						continue;
					cnt++;
					v[next] = true;
					q.add(next);
				}
			}
			if (cnt == 0)
				return;
			else
				answer = cnt;

		}
	}
}
