package partition3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_park {
	static int R, C, howmany;
	static int[][] map;
	static LinkedList<Point> camera;// 추가
	static int[] dy = { 0, -1, 0, 1 };
	static int[] dx = { -1, 0, 1, 0 };
	static int answer;

	public static class Point {// 추가
		int y;
		int x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		howmany = 0;
		map = new int[R][C];
		answer = Integer.MAX_VALUE;
		camera = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0 && map[i][j] < 6) {
					camera.add(new Point(i, j));// 추가
					howmany++;
				}

			}
		}
		cctv(0, map);/// 재귀형식으로 카메라가 볼 수 있는 4가지 경우의 수를 체크함!
		
//      for (int i = 0; i < R; i++) {
//         for (int j = 0; j < C; j++) {
//            if (map[i][j] >= 0 && map[i][j] < 6) {
//               cctv(map[i][j], i, j, map);
//            }
//         }
//      }
		System.out.println(answer);
	}

//   public static void cctv(int cctv_num, int y, int x, int[][] map) {
	public static void cctv(int cctv_num, int[][] map) {
		if (cctv_num == howmany)//
			return;
		Point now = camera.get(cctv_num);// 이번에 체크할 카메라
		int[][] cm = new int[R][C];
		switch (map[now.y][now.x]) {
		case 1:
			for (int d = 0; d < 4; d++) {
				for (int t = 0; t < R; t++) {
					cm[t] = Arrays.copyOf(map[t], map[t].length);
				}
//            look(d, y, x, cm);
				look(d, now.y, now.x, cm);
				cctv(cctv_num + 1, cm);// 추가
				count(cm);
			}
			break;
		case 2:
			for (int d = 0; d < 2; d++) {
				for (int t = 0; t < R; t++) {
					cm[t] = Arrays.copyOf(map[t], map[t].length);
				}
//            look(d, y, x, cm);
//            look((d + 2) % 4, y, x, cm);
				look(d, now.y, now.x, cm);
				look((d + 2) % 4, now.y, now.x, cm);
				cctv(cctv_num + 1, cm);// 추가
				count(cm);

			}
			break;
		case 3:
			for (int d = 0; d < 4; d++) {
				for (int t = 0; t < R; t++) {
					cm[t] = Arrays.copyOf(map[t], map[t].length);
				}
//            look(d, y, x, cm);
//            look((d + 1) % 4, y, x, cm);
				look(d, now.y, now.x, cm);
				look((d + 1) % 4, now.y, now.x, cm);
				cctv(cctv_num + 1, cm);// 추가
				count(cm);

			}
			break;
		case 4:
			for (int d = 0; d < 4; d++) {
				for (int t = 0; t < R; t++) {
					cm[t] = Arrays.copyOf(map[t], map[t].length);
				}
//            look(d % 4, y, x, cm);
//            look((d + 1) % 4, y, x, cm);
//            look((d + 2) % 4, y, x, cm);

				look(d, now.y, now.x, cm);
				look((d + 1) % 4, now.y, now.x, cm);
				look((d + 2) % 4, now.y, now.x, cm);
				cctv(cctv_num + 1, cm);// 추가
				count(cm);

			}
			break;
		case 5:
			for (int t = 0; t < R; t++) {
				cm[t] = Arrays.copyOf(map[t], map[t].length);
			}
//         look(0, y, x, cm);
//         look(1, y, x, cm);
//         look(2, y, x, cm);
//         look(3, y, x, cm);
			look(0, now.y, now.x, cm);
			look(1, now.y, now.x, cm);
			look(2, now.y, now.x, cm);
			look(3, now.y, now.x, cm);
			cctv(cctv_num + 1, cm);// 추가
			count(cm);

			break;
		}

	}

	public static void count(int[][] cm) {
		System.out.println("+++++++++++++++++");
		print(cm);
		int cnt = 0;
		for (int i = 0; i < cm.length; i++) {
			for (int j = 0; j < cm[i].length; j++) {
				if (cm[i][j] == 0) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		answer = Math.min(answer, cnt);
	}

	public static void look(int d, int y, int x, int[][] cm) {
		int ny = y + dy[d];
		int nx = x + dx[d];
//      if (isSafe(ny, nx) && cm[ny][nx] == 0) {
		if (isSafe(ny, nx) && (cm[ny][nx] == 9 || cm[ny][nx] == 0)) {//카메라가 비춘곳 or 아직 안비춘곳
			// 다른 카메라가 존재하는 곳에는 가려짐 , 이거때매 헷갈림
			cm[ny][nx] = 9;
			look(d, ny, nx, cm);
		} else {
			return;
		}
	}

	public static boolean isSafe(int y, int x) {
		if (y >= 0 && y < R && x < C && x >= 0) {
			return true;
		}
		return false;
	}

	public static void print(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
}