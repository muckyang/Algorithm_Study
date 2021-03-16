package Month03_Week03;

import java.util.Scanner;

public class Main_9251_LCS {
	static String A, B;
	static int dp[][];
	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.next();
		B = sc.next();
		dp = new int[A.length()][B.length()];
		res = solve(0,0);
		System.out.println(res);
	}

	private static int solve(int a, int b) {
		if(a==A.length() || b==B.length())
			return 0;
		if(dp[a][b] != 0 )
			return dp[a][b];
		if(A.charAt(a) == B.charAt(b)) {
			return dp[a][b] = solve(a+1,b+1)+ 1;
		}
		if(a==A.length()-1){
			return dp[a][b] = solve(a,b+1);
		}
		if(b==B.length()-1){
			return dp[a][b] = solve(a+1,b);
		}
		return dp[a][b] = Math.max(solve(a,b+1), solve(a+1,b));
	}

}
