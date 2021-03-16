package Algo12_Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10971_외판원순회2 {
	static int N;
	static int map[][];
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		res = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			solve(i, i, 0, 0, new boolean[N]);
		}
		System.out.println(res);
	}

	private static void solve(int start, int end, int sum, int cnt, boolean[] v) {
		v[start] = true;
		if (cnt == N - 1) {
			if (map[start][end] != 0)
				res = Math.min(res, sum + map[start][end]);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!v[i] && map[start][i] != 0) {
				v[i] = true;
				solve(i, end, sum + map[start][i], cnt + 1, v);
				v[i] = false;
			}
		}
	}
}
