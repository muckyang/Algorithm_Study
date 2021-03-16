package Study_1020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20058_마법사상어와파이어스톰 {
	static int N, Q;
	static int map[][];
	static int map2[][];
	static Queue<Ice> q;

	static int dy[] = { 0, 1, 0, -1 };
	static int dx[] = { 1, 0, -1, 0 };
	static int res;

	public static class Ice {
		int y, x, size;

		public Ice(int y, int x, int size) {
			this.y = y;
			this.x = x;
			this.size = size;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n;
		n = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		N = (int) Math.pow(2, n);

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int ice = Integer.parseInt(st.nextToken());
				map[i][j] = ice;
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			int size = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
			for (int sy = 0; sy < N; sy += size) {
				for (int sx = 0; sx < N; sx += size) {
					solve(sy, sx, size);
				}
			}
			map2 = new int[N][N];
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (map[y][x] > 0)
						map2[y][x] = melt(y, x);
				}
			}
			for (int k = 0; k < N; k++)
				System.arraycopy(map2[k], 0, map[k], 0, N);
		}

		q = new LinkedList<>();

		boolean[][] v = new boolean[N][N];
		int sum = 0;
		int maxsize = 0;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (map[y][x] > 0 && !v[y][x]) {
					q.add(new Ice(y, x, map[y][x]));
					v[y][x] = true;
					int nowsize = 1;
					while (!q.isEmpty()) {
						Ice e = q.poll();
						sum += map[e.y][e.x];
						for (int d = 0; d < 4; d++) {
							int jy = e.y + dy[d];
							int ix = e.x + dx[d];
							if (jy < 0 || ix < 0 || jy >= N || ix >= N || v[jy][ix] || map[jy][ix] == 0)
								continue;
							v[jy][ix] = true;
							nowsize++;
							q.add(new Ice(jy, ix, map[jy][ix]));
						}
					}
					maxsize = Math.max(nowsize, maxsize);
				}
			}
		}
		System.out.println(sum);
		System.out.println(maxsize);
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int melt(int y, int x) {
		int cnt = 0;
		for (int d = 0; d < 4; d++) {
			int jy = y + dy[d];
			int ix = x + dx[d];
			if (jy < 0 || ix < 0 || jy >= N || ix >= N || map[jy][ix] == 0)
				cnt++;
		}
		if (cnt >= 2)
			return map[y][x] - 1;
		else
			return map[y][x];
	}

	private static void solve(int y, int x, int size) {
		int temp[][] = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				temp[i][j] = map[size - 1 + y-j][x +i];
			}
		}
		for (int i = 0; i < size; i++) {
			System.arraycopy(temp[i], 0, map[y + i], x, size);
		}
	}
}
