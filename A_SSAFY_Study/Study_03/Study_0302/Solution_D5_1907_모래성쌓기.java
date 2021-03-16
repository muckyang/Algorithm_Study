package Study_0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D5_1907_모래성쌓기 {
	static int T, N, M, res;
	static int[][] map;
	static int[][] smap;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, 1, 1, -1, -1, -1 };
	static int[] dy = { 1, -1, 1, 0, -1, 1, 0, -1 };
	static Queue<Point> que;

	private static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			smap = new int[N][M];
			res = 0;
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < M; j++) {
					if (s.charAt(j) == '.')
						map[i][j] = 0;
					else
						map[i][j] = s.charAt(j) - '0';
				}
			}
			// 입력확인ok
			que = new LinkedList<Point>();
			solve();
			bfs();
			System.out.println("#" + tc + " " + res);
		}
	}

	private static void solve() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && map[i][j] != 9) {
					for (int d = 0; d < 8; d++) {
						int ix = i + dx[d];
						int jy = j + dy[d];
						if (map[ix][jy] == 0) {
							smap[i][j]++;
						}
					}
					if (smap[i][j] >= map[i][j]) {
						que.add(new Point(i, j));
						map[i][j] = -1;
					}
				}
			}

		}
	}

	private static void bfs() {
		while (!que.isEmpty()) {

			res++;
			int size = que.size();
			for (int k = 0; k < size; k++) {
				Point p = que.poll();
				for (int d = 0; d < 8; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (map[ix][jy] > 0 && map[ix][jy] < 9) {
						smap[ix][jy]++;
						if (smap[ix][jy] >= map[ix][jy]) {
							map[ix][jy] = -1;
							que.add(new Point(ix, jy));
						}
					}
				}
			}
		}
	}
}
