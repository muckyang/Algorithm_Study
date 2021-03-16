import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution02 {
	static PriorityQueue<Student> pq;

	static class Student implements Comparable<Student> {
		String addr;
		String lang;
		int score;

		public Student(String addr, String lang, int score) {
			this.addr = addr;
			this.lang = lang;
			this.score = score;
		}

		@Override
		public int compareTo(Student o) {
			if (this.addr.compareTo(o.addr) > 0) {
				return 1;
			} else {
				return -1;
			}
		}
	}

	public static void main(String[] args) {
		String[] ip_addrs = {"7.124.10.0", "7.124.10.0", "0.0.0.0", "7.124.10.0", "0.0.0.0", "7.124.10.0"};
		String[] langs = {"C++", "Java", "C#", "C#", "C", "Python3"};
		int[] scores = {314, 225, 45, 0, 155, 400};
//		String[] ip_address = { "5.5.5.5", "155.123.124.111", "10.16.125.0", "155.123.124.111", "5.5.5.5",
//				"155.123.124.111", "10.16.125.0", "10.16.125.0" };
//		String[] lang_list = { "Java", "C++", "Python3", "C#", "Java", "C", "Python3", "JavaScript" };
//		int[] score = { 314, 225, 45, 0, 155, 400 };
		pq = new PriorityQueue<>();

		for (int i = 0; i < scores.length; i++) {
			pq.add(new Student(ip_addrs[i], langs[i], scores[i]));
		}
		int res = scores.length;// 전체 참가자 - 부정행위 참가자
		LinkedList<Student> dupl = new LinkedList<>();
		while (!pq.isEmpty()) {
			Student st = pq.poll();
			dupl.add(st);
			if (pq.isEmpty() || pq.peek().addr != st.addr) { // 다르면!
				if (dupl.size() > 3) {
					res -= dupl.size();
				} else if (dupl.size() == 3) {
					String s = dupl.get(0).lang;
					boolean cc = false;
					if (s.charAt(0) == 'C')
						cc = true;
					boolean eq = true;
					for (int i = 1; i < 3; i++) {
						if (cc) {
							if (s.charAt(0) != dupl.get(i).lang.charAt(0)){
								eq = false;
							}
						} else {
							if (!s.equals(dupl.get(i).lang)) {
								eq = false;
							}
						}
					}
					if (eq) {
						res -= 3;
					}
				} else if (dupl.size() == 2) {
					String s = dupl.get(0).lang;
					int sco = dupl.get(0).score;
					boolean eq = true;
					if (!s.equals(dupl.get(1).lang) || sco != dupl.get(1).score) {
						eq = false;
					}
					if (eq) {
						res -= 2;
					}
				}
				dupl.clear();
			}
		}
		System.out.println(res);

	}
}
