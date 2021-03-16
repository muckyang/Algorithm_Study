import java.util.Iterator;
import java.util.TreeMap;

public class Line4 {
	static TreeMap<String, Integer> hm;

	public static void main(String[] args) {
		String[][] snapshots = { { "ACCOUNT1", "100" }, { "ACCOUNT2", "150" } };
		String[][] transactions = { { "1", "SAVE", "ACCOUNT2", "100" }, { "2", "WITHDRAW", "ACCOUNT1", "50" },
				{ "1", "SAVE", "ACCOUNT2", "100" }, { "4", "SAVE", "ACCOUNT3", "500" },
				{ "3", "WITHDRAW", "ACCOUNT2", "30" } };

		boolean[] v = new boolean[100001];
		hm = new TreeMap<>();

		for (int i = 0; i < snapshots.length; i++) {
			hm.put(snapshots[i][0], Integer.parseInt(snapshots[i][1]));
		}

		for (int i = 0; i < transactions.length; i++) {
			if (!v[Integer.parseInt(transactions[i][0])]) {
				v[Integer.parseInt(transactions[i][0])] = true;
				if (transactions[i][1].equals("SAVE")) {
					if (!hm.containsKey(transactions[i][2]))
						hm.put(transactions[i][2], Integer.parseInt(transactions[i][3]));
					else
						hm.put(transactions[i][2], hm.get(transactions[i][2]) + Integer.parseInt(transactions[i][3]));
				} else {
					if (!hm.containsKey(transactions[i][2]))
						hm.put(transactions[i][2], Integer.parseInt(transactions[i][3]));
					else
						hm.put(transactions[i][2], hm.get(transactions[i][2]) - Integer.parseInt(transactions[i][3]));
				}
			}
		}
		String[][] answer = new String[hm.size()][2];
		Iterator<String> it = hm.keySet().iterator();
		int idx = 0;
		while (it.hasNext()) {
			int cur = idx++;
			answer[cur][0] = it.next();
			answer[cur][1] = String.valueOf(hm.get(answer[cur][0]));
		}
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i][0] + " " + answer[i][1]);
		}
	}

}
