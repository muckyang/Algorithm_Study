package Study_0519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17182_우주탐사선 {
	static int N, K;
	static int map[][];
	static boolean visit[];
	static Queue<Point> q;
	static int min;

	public static class Point {
		int from, time;
		boolean v[];

		public Point(int from, int time, boolean v[]) {
			this.from = from;
			this.time = time;
			this.v = v;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visit = new boolean[N];
		visit[K] = true;
		map = new int[N][N];
		q = new LinkedList<>();
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		q.add(new Point(K, 0, visit));
		solve();
		System.out.println(min);

	}

	private static void solve() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				if (min <= p.time)
					continue;
				int cnt = 0;
				for (int k = 0; k < N; k++) {
					if (p.v[k])
						cnt++;
				}
				if (min > p.time && cnt == N) {
					min = p.time;
					continue;
				}
				for (int k = 0; k < N; k++) {
					if (p.from == k || map[p.from][k] + p.time >= min)
						continue;
					boolean vv[] = new boolean[N];
					System.arraycopy(p.v, 0, vv, 0, N);
					vv[k] = true;
					q.add(new Point(k, p.time + map[p.from][k], vv));
				}
			}
		}

	}
}
