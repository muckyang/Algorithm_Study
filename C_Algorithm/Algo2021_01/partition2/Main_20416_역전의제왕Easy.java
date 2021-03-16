package partition2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_20416_역전의제왕Easy {
	static int N, K;
	static Participant part[];
	static PriorityQueue<Solution> pq[];
	static int res;

	public static class Solution implements Comparable<Solution> {
		int index;
		int proNumber;
		int time;
		int cnt;

		public Solution(int index, int proNumber, int time, int cnt) {
			this.index = index;
			this.proNumber = proNumber;
			this.time = time;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Solution o) {
			return this.proNumber - o.proNumber;
		}
	}

	public static class Participant implements Comparable<Participant> {
		int index;
		int solution;
		int panalty;
		int lasttime;
		int point;

		public Participant(int index, int solution, int panalty, int lasttime, int point) {
			this.index = index;
			this.solution = solution;
			this.panalty = panalty;
			this.lasttime = lasttime;
			this.point = point;
		}


		@Override
		public int compareTo(Participant p) {
			if (this.solution == p.solution) {
				if (this.panalty == p.panalty) {
					return this.lasttime - p.lasttime;
				} else
					return this.panalty - p.panalty;
			} else
				return p.solution - this.solution;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		part = new Participant[N];
		pq = new PriorityQueue[N];
		res = 0;
		for (int i = 0; i < N; i++) {
			part[i] = new Participant(i, 0, 0, 0, 0);
			pq[i] = new PriorityQueue<>();
		}
		int freezeCnt = 0;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int time = stringToMin(st.nextToken());
			int partId = Integer.parseInt(st.nextToken()) - 1;
			int probNum = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());

			if (time > 18000) {// 프리징
				freezeCnt++;
				pq[partId].add(new Solution(partId, probNum, time, cnt));
			} else {// 그 전까지
				part[partId].solution++;
				part[partId].panalty += time + (cnt - 1) * 20;
				part[partId].lasttime = time;
			}

		}
		///입력 끝
		Arrays.sort(part); // 프리징 전 까지의 순위
		while (freezeCnt != 0) {
			int sp = N - 1; // 끝 등수부터 체크
			while (true) {
				if (sp == 0)
					break;
				if (pq[part[sp].index].isEmpty()) { // 해당등수 프리징시 푼 문제 없다면?
					sp--;// 다음등수로 이동
					continue;
				}
				Solution p = pq[part[sp].index].poll();
				System.out.println("probNum : " + p.proNumber);
				part[sp].solution++;
				part[sp].panalty += p.time + (p.cnt - 1) * 20;
				part[sp].lasttime = Math.max(p.time, part[sp].lasttime);
				break;
			}
			int now = 0;
			for (Participant p : part) {
				if (part[sp].index == p.index) {
					p.point += sp - now;
					break;
				}
				now++;
			}
			for (Participant p : part) {
				System.out.println(p.toString());
			}
			System.out.println();
			freezeCnt--;
		}
		int maxPoint = 0;
		for (Participant p : part) {
			if (maxPoint < p.point) {
				maxPoint = p.point;
				res = p.index + 1;
			}
		}
		if (res == 0)
			System.out.println(part[0].index + 1);
		else
			System.out.println(res);
	}

	private static int stringToMin(String str) {
		String sarr[] = new String[2];
		sarr = str.split(":");
		return Integer.parseInt(sarr[0]) * 60 + Integer.parseInt(sarr[1]);
	}
}
