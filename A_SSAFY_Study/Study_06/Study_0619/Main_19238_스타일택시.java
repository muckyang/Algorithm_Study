package Study_0619;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_19238_스타일택시 {
	static int N, M, G;
	static int map[][];
	static int people[][];
	static boolean v[][];
//	static boolean use
	static int sx, sy;
	static PriorityQueue<Point> pq;
	static List<Point> peol;
	static List<Point> endl;
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, -1, 0, 1 };

	static class Point implements Comparable<Point> {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		peol = new LinkedList<>();
		endl = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken()) - 1;
		sy = Integer.parseInt(st.nextToken()) - 1;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int peox = Integer.parseInt(st.nextToken()) - 1;
			int peoy = Integer.parseInt(st.nextToken()) - 1;
			peol.add(new Point(peox, peoy));
			int endx = Integer.parseInt(st.nextToken()) - 1;
			int endy = Integer.parseInt(st.nextToken()) - 1;
			endl.add(new Point(endx, endy));
		}
//		System.out.println(sx + "," + sy);
//		for (int i = 0; i < M; i++) {
//			System.out.println("사람위치 : " + peol.get(i).x + " ," + peol.get(i).y);
//			System.out.println("도착위치 : " + endl.get(i).x + " ," + endl.get(i).y);
//		}
		solve();
	}

	private static void solve() {
		// TODO Auto-generated method stub
		
	}
}
