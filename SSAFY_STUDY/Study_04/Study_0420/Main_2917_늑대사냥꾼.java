package Study_0420;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main_2917_늑대사냥꾼 {
	static int N, M;
	static int dist[][];
	static boolean v[][];
	static int min;
	static PriorityQueue<Ver> pq;
	static Queue<Point> q;
	static int sx, sy, ex, ey;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static Ver LastVer;

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Ver implements Comparable<Ver> {
		int x;
		int y;
		int v;
		Ver prev;

		public Ver(int x, int y, int v, Ver prev) {
			this.x = x;
			this.y = y;
			this.v = v;
			this.prev = prev;
		}

		@Override
		public int compareTo(Ver o) {
			return o.v - this.v;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		dist = new int[N][M];
		v = new boolean[N][M];

		q = new LinkedList<Point>();

		sx = sy = ex = ey = -1;
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++) {
				char c = s.charAt(j);
				if (c == '.') {

				} else if (c == '+') {
					q.add(new Point(i, j));
					v[i][j] = true;
				} else if (c == 'V') {
					sx = i;
					sy = j;
				} else if (c == 'J') {
					ex = i;
					ey = j;
				}
			}
		}
		int distance = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			distance++;
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (safe(ix, jy) && !v[ix][jy]) {
						v[ix][jy] = true;
						dist[ix][jy] = distance;
						q.add(new Point(ix, jy));
					}
				}

			}
		}

		// 입력 & 나무로부터 거리계산 완료
		v = new boolean[N][M];
		pq = new PriorityQueue<>();
		pq.add(new Ver(sx, sy, dist[sx][sy], null));
		v[sx][sy] = true;
		LastVer = pq.peek();
		bfs();

		min = Integer.MAX_VALUE;
		while (true) {
			if (LastVer.v < min)
				min = LastVer.v;
			if (LastVer.prev == null)
				break;
			LastVer = LastVer.prev;
		}
		System.out.println(min);
	}

	private static void bfs() {
		while (!pq.isEmpty()) {
			int size = pq.size();
			for (int i = 0; i < size; i++) {
				Ver ver = pq.poll();
				if (ver.x == ex && ver.y == ey) {
					LastVer = ver;
					return;
				}
				for (int d = 0; d < 4; d++) {
					int ix = ver.x + dx[d];
					int jy = ver.y + dy[d];
					if (safe(ix, jy) && !v[ix][jy]) {
						v[ix][jy] = true;
						pq.add(new Ver(ix, jy, dist[ix][jy], ver));
					}
				}
			}
		}
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < M)
			return true;
		return false;
	}
}
