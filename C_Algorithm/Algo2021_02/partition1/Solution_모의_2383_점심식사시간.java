package partition1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_모의_2383_점심식사시간 {
	static int T, N;
	static int map[][];
	static People parr[];
	static Stair sarr[];

	static PriorityQueue<People>[] pq;
	static PriorityQueue<People> spq;
	static int pcnt, scnt, res;

	public static class Stair {
		int y, x;
		int len;

		public Stair(int y, int x, int len) {
			this.y = y;
			this.x = x;
			this.len = len;
		}

	}

	public static class People implements Comparable<People> {
		int y, x;
		int stair, time;

		public People(int y, int x, int stair, int time) {
			super();
			this.y = y;
			this.x = x;
			this.stair = stair;
			this.time = time;
		}

		@Override
		public int compareTo(People p) {
			return this.time - p.time;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			pq = new PriorityQueue[2];
			for (int i = 0; i < 2; i++)
				pq[i] = new PriorityQueue<>();
			res = Integer.MAX_VALUE;
			scnt = pcnt = 0;
			parr = new People[10];
			sarr = new Stair[2];
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int now = Integer.parseInt(st.nextToken());
					if (now == 1) {
						parr[pcnt++] = new People(j, i, 0, 0);
					} else if (now > 1) {
						sarr[scnt++] = new Stair(j, i, now);
					}
				}
			}
			solve(0);
			System.out.println("#" + t + " " + res);
		}
	}

	private static void solve(int cnt) {
		if (cnt == pcnt) {
			for (int i = 0; i < pcnt; i++) {
				People p = parr[i];
				pq[p.stair].add(new People(p.y, p.x, p.stair,
						Math.abs(sarr[p.stair].y - p.y) + Math.abs(sarr[p.stair].x - p.x)));
			}
			int max = 0;
			for (int i = 0; i < 2; i++) {
				spq = new PriorityQueue<>();
				int mcnt = 0;
				int time = 0;
				while (!pq[i].isEmpty()) {
					People p = pq[i].poll();
					int dist = Math.abs(p.x - sarr[i].x) + Math.abs(p.y - sarr[i].y);
					if(dist > time )
						time = dist;
					p.time = time + sarr[i].len;
					if(!spq.isEmpty() && spq.peek().time < time) {
						System.out.println("asdf");
						spq.poll();
						mcnt--;
					}
					spq.add(p);
					mcnt++;
					if (mcnt == 3) {
						System.out.println("qweqw");
						People pull = spq.poll();
						time += pull.time - time;
						mcnt--;
					}
				}
				while (!spq.isEmpty()) {
					time = spq.poll().time;
				}
				System.out.println(time);
				max = Math.max(max, time);
			}
			System.out.println();
			res = Math.min(res, max);
			return;
		}
		for (int i = 0; i < 2; i++) {
			parr[cnt].stair = i;
			solve(cnt + 1);
		}
	}

}
