package Platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_10273_고대동굴탐사 {
	static int T, N, E;
	static List<Cave> list[];
	static int caveV[];
	static int total[];

	static Queue<Cave> q;
	static int max;
	static Cave res;

	public static class Cave {
		int x;
		int y;
		int pay;
		int nowp;
		Cave prev;

		public Cave(int x, int y, int pay, int nowp) {
			this.x = x;
			this.y = y;
			this.pay = pay;
			this.nowp = nowp;
			this.prev = null;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		q = new LinkedList<>();
		T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			caveV = new int[N];
			total = new int[N];
			Arrays.fill(total, Integer.MIN_VALUE);
			total[0] = caveV[0];
			list = new LinkedList[N];
			for (int i = 0; i < N; i++) {
				list[i] = new LinkedList<>();
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken());
				list[a].add(new Cave(a, b, c, total[a]));
			}

			for (Cave c : list[0]) {
				q.add(c);
			}
			res = null;
			max = Integer.MIN_VALUE;
			bfs();
			int index = res.x;
//			for (int i = 0; i < N; i++) {
//				if (max < total[i]) {
//					max = total[i];
//					index = i;
//				}
//			}
			Stack<Cave> calist = new Stack<>();
			while (true) {
				if (res.prev == null)
					break;
				Cave k = res;
				calist.add(k.prev);
				res = k;
			}
			for (Cave i : calist) {
				System.out.print((i.x + 1) + " ");
			}
			System.out.println(index);
		}

	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Cave p = q.poll();
				if (p.nowp > max) {
					max = p.nowp;
					res = p;
				}
				int now = Integer.MIN_VALUE;
				if (p.nowp == Integer.MIN_VALUE)
					now = 0;
				int nextPayT = caveV[p.y] + now - p.pay;
				if (nextPayT > total[p.y]) {
					total[p.y] = nextPayT;
					for (Cave c : list[p.y]) {
						c.nowp = nextPayT;
						c.prev = p;
						q.add(c);
					}
				}
			}

		}
	}
}
