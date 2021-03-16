package Algo12_Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
 
//0.5 지점에서 만나서 사라지는것을 먼저 처리하고 남은거 처리해보기 
public class Solution_5648_원자소멸시뮬레이션_Priority2_todo {
	static HashMap<Integer, Oneja> hm;
	static Queue<Oneja> q;
	static Iterator<Integer> it;
	static int dx[] = { 0, 0, -1, 1 }; // 상,하,좌,우            
	static int dy[] = { 1, -1, 0, 0 }; // 상,하,좌,우
	static int res;

	public static class Oneja {
		int x, y;
		int d, power, cnt;

		public Oneja(int x, int y, int d, int power) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.power = power;
			this.cnt = 1;

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			hm = new HashMap<>();
			q = new LinkedList<>();
			res = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) + 1000;
				int y = Integer.parseInt(st.nextToken()) + 1000;
				int d = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());
				Oneja oneja = new Oneja(x, y, d, power);
				hm.put(x + y * 2002, oneja);
				q.add(oneja);
			}
			solve();
			System.out.println("#" + t + " " + res);
		}
	}

	private static void solve() {
		while (!q.isEmpty()) {
			int size = q.size();
			HashMap<Integer, Oneja> hm2 = new HashMap<>();
			for (int i = 0; i < size; i++) {
				Oneja p = q.poll();
				if (hm.get(p.x + p.y * 2002) == null)
					continue;
				hm.remove(p.x + p.y * 2002);
				int jy = p.y + dy[p.d];
				int ix = p.x + dx[p.d];
				if (jy > 2001 || ix > 2001 || ix < 0 || jy < 0)
					continue;
				// 0.5처리
				if (hm.get(ix + jy * 2002) != null) {
					Oneja k = hm.get(ix + jy * 2002);
					if (p.d % 2 == 0) {
						if (k.d == p.d + 1) {
							res += (p.power + k.power);
							hm.remove(ix + jy * 2002);
							continue;
						}
					} else {
						if (k.d == p.d - 1) {
							res += (p.power + k.power);
							hm.remove(ix + jy * 2002);
							continue;
						}
					}
				}
				// 0.5 처리 끝

				if (hm2.get(ix + 2002 * jy) == null) {
					hm2.put(ix + jy * 2002, new Oneja(ix, jy, p.d, p.power));
				} else {
					Oneja t = hm2.get(ix + 2002 * jy);
					t.cnt++;
					t.power += p.power;
					hm2.put(ix + jy * 2002, t);
				}

			}
			for (Map.Entry<Integer, Oneja> list : hm2.entrySet()) {
				Oneja ja = list.getValue();
				if (ja.cnt > 1)
					res += ja.power;
				else
					q.add(ja);
			}
			hm = hm2;
			hm2 = new HashMap<>();

		}
	}

}
