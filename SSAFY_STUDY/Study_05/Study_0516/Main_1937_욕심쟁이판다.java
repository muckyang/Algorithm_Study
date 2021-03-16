package Study_0516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1937_욕심쟁이판다 {
	static int N;
	static int map[][];
	static int max[][];
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static Stack<Denamu> stack;

	public static class Denamu {
		int x, y, now;

		public Denamu(int x, int y, int now) {
			this.x = x;
			this.y = y;
			this.now = now;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		max = new int[N][N];
		stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve();

		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (res < max[i][j])
					res = max[i][j];
			}
		}
		System.out.println(res);
	}

	private static void solve() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (max[i][j] == 0) {
					dfs(i, j);
				}
			}
		}
	}

	private static int dfs(int x, int y) {
		max[x][y] = 1;
		for (int d = 0; d < 4; d++) {
			int ix = x + dx[d];
			int jy = y + dy[d];
			if (!safe(ix, jy) || map[ix][jy] <= map[x][y])
				continue;
			if (max[ix][jy] != 0)
				max[x][y] = Math.max(max[x][y], max[ix][jy] + 1);
			else
				max[x][y] = Math.max(max[x][y], dfs(ix, jy) + 1);
		}
		return max[x][y];
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		return false;
	}
}
