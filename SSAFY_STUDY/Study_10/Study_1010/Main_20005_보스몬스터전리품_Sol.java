package Study_1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20005_보스몬스터전리품_Sol {
	static int N, M, P, sx, sy;
	static Queue<Point> q;
	static Queue<Dealing> dealq;
	static int map[][];
	static int deal[];
	static boolean v[][];
	static int dy[] = { 0, 1, 0, -1 };
	static int dx[] = { 1, 0, -1, 0 };
	static int HP, res;

	public static class Point {
		int x, y;

		public Point(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}

	public static class Dealing {
		int time;
		int number;
		int deal;

		public Dealing(int time, int number, int deal) {
			this.time = time;
			this.number = number;
			this.deal = deal;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		v = new boolean[M][N];
		deal = new int[P + 1];

		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				char a = s.charAt(j);
				if (a == 'B') {
					sx = j;
					sy = i;
					map[i][j] = -2;
				} else if (a == '.') {
					continue;
				} else if (a == 'X') {
					map[i][j] = -1;
				} else {
					map[i][j] = a - 'a' + 1;
				}
			}
		}
		
		for (int i = 1; i <= P; i++) {
			st = new StringTokenizer(br.readLine());
			int num = st.nextToken().charAt(0) - 'a' + 1;
			int dpoint = Integer.parseInt(st.nextToken());
			deal[num] = dpoint;
		}
		q = new LinkedList<>();
		dealq = new LinkedList<>();
		q.add(new Point(sy, sx));
		v[sy][sx] = true;
		solve();
		HP = Integer.parseInt(br.readLine());
		res = 0;
		int dealSum = 0;
		int time = 0;
		while (!dealq.isEmpty()) {
			Dealing d = dealq.poll();

			HP -= (d.time - time) * dealSum;
			if (HP < 0)
				break;
			dealSum += d.deal;
			res += d.number;
			time = d.time;

		}
		System.out.println(res);
	}

	public static void print() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void solve() {
		int depth = 0;
		while (!q.isEmpty()) {
			int dealsum = 0;
			int pcnt = 0;
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Point p = q.poll();
				if (map[p.y][p.x] > 0) {
					dealsum += deal[map[p.y][p.x]];
					pcnt++;
				}
				for (int d = 0; d < 4; d++) {
					int jy = p.y + dy[d];
					int ix = p.x + dx[d];
					if (safe(jy, ix) || v[jy][ix] || map[jy][ix] == -1)
						continue;
					v[jy][ix] = true;
					q.add(new Point(jy, ix));
				}

			}
			if (pcnt > 0) {
				dealq.add(new Dealing(depth, pcnt, dealsum));
			}
			depth++;

		}
	}

	public static boolean safe(int y, int x) {
		if (y < 0 || x < 0 || y >= M || x >= N)
			return true;
		return false;
	}
}
