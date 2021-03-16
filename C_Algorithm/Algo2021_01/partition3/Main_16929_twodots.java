package partition3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16929_twodots {
	static int N, M;
	static char map[][];
	static int dy[] = { 0, 1, 0, -1 };
	static int dx[] = { 1, 0, -1, 0 };
	static boolean v[][];
	static String res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		res = "No";
		f: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				solve(i, j, 2501, new boolean[N][M]);
				v[i][j] = true;
				if (res.equals("Yes"))
					break f;
			}
		}
		System.out.println(res);

	}

	private static void solve(int y, int x, int back, boolean[][] visit) {
		visit[y][x] =true;
		if (v[y][x] || res.equals("Yes"))
			return;
		for (int d = 0; d < 4; d++) {
			int jy = y + dy[d];
			int ix = x + dx[d];
			if (!safe(jy, ix) ) {
				continue;
			}
			if (visit[jy][ix]) {
				if (back != jy * N + ix) {
					res = "Yes";
					return;
				}
				continue;
			}
			if (map[y][x] == map[jy][ix]) {
				solve(jy, ix, y * N + x, visit);
			}

		}
	}

	private static boolean safe(int y, int x) {
		if (y < 0 || x < 0 || y >= N || x >= M)
			return false;
		return true;

	}
}
