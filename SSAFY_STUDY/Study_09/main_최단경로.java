import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class main_최단경로 {
	static int N, M;
	static int start;
	static int price[];
	static PriorityQueue<Point> pq;
	static LinkedList<Point>[] l;

	public static class Point implements Comparable<Point> {
		int to;
		int weight;

		public Point(int to, int weight) {
			this.to = to;
			this.weight = weight;

		}

		@Override
		public int compareTo(Point o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken()) - 1;
		price = new int[N];
		l = new LinkedList[N];
		pq = new PriorityQueue<>();
		pq.add(new Point(start, 0));
		for (int i = 0; i < N; i++) {
			l[i] = new LinkedList<>();
			price[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			l[from].add(new Point(to, weight));

		}
		solve();
		for (int i = 0; i < N; i++) {
			if (i == start)
				sb.append(0).append("\n");
			else if (price[i] == Integer.MAX_VALUE)
				sb.append("INF").append("\n");
			else
				sb.append(price[i]).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void solve() {
		while (!pq.isEmpty()) {
			Point p = pq.poll();
//			for (int k2 = 0; k2 < l[p.to].size(); k2++) {
//				Point k = l[p.to].get(k2);
			for(Point k : l[p.to]) {
				int np = p.weight + k.weight;
				if (price[k.to] > np) {
					price[k.to] = np;
					pq.add(new Point(k.to, np));
				}
			}

		}
	}
}
