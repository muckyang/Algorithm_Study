package Month02_Week03;

import java.util.Scanner;

public class Main_3109_빵집 {

	static int N, M; /// 10000 , 500
	static int matrix[][];
	static int cnt;
	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };
	static int check;

	public static void dfs(int x, int y) {
		matrix[x][y] = 1;
		if (y == M - 1) {
			check = 1;
			cnt++;
			return;
		}
		for (int d = 0; d < 3; d++) {
			int ix = x + dx[d];
			int jy = y + dy[d];
			if (ix >= 0 && ix < N && matrix[ix][jy] != 1 && check == 0) {
				matrix[ix][jy] = 1;
				dfs(ix, jy);
			} else if (check == 1) {
				return;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		matrix = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++) {
				if (s.charAt(j) == '.')
					matrix[i][j] = 0;
				if (s.charAt(j) == 'x')
					matrix[i][j] = 1;
			}
		}
		cnt = 0;

		for (int i = 0; i < N; i++) {
			check = 0;// 0일떈 아직 연결안됨
//			matrix[i][0] = 1;
			dfs(i, 0);
			if (check == 0)
				matrix[i][0] = 0;
		}

		System.out.println(cnt);
	}

}
