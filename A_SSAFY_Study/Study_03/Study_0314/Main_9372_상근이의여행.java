package Study_0314;

import java.util.Scanner;

public class Main_9372_상근이의여행 {
	static int T, N, M;
	static boolean map[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new boolean[N][N];
			for (int i = 0; i < M; i++) {
				int x = sc.nextInt()-1;
				int y = sc.nextInt()-1;
				map[x][y] = map[y][x] = true;
			}
			System.out.println(N - 1);

		}
	}
}
