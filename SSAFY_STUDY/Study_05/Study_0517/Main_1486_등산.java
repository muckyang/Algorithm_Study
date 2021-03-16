package Study_0517;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1486_등산 {
	static int N, M, T, D, downD;
	static int map[][];
	static int up[][];
	static int down[][];
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

	static int res;
	static Queue<Point> q;
	static Queue<Point> dq;
	static PriorityQueue<Mountine> pq;

	public static class Mountine implements Comparable<Mountine> {
		int x, y, high;

		public Mountine(int x, int y, int high) {
			this.x = x;
			this.y = y;
			this.high = high;
		}

		@Override
		public int compareTo(Mountine o) {
			return o.high - this.high;
		}
	}

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());// 높이 최대 차이
		D = Integer.parseInt(st.nextToken());
		q = new LinkedList<>();
		pq = new PriorityQueue<>();

		map = new int[N][M];
		up = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(up[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = s.charAt(j);
				if (0 <= c - 'a' && c - 'z' <= 0) {
					map[i][j] = c - 'a' + 26;
				} else {
					map[i][j] = c - 'A';
				}
				pq.add(new Mountine(i, j, map[i][j]));
			}
		}
		res = map[0][0];
		up[0][0] = 0;
		q.add(new Point(0, 0));
		solve1(); // 올라갈수 있는 최소값 정립
		print();
		
		res = Math.max(res, solve2()); // 높은곳 부터 내려올수 있는지 파악
		System.out.println(res);
	}

	private static void print() {
		for(int i = 0 ; i< N ; i++) {
			for(int j = 0; j< M ; j++) {
				System.out.print(up[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void solve1() {
		while (!q.isEmpty()) {
			Point p = q.poll();
			int now = map[p.x][p.y];
			for (int d = 0; d < 4; d++) {
				int ix = p.x + dx[d];
				int jy = p.y + dy[d];
				if (!safe(ix, jy))
					continue;
				int chai = Math.abs(map[ix][jy] - now);
				if (T < chai)
					continue;
				if (now < map[ix][jy]) {
					if (up[ix][jy] > up[p.x][p.y] + chai * chai && D >= up[p.x][p.y] + chai * chai) {
						up[ix][jy] = up[p.x][p.y] + chai * chai;
						q.add(new Point(ix, jy));
					}
				} else {
					if (up[ix][jy] > up[p.x][p.y] + 1 && D >= up[p.x][p.y] + 1) {
						up[ix][jy] = up[p.x][p.y] + 1;
						q.add(new Point(ix, jy));
					}
				}
			}
		}
	}

	
	private static int solve2() {
		while (!pq.isEmpty()) {
			Mountine m = pq.poll();
			downD = D - up[m.x][m.y];
			if (downD < 0)
				continue;
			dq = new LinkedList<>();
			down = new int[N][M];
			for (int i = 0; i < N; i++)
				Arrays.fill(down[i], Integer.MAX_VALUE);
			down[m.x][m.y] = 0;
			dq.add(new Point(m.x, m.y));
			if (bfs())
				return m.high;
		}
		return 0;
	}

	private static boolean bfs() {
		while (!dq.isEmpty()) {
			Point p = dq.poll();
			if (p.x == 0 && p.y == 0)
				return true;

			int now = map[p.x][p.y];
			for (int d = 0; d < 4; d++) {
				int ix = p.x + dx[d];
				int jy = p.y + dy[d];
				if (!safe(ix, jy))
					continue;
				int chai = Math.abs(map[ix][jy] - now);
				if (T < chai)
					continue;
				if (now < map[ix][jy]) {
					if (down[ix][jy] > down[p.x][p.y] + chai * chai && downD >= down[p.x][p.y] + chai * chai) {
						down[ix][jy] = down[p.x][p.y] + chai * chai;
						dq.add(new Point(ix, jy));
					}
				} else {
					if (down[ix][jy] > down[p.x][p.y] + 1 && downD >= down[p.x][p.y] + 1) {
						down[ix][jy] = down[p.x][p.y] + 1;
						dq.add(new Point(ix, jy));
					}
				}

			}
		}
		return false;
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < M)
			return true;
		return false;
	}

}