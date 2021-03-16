package partition2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_09019_DSLR {
	static Queue<Register> pq;
	static boolean v[];
	static int T, input, target;
	static String res;

	public static class Register {
		int num;
		String str;

		public Register(int num, String str) {
			this.num = num;
			this.str = str;
		}

	
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			input = Integer.parseInt(st.nextToken());
			target = Integer.parseInt(st.nextToken());
			v = new boolean[10000];
			pq = new LinkedList<>();
			pq.add(new Register(input, ""));
			v[input] =true;
			solve();
			sb.append(res).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void solve() {
		while (!pq.isEmpty()) {
			Register r = pq.poll();
			if (r.num == target) {
				res = r.str;
				return;
			}
			String snum = r.num + "";
			while (snum.length() != 4) {
				snum = "0" + snum;
			}
			int D = r.num * 2 % 10000;
			int S = r.num - 1;
			if (S < 0)
				S = 9999;
			int L = Integer.parseInt(snum.substring(1,4) + snum.charAt(0));
			int R = Integer.parseInt(snum.charAt(3) + snum.substring(0, 3));
			if (!v[D]) {
				v[D] = true;
				pq.add(new Register(D, r.str + "D"));
			}
			if (!v[S]) {
				v[S] = true;
				pq.add(new Register(S, r.str + "S"));
			}
			if (!v[L]) {
				v[L] = true;
				pq.add(new Register(L, r.str + "L"));
			}
			if (!v[R]) {
				v[R] = true;
				pq.add(new Register(R, r.str + "R"));
			}
		}

	}

}
