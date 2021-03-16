package Study_0518;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3108_로고 {
	static int N;
	static boolean check[][];
	static boolean v[][];
	static boolean way[][][];
	static int dx[] = { 0, 1, 0, -1 };// 남 동 북 서
	static int dy[] = { 1, 0, -1, 0 };// 0 1 2 3
	static Queue<Point> q;
	static int cnt;

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
		v = new boolean[1001][1001];
		check = new boolean[1001][1001];
		way = new boolean[4][1001][1001];
		cnt = -1;
		q = new LinkedList<>();
		check[500][500] = true;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken()) + 500;
			int sy = Integer.parseInt(st.nextToken()) + 500;
			int ex = Integer.parseInt(st.nextToken()) + 500;
			int ey = Integer.parseInt(st.nextToken()) + 500;
			check[sx][sy] = check[sx][ey] = check[ex][sy] = check[ex][ey] = true;
			way[0][sx][sy] = way[1][sx][sy] = true;
			way[1][sx][ey] = way[2][sx][ey] = true;
			way[0][ex][sy] = way[3][ex][sy] = true;
			way[2][ex][ey] = way[3][ex][ey] = true;
			for (int i = sx + 1; i < ex; i++) {
				check[i][sy] = check[i][ey] = true;
				way[1][i][sy] = way[3][i][sy] = way[1][i][ey] = way[3][i][ey] = true;
			}
			for (int i = sy + 1; i < ey; i++) {
				check[sx][i] = check[ex][i] = true;
				way[0][sx][i] = way[2][sx][i] = way[0][ex][i] = way[2][ex][i] = true;
			}
		}
		for (int i = 0; i <= 1000; i++) {
			for (int j = 0; j <= 1000; j++) {
				if (check[i][j] && !v[i][j]) {
					cnt++;
					v[i][j] = true;
					q.add(new Point(i, j));
					bfs();
				}
			}

		}
		System.out.println(cnt);
	}


	private static void bfs() {
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int ix = p.x + dx[d];
				int jy = p.y + dy[d];
				if (!safe(ix, jy) || v[ix][jy] || !check[ix][jy] || !way[d][p.x][p.y])
					continue;
				v[ix][jy] = true;
				q.add(new Point(ix, jy));
			}
		}
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < 1001 && y < 1001)
			return true;
		return false;
	}
}
