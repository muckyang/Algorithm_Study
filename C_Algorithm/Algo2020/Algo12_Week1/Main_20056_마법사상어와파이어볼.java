package Algo12_Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20056_마법사상어와파이어볼 {
	static int N, M, K;
	static int dy[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dx[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static Fire map[][];
	static int number[][];
	static int bal[][];
	static Queue<Fire> q;

	public static class Fire {
		int y, x, m, s, d;

		public Fire(int y, int x, int m, int s, int d) {
			this.y = y;
			this.x = x;
			this.m = m;
			this.s = s;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Fire [y=" + y + ", x=" + x + ", m=" + m + ", s=" + s + ", d=" + d + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); // K초 후 상태
		q = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			q.add(new Fire(y, x, m, s, d));
		}
		for (int i = 0; i < K; i++) {
			map = new Fire[N][N];
			number = new int[N][N];
			bal = new int[N][N];
			bfs();
			fireAddQueue();
		}
		int res = 0;
		while (!q.isEmpty()) {
			Fire pp = q.poll();
			res += pp.m;
		}
		System.out.println(res);
	}

	private static void fireAddQueue() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (number[i][j] == 0) {
					continue;
				} else if (number[i][j] == 1) {
					q.add(map[i][j]);
				} else if (number[i][j] > 1) {
					int m = map[i][j].m / 5;
					int s = map[i][j].s / number[i][j];
					if (m == 0)
						continue;
					for (int d = 0; d < 8; d += 2) {
						if (bal[i][j] == 2)
							q.add(new Fire(i, j, m, s, d + 1));
						else
							q.add(new Fire(i, j, m, s, d));
					}

				}
			}
		}
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Fire p = q.poll();
				int y = p.y + dy[p.d] * p.s;
				int x = p.x + dx[p.d] * p.s;
				y = abs(y);
				x = abs(x);
				if (number[y][x] == 0) {
					number[y][x]++;
					bal[y][x] = p.d % 2;
					map[y][x] = new Fire(y, x, p.m, p.s, p.d);
				} else {
					number[y][x]++;
					map[y][x].m += p.m;
					map[y][x].s += p.s;
					if (bal[y][x] < 2) {
						if (bal[y][x] == p.d % 2) {
							continue;
						} else {
							bal[y][x] = 2;
						}
					}
				}
			}
		}
	}

	private static int abs(int number) {
		if (number >= N) {
			number = number % N;
		} else if (number < 0) {
			number = (N - Math.abs(number) % N) % N;
		}
		return number;
	}

}
