package Month02_Week03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_12851_숨바꼭질2 {
	static int N, K;
	static int minc, cnt, depth;
	static Queue<Integer> que;
	static boolean visited[];

	public static void bfs() {
		while (!que.isEmpty()) {
			int k = que.size();
			for (int i = 0; i < k; i++) {
				int p = que.poll();
				visited[p] = true;

				if (N == p && minc >= depth) {
					minc = depth;
					cnt++;
				}
				if (minc < depth)
					return;

				if (p % 2 == 0 && N < p && !visited[p / 2]) {
					que.add(p / 2);
				}
				if (p + 1 <= 100000 && !visited[p + 1]) {
					que.add(p + 1);
				}
				if (p - 1 >= 0 && !visited[p - 1]) {
					que.add(p - 1);
				}
			}
			depth++;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		que = new LinkedList<Integer>();
		visited = new boolean[100001];
		N = sc.nextInt();
		K = sc.nextInt();
		minc = Integer.MAX_VALUE;
		que.add(K);
		cnt = depth = 0;
		bfs();
		System.out.println(minc);
		System.out.println(cnt);
	}
}
