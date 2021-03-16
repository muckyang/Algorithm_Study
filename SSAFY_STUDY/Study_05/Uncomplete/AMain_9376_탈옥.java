package Uncomplete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AMain_9376_탈옥 {
	static int T, N, M;
	static char map[][];
	static boolean v[][];
	static Queue<Point> q;

	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static int res;

	public static class Point {
		int x, y;
		int cnt;
		int broken;

		public Point(int x, int y, int cnt, int broken) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.broken = broken;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int testcase = 0; testcase < T; testcase++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N + 2][M + 2];
			v = new boolean[N + 2][M + 2];
			q = new LinkedList<>();
			String s = "";
			for (int i = 0; i <= N + 1; i++) {
				if (i != 0 && i != N + 1)
					s = br.readLine();
				for (int j = 0; j <= M + 1; j++) {
					if (i == 0 || i == N + 1 || j == 0 || j == M + 1) {
						map[i][j] = '.';
					} else {
						map[i][j] = s.charAt(j - 1);
					}
				}
			}
			res = Integer.MAX_VALUE;
			
			// 입력완료
			// print();
			q.add(new Point(0, 0, 0, 0));
			solve();
		}

	}

	private static void solve() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				if (p.cnt == 2) {
					res = Math.min(p.broken, res);
					continue;
				}
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (!safe(ix, jy) || map[ix][jy] == '*' || v[ix][jy]) // 벽일 경우 || 방문
						continue;
					v[ix][jy] = true;

					if (map[ix][jy] == '.') {// 길
						q.add(new Point(ix, jy, p.cnt, p.broken));
					} else if (map[ix][jy] == '$') {// 죄수
						q.add(new Point(ix, jy, p.cnt + 1, p.broken));
					} else if (map[ix][jy] == '#') { // 문

					}
				}
			}
		}
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < N + 2 && y < M + 2)
			return true;
		return false;
	}

	private static void print() {
		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < M + 2; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}
}