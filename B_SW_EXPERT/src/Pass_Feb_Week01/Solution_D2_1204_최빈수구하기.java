package Pass_Feb_Week01;

import java.util.Scanner;

public class Solution_D2_1204_최빈수구하기 {

	static int T,N;
	static int [] list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		T= sc.nextInt();
		for(int test_case = 1 ; test_case <= T; test_case++	) {
			N= sc.nextInt();
			list = new int[101];
			for(int i = 0 ; i <1000; i++) {
				list[sc.nextInt()]++;
			}
			int max = 0 ;
			int max_v= 0 ;
			for(int i = 0 ; i < 100 ;i++) {
				if(max <= list[i]) {
					max= list[i];
					max_v=i;
				}
			}
	
			System.out.println("#" + test_case + " " + max_v);
		}
			
	}

}
