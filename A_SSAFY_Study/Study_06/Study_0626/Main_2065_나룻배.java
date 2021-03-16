package Study_0626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2065_나룻배 {
	static int M, T, N;
	static Queue<People> lq;
	static Queue<People> rq;
	static Queue<People> boatq;
	static PriorityQueue<People> input;
	static int res[];
	static int time;
	static StringBuilder sb;

	public static class People implements Comparable<People> {
		int number;
		int intime;
		String side;

		public People(int number, int intime, String side) {
			this.number = number;
			this.intime = intime;
			this.side = side;
		}

		@Override
		public int compareTo(People o) {
			return this.intime - o.intime;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		res = new int[N];
		lq = new LinkedList<>();
		rq = new LinkedList<>();
		boatq = new LinkedList<>();
		input = new PriorityQueue<>();
		sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int intime = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			input.add(new People(i, intime, s));
		}
		while (!input.isEmpty()) {
			People p = input.poll();
			if (p.side.equals("left")) {
				lq.add(p);
			} else {
				rq.add(p);
			}
		}
		time = 0;
		solve();

		for (int i = 0; i < N; i++) {
			sb.append(res[i]).append("\n");
		}
		System.out.print(sb.toString());
	}

	private static void solve() {
		int count = 0;
		while (lq.size() + rq.size() > 0) {
			if (count % 2 == 0) {// 왼쪽 탑승 순서
				onBoat(rq, lq);
			} else {// 오른족 탑승순서
				onBoat(lq, rq);
			}
			time += T;
			while (!boatq.isEmpty()) {
				People p = boatq.poll();
				res[p.number] = time;
			}
			count++;
		}
	}

	private static void onBoat(Queue<People> destq, Queue<People> nowq) {
		for (int i = 0; i < M; i++) {
			if (!nowq.isEmpty() && nowq.peek().intime <= time) {// 정박장에 이미 대기중인 사람이 있을때
				boatq.add(nowq.poll());
			} else if (boatq.isEmpty()) {// 현재 0 명인데 타려면 시간이 남은경우
				if (nowq.isEmpty() || (!nowq.isEmpty() && !destq.isEmpty() && nowq.peek().intime > destq.peek().intime)) {
					time = Math.max(time, destq.peek().intime);
					return;
				} else if (!nowq.isEmpty()) {
					time = Math.max(time, nowq.peek().intime);
					boatq.add(nowq.poll());
				}else
					return;
			} else {
				return;
			}
		}
	}
}
