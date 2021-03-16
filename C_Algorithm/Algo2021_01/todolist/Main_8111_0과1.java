package todolist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_8111_0과1 {
	static String list[];
	static boolean v[];
	static PriorityQueue<Point> pq;
	static int T;

	public static class Point implements Comparable<Point> {
		int num;
		String str;

		public Point(int num, String str) {
			this.num = num;
			this.str = str;

		}

		public int compareTo(Point p) {
			return this.str.length() - p.str.length();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		list = new String[20000];
		for (int i = 1; i < 20000; i += 2) {
			pq = new PriorityQueue<>();
			v = new boolean[20000];
			v[1] = true;
			pq.add(new Point(1, "1"));
			list[i] = solve(i);
		}
		for (int t = 0; t < T; t++) {
			int K = Integer.parseInt(br.readLine());
			if (list[K] != null)
				sb.append(list[K]).append("\n");
			else
				sb.append("BRAK\n");
		}
		System.out.println(sb.toString());
	}

	private static String solve(int num) {
		while (!pq.isEmpty()) {
			Point p = pq.poll();
			if (p.str.length() > 100) {
				return "0";
			}
			if (p.num % num == 0) {
				return p.str;
			} else {
				int k = (p.num * 10 + 1) % num;
				if (!v[k]) {
					v[k] = true;
					pq.add(new Point(k, p.str + "1"));
				}
				int k2 = (p.num * 10) % num;
				if (!v[k2]) {
					v[k2] = true;
					pq.add(new Point(k2, p.str + "0"));
				}
			}
		}
		return "0";
	}
}
