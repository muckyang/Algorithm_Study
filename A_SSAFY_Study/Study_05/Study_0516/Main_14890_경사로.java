package Study_0516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14890_경사로 {
	static int N, L;
	static int map[][];
	static boolean v[][][];
	static int backnum;
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		v = new boolean[2][N][N]; // 0 가로 1 세로
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		res = 0;
		for (int i = 0; i < N; i++) {// 가로방향 체크
			backnum = map[i][0];
			for (int j = 1; j < N; j++) {
				if (backnum == map[i][j]) {
				} else if (backnum + 1 == map[i][j]) { // 오르막길
					if (check(i, j, 1, 0)) {// i j 에서 오르막일때, 가로방향
						backnum++;
					} else {
						break;
					}
				} else if (backnum - 1 == map[i][j]) { // 내리막길
					if (check(i, j, 0, 0)) {// i j 에서 내리막때, 가로방향
						backnum--;
					} else {
						break;
					}
				} else
					break;
				// 살아서 포문을 다 돌은 경우 ( 길연결
				if (j == N - 1) {
					res++;
				}
			}
		}

		for (int j = 0; j < N; j++) {// 세로방향 체크
			backnum = map[0][j];
			for (int i = 1; i < N; i++) {
				if (backnum == map[i][j]) {

				} else if (backnum + 1 == map[i][j]) { // 오르막길
					if (check(i, j, 1, 1)) {// i j 에서 오르막일때, 세로방향
						backnum++;
					} else {
						break;
					}
				} else if (backnum - 1 == map[i][j]) { // 내리막길
					if (check(i, j, 0, 1)) {// i j 에서 내리막때, 세로방향

						backnum--;
					} else {
						break;
					}
				} else
					break;
				if (i == N - 1) {
					res++;
				}
			}
		}
		System.out.println(res);

	}

	private static boolean check(int x, int y, int h, int t) { // (x,y,오르막 1/0 내리막, 방향 가로 0/1 세로)
		int d = h * 1 + t * 2; // d = 0 ,1 은 내리막 확인용 , 2 ,3 오르막 확인용
		int ix = x;
		int jy = y;
		int K = L;
		if (h == 0) {
			if (v[t][ix][jy])
				return false;
			v[t][ix][jy] = true;
			for (int i = 1; i <= K - 1; i++) {
				ix += dx[d];
				jy += dy[d];
				if (!safe(ix, jy) || map[ix][jy] != map[x][y] || v[t][ix][jy])
					return false;
				v[t][ix][jy] = true;
			}
		} else
			for (int i = 1; i <= K; i++) {
				ix += dx[d];
				jy += dy[d];
				if (!safe(ix, jy) || map[ix][jy] != map[x][y] - 1 || v[t][ix][jy])
					return false;
				v[t][ix][jy] = true;
			}

		return true;
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		return false;
	}
}
