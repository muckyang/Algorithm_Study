package partition1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Main_04358_생태학_Trie {
	static Trie root;
	static int cnt;
	static StringBuilder sb;

	public static class Trie {
		HashMap<Character, Trie> next;
		int count;

		public Trie() {
			next = new HashMap<>();
			this.count = 0;// 뿌리지정용
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String s = "";
		root = new Trie();
		root.count = -1;
		cnt = 0;
		while ((s = br.readLine()) != null) {
//		while ((s = br.readLine()).length() != 0) {
			solve(s, root);
			cnt++;
		}
		exp(root, new char[30], 0);
//		sb.append(target).append(" ").append(String.format("%.4f", ((double) hm.get(target) / (double) N) *100) ).append("\n");
		System.out.println(sb.toString());
		br.close();
	}

	private static void exp(Trie next, char[] cs, int d) {
		if (next.count > 0) {
			String ans = "";
			for (int i = 0; i < 30; i++) {
				if (cs[i] == '\u0000')
					break;
				ans += cs[i];
			}
			sb.append(ans).append(" ").append(String.format("%.4f", ((double) next.count / (double) cnt) * 100))
					.append("\n");
		}
		if (next.next.size() == 0)
			return;
		Iterator<Character> it = next.next.keySet().iterator();
		int idx = 0;
		char arr[] = new char[next.next.size()];
		while (it.hasNext()) {
			arr[idx++] = it.next();
		}
		Arrays.sort(arr);
		for (int i = 0; i < idx; i++) {
			cs[d] = arr[i];
			exp(next.next.get(arr[i]), cs, d + 1);
			cs[d] = '\u0000';
		}
	}

	public static void solve(String s, Trie t) {
		if (s.length() == 0) {
			t.count++;
			return;
		}
		char c = s.charAt(0);
		if (t.next.get(c) == null) {
			t.next.put(c, new Trie());
		}
		solve(s.substring(1, s.length()), t.next.get(c));

	}

}
