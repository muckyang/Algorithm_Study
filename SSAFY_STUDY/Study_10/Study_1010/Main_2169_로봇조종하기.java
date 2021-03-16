package Study_1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2169_로봇조종하기 {

	static int N, M;
	static int map[][];
	static int visit[][];

	public static class Point {
		int y, x;
		int value;

		public Point(int y, int x, int value) {
			this.y = y;
			this.x = x;
			this.value = value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (i == 0 && j == 0) {
					visit[i][j] = map[i][j];
				} else if (i == 0) {
					visit[i][j] = visit[i][j - 1] + map[i][j];
				} else {
					visit[i][j] = Integer.MIN_VALUE;
				}
			}
		}
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visit[i][j] = visit[i - 1][j] + map[i][j];
			}
			int temp [] = new int[M];
			System.arraycopy(visit[i], 0, temp, 0, M);
			for (int j = 0; j < M; j++) {
				left(temp[j], i, j);
				right(temp[j], i, j);
			}
		}
		System.out.println(visit[N - 1][M - 1]);

	}

	private static void left(int value, int y, int x) {
		if (x <= 0) {
			return;
		}
		int res = value + map[y][x - 1];
		if (res > visit[y][x - 1]) {
			visit[y][x - 1] = res;
			left(res, y, x - 1);
		}
	}

	private static void right(int value, int y, int x) {
		if (x >= M - 1) {
			return;
		}
		int res = value + map[y][x + 1];
		if (res > visit[y][x + 1]) {
			visit[y][x + 1] = res;
			right(res, y, x + 1);
		}
	}
}
