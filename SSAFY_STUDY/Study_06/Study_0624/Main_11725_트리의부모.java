package Study_0624;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11725_트리의부모 {
	static int N;
	static int parent[];
	static boolean v[];
	static LinkedList<Integer>[] tlist;
	static Queue<Integer> q;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		v = new boolean[N + 1];
		tlist = new LinkedList[N+1];
		q = new LinkedList<>();
		sb = new StringBuilder();

		for (int i = 0; i < N + 1; i++)
			tlist[i] = new LinkedList<Integer>();

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tlist[a].add(b);
			tlist[b].add(a);
		}

		q.add(1);
		v[1] = true;
		solve();
		for (int i = 2; i < N + 1; i++) {
			sb.append(parent[i]).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void solve() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int p = q.poll();

				for (int item = 0; item < tlist[p].size(); item++) {
					if (!v[tlist[p].get(item)]) {
						v[tlist[p].get(item)] = true;
						parent[tlist[p].get(item)] = p;
						q.add(tlist[p].get(item));
					}
				}
			}
		}

	}
}
