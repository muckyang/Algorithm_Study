package Study_0531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_Unknown_1953_탈주범검거 {
	static int T, N, M, sx, sy, D;
	static int map[][];
	static boolean v[][];

	static int dx[] = { -1, 1, 0, 0 };// 상하좌우
	static int dy[] = { 0, 0, -1, 1 };
	static int res;
	static Queue<Point> q;
	static boolean canGo[][] = { { false, false, false, false }, // 0 : .
			{ true, true, true, true }, // 1 : +
			{ true, true, false, false }, // 2 : |
			{ false, false, true, true }, // 3 : -
			{ true, false, false, true }, // 4 : ㄴ
			{ false, true, false, true }, // 5 : ┌
			{ false, true, true, false }, // 6 : ㄱ
			{ true, false, true, false } // 7 : ┘
	};

	public static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());
		for (int testcase = 1; testcase <= T; testcase++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			v = new boolean[N][M];
			q = new LinkedList<>();
			res = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			q.add(new Point(sx, sy));
			BFS();
			System.out.println("#" + testcase + " " + res);
		}
	}

	private static void BFS() {
		int depth = 0;
		v[sx][sy] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				if (depth == D)
					return;
				Point p = q.poll();
				
				res++;
				for (int d = 0; d < 4; d++) {
					if (!canGo[map[p.x][p.y]][d])
						continue;
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					int d2 = 0;
					if (d % 2 == 0) {
						d2 = d + 1;
					} else {
						d2 = d - 1;
					}
					if (!safe(ix, jy) || v[ix][jy] || !canGo[map[ix][jy]][d2])
						continue;
					v[ix][jy] = true;
					q.add(new Point(ix, jy));
				}
			}
			depth++;
		}
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < M)
			return true;
		return false;

	}
}
