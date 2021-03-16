package Study_1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_10888_음식배달 {
	static int T, N;
	static int map[][];
	static boolean v[][];
	static Point list[];
	static Queue<Point> q;
	static int select[];
	static int dy[] = { 0, 1, 0, -1 };
	static int dx[] = { 1, 0, -1, 0 };
	static int shop;
	static int res;

	public static class Point {
		int y, x, value;

		public Point(int y, int x, int value) {
			this.y = y;
			this.x = x;
			this.value = value;

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			list = new Point[10];
			shop = 0;
			res = Integer.MAX_VALUE;
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > 1) {
						list[shop] = new Point(i, j, 0);
						shop++;
					}
				}
			}
			select = new int[shop];
			combi(0, 0, shop);

			System.out.println("#" + t + " " + res);
		}
	}

	private static void combi(int st, int cnt, int max) {
		if (cnt >max)
			return;
		else if(cnt> 0){
			int sum = 0;
			q = new LinkedList<>();
			v = new boolean[N][N];
			for (int i = 0; i < cnt; i++) {
				Point p = list[select[i]];
				sum += map[p.y][p.x];
				v[p.y][p.x] = true;
				q.add(p);
			}
			while (!q.isEmpty()) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					Point p = q.poll();
					for (int d = 0; d < 4; d++) {
						int jy = p.y + dy[d];
						int ix = p.x + dx[d];
						if (jy < 0 || jy >= N || ix < 0 || ix >= N || v[jy][ix])
							continue;
						v[jy][ix] = true;
						if (map[jy][ix] == 1)
							sum += p.value + 1;
						q.add(new Point(jy, ix, p.value + 1));
					}
				}
			}
			
			res = Math.min(res, sum);
		}

		for (int i = st; i < max; i++) {
			select[cnt] = i;
			combi(i + 1, cnt + 1, max);
		}

	}
}
