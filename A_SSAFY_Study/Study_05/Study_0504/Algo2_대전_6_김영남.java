package Study_0504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo2_대전_6_김영남 {
	static int T, R, C;
	static int N;
	static char map[][];// 굳은거 O 장애물 X
	static int dx[] = { 1, 0, 0 };
	static int dy[] = { 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder stb = new StringBuilder();
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

			stb.append("# ").append(t).append("\n");
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					stb.append(map[i][j]);
				}
				stb.append("\n");
			}
			
		}
		System.out.println(stb.toString());

	}

	private static void solve(int num) {
		drop(0, num);
	}

	private static void drop(int x, int y) {
		int ix = x + dx[0];
		int jy = y + dy[0];
		if (!safe(ix, jy) || map[ix][jy] == 'X' ) {// 범위 밖이거나 장애물인 경우
			map[x][y] = 'O';
		} else if (map[ix][jy] == '.') {//내려갈수 있는 경우
			drop(ix, jy);
		} else if (map[ix][jy] == 'O') { // 이미 굳은 화산석을 만난경우
			for (int d = 1; d < 3; d++) {// 왼쪽 , 오른쪽 순서대로 확인( 아래대각선도 확인)
				int kx = x + dx[d];
				int ky = y + dy[d];
				if (safe(kx, ky) && safe(kx + 1, ky) && map[kx][ky] == '.' && map[kx + 1][ky] == '.') {
					drop(kx + 1, ky);// 두 곳다 비어있다면 그 방향으로 이동후 떨굼
					return;
				}
			}
			map[x][jy] = 'O';// 양쪽다 갈수 없다면 화산석 위에 화산석 굳음
		}
		return;
	}

	private static boolean safe(int x, int y) {//범위 나가는지 여부 확인
		if (x >= 0 && y >= 0 && x < R && y < C)
			return true;
		return false;
	}
}
