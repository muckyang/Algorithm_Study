package Study_0708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_19238_스타트택시 {
	static int N, M, G, fx, fy;
	static int map[][];
	static boolean mapv[][];
	static boolean v[];
	static List<People> pl;
	static Queue<People> q;
	static PriorityQueue<Destination> pq;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static int res;
	static boolean check;

	public static class People {
		int x, y;
		int dist;// 사람으로부터 목적지 까지의 거리

		public People(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;

		}
	}

	public static class Destination implements Comparable<Destination> {
		int x, y;
		int dist;

		public Destination(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Destination o) {
			if (this.dist == o.dist) {
				if (this.x == o.x) {
					return this.y - o.y;
				}
				return this.x - o.x;
			}
			return this.dist - o.dist;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		check = true;
		st = new StringTokenizer(br.readLine());
		// 시작 지점 변수
		fx = Integer.parseInt(st.nextToken()) - 1;
		fy = Integer.parseInt(st.nextToken()) - 1;
		pl = new LinkedList<>();
		res = 0;
		v = new boolean[M];
		for (int i = 0; i < M; i++) {
			mapv = new boolean[N][N];
			q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken()) - 1;
			int sy = Integer.parseInt(st.nextToken()) - 1;
			map[sx][sy] = (i + 1) * -1;// 맵에 -n 이 승객위치
			int ex = Integer.parseInt(st.nextToken()) - 1;
			int ey = Integer.parseInt(st.nextToken()) - 1;
			q.add(new People(sx, sy, 0));
			mapv[sx][sy] = true;
			solve(ex, ey);
		}
		if (check) {
			pq = new PriorityQueue<>();
			pq.add(new Destination(fx, fy, 0));
			mapv = new boolean[N][N];
			mapv[fx][fy] = true;
			solve2();
			for (int i = 0; i < M; i++) {
				if (!v[i])// 방문하지않은곳이 하나라도 있다면
					res = -1;
			}
		}
		System.out.println(res);
	}

	private static void solve2() {
		while (!pq.isEmpty()) {
			int size = pq.size();
			for (int i = 0; i < size; i++) {
				Destination p = pq.poll();
				// 우선순위 승객 찾은경우
				int num = (map[p.x][p.y] * -1) - 1;
				if (map[p.x][p.y] < 0 && !v[num]) {
					People pa = pl.get(num);
					if (G < pa.dist + p.dist) {// 기름 부족시
						res = -1;
						return;
					} else {
						G = G - pa.dist - p.dist;
						G += pa.dist * 2;
						v[num] = true;
						mapv = new boolean[N][N];
						mapv[pa.x][pa.y] = true;
						pq.clear();
						pq.add(new Destination(pa.x, pa.y, 0));
						res = G;
						break;// while문으로 나감
					}
				} else {
					for (int d = 0; d < 4; d++) {
						int ix = p.x + dx[d];
						int jy = p.y + dy[d];
						if (!safe(ix, jy) || map[ix][jy] == 1 || mapv[ix][jy])
							continue;
						mapv[ix][jy] = true;
						pq.add(new Destination(ix, jy, p.dist + 1));
					}
				}
			}
		}

	}

	private static void solve(int ex, int ey) {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				People p = q.poll();
				if (p.x == ex && p.y == ey) {
					pl.add(p);
					return;
				}
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (!safe(ix, jy) || mapv[ix][jy] || map[ix][jy] == 1)
						continue;
					mapv[ix][jy] = true;
					q.add(new People(ix, jy, p.dist + 1));
				}
			}
		}
		check = false;
		res = -1;
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		return false;
	}
}