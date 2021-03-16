package Study_0304;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution_Unknown_2382_미생물격리 {
	static int T, N, M, K;// N *N 행렬 , M시간 , K개의 군집
	static int[][] mi;
	static int[][] temp ;
	static int[][] d;
	static int res;
	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, -1, 1 };/// 상하좌우 1,2,3,4
	static PriorityQueue<Micro> q;

	static class Micro implements Comparable<Micro> {
		int x;
		int y;
		int num;
		int dist;

		private Micro(int x, int y, int num, int dist) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.dist = dist;
		}

		@Override
		public int compareTo(Micro o) {
			return o.num - this.num;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			q = new PriorityQueue<Micro>();
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			mi = new int[N][N];
			for (int i = 0; i < K; i++) {// K개의 군집
				int x = sc.nextInt();
				int y = sc.nextInt();
				int num = sc.nextInt();
				int dist = sc.nextInt();
				mi[x][y] = num;
				q.add(new Micro(x, y, num, dist));
			}
			res = 0;
			bfs();
			res = count(temp);
			System.out.println("#" + tc + " " + res);
		}
	}

	private static void bfs() {
		while (M != 0) {
			M--;
			int size = q.size();
			temp = new int[N][N];
			d = new int[N][N];
			// 큐에서 미생물 빼면서 이동 & 감소 & 방향전환
			for (int i = 0; i < size; i++) {
				Micro m = q.poll();
				m = move(m);
				temp[m.x][m.y] += m.num;
				if (d[m.x][m.y] == 0)
					d[m.x][m.y] = m.dist;
			}
		
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (temp[i][j] != 0) {
						q.add(new Micro(i, j, temp[i][j], d[i][j]));
					}
				}
			}
		}
	}

	private static Micro move(Micro micro) {
		int ix = micro.x + dx[micro.dist];
		int jy = micro.y + dy[micro.dist];
		if (ix == 0 || jy == 0 || ix == N - 1 || jy == N - 1) {
			micro.num /= 2;
			if (micro.dist % 2 == 0)
				micro.dist--;
			else
				micro.dist++;
		}
		micro.x = ix;
		micro.y = jy;
		return micro;
	}

	private static int count(int[][] mat) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				count += mat[i][j];
			}
		}
		return count;
	}
}
