package REMIND.COMPLETE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_빵집 {
	static int R, C;
	static boolean map[][];
	static boolean v[][];
	static int dx[] = { -1, 0, 1 };
	static int dy[] = { 1, 1, 1 };
	static int res;
	static boolean check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				char c = s.charAt(j);
				if (c == '.') {
					map[i][j] = true;
				} else {
					map[i][j] = false;
				}
			}
		}
		res = 0;
		for (int i = 0; i < R; i++) {
			check =false;
			dfs(i, 0);
		}

		System.out.println(res);
	}

	private static void dfs(int i, int j) {
		map[i][j] = false;
		if (j == C-1) {
			res++;
			check = true;
			return;
		}
		for (int d = 0; d < 3; d++) {
			int ix = i + dx[d];
			int jy = j + dy[d];

			if (safe(ix, jy) && map[ix][jy]) {
				dfs(ix, jy);
				if(check) {
					return;
				}
			}
		}
	}

	private static boolean safe(int ix, int jy) {
		if(ix >= 0 && ix < R ) {
			return true;
		}
		return false;
	}

}
