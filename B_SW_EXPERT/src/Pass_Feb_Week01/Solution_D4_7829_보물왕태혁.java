package Pass_Feb_Week01;

import java.util.Scanner;

public class Solution_D4_7829_보물왕태혁 {

	static int T,N,K,result;
	static int n_MAX;
	static int n_MIN;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <=T; test_case++) {
			N = sc.nextInt();
			n_MAX = Integer.MIN_VALUE;
			n_MIN = Integer.MAX_VALUE;
			result = 0;
			for(int i = 0 ; i < N ; i++) {
				K = sc.nextInt();
				if(N == 1 ) {
					result = K * K;
					break;
				}
				if(n_MAX  < K)
					n_MAX = K;
				if(n_MIN  > K)
					n_MIN = K;
				result = n_MAX * n_MIN;
			}
			
			System.out.println("#" + test_case + " " + result);
		}
	}
}
