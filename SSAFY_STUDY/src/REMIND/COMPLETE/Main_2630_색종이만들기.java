package REMIND.COMPLETE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630_색종이만들기 {
	static int N;
	static int map[][];
	static int wcount, bcount;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		wcount = bcount = 0;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1)
					map[i][j] = 1;
			}
		}
//		print();
		solve(0, 0, N);// start, end, size
		System.out.println(wcount);
		System.out.println(bcount);

	}

	private static void solve(int x, int y, int size) {

		int color;
		if (map[x][y] == 1)
			color = 1;
		else
			color = 0;

		if (!checkAll(x, y, size, color)) {
			solve(x, y, size / 2);
			solve(x + size / 2, y, size / 2);
			solve(x, y + size / 2, size / 2);
			solve(x + size / 2, y + size / 2, size / 2);
		} else {
			if (color == 1)
				bcount++;
			else
				wcount++;
		}

	}

	private static boolean checkAll(int x, int y, int size, int color) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (color != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
