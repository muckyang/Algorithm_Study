package Line2021;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class pro2_3 {
	public static void main(String[] args) {
		String program = "bank";
		String[] flag_rules = {"-send STRING", "-a ALIAS -amount", "-amount NUMBERS"};
		String[] commands = { "bank -send abc -amount 500 200 -a 400", "bank -send abc -a hey" };
		solution(program, flag_rules, commands);
	}

	static HashMap<String, String> hm;

	public static boolean[] solution(String program, String[] flag_rules, String[] commands) {
		boolean[] answer = new boolean[commands.length];

		hm = new HashMap<String, String>();
		getFlag(flag_rules);

		for (int i = 0; i < commands.length; i++) {
			answer[i] = runCommand(program, commands[i]);
		}

		for (boolean b : answer) {
			System.out.println(b);

		}

		return answer;
	}

	public static boolean runCommand(String pro, String com) {
		StringTokenizer str = new StringTokenizer(com, "-");
		// 명령어
		if (!str.nextToken().equals(pro + " ")) {
			return false;
		}
		while (str.hasMoreTokens()) {
			String[] st = str.nextToken().split(" ");
			String key = st[0];

			if (!hm.containsKey(key)) {// 해당키 없을떄
				return false;
			}

			String Value = hm.get(key);

			if (Value.equals("NULL")) {
				continue;
			}

			if (st.length == 2) {
				if (Value.equals("NUMBER") || Value.equals("NUMBERS")) {
					if (!isNumber(st[1])) {
						return false;
					}

				} else if (Value.equals("STRING") || Value.equals("STRINGS")) {
					if (!isString(st[1])) {
						return false;
					}
				} else {
					return false;
				}
			} else {
				if (Value.equals("NUMBERS")) {
					for (int i = 1; i < st.length; i++) {
						if (!isNumbers(st[i])) {
							return false;
						}
					}
				} else if (Value.equals("STRINGS")) {
					for (int i = 1; i < st.length; i++) {
						if (!isStrings(st[i])) {
							return false;
						}
					}

				} else {
					return false;
				}

			}
		}
		return true;

	}

	public static boolean isNumbers(String numbers) {
		StringTokenizer st = new StringTokenizer(numbers);
		while (st.hasMoreTokens()) {
			String number = st.nextToken();
			if (!isNumber(number)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isStrings(String strings) {
		StringTokenizer st = new StringTokenizer(strings);
		while (st.hasMoreTokens()) {
			String string = st.nextToken();
			if (string.charAt(0) == '-')
				return true;
			if (!isString(string)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isNumber(String number) {
		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			if ('0' <= c && c <= '9') {
				continue;
			}
			return false;
		}
		return true;
	}

	public static boolean isString(String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
				continue;
			}
			return false;

		}
		return true;
	}

	public static void getFlag(String[] flag_rules) {

		PriorityQueue<Flag> pq = new PriorityQueue<>();
		for (int i = 0; i < flag_rules.length; i++) {
			StringTokenizer key_value = new StringTokenizer(flag_rules[i]);
			String key = key_value.nextToken().substring(1);
			String value = key_value.nextToken();
			String alias = "";
			if (value.equals("ALIAS")) {// ALIAS 일때
				alias = key_value.nextToken().substring(1);
			}
			pq.add(new Flag(key, value, alias));

		}

		while (!pq.isEmpty()) {
			Flag f = pq.poll();
			if (f.work.equals("ALIAS")) {
				String value = hm.get(f.alias);
				hm.put(f.idx,value);
				hm.remove(f.alias);
			} else {
				hm.put(f.idx, f.work);
			}
		}


	}

	public static class Flag implements Comparable<Flag> {
		String idx;
		String work;
		String alias;

		public Flag(String idx, String work, String alias) {
			super();
			this.idx = idx;
			this.work = work;
			this.alias = alias;
		}


		@Override
		public int compareTo(Flag o) {
			return this.work.compareTo(o.work) * -1;
		}

	}
}
