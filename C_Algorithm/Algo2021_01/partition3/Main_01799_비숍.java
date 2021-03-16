package partition3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
//시간초과, 메모리 초과
public class Main_01799_비숍 {
	static int N;
	static int[][] map;
	static LinkedList<Point>[] ls;
	static boolean v[];
	static int[] dy = { 1, 1, -1, -1 };
	static int[] dx = { 1, -1, -1, 1 };
	static int cnt, res;

	public static class Point {
		int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cnt = 0;
		res = 0;
		map = new int[N][N];
		ls = new LinkedList[4 * N];
		for(int i = 0 ;i < 4*N;i++)
			ls[i] = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					cnt++;
					int k = (i - j) + N - 1;
					int k2 = ((N - i) - j) + (3 * N - 1);
					ls[k].add(new Point(i, j));
					ls[k2].add(new Point(i, j));
				}
			}
		}
		v = new boolean[4 * N];
		solve(0, 0);
		System.out.println(res);

	}

	private static void solve(int count, int index) {
		res = Math.max(res, count);
		for (int i = index; i < 4 * N; i++) {
			for (Point p : ls[i])
				if (!v[(p.y - p.x) + N - 1] && !v[((N - p.x) - p.y) + (3 * N - 1)]) {
					v[(p.y - p.x) + N - 1] = true;
					v[((N - p.x) - p.y) + 3 * N - 1] = true;
					solve(count + 1, i + 1);
					v[(p.y - p.x) + N - 1] = false;
					v[((N - p.x) - p.y) + 3 * N - 1] = false;
				}
		}
	}

}
