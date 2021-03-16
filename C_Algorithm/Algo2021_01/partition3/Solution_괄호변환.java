package partition3;

public class Solution_괄호변환 {
	public static void main(String[] args) {
		String str = "()))((()";
		System.out.println(Solution(str));
	}

	private static String Solution(String s) {
		String res = "";
		int cnt = 0;
		int open = 0;
		int close = 0;
		String grep = "";
		while (s.length() > res.length()) {
			char c = s.charAt(cnt);
			boolean check = false;
			if (close > open)
				check = true;
			if (c == '(')
				open++;
			else
				close++;
			grep += c;
			if (open != 0 && open == close) {// 균형 마춰졌을때
				if (check) {
					String temp = "(";
					temp += Solution(s.substring(cnt+1));
					temp += ")";
					for (int i = 1; i < grep.length() -1; i++) {
						if (grep.charAt(i) == ')')
							temp += "(";
						else
							temp += ")";
					}
					res+=temp;
				} else
					res += grep;
				grep = "";
				open = close = 0;
			}
			cnt++;
		}
		return res;
	}
}
