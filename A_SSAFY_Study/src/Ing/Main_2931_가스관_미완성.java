package Ing;

import java.util.Scanner;

public class Main_2931_가스관_미완성 {
	static int N, M;
	static char[][] matrix;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean target, m, z;
	static boolean[] tr;
	static int sx, sy, ex, ey;
	static char res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		target = false;
		res = '.';
		sx = sy = ex = ey = -1;
		matrix = new char[N][M];
		tr = new boolean[4];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++) {
				matrix[i][j] = s.charAt(j);
				if (matrix[i][j] != '.' && matrix[i][j] != 'Z' && matrix[i][j] != 'M' && sx == -1) {
					sx = i;
					sy = j;
				}
			}
		}
		// 입력은 맞음
		visited[sx][sy] = true;
		dfs(sx, sy);
		System.out.println(ex + " " + ey + " " + res);
	}

	private static void dfs(int x, int y) {
		if (target)// 찾았다면 리턴해버림
			return;
		if (matrix[x][y] == '.') { // 위치 찾은경우
			target = true;
			ex = x + 1;
			ey = y + 1;
			int cnt = 0;
			for (int d = 0; d < 4; d++) {
				int ix = x + dx[d];
				int jy = y + dy[d];
				if (ix >= 0 && jy >= 0 && ix < N && jy < M && matrix[ix][jy] != '.') {
					if (d == 0 && (matrix[ix][jy] == '+' || matrix[ix][jy] == '-' || matrix[ix][jy] == '3'
							|| matrix[ix][jy] == '4')) {
						tr[d] = true;
					}
					if (d == 1 && (matrix[ix][jy] == '+' || matrix[ix][jy] == '|' || matrix[ix][jy] == '2'
							|| matrix[ix][jy] == '3')) {
						tr[d] = true;
					}
					if (d == 2 && (matrix[ix][jy] == '+' || matrix[ix][jy] == '-' || matrix[ix][jy] == '1'
							|| matrix[ix][jy] == '2')) {
						tr[d] = true;
					}
					if (d == 3 && (matrix[ix][jy] == '+' || matrix[ix][jy] == '|' || matrix[ix][jy] == '4'
							|| matrix[ix][jy] == '1')) {
						tr[d] = true;
					}
					cnt++;
				}
			}
			if (cnt == 1) {
				for (int d = 0; d < 4; d++) {
					int ix = x + dx[d];
					int jy = y + dy[d];
					if (ix >= 0 && jy >= 0 && ix < N && jy < M && matrix[ix][jy] != '.') {
						if (!z && matrix[ix][jy] == 'Z') {
							z = true;
							tr[d] = true;
						}
						if (!m && matrix[ix][jy] == 'M') {
							m = true;
							tr[d] = true;
						}


					}
				}
			}

			if (cnt == 4)
				res = '+';
			else if (tr[0] && tr[1])
				res = '1';
			else if (tr[1] && tr[2])
				res = '4';
			else if (tr[2] && tr[3])
				res = '3';
			else if (tr[3] && tr[0])
				res = '2';
			else if (tr[0] && tr[2])
				res = '-';
			else if (tr[1] && tr[3])
				res = '|';
			return;
		} else if (matrix[x][y] == '+') {
			for (int d = 0; d < 4; d++) {
				int ix = x + dx[d];
				int jy = y + dy[d];
				if (ix >= 0 && jy >= 0 && ix < N && jy < M && !visited[ix][jy]) {
					visited[ix][jy] = true;
					dfs(ix, jy);
				}
			}
		} else if (matrix[x][y] >= 49 && matrix[x][y] < 53) { // 1~4
			int num = matrix[x][y] - 49;
			if (num == 1)
				num = 3;
			else if (num == 3)
				num = 1;
			for (int d = num; d < num + 2; d++) {
				if (d == 4)
					d = 0;
				int ix = x + dx[d];
				int jy = y + dy[d];
				if (ix >= 0 && jy >= 0 && ix < N && jy < M && !visited[ix][jy]) {
					visited[ix][jy] = true;
					dfs(ix, jy);
				}

			}
		} else if (matrix[x][y] == '|') {
			for (int d = 1; d < 4; d += 2) {
				int ix = x + dx[d];
				int jy = y + dy[d];
				if (ix >= 0 && jy >= 0 && ix < N && jy < M && !visited[ix][jy]) {
					visited[ix][jy] = true;
					dfs(ix, jy);
				}

			}
		} else if (matrix[x][y] == '-') {
			for (int d = 0; d < 4; d += 2) {
				int ix = x + dx[d];
				int jy = y + dy[d];
				if (ix >= 0 && jy >= 0 && ix < N && jy < M && !visited[ix][jy]) {
					visited[ix][jy] = true;
					dfs(ix, jy);
				}

			}
		} else if (matrix[x][y] == 'Z') {
			z = true;
		} else if (matrix[x][y] == 'M') {
			m = true;
		}

	}

}
