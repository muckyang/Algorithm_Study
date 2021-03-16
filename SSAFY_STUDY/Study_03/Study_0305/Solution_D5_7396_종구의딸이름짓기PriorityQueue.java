package Study_0305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D5_7396_종구의딸이름짓기PriorityQueue {
	static int T, N, M;
	static char[][] matrix;
	static boolean[][] v;
	static int dx[] = { 1, 0 };
	static int dy[] = { 0, 1 };
	static Queue<Point> q;
	static String res;
	static StringBuilder sb;

	static class Point implements Comparable<Point> {
		int x;
		int y;
		char c;

		Point(int x, int y, char c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}

		@Override
		public int compareTo(Point o) {
			return this.c - o.c;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			q = new LinkedList<Point>();
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			matrix = new char[N][M];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				matrix[i] = s.toCharArray();
			}
			v = new boolean[N][M];
			sb = new StringBuilder();
			bfs();
			System.out.println("#" + tc + " " + sb.toString());
		}
	}

	private static void bfs() {
		q.add(new Point(0, 0, matrix[0][0]));
		while (!q.isEmpty()) {
			PriorityQueue<Point> pq = new PriorityQueue<Point>();
			int size = q.size();
			boolean check = false;
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				if (!check) {
					check = true;
					sb.append(p.c);
				}
				for (int d = 0; d < 2; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (ix >= N || jy >= M || v[ix][jy])
						continue;

					v[ix][jy] = true;
					pq.add(new Point(ix, jy, matrix[ix][jy]));
				}

			}

			char plus = '{';
			while (!pq.isEmpty()) {
				Point p = pq.poll();
				if (plus == '{') {
					plus = p.c;
					res += p.c;
					q.add(p);
				} else if (p.c == plus) {
					q.add(p);
				}
			}

		}

	}
}
