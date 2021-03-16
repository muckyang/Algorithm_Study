package Study_0623;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2931_가스관 {
	static int N, M;
	static int tarx, tary;
	static char resshape;
	static int map[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static int isLink[];
	// 상 하 좌 우
	static int shape[][] = { { 0, 0, 0, 0 }, { 0, 1, 0, 1 }, { 1, 0, 0, 1 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 },
			{ 1, 1, 0, 0 }, { 0, 0, 1, 1 }, { 1, 1, 1, 1 } }; // . ,1,2,3,4,|,-,+ 순

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				char a = s.charAt(j);
				if (a == '+')
					map[i][j] = 7;
				else if (a == '-')
					map[i][j] = 6;
				else if (a == '|')
					map[i][j] = 5;
				else if (a == '.')
					map[i][j] = 0;
				else if (a == 'M')
					map[i][j] = -1;
				else if (a == 'Z')
					map[i][j] = -2;
				else
					map[i][j] = a - '0';
			}
		}
		targeting();// 없어진 위치 확인
		check4way();
		int ss = 0;
		for (int i = 1; i < 8; i++) {
			int count = 0;
			for (int d = 0; d < 4; d++) {
				if (isLink[d] == shape[i][d])
					count++;
			}
			if (count == 4)
				ss = i;
		}
		
		if (ss == 7)
			resshape = '+';
		else if (ss == 6)
			resshape = '-';
		else if (ss == 5)
			resshape = '|';
		else
			resshape = (char) (ss + '0');
		System.out.println(tarx + 1 + " " + (tary + 1) + " " + resshape);
	}

	private static void check4way() {
		isLink = new int[4];
		for (int d = 0; d < 4; d++) {
			int ix = tarx + dx[d];
			int jy = tary + dy[d];
			if (ix < 0 || jy < 0 || ix > N - 1 || jy > M - 1 || map[ix][jy] == 0)
				continue;
			if( map[ix][jy] < 0)
				isLink[d] = 0;
			else if (d % 2 == 0) { // 상 or 좌
				int id = d + 1;
				if (shape[map[ix][jy]][id] == 1)
					isLink[d] = 1;
			} else { // 하 or 우
				int id = d - 1;
				if (shape[map[ix][jy]][id] == 1)
					isLink[d] = 1;
			}

		}
	}

	private static void targeting() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0)
					if (check(i, j))
						return;
			}
		}
	}

	private static boolean check(int x, int y) {
		int pipe = map[x][y];
		for (int d = 0; d < 4; d++) {
			if (shape[pipe][d] == 0)
				continue;
			int ix = x + dx[d];
			int jy = y + dy[d];
			if (map[ix][jy] == 0) {
				tarx = ix;
				tary = jy;
				return true;
			}
		}
		return false;
	}


}
