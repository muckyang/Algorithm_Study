package Algo12_Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_10580_전봇대 {

	static PriorityQueue<Point> pq;

	public static class Point implements Comparable<Point> {
		int stp;
		int enp;

		public Point(int stp, int enp) {
			this.stp = stp;
			this.enp = enp;
		}

		@Override
		public int compareTo(Point o) {
			return this.stp - o.stp;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			pq = new PriorityQueue<>();
			LinkedList<Point> list = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int sp = Integer.parseInt(st.nextToken());
				int ep = Integer.parseInt(st.nextToken());
				pq.add(new Point(sp, ep));

			}
			while (!pq.isEmpty()) {
				Point p = pq.poll();
				for (Point ls : list) {
					if (p.enp < ls.enp) {
						cnt++;
					}
				}
				list.add(p);
			}
			System.out.println("#" + t+" " + cnt);

		}
	}
}
