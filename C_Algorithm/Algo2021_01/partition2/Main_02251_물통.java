package partition2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_02251_물통 {
	static int A, B, C;
	static boolean v[][][];
	static TreeSet<Integer> ts;
	static Queue<Water> q;

	public static class Water {
		int a, b, c;

		public Water(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ts = new TreeSet<>();
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		v = new boolean[A + 1][B + 1][C + 1];
		q = new LinkedList<>();
		q.add(new Water(0, 0, C));
		v[0][0][C] = true;
		ts.add(C);
		solve();
		StringBuilder sb = new StringBuilder();
		for(Integer k : ts) {
			sb.append(k).append(" ");
		}
		sb.append("\n");
		System.out.println(sb.toString());
	}

	private static void solve() {
		while (!q.isEmpty()) {
			Water w = q.poll();
			if(w.a==0) {
				ts.add(w.c);
			}
			if (w.c != 0 && A != w.a) {// c->a
				int su = w.c - (A - w.a);
				if (su > 0 && !v[A][w.b][su]) {// w.c가 남을 경우
					v[A][w.b][su] = true;
					q.add(new Water(A, w.b, su));
				} else if (su <= 0 && !v[w.a + w.c][w.b][0]) {// 다 쓸 경우
					v[w.a + w.c][w.b][0] = true;
					q.add(new Water(w.a + w.c, w.b, 0));
				}
			}
			if (w.c != 0 && B != w.b) {// c->b
				int su = w.c - (B - w.b);
				if (su > 0 && !v[w.a][B][su]) {// w.c가 남을 경우
					v[w.a][B][su] = true;
					q.add(new Water(w.a, B, su));
				} else if (su <= 0 && !v[w.a][w.b + w.c][0]) {// 다 쓸 경우
					v[w.a][w.b + w.c][0] = true;
					q.add(new Water(w.a, w.b + w.c, 0));
				}
			}
			if (w.b != 0 && C != w.c) {// b->c
				int su = w.b - (C - w.c);
				if (su > 0 && !v[w.a][su][C]) {// w.c가 남을 경우
					v[w.a][su][C] = true;
					q.add(new Water(w.a, su, C));
				} else if (su <= 0 && !v[w.a][0][w.c + w.b]) {// 다 쓸 경우
					v[w.a][0][w.c + w.b] = true;
					q.add(new Water(w.a, 0, w.c + w.b));
				}
			}
			if (w.b != 0 && A != w.a) {// b->a
				int su = w.b - (A - w.a);
				if (su > 0 && !v[A][su][w.c]) {// w.c가 남을 경우
					v[A][su][w.c] = true;
					q.add(new Water(A, su, w.c));
				} else if (su <= 0 && !v[w.a + w.b][0][w.c]) {// 다 쓸 경우
					v[w.a + w.b][0][w.c] = true;
					q.add(new Water(w.a + w.b, 0, w.c));
				}
			}

			if (w.a != 0 && B != w.b) {// a->b
				int su = w.a - (B - w.b);
				if (su > 0 && !v[su][B][w.c]) {// w.c가 남을 경우
					v[su][B][w.c] = true;
					q.add(new Water(su, B, w.c));
				} else if (su <= 0 && !v[0][w.a + w.b][w.c]) {// 다 쓸 경우
					v[0][w.a + w.b][w.c] = true;
					q.add(new Water(0, w.a + w.b, w.c));
				}
			}

			if (w.a != 0 && C != w.c) {// a->c
				int su = w.a - (C - w.c);
				if (su > 0 && !v[su][w.b][C]) {// w.c가 남을 경우
					v[su][w.b][C] = true;
					q.add(new Water(su, w.b, C));
				} else if (su <= 0 && !v[0][w.b][w.a + w.c]) {// 다 쓸 경우
					v[0][w.b][w.a + w.c] = true;
					q.add(new Water(0, w.b, w.a + w.c));
				}
			}
		}
	}
}
