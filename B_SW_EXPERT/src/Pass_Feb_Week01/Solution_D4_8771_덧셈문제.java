package Pass_Feb_Week01;
import java.util.Scanner;

public class Solution_D4_8771_덧셈문제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int N,min,max;
		long result;
		for(int i = 1 ; i <= T ; i++) {
			result = 0;
			N = sc.nextInt();
			min = sc.nextInt();
			max = sc.nextInt();
			if(min > max || (N ==1 && min!=max)) {
				result = 0;
			}else if (N == 1 && min == max){
				result = 1;
			}else {
				result = (long)(N - 2) * (max - min) +1 ; 
			}

			//System.out.println("N : " + N +"   min : " + min + "   max : " + max);
			System.out.println("#" + i +" " + result);
		}
	}
}
