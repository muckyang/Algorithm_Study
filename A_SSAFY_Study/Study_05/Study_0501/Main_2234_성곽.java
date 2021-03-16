package Study_0501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2234_성곽 {
	static int N, M;
	static int wall[][];
	static int rnum[][];
	static List<Integer> roomsize;
	static boolean v[][];
	static int rsize;
	static int dx[] = { 0, -1, 0, 1 };
	static int dy[] = { -1, 0, 1, 0 };

	static Queue<Point> q;
	static int maxsize;
	static int res;

	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		wall = new int[N][M];
		v = new boolean[N][M];
		rnum = new int[N][M];
		roomsize = new LinkedList<Integer>();
		q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				wall[i][j] = num;
			}
		}
		maxsize = 0;
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!v[i][j]) {
					rnum[i][j] = cnt;
					rsize = 1;
					v[i][j] = true;
					q.add(new Point(i, j));
					bfs(cnt);
					if (maxsize < rsize)
						maxsize = rsize;
					roomsize.add(rsize);
					cnt++;
				}
			}
		}
		int dmax = maxsize;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int d = 0; d < 4; d++) {
					int ix = i + dx[d];
					int jy = j + dy[d];
					if (safe(ix, jy) && rnum[ix][jy] != rnum[i][j]) {
						int num = roomsize.get(rnum[i][j] - 1) + roomsize.get(rnum[ix][jy] - 1);
						if (num > dmax)
							dmax = num;
					}
				}
			}
		}
		System.out.println(cnt - 1);
		System.out.println(maxsize);
		System.out.println(dmax);
	}

	private static void bfs(int cnt) {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (safe(ix, jy) && !v[ix][jy] && (wall[p.x][p.y] & (1 << d)) == 0) {
						v[ix][jy] = true;
						rnum[ix][jy] = cnt;
						rsize++;
						q.add(new Point(ix, jy));
					}

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
