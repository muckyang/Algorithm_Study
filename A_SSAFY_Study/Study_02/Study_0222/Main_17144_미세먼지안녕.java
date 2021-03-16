package Study_0222;

import java.util.Scanner;

public class Main_17144_미세먼지안녕 {
	static int N, M, T;
	static int[][] matrix;
	static int[][] calc;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[] bdx = { 1, 0, -1, 0 };
	static int[] bdy = { 0, 1, 0, -1 };
	static int tx, ty, bx, by; // 공청기 좌표

	private static void func(int c) {
		while (c != T) {
			spary();
			topShift();
			bottomShift();
			c++;
//			print();
		}

	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void spary() {
		calc = new int[N][M];
		calc[tx][ty] = -1;
		calc[bx][by] = -1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int cnt = 0;
				boolean[] list = new boolean[4];
				if (matrix[i][j] > 0) {
					for (int d = 0; d < 4; d++) {
						int ix = i + dx[d];
						int jy = j + dy[d];
						if (ix >= 0 && jy >= 0 && ix < N && jy < M && matrix[ix][jy] != -1) {
							cnt++;
							list[d] = true;
						}

					}
					calc[i][j] += (matrix[i][j] - (matrix[i][j] / 5) * cnt);
					for (int d = 0; d < 4; d++) {
						int ix = i + dx[d];
						int jy = j + dy[d];
						if (list[d]) {
							calc[ix][jy] += (matrix[i][j] / 5);
						}

					}
				}
			}

		}
		for (int i = 0; i < N; i++)
			System.arraycopy(calc[i], 0, matrix[i], 0, matrix[i].length);
	}

	private static void topShift() {
		int x = tx;
		int y = ty;
		for (int d = 0; d < 4; d++) {
			while (true) {
				int ix = x + dx[d];
				int jy = y + dy[d];
				if (ix < 0 || jy < 0 || ix > tx || jy >= M) {
					break;
				} else {
					if (matrix[x][y] == -1) {
						x = ix;
						y = jy;
					} else if (matrix[ix][jy] == -1) {
						matrix[x][y] = 0;
						break;
					} else {
						matrix[x][y] = matrix[ix][jy];
						x = ix;
						y = jy;
					}
				}
			}
		}
	}

	private static void bottomShift() {
		int x = bx;
		int y = by;
		for (int d = 0; d < 4; d++) {
			while (true) {
				int ix = x + bdx[d];
				int jy = y + bdy[d];
				if (ix < bx || jy < 0 || ix >= N || jy >= M) {
					break;
				} else {
					if (matrix[x][y] == -1) {
						x = ix;
						y = jy;
					} else if (matrix[ix][jy] == -1) {
						matrix[x][y] = 0;
						break;
					} else {
						matrix[x][y] = matrix[ix][jy];
						x = ix;
						y = jy;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();
		matrix = new int[N][M];
		tx = ty = bx = by = -1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				matrix[i][j] = sc.nextInt();
				if (matrix[i][j] == -1 && tx == -1) {
					tx = i;
					ty = j;
				} else if (matrix[i][j] == -1 && tx != -1) {
					bx = i;
					by = j;
				}
			}
		}

//		topShift();
//		bottomShift();
		func(0);

//		print();

		int sum = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sum += matrix[i][j];
			}
		}
		System.out.println(sum);

	}

}
