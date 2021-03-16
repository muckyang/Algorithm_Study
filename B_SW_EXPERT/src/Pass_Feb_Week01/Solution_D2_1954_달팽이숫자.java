package Pass_Feb_Week01;

import java.util.Scanner;

public class Solution_D2_1954_달팽이숫자 {
	static int T,N;
	static int [][] matrix;
	static int [] dx = {0,1,0,-1};
	static int [] dy = {1,0,-1,0};
	static int count ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int d,a,b;
		T= sc.nextInt();
	
		for(int test_case = 1 ; test_case <= T ; test_case++) {
			N = sc.nextInt();
			matrix = new int[N][N];
			count = 1;
			d=0;
			a=b=0;
			matrix[a][b] = count;
			count++;
			while(count <= N*N) {
				switch(d) {
				case 0:
					if(b + dy[d] < N && matrix[a+dx[d]][b+dy[d]] == 0) {
						a += dx[d];
						b += dy[d];
						matrix[a][b] = count;
						count++;
						
					}else {
						d++;
					}
					break;
				case 1:
					if(a + dx[d] < N && matrix[a+dx[d]][b+dy[d]] == 0) {
						a += dx[d];
						b += dy[d];
						matrix[a][b] = count;
						count++;
						
					}else {
						d++;
					}
					break;
				case 2:
					if(b + dy[d] >= 0 && matrix[a+dx[d]][b+dy[d]] == 0) {
						a += dx[d];
						b += dy[d];
						matrix[a][b] = count;
						count++;
						
					}else {
						d++;
					}
					break;
				case 3:
					if(a + dx[d] >= 0 && matrix[a+dx[d]][b+dy[d]] == 0) {
						a += dx[d];
						b += dy[d];
						matrix[a][b] = count;
						count++;
						
					}else {
						d=0;
					}
					break;
					
				}
				
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(matrix[i][j] + " ");
				}
				System.out.println();
			}
			
		}
	}
}
