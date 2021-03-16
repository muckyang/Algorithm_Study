package Study_1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19235_모노미노도미노 {
	static int N;
	static int blue[][];
	static int green[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		blue = new int[6][4];// 가로모양
		green = new int[6][4];// 세로모양
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int bt = 0;
			int gt = 0;

			blueGo(type, y, x);
			greenGo(type, x, y);

		}
	}

	private static void blueGo(int type, int y, int x) {
		int number = 1;
		if (type == 1) {

		} else if (type == 2) {

		} else if (type == 3) {
			number = 2;
		}
	}

	private static void greenGo(int type, int y, int x) {
		int number = 1;
		if (type == 2) {
			number = 2;
		}
	}
}
