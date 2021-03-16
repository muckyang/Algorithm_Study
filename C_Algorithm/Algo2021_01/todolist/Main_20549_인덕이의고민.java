package todolist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_20549_인덕이의고민 {
	static int N;
	static int map[][];
	static TreeSet<Go> ts;
	static boolean[] v;
	static int[] list;
	static int K;
	static int sx, sy;
	static int ax[];
	static int ay[];
	static int arr[][];
	static int dy[] = { 2, 2, 1, 1, -1, -1, -2, -2, 1, -1, 1, -1, 0, 0, -1, 1 };
	static int dx[] = { 1, -1, 2, -2, 2, -2, 1, -1, 1, -1, -1, 1, 1, -1, 0, 0 };
	static PriorityQueue<Duck> pq;
	static int res;

	public static class Duck implements Comparable<Duck> {
		int y;
		int x;
		int overload;

		public Duck(int x, int y, int overload) {
			this.x = x;
			this.y = y;
			this.overload = overload;
		}

		@Override
		public int compareTo(Duck d) {
			return this.overload - d.overload;
		}
	}

	public static class Go implements Comparable<Go> {
		int index;
		int over;

		public Go(int index, int over) {
			this.index = index;
			this.over = over;
		}

		@Override
		public int compareTo(Go o) {
			return this.over - o.over;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++)
			Arrays.fill(map[i], Integer.MAX_VALUE);
		ts = new TreeSet<>();
		for (int i = 0; i < 3; i++) {
			ts.add(new Go(i, Integer.parseInt(st.nextToken())));
		}

		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		arr = new int[K + 1][K + 1];// K *K 인접행렬
		ax = new int[K];
		ay = new int[K];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			ax[i] = Integer.parseInt(st.nextToken());
			ay[i] = Integer.parseInt(st.nextToken());
		}
		// 입력 끝
		pq = new PriorityQueue<>();
		pq.add(new Duck(sx, sy, 0));
		map[sx][sy] = 0;
		solve(0);
		for (int i = 1; i < K; i++) {
			map = new int[N][N];
			for (int k = 0; k < N; k++)
				Arrays.fill(map[k], Integer.MAX_VALUE);
			pq = new PriorityQueue<>();
			pq.add(new Duck(ax[i - 1], ay[i - 1], 0));
			map[ax[i - 1]][ay[i - 1]] = 0;

			solve(i);
		}
		print();
		v = new boolean[K];
		list = new int[K];
		res = Integer.MAX_VALUE;
		solveMin(0);
		System.out.println(res);

	}

	private static void solveMin(int cnt) {
		if (cnt == K) {
			int sum = arr[0][list[0]];
			System.out.print(list[0] + " ");
			for (int i = 0; i < K - 1; i++) {
				System.out.print(list[i + 1] + " ");
				sum += arr[list[i]][list[i + 1]];
			}
			System.out.println();
			res = Math.min(res, sum);
		}
		for (int i = 0; i < K; i++) {
			if (!v[i]) {
				list[cnt] = i + 1;
				v[i] = true;
				solveMin(cnt + 1);
				v[i] = false;
			}
		}
	}

	private static void print() {
		for (int i = 0; i <= K; i++) {
			for (int j = 0; j <= K; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}

	private static void solve(int num) {
		int cnt = 0;
		while (!pq.isEmpty() && cnt < K - num) {
			Duck p = pq.poll();
			System.out.println(p.x + " " + p.y);
			for (int i = num; i < K; i++) {
				if (ax[i] == p.x && ay[i] == p.y && arr[num][i + 1] == 0) {
					arr[i + 1][num] = arr[num][i + 1] = p.overload;
					cnt++;
				}
			}

			for (Go g : ts) {
				int sumover = p.overload + g.over;
				if (g.index == 0) {// 나이트
					for (int d = 0; d < 8; d++) {
						int jy = p.y + dy[d];
						int ix = p.x + dx[d];
						if (safe(jy, ix) && map[jy][ix] > sumover) {
							map[jy][ix] = sumover;
							System.out.println("낱 in");
							pq.add(new Duck(ix, jy, sumover));
						}
					}
				} else if (g.index == 1) {// 비숍
					for (int d = 8; d < 12; d++) {
						int jy = p.y + dy[d];
						int ix = p.x + dx[d];
						while (safe(jy, ix)) {
							if (map[jy][ix] > sumover) {
								map[jy][ix] = sumover;
								System.out.println("숍 in");
								pq.add(new Duck(ix, jy, sumover));
							}
							jy += dy[d];
							ix += dx[d];
						}

					}
				} else {// 룩
					for (int d = 12; d < 16; d++) {
						int jy = p.y + dy[d];
						int ix = p.x + dx[d];
						while (safe(jy, ix)) {
							if (map[jy][ix] > sumover) {
								map[jy][ix] = sumover;
								System.out.println("룩 in");
								pq.add(new Duck(ix, jy, sumover));
							}
							jy += dy[d];
							ix += dx[d];
						}
					}
				}
			}
		}
	}

	private static boolean safe(int y, int x) {
		if (y >= 0 && x >= 0 && y < N && x < N)
			return true;
		return false;
	}
}
