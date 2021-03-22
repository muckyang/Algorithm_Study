package Line2021;

import java.util.PriorityQueue;

public class pro3 {

	public static void main(String[] args) {
		int[] enter = { 3, 2, 1 };
		int[] leave = { 2, 1, 3 };
		solution(enter, leave);
	}

//	static PriorityQueue<Student> pq;
//
//	public static class Student implements Comparable<Student> {
//		int idx;
//		int enter;
//		int leave;
//
//		public Student(int idx, int enter, int leave) {
//			super();
//			this.idx = idx;
//			this.enter = enter;
//			this.leave = leave;
//		}
//
//		@Override
//		public String toString() {
//			return "Student [idx=" + idx + ", enter=" + enter + ", leave=" + leave + "]";
//		}
//
//		@Override
//		public int compareTo(Student o) {
//			if (this.enter > o.enter) {
//				return 1;
//			} else if (this.enter < o.enter) {
//				return -1;
//			} else {
//				return this.leave - o.leave;
//			}
//		}
//
//	}

	public static int[] solution(int[] enter, int[] leave) {
		int len = enter.length;

		int[] answer = new int[len];

		for (int i = 1; i <= len; i++) {
			int cnt = 0;
			int in = enter[i];
			int out = leave[i];
			for (int j = 1; j <= len; j++) {
				if (i == j)
					continue;
				if (out > enter[j] && in < leave[j]) {
					cnt++;
				} else if (out <= enter[j] && in >= leave[j]) {
					cnt++;
				}
			}
			answer[i - 1] = cnt;
			System.out.println(cnt);
		}

		return answer;
	}

}
