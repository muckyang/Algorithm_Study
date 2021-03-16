package Study_0416;

import java.util.Scanner;

public class Main_makde {
	static int dp[];
	static int res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		dp = new int[N];
		dp[0]= 1;
		dp[1]= 2;
		dp[2]= 4;
		for(int i = 3; i <N;i++) {
			dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
		}
		System.out.println(dp[N-1]);
	}
}
