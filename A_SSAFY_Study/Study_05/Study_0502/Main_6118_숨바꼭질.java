package Study_0502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6118_숨바꼭질 {
	static int N, M;
	static List<Integer> list[];
	static Queue<Integer> q;
	static boolean v[];
	static int dupl, dist, minnum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new LinkedList[N];
		v = new boolean[N];
		q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			list[i] = new LinkedList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			list[e].add(s);
			list[s].add(e);
		}
		v[0] = true;
		q.add(0);
		dist = -1;
		bfs();
		System.out.println(minnum + 1 + " " + dist + " " + dupl);
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();

			dupl = 0;
			minnum = Integer.MAX_VALUE;

			for (int i = 0; i < size; i++) {
				int p = q.poll();
				dupl++;
				if (minnum > p)
					minnum = p;
				for (int k : list[p]) {
					if (!v[k]) {
						v[k] = true;
						q.add(k);
					}
				}
			}
			dist++;
		}
	}
}
