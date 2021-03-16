package Study_0421;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class Main_1944_복제로봇 {
	static int N, M;
	static int dist[][];
	static boolean v[][];
	static int kx[];
	static int ky[];
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static PriorityQueue<Point> pq;
	static int sx, sy;
	static int res, cnt;

	static class Point implements Comparable<Point> {
		int x;
		int y;
		int v;

		public Point(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.v = v;
		}

		@Override
		public int compareTo(Point o) {
			return this.v - o.v;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		v = new boolean[N][N];
		dist = new int[N][N];
		kx = new int[M];
		ky = new int[M];
		sx = sy = -1;
		pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++)
			Arrays.fill(dist[i], Integer.MAX_VALUE);

		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < N; j++) {
				char c = s.charAt(j);
				if (c == '1') {
					dist[i][j] = -1;
				} else if (c == 'S') {
					sx = i;
					sy = j;

				} else if (c == 'K') { // key 자리는 0
					kx[cnt] = i;
					ky[cnt] = j;
					dist[i][j] = 0;
					cnt++;
				}
			}

		}

		cnt = 0;
		pq.add(new Point(sx, sy, 0));
		v[sx][sy] = true;
		bfsAll();
		for (int i = 0; i < M; i++) {
			res += dist[kx[i]][ky[i]];
		}
		if(cnt == M)
			System.out.println(res);
		else
			System.out.println(-1);
		
		
	}

	private static void bfsAll() {
		while (!pq.isEmpty()) {
		
			Point p = pq.poll();
			if (dist[p.x][p.y] == 0) {
				dist[p.x][p.y] = p.v;
				cnt++;
				if (cnt == M)
					return;
				pq.add(new Point(p.x, p.y, 0));
				continue;
			}
			for (int d = 0; d < 4; d++) {
				int ix = p.x + dx[d];
				int jy = p.y + dy[d];
				if (!safe(ix, jy) || dist[ix][jy] == -1)
					continue;
				if (dist[ix][jy] == 0) {// 키라면
					v[ix][jy] = true;
					pq.add(new Point(ix, jy, p.v + 1));
				} else if (p.v + 1 < dist[ix][jy] && !v[ix][jy]) {
					dist[ix][jy] = p.v + 1;
					pq.add(new Point(ix, jy, p.v + 1));
				}
			}

		}
	}

	private static boolean safe(int ix, int jy) {
		if (ix >= 0 && jy >= 0 && ix < N && jy < N)
			return true;
		return false;
	}

}
