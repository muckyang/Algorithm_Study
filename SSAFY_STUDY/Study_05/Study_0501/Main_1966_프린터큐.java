package Study_0501;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_1966_프린터큐 {
	static int T, N, M;
	static List<Print> list;
	static Queue<Print> q;
	static int cnt; 
	public static class Print {
		int index;
		int weight;

		public Print(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int testcase = 0; testcase < T; testcase++) {
			N = sc.nextInt();
			M = sc.nextInt();
			cnt = 0 ;
			list = new LinkedList<>();
			q = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				int weight = sc.nextInt();
				Print p = new Print(i, weight);
				list.add(p);
				q.add(p);
			}
			solve();
			System.out.println(cnt);
		}
	}

	private static void solve() {
		while (true) {
			int max = 0;
			for (Print p : list) {
				if (max < p.weight)
					max = p.weight;
			}
			while(true) {
				Print p = q.poll();
				if(p.weight == max) {
					cnt++;
					list.get(p.index).weight = 0;
					if(p.index == M)
						return;
					break;
				}else {
					q.add(p);
				}
			}
		}
	}
}
