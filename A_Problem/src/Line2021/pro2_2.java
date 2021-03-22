package Line2021;

import java.util.HashMap;
import java.util.StringTokenizer;

public class pro2_2 {
	public static void main(String[] args) {
		String program = "trip";
		String[] flag_rules = { "-days NUMBERS", "-dest STRING" };
		String[] commands = { "trip -days 15 10 -dest Seoul Paris", "trip -days 10 -dest Seoul" };
		solution(program, flag_rules, commands);
	}

	static HashMap<String, String> hm;

	public static boolean[] solution(String program, String[] flag_rules, String[] commands) {
		boolean[] answer = new boolean[commands.length];

		hm = new HashMap<String, String>();
		//규칙 정립
		getFlag(flag_rules);

		
		//커맨드 실행
		for (int i = 0; i < commands.length; i++) {
			answer[i] = runCommand(program, commands[i]);
		}

		return answer;
	}

	public static boolean runCommand(String pro, String com) {
		//- 단위로 쪼개서 명령어 추출
		StringTokenizer str = new StringTokenizer(com, "-");
		
		//커맨드의 가정 첫번쨰오는 값이 프로그램 이름과 다른경우
		if (!str.nextToken().trim().equals(pro)) {
			return false;
		}
		
		//명령 내용 실행
		while (str.hasMoreTokens()) {
			//명령내용 구분
			String[] st = str.nextToken().split(" ");
			String key = st[0];

			// 해당 명령이 존재하지 않는경우 false
			if (!hm.containsKey(key)) {
				return false;
			}

			//명령어 타입 추출
			String Value = hm.get(key);

			
			//NULL 명령어의 경우 뒷 내용이 없으므로 계속 진행
			if (Value.equals("NULL")) {
				continue;
			}

			
			// 명령의 내용이 1개인 경우
			if (st.length == 2) {
				//숫자 명령어인 경우
				if (Value.equals("NUMBER") || Value.equals("NUMBERS")) {
					if (!isNumber(st[1])) {
						return false;
					}
					//문자 명령어인 경우
				} else if (Value.equals("STRING")|| Value.equals("STRINGS")) {
					if (!isString(st[1])) {
						return false;
					}
					//그 외
				} else {
					return false;
				}
				
				//명령어 길이가 2 이상인 경우
			} else {
				//숫자들
				if (Value.equals("NUMBERS")) {
					for (int i = 1; i < st.length; i++) {
						if (!isNumbers(st[i])) {
							return false;
						}
					}
					//문자들
				} else if (Value.equals("STRINGS")) {
					for (int i = 1; i < st.length; i++) {
						if (!isStrings(st[i])) {
							return false;
						}
					}
					//그 외 (단수형 명령 포함)
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

		for (int i = 0; i < flag_rules.length; i++) {
			StringTokenizer st = new StringTokenizer(flag_rules[i], "-");
			while (st.hasMoreTokens()) {
				StringTokenizer key_value = new StringTokenizer(st.nextToken());
				hm.put(key_value.nextToken(), key_value.nextToken());
			}
		}

	}
}
