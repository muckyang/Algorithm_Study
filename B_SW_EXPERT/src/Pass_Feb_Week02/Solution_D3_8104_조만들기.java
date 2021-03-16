package Pass_Feb_Week02;

import java.util.Scanner;

public class Solution_D3_8104_조만들기 {
	static int T;
	static int N, K;
	static int matrix[][];
	static int sum [];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T= sc.nextInt();
		for(int test_case = 1 ; test_case <=T; test_case++) {
			N=sc.nextInt();
			K=sc.nextInt();
			matrix= new int [N][K];
			sum = new int[K];
			int all = N*K;
			for(int i = 0 ; i <all;i++) {
				if( (i / K)%2==0 ) {
					matrix[i/K][(i%K)] = i+1;
				}else {
					matrix[i/K][(K-1) - (i % K)]=i+1	;
				}
			}
			for(int i = 0 ;i <N;i++) {
				for(int j = 0 ; j< K ;j++ )
					sum[j] += matrix[i][j];
			}
			System.out.print("#" + test_case );
			for(int j = 0 ; j< K ;j++ )
				System.out.print(" " + sum[j] );
			System.out.println();
		}
	}
}
