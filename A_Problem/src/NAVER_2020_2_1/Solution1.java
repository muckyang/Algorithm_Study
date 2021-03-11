package NAVER_2020_2_1;

public class Solution1 {
	public static void main(String[] args) {
		int n = 6;
		int[] p = { 5, 4, 7, 2, 0, 6 };
		int[] c = { 4, 6, 4, 9, 2, 3 };
//		int n = 7;
//		int[] p = {6,2,1,0,2,4,3};
//		int[] c = { 3,6,6,2,3,7,6};

		System.out.println(solution(n, p, c));
	}
	public static String solution(int n, int[] p, int[] c) {
		double answer = 0.0;
		int count = 0;
		int fcount = 0;
		int tak = 0;
		for(int i= 0 ; i < n;i++) {
			tak += p[i];
			count ++;
			if(c[i] > tak) {
				fcount ++;
				if(fcount==3)
					break;
				continue;
			}
			tak -= c[i];
			answer += c[i] * 100 * Math.pow(2, -(fcount));
			fcount = 0;
		}
		answer *=10;
		answer = Math.round(answer)/10/count;
		String answerstr = String.format("%.2f", answer);
		return answerstr;
	}
}
