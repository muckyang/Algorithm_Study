package Uncomplete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AMain_1175_배달 {
	static int N, M;
	static int map[][];
	static int v[][][][];
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static Queue<Point> q;
	static int sx, sy, ex1, ey1, ex2, ey2;
	static int ecnt, min;

	public static class Point {
		int x, y, d, index, depth;

		public Point(int x, int y, int d, int index, int depth) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.index = index;
			this.depth = depth;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ecnt = 0;
		map = new int[N][M];
		v = new int[4][4][N][M];// 도착상태 , 방향 , N , M
		q = new LinkedList<>();
		min = Integer.MAX_VALUE;
		for (int stk = 0; stk < 4; stk++) {
			for (int d = 0; d < 4; d++) {
				for (int i = 0; i < N; i++) {
					Arrays.fill(v[stk][d][i], Integer.MAX_VALUE);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = s.charAt(j);
				if (c == 'S') {
					sx = i;
					sy = j;
				} else if (c == '#') {
					map[i][j] = -1;
				} else if (c == '.') {

				} else if (c == 'C') {
					if (ecnt == 0) {
						ex1 = i;
						ey1 = j;
					} else {
						ex2 = i;
						ex2 = j;
					}

				}
			}
		}
		v[0][0][sx][sy] = 0;
		v[0][1][sx][sy] = 0;
		v[0][2][sx][sy] = 0;
		v[0][3][sx][sy] = 0;
		q.add(new Point(sx, sy, -1, 0, 0));
		solve();
//		print();
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	private static void print() {
		for (int index = 0; index < 4; index++) {
			for (int d = 0; d < 4; d++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						System.out.print(v[index][d][i][j] + " ");
					}
					System.out.println();
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void solve() {
		while (!q.isEmpty()) {
			Point p = q.poll();
			if (p.x == ex1 && p.y == ey1 && (p.index & 1) == 0) {
				p.index += 1;
			} else if (p.x == ex2 && p.y == ey2 && (p.index & 2) == 0) {
				p.index += 2;
			}
			if (p.index == 3) {
				min = Integer.min(p.depth, min);
				continue;
			}

			for (int d = 0; d < 4; d++) {
				if (d == p.d)
					continue;
				int ix = p.x + dx[d];
				int jy = p.y + dy[d];
				int index = p.index;
				if (!safe(ix, jy) || map[ix][jy] == -1)
					continue;
//				if (ix == ex1 && jy == ey1) {
//					if ((index & 1) == 0)
//						index += 1;
//					else
//						continue;
//				} else if (ix == ex2 && jy == ey2) {
//					if ((index & 2) == 0)
//						index += 2;
//					else
//						continue;
//				}
				if (map[ix][jy] == 0 && v[index][d][ix][jy] > p.depth + 1) {
					v[index][d][ix][jy] = p.depth + 1;
					q.add(new Point(ix, jy, d, index, p.depth + 1));
				}
			}
		}
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < M)
			return true;
		return false;
	}

}