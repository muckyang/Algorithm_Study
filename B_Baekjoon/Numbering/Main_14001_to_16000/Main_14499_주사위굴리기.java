package Main_14001_to_16000;

import java.util.Scanner;

public class Main_14499_주사위굴리기 {
	static int N, M, K;
	static int x, y;
	static int[] value;
	static int top, bot, east, west, south, north;
	static int[][] matrix;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		K = sc.nextInt();
		top = 1;
		north = 2;
		east = 3;
		west = 4;
		south = 5;
		bot = 6;
		value = new int[6];
		matrix = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < K; i++) {
			int d = sc.nextInt() - 1;
			int ix = x + dx[d];
			int jy = y + dy[d];
			if (ix < 0 || jy < 0 || ix >= N || jy >= M)
				continue;
			dice(ix, jy, d);
			x = ix;
			y = jy;
		}

	}

	private static void dice(int ix, int jy, int d) {
		int temp = 0;
		if (d == 0) {// 동
			temp = top;
			top = west;
			west = bot;
			bot = east;
			east = temp;
		} else if (d == 1) {// 서
			temp = top;
			top = east;
			east = bot;
			bot = west;
			west = temp;
		} else if (d == 2) {// 북

			
			temp = top;
			top = south;
			south = bot;
			bot = north;
			north = temp;
		
		} else if (d == 3) {// 남
			temp = top;
			top = north;
			north = bot;
			bot = south;
			south = temp;
		}
		if (matrix[ix][jy] == 0) {
			 matrix[ix][jy] = value[bot - 1];
		} else {
			value[bot - 1] = matrix[ix][jy];
			matrix[ix][jy] = 0;
		}
		System.out.println(value[top - 1]);
	}
}
