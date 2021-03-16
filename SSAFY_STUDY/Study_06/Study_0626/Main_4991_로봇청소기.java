package Study_0626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4991_로봇청소기 {
	static int W, H, K;
	static List<Point> list;
	static int link[][];
	static int map[][];
	static boolean v[][];
	static boolean vlist[];

	static Queue<Point> q;
	static int res;
	static int min;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

	public static class Point {
		int x, y, value;

		public Point(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if (W == 0 && H == 0) {
				break;
			}
			map = new int[H][W];
			v = new boolean[H][W];

			q = new LinkedList<>();

			list = new LinkedList<>();
			int count = 1;
			for (int i = 0; i < H; i++) {
				String s = br.readLine();
				for (int j = 0; j < W; j++) {
					char c = s.charAt(j);
					if (c == 'o') {
						list.add(new Point(i, j, 1));
						map[i][j] = 1;
					} else if (c == '*') {
						count++;
						list.add(new Point(i, j, count));
						map[i][j] = count;
					} else if (c == 'x') {
						map[i][j] = -1;
					}
				}
			}
			K = list.size();
			vlist = new boolean[K];
			link = new int[K][K];
			//각 청소할위치간의 거리 측정
			dist();
			
			
			// 최소거리 찾기
			min = Integer.MAX_VALUE;
			vlist[0] = true;
			solve(0, 0, 1);// 0번에서 시작, 총합 0, 체크갯수
			if(min == Integer.MAX_VALUE)
				min = -1;
			System.out.println(min);
		}
	}

	private static void dist() {
		for (int i = 0; i < K; i++) {
			v = new boolean[H][W];
			Point p = list.get(i);
			v[p.x][p.y] = true;
			q.add(p);
			int depth = 0;
			while (!q.isEmpty()) {
				int size = q.size();
				depth++;
				for (int s = 0; s < size; s++) {
					Point point = q.poll();
					for (int d = 0; d < 4; d++) {
						int ix = point.x + dx[d];
						int jy = point.y + dy[d];
						if (!safe(ix, jy) || v[ix][jy] || map[ix][jy] == -1)
							continue;
						v[ix][jy] = true;
						if (map[ix][jy] > 0) 
							link[p.value - 1][map[ix][jy] - 1] = depth;
						
						q.add(new Point(ix, jy, map[ix][jy]));
					}
				}
			}

		}
	}

	private static void solve(int now, int sum, int count) {
		if (count == K) {
			if (min > sum)
				min = sum;
			return;
		}
		for (int i = 0; i < K; i++) {
			if (i != now && link[i][now] == 0)
				return;
			if (!vlist[i]) {
				vlist[i] = true;
				solve(i, sum + link[i][now], count + 1);
				vlist[i] = false;
			}
		}

	}

	private static void printlink(int K) {
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < K; j++) {
				System.out.print(link[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < H && y < W)
			return true;
		return false;
	}
}
