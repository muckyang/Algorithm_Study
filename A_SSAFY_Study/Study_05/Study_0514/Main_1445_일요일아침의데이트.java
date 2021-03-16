package Study_0514;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//시작과 꽃 위치는 쓰레기 , 쓰레기 인접이어도 상관없음
public class Main_1445_일요일아침의데이트 {
	static int N, M;
	static int map[][];
	static Garbage v[][];
	static boolean gar[][][];
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static Queue<Point> q;
	static int sx, sy, fx, fy;

	public static class Point {
		int x, y;
		int ginc, gc;

		public Point(int x, int y, int gc, int ginc) {
			this.x = x;
			this.y = y;
			this.gc = gc;
			this.ginc = ginc;
		}
	}

	public static class Garbage {
		int gc, ginc;

		public Garbage(int gc, int ginc) {
			this.gc = gc;
			this.ginc = ginc;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		q = new LinkedList<>();
		map = new int[N][M];
		v = new Garbage[N][M];
		gar = new boolean[2][N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = s.charAt(j);
				v[i][j] = new Garbage(Integer.MAX_VALUE, Integer.MAX_VALUE);
				if (c == 'S') {
					sx = i;
					sy = j;
				} else if (c == 'F') {
					fx = i;
					fy = j;
				} else if (c == 'g') {
					gar[0][i][j] = true;// 쓰레기 위치
					for (int d = 0; d < 4; d++) {
						int ix = i + dx[d];
						int jy = j + dy[d];
						if (!safe(ix, jy))
							continue;
						gar[1][ix][jy] = true;// 쓰레기 주변
					}
				}
			}
		}
		q.add(new Point(sx, sy, 0, 0));
		v[sx][sy].gc = 0;
		v[sx][sy].ginc = 0;
		solve();

		System.out.println(v[fx][fy].gc + " " + v[fx][fy].ginc);
	}

	private static void solve() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					int gc = p.gc;// 쓰레기 지난 수
					int ginc = p.ginc;// 쓰레기 인접 지난 수
					if (!safe(ix, jy))
						continue;
					
					if (ix == fx && jy == fy) {
						if (v[ix][jy].gc < gc)
							continue;
						if (v[ix][jy].gc == gc && v[ix][jy].ginc <= ginc)
							continue;
						v[ix][jy].gc = gc;
						v[ix][jy].ginc = ginc;
						continue;
					}
					
					if (gar[0][ix][jy])
						gc++;
					else if (gar[1][ix][jy])
						ginc++;
					if (v[ix][jy].gc < gc)
						continue;
					if (v[ix][jy].gc == gc && v[ix][jy].ginc <= ginc)
						continue;
					v[ix][jy].gc = gc;
					v[ix][jy].ginc = ginc;
					q.add(new Point(ix, jy, gc, ginc));

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