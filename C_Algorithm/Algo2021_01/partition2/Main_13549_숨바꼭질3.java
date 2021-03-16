package partition2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_13549_숨바꼭질3 {
	static int A, B, res;
	static int list[];
	static PriorityQueue<Point> pq;

	public static class Point implements Comparable<Point> {
		int num;
		int cnt;

		public Point(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;

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
		pq = new PriorityQueue<>();
		pq.add(new Point(A, 0));
		solve();
		System.out.println(res);
	}

	private static void solve() {
		while (!pq.isEmpty()) {
			int size = pq.size();
			for (int i = 0; i < size; i++) {
				Point p = pq.poll();
				if (p.num == B) {
					res = p.cnt;
					return;
				}
				if (p.num * 2 <= 100000 && list[p.num * 2] > p.cnt) {
					list[p.num * 2] = p.cnt;
					pq.add(new Point(p.num * 2, p.cnt));
				}
				if (p.num + 1 <= 100000 && list[p.num + 1] > p.cnt + 1) {
					list[p.num + 1] = p.cnt + 1;
					pq.add(new Point(p.num + 1, p.cnt + 1));
				}
				if (p.num - 1 >= 0 && list[p.num - 1] > p.cnt + 1) {
					list[p.num - 1] = p.cnt + 1;
					pq.add(new Point(p.num - 1, p.cnt + 1));
				}

			}
		}
	}
}
