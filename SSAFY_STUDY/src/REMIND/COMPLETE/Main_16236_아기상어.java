package REMIND.COMPLETE;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_16236_아기상어 {
	static int N;
	static int map[][];
	static boolean v[][];
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static PriorityQueue<Point> pq;
	static int sx, sy, sharksize;
	static int eatcount;
	static int time;

	static class Point implements Comparable<Point> {
		int x;
		int y;
		int size;
		int depth;

		public Point(int x, int y, int size, int depth) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.depth = depth;
		}

		@Override
		public int compareTo(Point o) {
			if (this.depth >o.depth) {
				return 1;
			} else if (this.depth <o.depth) {
				return -1;
			} else {
				if (this.x < o.x) {
					return -1;
				} else if (this.x > o.x) {
					return 1;
				} else {
					if (this.y < o.y) {
						return -1;
					} else {
						return 1;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		v = new boolean[N][N];
		sharksize = 2;
		time = 0;
		pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int num = sc.nextInt();
				if (num == 9) {
					sx = i;
					sy = j;
				} else
					map[i][j] = num;
			}
		}
		eatcount = 0;
		v[sx][sy] = true;
		pq.add(new Point(sx, sy, 0, 0));
		bfs();
		System.out.println(time);

	}

	private static void bfs() {
		int depth = 0;
		while (!pq.isEmpty()) {
			int size = pq.size();
			depth++;
			for (int i = 0; i < size; i++) {
				Point p = pq.poll();
				int x = p.x;
				int y = p.y;
				if (p.size != 0 && p.size < sharksize) {// 먹을수 있는 경우
					time += p.depth;
					depth = 0;
					map[x][y] = 0;
					p.size = 0;
					p.depth = 0;
					pq = new PriorityQueue<>();
					pq.add(p);
					v = new boolean[N][N];
					v[x][y] = true;
					eatcount++;
					if (eatcount == sharksize) {
						eatcount = 0;
						sharksize++;
					}
					break;
				}
				for (int d = 0; d < 4; d++) {
					int ix = x + dx[d];
					int jy = y + dy[d];
					if (safe(ix, jy) && !v[ix][jy] && map[ix][jy] <= sharksize) {
						v[ix][jy] = true;
						pq.add(new Point(ix, jy, map[ix][jy], depth));
					}
				}
			}
		}
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N)
			return true;
		return false;
	}
}
