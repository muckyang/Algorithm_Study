package Main_02001_to_4000;

import java.util.Scanner;

public class Main_2174_로봇시뮬레이션 {
	static int A, B, N, M;
	static int[] robotX;
	static int[] robotY;
	static int[] robotd;
	static int[][] matrix;

	// 상 좌 하 우
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) {
		int check = 0;
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		N = sc.nextInt();
		M = sc.nextInt();
		matrix = new int[B][A];
		robotX = new int[N];
		robotY = new int[N];
		robotd = new int[N];
		for (int i = 0; i < N; i++) {

			robotY[i] = sc.nextInt()-1;
			robotX[i] = sc.nextInt()-1;
			matrix[robotX[i]][robotY[i]] = i + 1;
			String s = sc.next();
			if (s.charAt(0) == 'N') {
				robotd[i] = 0;
			}
			if (s.charAt(0) == 'W') {
				robotd[i] = 1;
			}
			if (s.charAt(0) == 'S') {
				robotd[i] = 2;
			}
			if (s.charAt(0) == 'E') {
				robotd[i] = 3;
			}
		}
		// 로봇 설정 끝
		for (int i = 0; i < M; i++) {
			int remoteR = sc.nextInt() - 1;
			String s = sc.next();
			int num = sc.nextInt();
			if (s.charAt(0) == 'R') {// 시계방향
				while (num != 0) {
					num--;
					robotd[remoteR]--;
					if (robotd[remoteR] == -1)
						robotd[remoteR] = 3;
				}
			} else if (s.charAt(0) == 'L') {// 반시계방향 // 증가
				while (num != 0) {
					num--;
					robotd[remoteR]++;
					if (robotd[remoteR] == 4)
						robotd[remoteR] = 0;
				}
			} else if (s.charAt(0) == 'F') {// 전진
				while (num != 0) {
					num--;
					int ix = robotX[remoteR] + dx[robotd[remoteR]];
					int jy = robotY[remoteR] + dy[robotd[remoteR]];
					if (ix < 0 || jy < 0 || ix >= B || jy >= A) {
						check = 1;
						System.out.println("Robot " + (remoteR + 1) + " crashes into the wall");
						return;
					} else if (matrix[ix][jy] != 0) {
						check = 1;
						System.out.println("Robot " + (remoteR + 1) + " crashes into robot " + matrix[ix][jy]);
						return;
					} else {
						matrix[robotX[remoteR]][robotY[remoteR]] = 0;
						matrix[ix][jy] = remoteR + 1;
						robotX[remoteR] = ix;
						robotY[remoteR] = jy;
					}
				}
			}
		}
		if (check == 0)
			System.out.println("OK");
	}
}
