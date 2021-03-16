package partition4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14716_현수막 {
	static int N, M;
	static int dy[] = { 1, 0, -1, 0, -1, -1, 1, 1 };
	static int dx[] = { 0, -1, 0, 1, -1, 1, 1, -1 };
	static boolean map[][];
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				if (Integer.parseInt(st.nextToken()) == 1)
					map[i][j] = true;
		}
		res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j]) {
					map[i][j] = false;
					solve(i, j);
					res++;
				}
			}
		}
		System.out.println(res);
	}

	private static void solve(int y, int x) {
		for (int d = 0; d < 8; d++) {
			int jy = y + dy[d];
			int ix = x + dx[d];
			if (!safe(jy, ix) || !map[jy][ix])
				continue;
			map[jy][ix] = false;
			solve(jy, ix);
		}
	}

	private static boolean safe(int jy, int ix) {
		if (jy >= 0 && ix >= 0 && jy < N && ix < M)
			return true;
		return false;
	}
}
