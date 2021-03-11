package NHN;

import java.util.Stack;

public class sol3 {
	static int nowindex;

	private static void solution(int numOfOrder, String[] orderArr) {
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < numOfOrder; t++) {
			String res = "";
			Stack<String> str = new Stack<>();
			Stack<Integer> num = new Stack<>();
//			res = solve(orderArr[i], 0,0);
			String s = "";
			for (int i = 0; i < orderArr[t].length(); i++) {
				char c = orderArr[t].charAt(i);
				int cnt = 0;
				if (1 <= c - '0' && c - '0' <= 9) {
					int number = Integer.parseInt(c + "");
					num.add(number);
			
				} else if (c == '(') {
					cnt++;
					str.add(s);
					s="";
				} else if (c == ')') {
					cnt--;
					int su = num.pop();
					for (int k = 0; k < su; k++)
						res += s;
					res = str.pop()+res;
					
				} else {
					s += c;
				}
			}
			System.out.println(res);
			sb.append(res).append("\n");	
		}
		System.out.println(sb.toString());
	}


	public static void main(String[] args) {
		int numOfOrder = 1;
		String[] orderArr = new String[numOfOrder];
		orderArr[0] = "B2(RG)";
//		orderArr[1] = "3(R2(GB))";
		solution(numOfOrder, orderArr);
	}
}
//
//2
//B2(RG)
//3(R2(GB))
//
//BRGRG
//RGBGBRGBGBRGBGB
//
//3
//3(BR2(R))
//B(RGB(RG))
//1B2R3G
//
//BRRRBRRRBRRR
//BRBGBBBRBBBG
//BRRGGG
