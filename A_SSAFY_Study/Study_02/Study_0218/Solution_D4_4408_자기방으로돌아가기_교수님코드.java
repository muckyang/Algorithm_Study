package Study_0218;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution_D4_4408_자기방으로돌아가기_교수님코드 {

	static class Room implements Comparable<Room> {
		int sp;
		int ep;
		int dist;

		public Room(int sp, int ep) {
			super();
			this.sp = sp;
			this.ep = ep;
			if (this.sp > this.ep) {
				int temp = this.sp;
				this.sp = this.ep;
				this.ep = temp;
			}
			this.dist = Math.abs(sp - ep);
		}

		@Override
		public String toString() {
			return "[sp=" + sp + ", ep=" + ep + ", dist=" + dist + "]";
		}

		@Override
		public int compareTo(Room o) {
			return this.dist - o.dist;
		}
	}

	static int T;
	static int N;
	static PriorityQueue<Room> que;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			que = new PriorityQueue<Room>();
			for (int i = 0; i < N; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				que.add(new Room((x + 1) / 2, (y + 1) / 2));
			}

			int[] room = new int[201];
			while (!que.isEmpty()) {
				Room r = que.poll();
				for (int i = r.sp; i <= r.ep; i++) {
					room[i]++;
				}

			}
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < room.length; i++) {
				if (max < room[i])
					max = room[i];
			}

			System.out.println("#" + test_case + " " + max);
		}
	}
}
