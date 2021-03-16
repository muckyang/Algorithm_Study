package Pass_Feb_Week01;

import java.util.Scanner;

public class Solution_D3_1217_거듭제곱 {
	
	static int n;
	static int a,b;
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		for(int test_case =  1 ; test_case < 11;test_case ++) {
			n=sc.nextInt();//안씀
			
			a=sc.nextInt();
			b=sc.nextInt();
			System.out.println("#" + test_case + " " + (long)Math.pow(a,b));
		}
	}
}
