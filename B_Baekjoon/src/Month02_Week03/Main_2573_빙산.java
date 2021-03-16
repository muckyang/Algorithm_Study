package Month02_Week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2573_빙산 {
	static int N, M;
	static int[][] matrix;
	static int[][] calc;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static Queue<Point> que;
	static int cnt;

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		que = new LinkedList<Point>();
		matrix = new int[N][M];
		cnt = 0;
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 확인 ok
		while (true) {
			if (iceCount() == 0) {
				cnt = 0;
				break;
			}
			if (!isOne())
				break;

			calc = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (matrix[i][j] != 0) {
						int zeroCount = 0;
						for (int d = 0; d < 4; d++) {
							int ix = i + dx[d];
							int jy = j + dy[d];
							if (ix >= 0 && jy >= 0 && ix < N && jy < M && matrix[ix][jy] <= 0)
								zeroCount++;
						}
						calc[i][j] = zeroCount;
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					matrix[i][j] -= calc[i][j];
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}

	private static int iceCount() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(matrix[i][j] > 0)
					return 1;
			}
		}
		
		return 0;
	}

	private static boolean isOne() {
		boolean c = false;
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matrix[i][j] > 0 && !visited[i][j]) {
					visited[i][j] = true;
					if (c)
						return false;
					c = true;
					que.add(new Point(i, j));
					check();
				}
			}
		}
		return c;
	}

	private static void check() {
		while (!que.isEmpty()) {
			int qs = que.size();
			for (int k = 0; k < qs; k++) {
				Point p = que.poll();
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (ix >= 0 && jy >= 0 && ix < N && jy < M && matrix[ix][jy] > 0 && !visited[ix][jy]) {
						visited[ix][jy] = true;
						que.add(new Point(ix, jy));
					}

				}
			}
		}

	}
}
