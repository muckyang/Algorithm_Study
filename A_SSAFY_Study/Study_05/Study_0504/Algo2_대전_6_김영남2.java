package Study_0504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo2_대전_6_김영남2 {
	static int T, R, C;
	static int N;
	static char map[][];// 굳은거 O 장애물 X
	static int dx[] = { 1, 0, 0 };
	static int dy[] = { 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			for (int i = 0; i < R; i++) {
				String s = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = s.charAt(j);
				}
			}

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				int num = Integer.parseInt(st.nextToken()) - 1; 
				solve(num);
			}

			System.out.println("# " + t);
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}

	}

	private static void solve(int num) {
		drop(0, num);
	}

	private static void drop(int x, int y) {
		int ix = x + dx[0];
		int jy = y + dy[0];
		if (!safe(ix, jy) || map[ix][jy] == 'X' ) {// 범위 밖이거나 장애물인 경우
			map[x][y] = 'O';
		} else if (map[ix][jy] == '.') {
			drop(ix, jy);
		} else if (map[ix][jy] == 'O') {
			for (int d = 1; d < 3; d++) {
				int kx = x + dx[d];
				int ky = y + dy[d];
				if (safe(kx, ky) && safe(kx + 1, ky) && map[kx][ky] == '.' && map[kx + 1][ky] == '.') {
					drop(kx + 1, ky);
					return;
				}
			}
			map[x][jy] = 'O';
		}
		return;
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < R && y < C)
			return true;
		return false;
	}
}
