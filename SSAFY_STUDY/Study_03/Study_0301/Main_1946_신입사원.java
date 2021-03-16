package Study_0301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//반례 https://dundung.tistory.com/69

public class Main_1946_신입사원 {
	static int T, N;
	static int[] as;
	static int[] bs;
	static PriorityQueue<Point> pq;

	private static class Point implements Comparable<Point> {
		int x;
		int y;
		@Override
		public int compareTo(Point o) {
			return this.x - o.x;
		}

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		T = Integer.parseInt(s);
		pq = new PriorityQueue<>();
		for (int test_case = 0; test_case < T; test_case++) {
			s = br.readLine();
			N = Integer.parseInt(s);
			as = new int[N];
			bs = new int[N];
			int amax = -1;
			int bmax = -1;

			int res = 0;
			for (int i = 0; i < N; i++) {
				s = br.readLine();
				StringTokenizer st = new StringTokenizer(s, " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				pq.add(new Point(a, b));
			}
			Point p = pq.poll();
			res++;
			
			int minb = p.y;
			while (!pq.isEmpty()) {
				p = pq.poll();
				if(minb > p.y) {
					minb=p.y;
					res++;
				}
			}

			System.out.println(res);

		}
	}
}
