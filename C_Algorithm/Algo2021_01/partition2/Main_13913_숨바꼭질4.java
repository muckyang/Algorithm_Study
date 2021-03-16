package partition2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13913_숨바꼭질4 {
	static int A, B, time;
	static int list[];
	static Queue<Point> pq;
	static StringBuilder res;

	public static class Point implements Comparable<Point> {
		int num;
		int cnt;
		StringBuilder s;

		public Point(int num, int cnt, StringBuilder s) {
			this.num = num;
			this.cnt = cnt;
			this.s = s;
		}

		@Override
		public int compareTo(Point o) {
			return this.cnt - o.cnt;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		list = new int[100001];
		Arrays.fill(list, Integer.MAX_VALUE);
		pq = new LinkedList<>();
		pq.add(new Point(A, 0, new StringBuilder()));
		solve();
	}

	private static void solve() {
		while (!pq.isEmpty()) {
			int size = pq.size();
			for (int i = 0; i < size; i++) {
				Point p = pq.poll();
				p.s.append(p.num).append(" ");
				if (p.num == B) {
					System.out.println(p.cnt);
					System.out.println(p.s.toString());
					return;
				}
				if (p.num * 2 <= 100000 && list[p.num * 2] > p.cnt + 1) {
					list[p.num * 2] = p.cnt + 1;
					pq.add(new Point(p.num * 2, p.cnt + 1, p.s));
				}
				if (p.num + 1 <= 100000 && list[p.num + 1] > p.cnt + 1) {
					list[p.num + 1] = p.cnt + 1;
					pq.add(new Point(p.num + 1, p.cnt + 1, p.s));
				}
				if (p.num - 1 >= 0 && list[p.num - 1] > p.cnt + 1) {
					list[p.num - 1] = p.cnt + 1;
					pq.add(new Point(p.num - 1, p.cnt + 1, p.s));
				}

			}
		}
	}
}
