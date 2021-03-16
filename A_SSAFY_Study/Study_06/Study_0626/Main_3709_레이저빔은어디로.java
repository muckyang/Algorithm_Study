package Study_0626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3709_레이저빔은어디로 {
	static int T, N, R;
	static int sx, sy, sd, rx, ry;
	static boolean v[][][];
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			map = new int[N + 2][N + 2];
			v = new boolean[4][N + 2][N + 2];
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
			st = new StringTokenizer(br.readLine());
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			map[sx][sy] = -1;
			if (sx == 0) {
				sd = 2;
			} else if (sy == 0) {
				sd = 1;
			} else if (sx == N + 1) {
				sd = 0;
			} else if (sy == N + 1) {
				sd = 3;
			}
			rx = ry = 0;
			solve();
			System.out.println(rx + " " + ry);
		}
	}

	private static void solve() {
		while (true) {
			int ix = sx + dx[sd];
			int jy = sy + dy[sd];
			if (!safe(ix, jy)) {
				rx = sx;
				ry = sy;
				return;
			}
			if (v[sd][ix][jy]) {
				return;
			}
			v[sd][ix][jy] = true;
			if (map[ix][jy] == 1) {
				sd++;
				if (sd == 4)
					sd = 0;
			}
			sx = ix;
			sy = jy;
		}
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < N + 2 && y < N + 2)
			return true;
		return false;
	}

	private static void printmap() {
		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < N + 2; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
