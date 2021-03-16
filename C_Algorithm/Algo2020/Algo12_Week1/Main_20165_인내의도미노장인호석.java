package Algo12_Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20165_인내의도미노장인호석 {
	static int N, M, R;
	static int[][] map;
	static StringBuilder sb;
	static boolean[][] v;
	static int dy[] = { 0, 0, 1, -1 };
	static int dx[] = { 1, -1, 0, 0 };
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(v[i], true);
		}
		res = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			String s = st.nextToken();
			int d = 0;
			if (s.equals("E")) {
				d = 0;
			} else if (s.equals("W")) {
				d = 1;
			} else if (s.equals("S")) {
				d = 2;
			} else if (s.equals("N")) {
				d = 3;
			}
			if (v[y][x])
				push(y, x, d);
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken()) - 1;
			x = Integer.parseInt(st.nextToken()) - 1;
			if (!v[y][x]) {
				v[y][x] = true;
			}
		}
		System.out.println(res);
		print();
		System.out.println(sb.toString());
	}

	private static void push(int y, int x, int d) {
		int k = map[y][x];
		v[y][x] = false;
		res++;
		for (int i = 0; i < k - 1; i++) {
			int jy = y + dy[d];
			int ix = x + dx[d];
			y = jy;
			x = ix;
			if (!safe(jy, ix))
				return;
			if (!v[jy][ix])
				continue;
			else if (k < i + map[jy][ix] + 1) {
				k = i + map[jy][ix] + 1;
			}
			res++;
			v[jy][ix] = false;
		}
	}

	private static boolean safe(int jy, int ix) {
		if (jy >= 0 && ix >= 0 && jy < N && ix < M)
			return true;
		return false;
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (v[i][j]) {
					sb.append("S ");
				} else {
					sb.append("F ");
				}
			}
			sb.append("\n");
		}
	}

}
