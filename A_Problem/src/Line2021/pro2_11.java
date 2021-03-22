package Line2021;

import java.util.HashMap;
import java.util.StringTokenizer;

public class pro2_11 {
	public static void main(String[] args) {
		String[] flag_rules = { "-s STRING", "-n NUMBER", "-e NULL" };
		String[] commands = {"line -s 123 -n HI", "line fun"};
		solution("line", flag_rules, commands);
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
		//실행문을 공백단위로 잘라냄
		StringTokenizer st = new StringTokenizer(com);
		
		
		if (!st.nextToken().equals(pro)) {
			return false;
		}

		while (st.hasMoreTokens()) {
			String key = st.nextToken();
			if(!hm.containsKey(key))//해당키 없을떄
				return false;
			
			String Value = hm.get(key);
			if (Value.equals("NULL")) {
				continue;
			}
			String command = st.nextToken();
			if (Value.equals("NUMBER")) {
				for (int i = 0; i < command.length(); i++) {
					if (!isNumber(command.charAt(i))) {
						return false;
					}
				}
			} else if (Value.equals("STRING")) {
				for (int i = 0; i < command.length(); i++) {
					if (!isString(command.charAt(i))) {
						return false;
					}
				}
			}

		}
		return true;
	}

	public static boolean isNumber(char c) {
		if ('0' <= c && c <= '9') {
			return true;
		}
		return false;
	}

	public static boolean isString(char c) {
		if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
			return true;
		}
		return false;
	}

	public static void getFlag(String[] flag_rules) {

		for (int i = 0; i < flag_rules.length; i++) {
			StringTokenizer st = new StringTokenizer(flag_rules[i]);
			while (st.hasMoreTokens()) {
				hm.put(st.nextToken(), st.nextToken());
			}
		}

	}
}
