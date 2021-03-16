package Pass_Feb_Week01;

import java.util.Scanner;

public class Solution_D5_1247_최적경로 {
	static int T, N, sx, sy, ex, ey;
	static int[] dx;
	static int[] dy;
	static int Min_dist;

	public static void func(int N, int x, int y, int flag, int count, int dist) { // N

		if (count == N) {// 모두 거쳐감
			dist += Math.abs(ex - x) + Math.abs(ey - y);
			Min_dist = Math.min(Min_dist, dist);
			return;
		} else {
			for (int i = 0; i < N; i++) {
				int k =  dist + Math.abs(x - dx[i]) + Math.abs(y - dy[i]);
				if ((flag & 1 << i) == 0 && k < Min_dist) {
					func(N, dx[i], dy[i], flag | 1 << i, count + 1,k);
				}
			}

		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			Min_dist = Integer.MAX_VALUE;

			dx = new int[N];
			dy = new int[N];
			// 시작 좌표
			sx = sc.nextInt();
			sy = sc.nextInt();
			// 끝 좌표
			ex = sc.nextInt();
			ey = sc.nextInt();

			// 0번 배열에는 아무것도 넣지않음
			for (int i = 0; i < N; i++) {
				dx[i] = sc.nextInt();
				dy[i] = sc.nextInt();

			}
			for (int i = 0; i < N; i++) {
				func(N, dx[i], dy[i], 1 << i, 1, Math.abs(sx - dx[i]) + Math.abs(sy - dy[i]));
			}

			System.out.println("#" + test_case + " " + Min_dist);
		}

	}
}
