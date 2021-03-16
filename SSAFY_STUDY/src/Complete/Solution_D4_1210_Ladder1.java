package Complete;

import java.util.Scanner;

public class Solution_D4_1210_Ladder1 {

	//static int T;
	static int[][] matrix;
	static int[] dx = {0,0,-1};
	static int[] dy = {1,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int si,sj;
		//T = sc.nextInt();
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			si = 98;
			sj = 0;
			matrix = new int [100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					matrix[i][j] = sc.nextInt();
					if(matrix[i][j] == 2) {
						sj=j;
					}
						
				}
			}
			while(si != 0) {
				if(sj == 0 && matrix[si + dx[0]][sj + dy[0]] == 0) {//왼벽에 닿은경우
					si--;
				}else if(sj == 99 && matrix[si + dx[1]][sj + dy[1]] == 0) {//오른벽에 닿은경우
					si--;
				}else if( sj > 0 && sj < 99 && matrix[si + dx[0]][sj + dy[0]] == 0 && matrix[si + dx[1]][sj + dy[1]] == 0) {
					si--;
				}else if( sj > 0  && matrix[si + dx[1]][sj + dy[1]] == 1) {
					while( sj > 0  && matrix[si + dx[1]][sj + dy[1]] != 0 ) {
						si +=dx[1];
						sj +=dy[1];
					}
					si--;
				}else if( sj < 99 && matrix[si + dx[0]][sj + dy[0]] == 1 ) {
					while( sj < 99 &&matrix[si + dx[0]][sj + dy[0]] != 0 ) {
						si +=dx[0];
						sj +=dy[0];
					}
					si--;
				}else {
					si--;
				}
			}
			System.out.println("#" + test_case + " " + sj);
			
			
		}
	}
}
