package partition3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int map[][];
	static int dy[] = { 0, 1, 0, -1 };
	static int dx[] = { 1, 0, -1, 0 };
	static String[] ds = { "R", "D", "L", "U" };
	static int max;
	static String res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		max = Integer.MIN_VALUE;
		solve(0, 0, map[0][0], new boolean[N][M], new StringBuilder());
		System.out.println(res);
	}

	private static void solve(int y, int x, int value, boolean[][] v, StringBuilder sb) {
		v[y][x] = true;
		if (y == N - 1 && x == M - 1) {
			
			if(max < value) {
				res = sb.toString();
				max = value;
			}
			return;
		}
		for (int d = 0; d < 4; d++) {
			int jy = y + dy[d];
			int ix = x + dx[d];
			if (!safe(jy, ix) || v[jy][ix])
				continue;
			v[jy][ix] = true;
			solve(jy, ix, value + map[jy][ix], v, sb.append(ds[d]));
			sb.replace(0, sb.length(), sb.substring(0, sb.length()-1));
			v[jy][ix] = false;
		}

	}

	private static boolean safe(int jy, int ix) {
		if (jy >= 0 && ix >= 0 && jy < N && ix < M)
			return true;
		return false;
	}
}
