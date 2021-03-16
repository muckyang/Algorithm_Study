package partition1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_20665_독서실거리두기 {
	static int T, N, P;
	static boolean use[];
	static PriorityQueue<Desk> pq;
	static PriorityQueue<People> ppq;
	static int res;

	public static class Desk implements Comparable<Desk> {
		int start;
		int end;

		public Desk(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		public int compareTo(Desk d) {
			if (this.start == d.start) {
				return (this.end - this.start) - (d.end - d.start);
			}
			return this.start - d.start;
		}

	}

	public static class People implements Comparable<People> {
		int index;
		int end;

		public People(int index, int end) {
			super();
			this.index = index;
			this.end = end;
		}

		public int compareTo(People p) {
			return this.end - p.end;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		pq = new PriorityQueue<>();
		ppq = new PriorityQueue<>();
		res = 60 * (21 - 9);// 전체 이용시간
		N = Integer.parseInt(st.nextToken());// 자리수
		T = Integer.parseInt(st.nextToken());// 이용인원수
		P = Integer.parseInt(st.nextToken());// 타겟
		use = new boolean[N + 1];
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int start = tToi(st.nextToken());
			int end = tToi(st.nextToken());
			pq.add(new Desk(start, end));
		} // 줄세우기 완료

		solve();
		System.out.println(res);
	}

	private static void solve() {
		int cnt = 0;// 사용중인 인원수
		int time = tToi("0900");
		while (time <= tToi("2100")) {
			while (!ppq.isEmpty() && ppq.peek().end == time) {
				People p = ppq.poll();
				use[p.index] = false;
				cnt--;
			}
			while (!pq.isEmpty() && pq.peek().start == time) {
				Desk d = pq.poll();
				if(d.end  == d.start)
					continue; 	
				int target = getTarget(cnt);
				use[target] = true;
				ppq.add(new People(target, d.end));
				if (P == target) {
					res -= (d.end - d.start);
				}
				cnt++;
				
			}
			
			
			time++;// 시간 증가
		}
	}

	private static int getTarget(int cnt) {
		if (cnt == 0)
			return 1;
		int max = 0;// 최대거리
		int target = 0;
		for (int i = 1; i <= N; i++) {
			if (!use[i]) {// 이용중이지 않을떄만 선택가능
				int dist = getDist(i);
				if (max < dist) {
					max = dist;
					target = i;
				}
			}
		}
		return target;
	}

	private static int getDist(int i) {
		int sp = i;
		int ep = i;
		int dist = 0;
		while (true) {
			dist++;
			if (sp > 1)
				sp--;
			if (ep < N)
				ep++;
			if (use[sp] || use[ep])
				break;
		}
		return dist;
	}

	public static int tToi(String s) {
		int hour = Integer.parseInt(s.substring(0, 2)) * 60;
		int min = Integer.parseInt(s.substring(2, 4));
		return min + hour;
	}
}
