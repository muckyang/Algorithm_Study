package Main_02001_to_4000;

import java.util.Scanner;

public class Main_2606_바이러스 {
	static int N, K;
	static boolean[][] map;
	static boolean[] v;
	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		res = 0;
		map = new boolean[N][N];
		for (int i = 0; i < K; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;

			map[x][y] = map[y][x] = true;
		}

		v = new boolean[N];
		v[0] = true;

		solve(0);
		System.out.println(res);
	}

	private static void solve(int x) {
		for(int i = 0 ; i < N; i++) {
			if(map[x][i] && !v[i]) {
				res++;
				v[i] =true;
				solve(i);
			}
		}
	}

}