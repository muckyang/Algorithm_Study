package Pass_Feb_Week02;

import java.util.Scanner;

public class Solution_D3_1244_최대상금_수현 {
	static int T;
	static String S;
	static int N;
	static int[] num;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			S = sc.next();
			num = new int[S.length()];
			for (int j = 0; j < S.length(); j++) {
				num[j] = S.charAt(j) - '0';
			}
			N = sc.nextInt();
			max = Integer.MIN_VALUE;
			find(0, 0);
			System.out.println("#" + t + " " + max);
		}
	}

	private static void find(int n, int index) {
		if (n == N) {
			String A = "";
			for (int i = 0; i < num.length; i++) {
				A += num[i];
			}
			if (max < Integer.parseInt(A)) {
				max = Integer.parseInt(A);
			}
			return;
		}
		for (int i = index; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				if (num[i] <= num[j]) {// 뒤에 숫자가 더 크면 교환
					swap(i, j);
					find(n + 1, i);
					swap(j, i);
				}
			}
		}
	}

	private static void swap(int i, int j) {

		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
}
///히든테케에 없는 예외 케이스////
//Input 
//1 
//321 1 
//
//
//Output
//312
