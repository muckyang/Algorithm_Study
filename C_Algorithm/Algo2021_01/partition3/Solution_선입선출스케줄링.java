package partition3;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
/// 파라메트릭 서치? 
//https://programmers.co.kr/questions/12333
public class Solution_선입선출스케줄링 {
	
	
	public static void main(String[] args) {
		int n =5;
		int [] cores = {4540, 6383, 8674, 2699};// 작업시간
		/// 마지막 작업을 담당하는 코어 번호 리턴( n +1)
		System.out.println(solution(n, cores));
	}

	public static class Core implements Comparable<Core> {
		int index;
		long runingtime;

		public Core(int index, long runingtime) {
			super();
			this.index = index;
			this.runingtime = runingtime;
		}

		@Override
		public int compareTo(Core c) {
			if(this.runingtime - c.runingtime > 0)
				return 1;
			return -1;
		}

	}

	public static int solution(int n, int[] cores) {
		PriorityQueue<Core> pq = new PriorityQueue<>(); // 시간 담당
		LinkedList<Core> freeCore = new LinkedList<>();// 인덱스 담당
		Comparator<Core> c1 = new Comparator<Core>() {
			@Override
			public int compare(Core o1, Core o2) {
				return o1.index - o2.index;
			}
		};

		int cnt = 0;
		long time = 0;
		for (int i = 0; i < cores.length; i++) {
			freeCore.add(new Core(i, cores[i]));
			
		}
		for (Core k : freeCore) {
			pq.add(k);
			cnt ++;
			if (cnt == n)
				return k.index+ 1;
		}
		while(true) {
			freeCore = new LinkedList<>();
			time = pq.peek().runingtime;
			while (!pq.isEmpty() && time == pq.peek().runingtime){
				Core c = pq.poll();
				time = c.runingtime;
				freeCore.add(new Core(c.index, time));
			} 
			
			Collections.sort(freeCore, c1);
			for(Core c : freeCore) {
				pq.add(new Core(c.index, c.runingtime + cores[c.index]));
				cnt++;
				System.out.println(c.index);
				if (cnt == n) {
					return c.index + 1;
				}
			}
		} 
	}
}
