package Coupang_2020_하반기;

import java.time.DayOfWeek;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution2 {
	static int[] dayOfMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		int n = 2;
//		String[] customers = { "10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24",
//				"10/01 23:50:25 13", "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10" };
		String[] customers = { "02/28 23:59:00 03","03/01 00:00:00 02", "03/01 00:05:00 01" };
		
		System.out.println(solution(n, customers));
	}

	public static class Kiosk implements Comparable<Kiosk> {
		int index;
		int endtime;

		public Kiosk(int index, int endtime) {
			this.index = index;
			this.endtime = endtime;
		}

		@Override
		public int compareTo(Kiosk o) {
			if (o.endtime == this.endtime) {
				return this.index - o.index;
			}
			return this.endtime - o.endtime;
		}
	}

	public static int solution(int n, String[] customers) {
		int count[] = new int[customers.length];
		int[]customer = new int[customers.length];
		PriorityQueue<Kiosk> pq = new PriorityQueue<>();
		for (int i = 0; i < customers.length; i++) {
			StringTokenizer st = new StringTokenizer(customers[i]);

			String s1 = st.nextToken();
			String s2 = st.nextToken();
			String s3 = st.nextToken();
			st = new StringTokenizer(s1, "/");

			int day = 0;
			int month = Integer.parseInt(st.nextToken());
			for (int k = 1; k <= month - 1; k++) {
				day += dayOfMonth[k];
			}
			day += Integer.parseInt(st.nextToken());

			st = new StringTokenizer(s2, ":");

			int hour = Integer.parseInt(st.nextToken()) + day * 24;
			int min = Integer.parseInt(st.nextToken()) + hour * 60;
			int sec = Integer.parseInt(st.nextToken()) + min * 60;

			int use = 60 * Integer.parseInt(s3);
			customer[i] = sec + use;// 시작시간

		}
		for (int i = 0; i < n; i++) {
			pq.add(new Kiosk(i, i));
		}
		for (int i = 0; i < customers.length; i++) {
			Kiosk k = pq.poll();
			k.endtime = customer[i];
			count[k.index]++;
			pq.add(k);
		}
		int resc = 0 ;
		for(int i = 0 ; i <customer.length;i++) {
			resc = Math.max(resc, count[i]);
		}
		return resc;
	}
}
