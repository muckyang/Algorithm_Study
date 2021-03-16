package Study_0504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2933_미네랄 {
	static int R, C, N;
	static int map[][];
	static int v[][];
	static Queue<Point> q;

	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

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

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		q = new LinkedList<>();
		map = new int[R][C];

		for (int i = R - 1; i >= 0; i--) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				char c = s.charAt(j);
				if (c == 'x')
					map[i][j] = 1;
			}
		}
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int targ = Integer.parseInt(st.nextToken()) - 1;
			if (i % 2 == 0) {// 왼쪽에서 던지기
				destroy(targ, 0);
			} else {// 오른쪽에서 던지기
				destroy(targ, 1);
			}

			// 부순후에 클러스터 분리되었다면 아래로 밀기
			if (isDivide()) {
				drop();
			}
//			print();
		}
		print();
	}

	private static void print() {
		for (int i = R - 1; i >= 0; i--) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 0)
					System.out.print(".");
				else
					System.out.print("x");
//				System.out.print(v[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void drop() {
		int min = Integer.MAX_VALUE;
		for (int j = 0; j < C; j++) {
			for (int i = 0; i < R; i++) {
				if (v[i][j] == 2) {
					int c = 0;
					boolean check = false;
					for (int k = i - 1; k >= 0; k--) {
						if (v[k][j] == 1)
							break;
						else if (v[k][j] == 2) {
							c = Integer.MAX_VALUE;
							break;
						} else {
							c++;
							check = true;
						}
					}
					if (check)
						min = Math.min(min, c);
				}
			}
		}
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (v[i][j] == 1)
					map[i][j] = 1;
				else if (v[i][j] == 2)
					map[i - min][j] = 1;

			}
		}

	}

	private static boolean isDivide() {
		v = new int[R][C];
		int cnt = 1;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 1 && v[i][j] == 0) {
					if (i == 0)
						cnt = 1;
					v[i][j] = cnt;
					q.add(new Point(i, j));
					bfs(cnt);
					cnt++;
				}
			}
		}
		if (cnt != 2)
			return true;
		return false;
	}

	private static void bfs(int cnt) {
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int ix = p.x + dx[d];
				int jy = p.y + dy[d];
				if (!safe(ix, jy) || v[ix][jy] != 0 || map[ix][jy] == 0)
					continue;
				v[ix][jy] = cnt;
				q.add(new Point(ix, jy));
			}

		}
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < R && y < C)
			return true;
		return false;
	}

	private static void destroy(int targ, int lr) {
		if (lr == 0) { // 왼쪽부터
			for (int j = 0; j < C; j++) {
				if (map[targ][j] == 1) {
					map[targ][j] = 0;
					return;
				}
			}
		} else { // 오른쪽 부터
			for (int j = C - 1; j >= 0; j--) {
				if (map[targ][j] == 1) {
					map[targ][j] = 0;
					return;
				}
			}
		}
	}
}