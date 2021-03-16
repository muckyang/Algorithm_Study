package partition2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_01038_감소하는수 {
	static int N;
	static Queue<Long> q;
	static long res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		q = new LinkedList<>();
		for (int i = 0; i < 10; i++)
			q.add((long)i);
		res = -1;
		solve(N);
		System.out.println(res);
	}

	private static void solve(int num) {
		if (num <= 10) {
			res = N;
			return;
		}
		int cnt = 10;
		while (!q.isEmpty()) {
			long p = q.poll();
			if (p == 9876543210L)
				return;
			for (int k = 0; k < p % 10; k++) {
				long next = Long.parseLong(p + "" + k);
				q.add(next);
				if (cnt == N) {
					res = next;
					return;
				}
				cnt++;
			}
		}
	}
}
