package Pass_Feb_Week03;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution_D4_6855_신도시전기연결하기 {
	static int T, N, K;
	static int[] home;

	private static class Home implements Comparable<Home> {
		int dist;

		public Home(int dist) {
			this.dist = dist;
		}

		@Override
		public int compareTo(Home o) {
			return this.dist - o.dist;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			PriorityQueue<Home> que = new PriorityQueue<>();
			N = sc.nextInt();
			K = sc.nextInt();
			home = new int[N];
			for (int i = 0; i < N; i++) {
				home[i] = sc.nextInt();
				if (i > 0)
					que.add(new Home(home[i] - home[i - 1]));
			}
			int res = 0;
			for(int i = 0 ; i < N - K ; i++) {
				res += que.poll().dist;
			}
			System.out.println("#" + test_case + " " + res);
		}
	}
}
