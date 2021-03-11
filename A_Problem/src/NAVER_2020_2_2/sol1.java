package NAVER_2020_2_2;

public class sol1 {

	public static void main(String[] args) {
		String m = "acbbcdc";
		String k = "abc";
		StringBuilder sb = new StringBuilder();
		int c = 0;
		for (int i = 0; i < m.length(); i++) {
			if(c==k.length()) {
				
			}else if(m.charAt(i)==k.charAt(c)) {
				c++;
				continue;
			}
			sb.append(m.charAt(i));
		}
		String answer = sb.toString();
		System.out.println(answer);
	}
}
