package Study_0419;

import java.util.Scanner;

public class Main_13460_구슬탈출2 {
	static int N, M;
	static boolean red, blue, check;
	static int srx, sry, sbx, sby, min, res;
	static int rx, ry, bx, by;
	static int turn[];
	static int map[][];
	static int copy[][];
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++) {
				char c = s.charAt(j);
				if (c == '#') {
					map[i][j] = -1;
				} else if (c == 'O') {
					map[i][j] = 1;
				} else if (c == 'R') {
					map[i][j] = 2;
					srx = i;
					sry = j;
				} else if (c == 'B') {
					map[i][j] = 2;
					sbx = i;
					sby = j;
				}
			}
		}
		check = false;
		min = 11;
		turn = new int[11];
		perm(0);

		if (check)
			System.out.println(min);
		else
			System.out.println(-1);
	}

	private static void perm(int cnt) {
		if (cnt >= min)
			return;

		if (cnt > 0) {// 구슬 굴리기
			copy = new int[N][M];
			for (int i = 0; i < N; i++)
				System.arraycopy(map[i], 0, copy[i], 0, M);
			red = blue = false;
			rx = srx;
			ry = sry;
			bx = sbx;
			by = sby;
			for (int i = 0; i < cnt; i++) {
				int d = turn[i];
				if (d == 0) {
					if (rx > bx) {
						go(rx, ry, d, false);
						go(bx, by, d, true);
					} else {
						go(bx, by, d, true);
						go(rx, ry, d, false);
					}
				} else if (d == 1) {
					if (ry > by) {
						go(rx, ry, d, false);
						go(bx, by, d, true);
					} else {
						go(bx, by, d, true);
						go(rx, ry, d, false);
					}
				} else if (d == 2) {
					if (rx < bx) {
						go(rx, ry, d, false);
						go(bx, by, d, true);
					} else {
						go(bx, by, d, true);
						go(rx, ry, d, false);
					}
				} else if (d == 3) {
					if (ry < by) {
						go(rx, ry, d, false);
						go(bx, by, d, true);
					} else {
						go(bx, by, d, true);
						go(rx, ry, d, false);
					}
				}
				if (blue)
					return;
				if (red) {
					if (min > cnt) {
						min = cnt;
						check = true;
					}
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			if (cnt > 0 && (turn[cnt - 1] == i || turn[cnt - 1] - 2 == i || turn[cnt - 1] + 2 == i))
				continue;
			turn[cnt] = i;
			perm(cnt + 1);
		}
	}

	private static void go(int x, int y, int d, boolean k) {
		while (true) {
			int ix = x + dx[d];
			int jy = y + dy[d];
			if (copy[ix][jy] == 0) {
				copy[x][y] = 0;
				copy[ix][jy] = 2;
				x = ix;
				y = jy;
			} else if (copy[ix][jy] == 1) {// 끝
				copy[x][y] = 0;
				if (k) {
					blue = true;
				} else {
					red = true;
				}
				break;
			} else {// 벽 혹은 구슬
				if (k) {
					bx = x;
					by = y;
				} else {
					rx = x;
					ry = y;
				}
				break;
			}
		}

	}

}
