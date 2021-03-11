package COUPANG_2020_하반기;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Solution4 {

	static LinkedList<Integer>[] list;
	static Queue<Integer> q;
	static HashSet<String> hs;
	static HashMap<String, Integer> hm;

	public static void main(String[] args) {
//		String depar = "SEOUL";
//		String hub = "DAEGU";
//		String dest = "YEOSU";
//
//		String[][] road = { { "ULSAN", "BUSAN" }, { "DAEJEON", "ULSAN" }, { "DAEJEON", "GWANGJU" },
//				{ "SEOUL", "DAEJEON" }, { "SEOUL", "ULSAN" }, { "DAEJEON", "DAEGU" }, { "GWANGJU", "BUSAN" },
//				{ "DAEGU", "GWANGJU" }, { "DAEGU", "BUSAN" }, { "ULSAN", "DAEGU" }, { "GWANGJU", "YEOSU" },
//				{ "BUSAN", "YEOSU" } };
		String[][] roads = {{"SEOUL","DAEJEON"},{"ULSAN","BUSAN"},{"DAEJEON","ULSAN"},{"DAEJEON","GWANGJU"},{"SEOUL","ULSAN"},{"DAEJEON","BUSAN"},{"GWANGJU","BUSAN"}};
	      String depar = "ULSAN";
	      String hub = "SEOUL";
	      String dest = "BUSAN";
		System.out.println(solution(depar, hub, dest, roads));
	}

	public static int solution(String depar, String hub, String dest, String[][] roads) {
		hs = new HashSet<>();
		hm = new HashMap<>();
		for (int i = 0; i < roads.length; i++) {
			hs.add(roads[i][0]);
			hs.add(roads[i][1]);
		}

		Iterator<String> it = hs.iterator();
		int c = 0;
		while (it.hasNext()) {
			hm.put(it.next(), c);
			c++;
		}
		list = new LinkedList[c];
		for (int i = 0; i < c; i++) {
			list[i] = new LinkedList<>();
		}
		for (int i = 0; i < roads.length; i++) {
			int from = hm.get(roads[i][0]);
			int to = hm.get(roads[i][1]);
			list[from].add(to);
		}
		q = new LinkedList<>();
		int hubcount = 0;
		int endcount = 0;
		q.add(hm.get(depar));
		hubcount = solve(hub,  hubcount);
		q.add(hm.get(hub));
		endcount = solve(dest,  endcount);
		return endcount * hubcount;
	}

	private static int solve(String end, int endcount) {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int k = q.poll();
				if (k == hm.get(end)) {
					endcount++;
					continue;
				}
				for (int d : list[k]) {
					q.add(d);
				}
			}
		}
		return endcount;
	}
}
