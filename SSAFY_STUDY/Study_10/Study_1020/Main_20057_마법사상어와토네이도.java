package Study_1020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20057_마법사상어와토네이도 {
	static int N;
	static int map[][];
	static int res, sum;

	static int dy[] = { 0, 1, 0, -1 };
	static int dx[] = { -1, 0, 1, 0 };
	static int spread[] = { 2, 10, 7, 1, 5, 10, 7, 1, 2, 0 };
	static int my[][] = { { -2, -1, -1, -1, 0, 1, 1, 1, 2, 0 }, { 0, 1, 0, -1, 2, 1, 0, -1, 0, 1 },
			{ 2, 1, 1, 1, 0, -1, -1, -1, -2, 0 }, { 0, -1, 0, 1, -2, -1, 0, 1, 0, -1 } };
	static int mx[][] = { { 0, -1, 0, 1, -2, -1, 0, 1, 0, -1 }, { 2, 1, 1, 1, 0, -1, -1, -1, -2, 0 },
			{ 0, 1, 0, -1, 2, 1, 0, -1, 0, 1 }, { -2, -1, -1, -1, 0, 1, 1, 1, 2, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int d = 0;
		int jy = N / 2;
		int ix = N / 2;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				for (int l = 0; l < i; l++) {
					jy += dy[d];
					ix += dx[d];
					sum = 0;
					for (int k = 0; k < 10; k++) {
						int ky = my[d][k] + jy;
						int kx = mx[d][k] + ix;
						solve(d, jy, ix, k, ky, kx);
					}
					map[jy][ix] = 0;
				}
				d++;
				if (d >= 4)
					d -= 4;
				print();
			}
		}
		sum = 0;
		jy += dy[d];
		ix += dx[d];
		for (int k = 0; k < 10; k++) {
			int ky = my[d][k] + jy;
			int kx = mx[d][k] + ix;
			solve(d, jy, ix, k, ky, kx);
		}
		System.out.println(res);
	}

	private static void solve(int d, int jy, int ix, int k, int ky, int kx) {

		if (k == 9) {
			if (ky < 0 || kx < 0 || ky >= N || kx >= N) {
				res += sum;
				return;
			}
			map[ky][kx] += map[jy][ix] - sum;
		}
		int sp = (map[jy][ix] * spread[k]) / 100;
		if (ky < 0 || kx < 0 || ky >= N || kx >= N) {
			res += sp;
			sum += sp;
			return;
		} else {
			map[ky][kx] += sp;
			sum += sp;
		}
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
