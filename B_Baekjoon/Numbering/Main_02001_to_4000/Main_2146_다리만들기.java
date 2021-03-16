package Main_02001_to_4000;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2146_다리만들기 {
	static int N;
	static int map[][];
	static int v[][];
	static int res;
	static Queue<Point> q;
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, -1, 0, 1 };

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		q = new LinkedList<Point>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int cnt = 1;
		res = Integer.MAX_VALUE;
		v = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && v[i][j] == 0) {
					v[i][j] = cnt;
					q.add(new Point(i, j));
					bfs(cnt);
					cnt++;
				}
			}
		}
		// 출력 정상

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (v[i][j] != 0) {
					int min = check(i, j, v[i][j]);
					if (res > min)
						res = min;
				}
			}
		}
		System.out.println(res);

	}

	private static int check(int x, int y, int value) {
		q = new LinkedList<>();
		boolean visit[][] = new boolean[N][N];
		q.add(new Point(x, y));
		visit[x][y] = true;
		
		int depth = 0;
		while (!q.isEmpty()) {
			int size = q.size();
		
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				if (v[p.x][p.y] != 0 && v[p.x][p.y] != value) {
					return depth-1;
				}
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (safe(ix, jy) && v[ix][jy] != value && !visit[ix][jy]) {
						visit[ix][jy] = true;
						q.add(new Point(ix, jy));
					}
				}
			}
			depth++;
			if(res < depth)
				return Integer.MAX_VALUE;
		}
		return Integer.MAX_VALUE;
	}

	private static void bfs(int cnt) {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (safe(ix, jy) && v[ix][jy] == 0 && map[ix][jy] == 1) {
						v[ix][jy] = cnt;
						q.add(new Point(ix, jy));
					}
				}

			}
		}
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		return false;
	}
}
