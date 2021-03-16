package partition1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
/// 250300KB , 1112ms 
public class Main_03197_백조의호수 {
	static int N, M;
	static int sy, sx, ex, ey;
	static boolean v[][];
	static int wall[][];
	static PriorityQueue<Swan> pq;
	static Queue<Swan> q;

	static int dy[] = { 0, 1, 0, -1 };
	static int dx[] = { 1, 0, -1, 0 };

	public static class Swan implements Comparable<Swan> {
		int y, x;
		int wallMax;

		public Swan(int y, int x, int wallMax) {
			this.y = y;
			this.x = x;
			this.wallMax = wallMax;
		}

		public int compareTo(Swan o) {
			return this.wallMax - o.wallMax;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		v = new boolean[N][M];
		wall = new int[N][M];

		boolean se = false;
		q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = s.charAt(j);
				if (c == '.') {
					q.add(new Swan(i, j, 0));
					v[i][j] = true;
				} else if (c == 'X') {// 벽
				} else {
					q.add(new Swan(i, j, 0));
					v[i][j] = true;
					if (se) {
						ey = i;
						ex = j;
					} else {
						se = true;
						sy = i;
						sx = j;
					}
				}
			}
		}

		solveWall();
		pq = new PriorityQueue<>();
		v = new boolean[N][M];
		pq.add(new Swan(sy, sx, 0));
		bfs();
	}


	private static void solveWall() {
		int cnt = 0;
		while (!q.isEmpty()) {
			cnt++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Swan p = q.poll();
				for (int d = 0; d < 4; d++) {
					int jy = p.y + dy[d];
					int ix = p.x + dx[d];
					if (!safe(jy, ix) || v[jy][ix])
						continue;
					v[jy][ix] = true;
					wall[jy][ix] = cnt;
					q.add(new Swan(jy, ix, 0));
				}
			}
		}
	}

	private static void bfs() {
		while (!pq.isEmpty()) {
			Swan p = pq.poll();
			if(v[p.y][p.x])
				continue;
			if (p.y == ey && p.x == ex) {
				System.out.println(p.wallMax);
				return;
			}
			v[p.y][p.x] = true;
			for (int d = 0; d < 4; d++) {
				int jy = p.y + dy[d];
				int ix = p.x + dx[d];
				if (!safe(jy, ix) || v[jy][ix])
					continue;
				pq.add(new Swan(jy, ix, Math.max(p.wallMax, wall[jy][ix])));

			}
		}

	}

	private static boolean safe(int jy, int ix) {
		if (jy >= 0 && ix >= 0 && jy < N && ix < M)
			return true;
		return false;
	}
}
