package Study_0316;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_11066_파일합치기 {
	static int T, N;
	static PriorityQueue<Su> pq;
	static class Su implements Comparable<Su>{
		int v;
		Su(int v ){
			this.v = v; 
		}
		@Override
		public int compareTo(Su o) {
			
			return this.v - o.v;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			N = sc.nextInt();
			pq = new PriorityQueue<Su>();
		
			for (int i = 0; i < N; i++) {
				pq.add(new Su(sc.nextInt()));
			}
			int res = 0;
			while (pq.size() != 1) {
				int x = pq.poll().v;
				int y = pq.poll().v;
				res += x + y;
				System.out.println(res);
				pq.add(new Su(x + y));
			}
			System.out.println(res);
		}

	}
}
