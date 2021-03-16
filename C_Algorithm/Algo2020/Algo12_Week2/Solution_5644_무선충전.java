package Algo12_Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 {
	static int N, A;
	static int power[];
	static int sx1, sy1, sx2, sy2;
	static int battery[][][];
	static int go[][];
	static PriorityQueue<Battery> pq;
	static Queue<Battery> q;
	static int dy[] = { 0, 0, 1, 0, -1 };
	static int dx[] = { 0, -1, 0, 1, 0 };
	static int res;

	public static class Battery implements Comparable<Battery> {
		int index;
		int y, x;
		int depth;
		int value;

		public Battery(int index, int y, int x, int depth, int value) {
			this.index = index;
			this.y = y;
			this.x = x;
			this.depth = depth;
			this.value = value;

		}

		public int compareTo(Battery o) {
			return o.value - this.value;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			power = new int[A + 1];
			battery = new int[2][10][10];
			go = new int[2][N];
			sx1 = sy1 = 0;
			sx2 = sy2 = 9;
			pq = new PriorityQueue<>();
			q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				go[0][i] = Integer.parseInt(st.nextToken()) ;
				go[1][i] = Integer.parseInt(st2.nextToken()) ;
			}
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken()) - 1;
				int x = Integer.parseInt(st.nextToken()) - 1;
				int depth = Integer.parseInt(st.nextToken());
				int power1 = Integer.parseInt(st.nextToken());
				pq.add(new Battery(i + 1, y, x, depth, power1));
				power[i + 1] = power1;
			}
			while (!pq.isEmpty()) {
				Battery b = pq.poll();
				q.add(b);
				solve();
				q = new LinkedList<>();
			}
			res = 0;

			for (int i = 0; i <= N; i++) {
				if (battery[0][sy1][sx1] == battery[0][sy2][sx2]) {
					int max = Math.max(power[battery[1][sy1][sx1]], power[battery[1][sy2][sx2]]);;
					res += (power[battery[0][sy1][sx1]] + max);
				} else {
					res += (power[battery[0][sy1][sx1]] + power[battery[0][sy2][sx2]]);
				}
				if (N == i)
					break;
				sx1 += dx[go[0][i]];
				sy1 += dy[go[0][i]];
				sx2 += dx[go[1][i]];
				sy2 += dy[go[1][i]];
			}
			System.out.println("#" + t + " " + res);
		}
	}

	private static void solve() {
		boolean[][] v = new boolean[10][10];
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Battery p = q.poll();
				if (v[p.y][p.x])
					continue;
				if (battery[0][p.y][p.x] == 0) {
					battery[0][p.y][p.x] = p.index;
				} else if (battery[1][p.y][p.x] == 0) {
					battery[1][p.y][p.x] = p.index;
				}
				v[p.y][p.x] = true;
				if (p.depth > 0) {
					for (int d = 1; d <= 4; d++) {
						int jy = p.y + dy[d];
						int ix = p.x + dx[d];
						if (jy >= 10 || ix >= 10 || jy < 0 || ix < 0)
							continue;
						q.add(new Battery(p.index, jy, ix, p.depth - 1, p.value));
					}
				}
			}
		}
	}

}
