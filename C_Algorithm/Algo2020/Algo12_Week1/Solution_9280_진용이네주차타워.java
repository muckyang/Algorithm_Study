package Algo12_Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_9280_진용이네주차타워 {
	static int T, N, M;
	static int[] pay;
	static int[] wei;
	static int[] pindex;
	static Queue<Integer> q;
	static PriorityQueue<Parking> pq;

	public static class Parking implements Comparable<Parking> {
		int index;
		int pay;

		public Parking(int index, int pay) {
			this.index = index;
			this.pay = pay;

		}

		@Override
		public int compareTo(Parking o) {
			return this.index - o.index;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			int res = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			pay = new int[N];
			wei = new int[M];
			pindex = new int[M];
			q = new LinkedList<Integer>();
			pq = new PriorityQueue<>();
			for (int i = 0; i < N; i++) {
				pay[i] = Integer.parseInt(br.readLine());
				pq.add(new Parking(i, pay[i]));
			}
			for (int i = 0; i < M; i++)
				wei[i] = Integer.parseInt(br.readLine());
			for (int i = 0; i < M * 2; i++) {
				int car = Integer.parseInt(br.readLine());
				if (car > 0) {// 주차 하려고 함
					car -= 1;
					if (pq.isEmpty()) {// 주차 할 곳 없다면?
						q.add(car);
					} else {// 남은자리 있으면
						Parking parking = pq.poll();
						res += parking.pay * wei[car];
						pindex[car] = parking.index;
					}
				} else { // 차뻄
					car = Math.abs(car);
					car -= 1;
					pq.add(new Parking(pindex[car], pay[pindex[car]]));
					if (!q.isEmpty()) {
						int in = q.poll();
						Parking parking = pq.poll();
						res += parking.pay * wei[in];
						pindex[in] = parking.index;
					}
				}
			}
			System.out.println("#" + t + " " + res);
		}
	}
}
