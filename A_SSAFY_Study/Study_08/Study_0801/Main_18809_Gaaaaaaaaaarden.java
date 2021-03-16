package Study_0801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18809_Gaaaaaaaaaarden {
	static int N, M, G, R;
	static int map[][];
	static int temp[][];
	static int time[][];
	static int combi[];
	static boolean v[][];
	static Garden garden[];
	static int fcnt, count, res;
	static int dy[] = { 0, 1, 0, -1 };
	static int dx[] = { 1, 0, -1, 0 };

	static Queue<Garden> q;

	public static class Garden {

		int y, x, c, t;

		public Garden(int y, int x, int c, int t) {
			this.y = y;
			this.x = x;
			this.c = c;
			this.t = t;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		garden = new Garden[10];
		count = 0;
		res = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					garden[count] = new Garden(i, j, 0, 0);
					count++;
				}
			}
		}
		combi = new int[count];
		temp = new int[N][M];
		solve(0, G, R);
		System.out.println(res);
	}

	private static void solve(int cnt, int g, int r) {
		if (count - cnt < g + r)
			return;
		if (g == 0 && r == 0 && count == cnt) {
			fcnt = 0;
			time = new int[N][M];
			v = new boolean[N][M];
			for (int i = 0; i < N; i++)
				System.arraycopy(map[i], 0, temp[i], 0, M);
			grow();
			return;
		}
		if (g > 0) {
			combi[cnt] = 3; // green
			solve(cnt + 1, g - 1, r);

		}
		if (r > 0) {
			combi[cnt] = 4; // red
			solve(cnt + 1, g, r - 1);
		}
		combi[cnt] = 0;
		solve(cnt + 1, g, r);

	}

	private static void grow() {
		q = new LinkedList<>();
		for (int i = 0; i < count; i++) {
			if (combi[i] == 3) {
				temp[garden[i].y][garden[i].x] = 3;
				v[garden[i].y][garden[i].x]=true;
				q.add(new Garden(garden[i].y, garden[i].x, 3, 0));
			} else if (combi[i] == 4) {
				temp[garden[i].y][garden[i].x] = 4;
				v[garden[i].y][garden[i].x]=true;
				q.add(new Garden(garden[i].y, garden[i].x, 4, 0));
			}
		}
		bfs();

	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Garden g = q.poll();
				if (temp[g.y][g.x] == 7)
					continue;
				
				for (int d = 0; d < 4; d++) {
					int jy = g.y + dy[d];
					int ix = g.x + dx[d];
					if (!safe(jy, ix) || temp[jy][ix] == 0 || temp[jy][ix] == 7)
						continue;
					if (v[jy][ix] && temp[jy][ix] != g.c && g.t + 1 == time[jy][ix]) {
						temp[jy][ix] = 7;
						fcnt++;
						continue;
					}
					
					temp[jy][ix] = g.c;
					time[jy][ix] = g.t + 1;
					v[jy][ix] = true;
					q.add(new Garden(jy, ix, g.c, g.t + 1));
				}
			}

		}
		res = Math.max(fcnt, res);
	}

	private static boolean safe(int jy, int ix) {
		if (ix >= 0 && jy >= 0 && ix < M && jy < N)
			return true;
		return false;
	}
}