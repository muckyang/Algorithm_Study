package Study_0904;

import java.util.LinkedList;
import java.util.Queue;

public class Kakao_2020_블록이동하기 {

	static boolean v[][][];
	static int map[][];
	static int n;
	static int min;
	static int dy[] = { 0, 1, 0, -1 };
	static int dx[] = { 1, 0, -1, 0 };
	static Queue<Point> q;

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 1 }, { 1, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 0 } };
		System.out.println(solution(board));
	}

	public static class Point {
		int y, x, type;

		public Point(int type, int y, int x) {
			this.y = y;
			this.x = x;
			this.type = type;

		}
	}

	public static int solution(int[][] board) {// y,x
		min = Integer.MAX_VALUE;
		n = board.length;
		q = new LinkedList<>();
		v = new boolean[2][n][n]; // 0 : ㅡ , 1: |
		map = board;
		v[0][0][0] = true;
		q.add(new Point(0, 0, 0));
		solve();
		print();
		printboard();
		return min;
	}

	private static void printboard() {

			for(int i = 0 ; i < n; i ++) {
				for(int j = 0; j < n ; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		
	}

	private static void solve() {
		int depth = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				if (p.x + p.y == n * 2 - 3) {
					min = depth;
					return;
				}
				for (int d = 0; d < 4; d++) {// 일반이동
					int jy = p.y + dy[d];
					int ix = p.x + dx[d];
					if (!safe(jy, ix) || v[p.type][jy][ix] || map[jy][ix] == 1)
						continue;
					if (p.type == 0 ) {
						if (!safe( jy, ix + 1) || map[jy][ix + 1] == 1)
							continue;
					} else if (p.type == 1) {
						if (!safe(jy + 1, ix) || map[jy + 1][ix] == 1)
							continue;
					}
					
					v[p.type][jy][ix] = true;
					q.add(new Point(p.type, jy, ix));
					
				}
				for (int d = 0; d < 2; d++) {
					// 첫위치를 중심으로 회전
					if (d == 0) {
						if (p.type == 0) { // 가로모양
							if (p.y > 0 && !v[1][p.y - 1][p.x] && map[p.y - 1][p.x + 1] == 0
									&& map[p.y - 1][p.x] == 0) { // 위쪽 세로모양으로 변경시
								v[1][p.y - 1][p.x] = true;
								q.add(new Point(1, p.y - 1, p.x));
							}
							if (p.y < n - 1 && !v[1][p.y][p.x] && map[p.y + 1][p.x + 1] == 0
									&& map[p.y + 1][p.x] == 0) { // 아래 세로모양으로 변경시
								v[1][p.y][p.x] = true;
								q.add(new Point(1, p.y, p.x));
							}
						} else {// 세로모양
							if (p.x > 0 && !v[0][p.y][p.x - 1] && map[p.y + 1][p.x - 1] == 0
									&& map[p.y][p.x - 1] == 0) { // 왼쪽 가로모양
								v[0][p.y][p.x - 1] = true;
								q.add(new Point(0, p.y, p.x - 1));
							}
							if (p.x < n - 1 && !v[0][p.y][p.x] && map[p.y + 1][p.x + 1] == 0
									&& map[p.y][p.x + 1] == 0) { // 오른쪽 가로모양
								v[0][p.y][p.x] = true;
								q.add(new Point(0, p.y, p.x));
							}
						}
					} else {// 끝위치를 중심으로 회전
						if (p.type == 0) { // 가로모양
							if (p.y > 0 && !v[1][p.y - 1][p.x + 1] && map[p.y - 1][p.x + 1] == 0
									&& map[p.y - 1][p.x] == 0) { // 위쪽 세로모양으로 변경시
								v[1][p.y - 1][p.x + 1] = true;
								q.add(new Point(1, p.y - 1, p.x + 1));
							}
							if (p.y < n - 1 && !v[1][p.y][p.x + 1] && map[p.y + 1][p.x] == 0
									&& map[p.y + 1][p.x + 1] == 0) { // 아래 세로모양으로 변경시
								v[1][p.y][p.x + 1] = true;
								q.add(new Point(1, p.y, p.x + 1));
							}
						} else {// 세로모양
							if (p.x > 0 && !v[0][p.y + 1][p.x - 1] && map[p.y][p.x - 1] == 0
									&& map[p.y + 1][p.x - 1] == 0) { // 왼쪽 가로모양
								v[0][p.y + 1][p.x - 1] = true;
								q.add(new Point(0, p.y + 1, p.x - 1));
							}
							if (p.x < n - 1 && !v[0][p.y + 1][p.x] && map[p.y + 1][p.x + 1] == 0
									&& map[p.y][p.x + 1] == 0) { // 오른쪽 가로모양
								v[0][p.y + 1][p.x] = true;
								q.add(new Point(0, p.y + 1, p.x));
							}
						}
					}
				}

			}
			depth++;
		}

	}

	public static boolean safe( int x, int y) {

		if (x < 0 || y < 0 || x > n - 1 || y > n - 1)
			return false;

		return true;
	}
	public static void print () {
		for(int b = 0; b< 2 ;b++) {
			for(int i = 0 ; i < n; i ++) {
				for(int j = 0; j < n ; j++) {
					System.out.print(v[b][i][j]  ? 1 : 0);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
