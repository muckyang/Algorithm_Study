package REMIND.COMPLETE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206_벽부수고이동하기 {
	static int N, M;
	static int map[][];
	static boolean v[][][];
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = {  1, 0, -1,0 };
	static Queue<Point> q;

	static int res;
	static boolean check;

	public static class Point {
		int x;
		int y;
		int boom;

		public Point(int x, int y, int boom) {
			this.x = x;
			this.y = y;
			this.boom = boom;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[2][N][M];
		q = new LinkedList<>();
		res = 1;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				int num = s.charAt(j) - 48;
				map[i][j] = num;
			}
		}
		v[0][0][0] = true;
		v[1][0][0] = true;

		q.add(new Point(0, 0, 0));

		bfs();
		if (check)
			System.out.println(res);
		else
			System.out.println(-1);
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				if (p.x == N-1 && p.y == M-1) {
					check = true;
					return;
				}
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (safe(ix, jy)) {
						if (p.boom == 0) {
							if (map[ix][jy] == 0 && !v[0][ix][jy]) {
								v[0][ix][jy] = true;
								q.add(new Point(ix, jy, 0));
							} else if (map[ix][jy] == 1 && !v[1][ix][jy]) {
								v[1][ix][jy] = true;
								q.add(new Point(ix, jy, 1));
							}
						} else if (map[ix][jy] == 0 && !v[1][ix][jy]) {
							v[1][ix][jy] = true;
							q.add(new Point(ix, jy, 1));
						}
					}
				}
			}
			res++;
		}
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < M)
			return true;
		return false;
	}
}
