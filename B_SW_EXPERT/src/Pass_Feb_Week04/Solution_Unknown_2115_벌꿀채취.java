package Pass_Feb_Week04;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class Solution_Unknown_2115_벌꿀채취 {
	static int T, N, M, C;
	static int[][] honey;
	static boolean[] choice;
	static int hm, res;
	static PriorityQueue<Honey> pq;

	private static class Honey implements Comparable<Honey> {
		int x;
		int y;
		int value;

		public Honey(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}

		@Override
		public int compareTo(Honey o) {
			// TODO Auto-generated method stub
			return o.value - this.value;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			pq = new PriorityQueue<>();
			honey = new int[N][N];
			res = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					honey[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j + M - 1 < N; j++) {
					int cnt = 0;
					hm = 0;
					int[] list = new int[M];
					for (int k = j; k < j + M; k++) {
						list[cnt++] = honey[i][k];
					}
					func(list);

					pq.add(new Honey(i, j, hm));
				}
			}
//			int k = pq.size();
//			while (!pq.isEmpty()) {
//				Honey l = pq.poll();
//
//				System.out.println("x : " + l.x + " y : " + l.y + "  value : " + l.value);
//			}
			Honey h = pq.poll();
			for (int i = 0; i < M; i++) {
				honey[h.x][h.y + i] = -1;
			}
			res += h.value;

			w: while (!pq.isEmpty()) {
				h = pq.poll();
				for (int i = 0; i < M; i++) {
					if (honey[h.x][h.y + i] == -1) {
						continue w;
					}
				}
				res += h.value;
				break;
			}

			System.out.println("#" + test_case + " " + res);
		}
	}

	private static void func(int[] list) {
		int sum = 0;
		int sums = 0;
		for (int i = 0; i < list.length; i++) {
			sum += list[i];
			sums += (int) Math.pow(list[i], 2);
		}
		if (sum <= C) {
			hm = sums;
		} else {
			choice = new boolean[list.length];
			combi(0, 0, list);
		}
		return;
	}

	private static void combi(int start, int cnt, int[] list) {
	
		if (cnt > 0) {
			int k = 0;
			int sum = 0;
			for (int i = 0; i < list.length; i++) {
				if (choice[i]) {
					sum += list[i];
					k += (int) Math.pow(list[i], 2);
				}
			}
			if (sum <= C && k > hm)
				hm = k;

		}
		if (cnt== list.length) {
			return;
		}
		for (int i = start; i < list.length; i++) {
			choice[i] = true;
			combi(i + 1, cnt + 1, list);
			choice[i] = false;
		}

	}
}
