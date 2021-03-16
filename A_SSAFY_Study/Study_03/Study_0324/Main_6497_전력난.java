package Study_0324;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_6497_전력난 {
	static int N, M;
	static int house[];
	static PriorityQueue<Point> pq;
	static int res, cnt;

	static class Point implements Comparable<Point> {
		int x;
		int y;
		int v;

		public Point(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.v = v;
		}

		@Override
		public int compareTo(Point o) {
			return this.v - o.v;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			res = 0;
			cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			pq = new PriorityQueue<>();
			house = new int[N];
			if (N == 0 && M == 0)
				break;
			for (int i = 0; i < N; i++) {
				house[i] = i;
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				res += value;// 전체 값 더함
				pq.add(new Point(start, end, value));
			}
			// 오름차순으로 정렬 완료
			int min = 0;
			while (!pq.isEmpty()) {
				if (N - 1 == cnt)
					break;
				Point p = pq.poll();
				
				int s = p.x;
				int e = p.y;
				
				if (house[s] == house[e])
					continue;
				else if (house[s] != house[e]) {
					min += p.v;
					cnt++;
					int hs = house[s];
					int k = house[e];
					for (int i = 0; i < N; i++) {
						if (house[i] == hs)
							house[i] = k;
					}
				}
			}
			System.out.println(res - min);

		}

	}
}
