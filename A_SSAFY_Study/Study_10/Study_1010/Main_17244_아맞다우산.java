package Study_1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17244_아맞다우산 {
	static int N, M;
	static int[][] map;
	static int[][] dist;
	static int[] list;
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };
	static boolean v[][];
	static Queue<Point> q;
	static int res;

	public static class Point {
		int y, x;
		int depth;

		public Point(int y, int x, int depth) {
			this.y = y;
			this.x = x;
			this.depth = depth;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dist = new int[7][7];
		int[][] item = new int[7][2];
		int xcnt = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = s.charAt(j);
				if (c == '#')
					map[i][j] = -1;
				else if (c == 'S') {
					item[0][0] = i; // y
					item[0][1] = j; // x
				} else if (c == 'E') {
					item[6][0] = i;
					item[6][1] = j;
					map[i][j] = 6;
				} else if (c == 'X') {
					xcnt++;
					item[xcnt][0] = i;
					item[xcnt][1] = j;
					map[i][j] = xcnt;
				}
			}
		}
		for (int i = 0; i <= xcnt; i++) {
			q = new LinkedList<>();
			v = new boolean[N][M];
			v[item[i][0]][item[i][1]] = true;
			q.add(new Point(item[i][0], item[i][1], 0));
			solve(i);
		}
		res = Integer.MAX_VALUE;
		list = new int[xcnt];
		perm(0, 0, xcnt);
		System.out.println(res);
	}

	private static void perm(int cnt, int flag, int max) {

		if (cnt == max) {
			int sumdist = dist[list[0]][0];
			sumdist += dist[list[list.length - 1]][6];

			for (int i = 0; i < list.length - 1; i++) {
				int from = list[i + 1];
				int to = list[i];
				sumdist += dist[to][from];
			}

			res = Math.min(res, sumdist);
			return;
		}
		for (int i = 1; i <= max; i++) {
			if ((flag & (1 << (i - 1))) == 0) {
				list[cnt] = i;
				perm(cnt + 1, (flag | (1 << (i - 1))), max);
			}
		}
	}

	private static void solve(int start) {
		while (!q.isEmpty()) {
			Point p = q.poll();
			if (map[p.y][p.x] > 0 && dist[start][map[p.y][p.x]] == 0) {
				dist[start][map[p.y][p.x]] = p.depth;
				dist[map[p.y][p.x]][start] = p.depth;
			}
			for (int d = 0; d < 4; d++) {
				int jy = p.y + dy[d];
				int ix = p.x + dx[d];
				if (safe(jy, ix) || v[jy][ix] || map[jy][ix] == -1)
					continue;
				v[jy][ix] = true;
				q.add(new Point(jy, ix, p.depth + 1));
			}
		}

	}

	private static boolean safe(int jy, int ix) {
		if (jy < 0 || ix < 0 || jy >= N || ix >= M)
			return true;
		return false;
	}
}
