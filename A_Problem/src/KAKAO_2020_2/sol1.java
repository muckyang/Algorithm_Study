package KAKAO_2020_2;

public class sol1 {
	public static void main(String[] args) {
//		String new_id = "...!@BaT#*..y.abcdefghijklm";// "bat.y.abcdefghi"
//		String new_id = "...";// "bat.y.abcdefghi"
		String new_id = "=.=";// "bat.y.abcdefghi"
		
		System.out.println(solution(new_id));
	}

	public static String solution(String new_id) {
		String answer = "";
		// 1
		new_id = new_id.toLowerCase();
		String temp = "";
		// 2,3
		for (int i = 0; i < new_id.length(); i++) {
			char c = new_id.charAt(i);
			if (c == '-' || c == '_' || c == '.' || ('0'<=c && c<='9')||('a' <= c && c <= 'z')) {
				if (c == '.' && temp.length()>0 && temp.charAt(temp.length() - 1) == '.') {
					continue;
				}
				temp += c;
			}
		}
		// 4
		if (temp.charAt(0) == '.') {
			temp = temp.substring(1, temp.length());
		}
		if (temp.length() > 0 && temp.charAt(temp.length() - 1) == '.')
			temp = temp.substring(0, temp.length() - 1);
		// 5
		if (temp.equals("")) {
			temp = "a";
		}

		// 6
		if (temp.length() >= 16)
			temp = temp.substring(0, 15);
		if (temp.length() > 0 && temp.charAt(temp.length() - 1) == '.')
			temp = temp.substring(0, temp.length()-1);

		// 7
		if (temp.length() <= 2) {
			char c = temp.charAt(temp.length()-1);
			for(int i = temp.length(); i< 3;i++) {
				temp+=c;
			}
		}
		System.out.println(temp);

		return answer;
	}
}
