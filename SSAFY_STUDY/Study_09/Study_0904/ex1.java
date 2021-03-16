package Study_0904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex1 {

	static int N;
	static int M;
	static int[][] map;
	static int[][] cmap;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static boolean[][] visited;
	static boolean[][] cvisited;
	static boolean[] v;
	static int[] select;
	static int min = Integer.MAX_VALUE;// 최대시간중에서 최소인 것
	static ArrayList<Point> Plist;
	static int psize = 0;
	static int dep;// 연구실 내 최대시간
	static Queue<Point> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];
		select = new int[M];
		Plist = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {// 벽
					map[i][j] = -1;
					visited[i][j] = true;
				}
				if (map[i][j] == 2) {// 바이러스 인 부분 List에 담기
					map[i][j] = 0;
					Plist.add(new Point(i, j));
				}
			}
		}
		psize = Plist.size();
		v = new boolean[psize];
//      print(map);
		v(0, 0);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	public static void v(int start, int cnt) {
		if (cnt == M) {
			// map복사
			cmap = new int[N][N];
			cvisited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				System.arraycopy(map[i], 0, cmap[i], 0, N);
				System.arraycopy(visited[i], 0, cvisited[i], 0, N);
			}
			// 바이러스 위치 큐에 담기
			que = new LinkedList<>();
			for (int i = 0; i < M; i++) {
				Point p = Plist.get(select[i]);
				cvisited[p.x][p.y] = true;
				cmap[p.x][p.y] = 2;
				que.offer(new Point(p.x, p.y));
			}
			bfs();
			return;
		}
		for (int i = start; i < psize; i++) {// 바이러스의 담긴 크기만큼만 돌기
			if (!v[i]) {// 바이러스가 있을 수 있는 자리
				select[cnt] = i;
				v[i] = true;
				v(i + 1, cnt + 1);
				v[i] = false;
			}
		}
	}

	private static void bfs() {
		// 퍼짐
		int dep = 0;// 시간
		while (!que.isEmpty()) {
			// que의 크기만큼 돌때마다
			int qsize = que.size();// que의 크기만큼
			boolean check = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (cmap[i][j] == 0) {
						check = true;
						i = N;
						break;
					}
				}
			}
			if (!check) {// 다 퍼져있으면 dep값을 time으로 줘서 나가기
				min = Math.min(min, dep);
				return;
			}
			for (int s = 0; s < qsize; s++) {// 한번씩 퍼지기
				// 바이러스가 퍼지기 전에 연구실이 다 퍼져있는지 확인
				// 다 퍼져있지 않으면 퍼뜨리기
				Point p = que.poll();
				for (int d = 0; d < 4; d++) {
					int ny = p.y + dy[d];
					int nx = p.x + dx[d];
					if (!safe(ny, nx) || cvisited[ny][nx])
						continue;
					if (cmap[ny][nx] == 0) {
						cvisited[ny][nx] = true;
						cmap[ny][nx] = 2;
						que.offer(new Point(ny, nx));
					}
					
				}
			}
			dep++;
		}
	}

	private static boolean safe(int y, int x) {
		if (y >= 0 && y < N && x >= 0 && x < N)
			return true;
		else
			return false;
	}

	static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Point [y=" + y + ", x=" + x + "]";
		}

	}

	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}
}