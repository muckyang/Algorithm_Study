package REMIND.COMPLETE;

import java.util.Scanner;

public class Main_15683_감시 {
	static int N, M;
	static int map[][];
	static int temp[][];
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, -1, 0, 1 };

	static int camera;
	static int turn[];
	static Camera[] list;
	static int min;

	public static class Camera {
		int x;
		int y;
		int index;

		public Camera(int x, int y, int index) {
			this.x = x;
			this.y = y;
			this.index = index;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		camera = 0;
		min = Integer.MAX_VALUE;
		list = new Camera[8];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] != 0 && map[i][j] != 6) {
					list[camera] = new Camera(i,j,map[i][j]);
					camera++;
				}

			}
		}

		turn = new int[camera];
		solve(0);
		System.out.println(min);
	}

	private static void solve(int count) {
		if (count == camera) {
			temp = new int[N][M];
			
			for (int i = 0; i < N; i++)
				System.arraycopy(map[i], 0, temp[i], 0, M);

			for (int i = 0; i < count; i++)
				ON(i);
			
			sagak();
			return;
		}
		for (int d = 0; d < 4; d++) {
			turn[count] = d;
			solve(count + 1);
		}

	}

	private static void ON(int i) {
		Camera k = list[i];
		int d = turn[i];
		if (k.index == 1) {// 한쪽만 켜짐
			seeLine(k, d);

		} else if (k.index == 2) { // 양옆 , 상하
			if (d % 2 == 0) {
				seeLine(k, 0);
				seeLine(k, 2);
			} else {
				seeLine(k, 1);
				seeLine(k, 3);
			}
		} else if (k.index == 3) { // 인접한 두 방향
			seeLine(k, d);
			if (d == 3)
				seeLine(k, 0);
			else
				seeLine(k, d + 1);
		} else if (k.index == 4) { // 세 방향
			for (int l = 0; l < 4; l++) {
				if (d == l)
					continue;
				seeLine(k, l);
			}
		} else if (k.index == 5) { // 전 방향
			for (int l = 0; l < 4; l++) {
				seeLine(k, l);
			}
		}

	}

	private static void seeLine(Camera k, int d) {
		int x = k.x;
		int y = k.y;

		while (true) {
			int ix = x + dx[d];
			int jy = y + dy[d];

			if (!safe(ix, jy) || temp[ix][jy] == 6) {
				break;
			} else {
				if (temp[ix][jy] == 0)
					temp[ix][jy] = -1;
				x = ix;
				y = jy;
			}
		}
	}

	private static boolean safe(int ix, int jy) {
		if (ix >= 0 && jy >= 0 && ix < N && jy < M)
			return true;
		return false;
	}

	private static void sagak() {
		int c = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (temp[i][j] == 0)
					c++;
			}
		}
		if (min > c)
			min = c;
	}
}
