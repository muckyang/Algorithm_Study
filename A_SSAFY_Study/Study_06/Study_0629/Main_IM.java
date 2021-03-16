package Study_0629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_IM {
	static int N, M;
	static int map[][];
	static int res;

	static int tarx, tary;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		res = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
			}
		}

		func();
		System.out.println(tarx + " " + tary);
		System.out.println(res);
	}

	private static void func() {
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M; y++) {
				if (solve(x, y)) {
					res = 1;
					tarx = x;
					tary = y;
					return;
				}
			}
		}
	}

	private static boolean solve(int x, int y) {
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		int sum4 = 0;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				sum1 += map[i][j];
			}
		}

		for (int i = x; i < N; i++) {
			for (int j = 0; j < y; j++) {
				sum2 += map[i][j];
			}
		}
		if (sum1 != sum2)
			return false;
		for (int i = 0; i < x; i++) {
			for (int j = y; j < M; j++) {
				sum3 += map[i][j];
			}
		}
		if (sum1 != sum3)
			return false;
		for (int i = x; i < N; i++) {
			for (int j = y; j < M; j++) {
				sum4 += map[i][j];
			}
		}
		if (sum1 != sum4)
			return false;

		return true;
	}
}
