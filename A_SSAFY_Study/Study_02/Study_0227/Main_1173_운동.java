package Study_0227;

import java.util.Scanner;

public class Main_1173_운동 {
	static int N, m, M, T, R;
	static int res, tcnt, pulse;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		m = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();
		R = sc.nextInt();
		pulse = m;
		res = 0;
		tcnt = 0;
		while (N != tcnt) {
			if(m + T > M){
				res=-1;
				break;
			}
			res++;
			if (pulse + T <= M) {
				pulse += T;
				tcnt++;
			}else {
				pulse -= R;
				if(pulse < m)
					pulse=m;
			}
		
			
		}
		System.out.println(res);

	}
}
