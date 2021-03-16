package Study_1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_20007_떡돌리기_WHY {

	public static class Ver implements Comparable<Ver> {
		int from, to, value;

		public Ver(int from, int to, int value) {
			this.from = from;
			this.to = to;
			this.value = value;

		}

		@Override
		public int compareTo(Ver o) {
			return this.value - o.value;
		}
	}

	public static void main(String[] args) throws IOException {
		PriorityQueue<Ver> pq = new PriorityQueue<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		LinkedList<Ver>[] list = new LinkedList[N];
		boolean[] fromv = new boolean[N];
		boolean[] tov = new boolean[N];
		pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++)
			list[i] = new LinkedList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			list[from].add(new Ver(from, to, value));
			list[to].add(new Ver(to, from, value));
		}
		int res = 0;
		for (Ver vv : list[Y]) {
			pq.add(vv);
		}
		fromv[Y] =true;
		tov[Y] =true;
		while (!pq.isEmpty()) {
			Ver ver = pq.poll();
			if (tov[ver.to] || ver.value * 2 > X)
				continue;
			tov[ver.to] = true;
			if (fromv[ver.from]) {
				res++;
			}
			fromv[ver.from] = true;
			for (Ver k : list[ver.to]) {
				int sum = ver.value + k.value;
				pq.add(new Ver(k.from, k.to, sum));
			}
		}
		for (int i = 0; i < N; i++)
			if (!tov[i])
				res = -1;
		System.out.println(res);

	}
}
