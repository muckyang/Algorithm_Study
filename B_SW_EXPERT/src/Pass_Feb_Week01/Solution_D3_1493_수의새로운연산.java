package Pass_Feb_Week01;

import java.util.Scanner;

public class Solution_D3_1493_수의새로운연산 {
	static int T;
	static int N, M;
	static int nx, ny;
	static int mx, my;
	static int next_Value;

	static int calc(int x, int y) { // 연산된 x ,y에 해당하는 값
		int result = 1;
		for (int i = 1; i < x + y - 1; i++) {
			result += i;
		}
		return result + y - 1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			next_Value = 1;
			nx = mx = 1;
			ny = my = 1;
			int val= 0;
			for(int i = 1; N != 1 ;i++) {
				if(next_Value + i< N) {
					next_Value += i;
					nx++;
				}else if(next_Value + i == N) {
					nx++;
					break;
				}else if (next_Value ==N ){
					break;
				}else  {
					next_Value++;
					nx--;
					ny++;
				}
			}
			next_Value = 1;
			for(int i = 1; M != 1 ;i++) {
				if(next_Value + i < M) {
					next_Value += i;
					mx++;
				}else if(next_Value + i == M) {
					mx++;
					break;
				}else if (next_Value == M ){
					break;
				}else  {
					next_Value++;
					mx--;
					my++;
				}
			}
			System.out.println("#" + test_case + " "+ calc(nx+mx , ny+my) );
		}

	}
}
