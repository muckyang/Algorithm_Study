package Algo12_Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2806_N_Queen {
	static boolean[][] map;
	static int dy[] = { 1, 0, -1, 0, 1, 1, -1, -1 };
	static int dx[] = { 0, -1, 0, 1, 1, -1, -1, 1 };
	static int N, res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			res = 0;
			map = new boolean[N][N];
			recusion(0);
			System.out.println("#" + t + " " + res);
		}

	}

	private static void recusion(int now) {
		if (now == N) {
			res++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (isPossible(now, i)) {
				map[now][i] = true;
				recusion(now + 1);
				map[now][i] = false;
			}
		}
	}

	private static boolean isPossible(int now, int i) {
		// TODO Auto-generated method stub
		for (int d = 0; d < 8; d++) {
			int jy = now + dy[d];
			int ix = i + dx[d];
			while (safe(jy, ix)) {
				if (map[jy][ix])
					return false;
				jy += dy[d];
				ix += dx[d];

			}
		}
		return true;
	}

	private static boolean safe(int y, int x) {
		if (y < 0 || x < 0 || y >= N || x >= N)
			return false;
		return true;
	}
}
