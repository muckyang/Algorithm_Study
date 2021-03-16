package Algo12_Week2;

//324612KB , 924ms
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_20166_문자열지옥에빠진호석_HASHMAP {
	static int N, M, K;
	static char[][] map;
	static HashMap<String, Integer> hm;
	static int dy[] = { 0, -1, 0, 1, 1, 1, -1, -1 };
	static int dx[] = { -1, 0, 1, 0, 1, -1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		hm = new HashMap<>();
		map = new char[N][M];
		String s = "";
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		// 전체경우의수 체크
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				solve(i, j, 0, "" + map[i][j]);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < K; i++) {
			s = br.readLine();
			if (hm.get(s) == null)
				sb.append("0\n");
			else
				sb.append(hm.get(s)).append("\n");
		}
		System.out.println(sb.toString());

	}

	private static void solve(int y, int x, int cnt, String str) {
		if (cnt > 4)
			return;
		if (hm.get(str) != null) {
			hm.put(str, hm.get(str) + 1);
		} else {
			hm.put(str, 1);
		}
		for (int d = 0; d < 8; d++) {
			int jy = y + dy[d];
			int ix = x + dx[d];
			if (jy == -1)
				jy = N - 1;
			if (jy == N)
				jy = 0;
			if (ix == -1)
				ix = M - 1;
			if (ix == M)
				ix = 0;
			solve(jy, ix, cnt + 1, str + map[jy][ix]);

		}
	}
}
