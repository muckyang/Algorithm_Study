package Study_0202;

import java.util.Scanner;

public class Solution_D3_1215_회문 {

	static int N, n, k, count,check;
	static char[][] matrix;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case < 11; test_case++) {
			N = sc.nextInt();
			n = N;
			count = 0;
			matrix = new char[8][8];

			for (int i = 0; i < 8; i++) {
				String s = sc.next();
				for (int j = 0; j < 8; j++) {
					matrix[i][j] = s.charAt(j);
				}
			}

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8 - N + 1; j++) {
					check=1;
					for(int d = 0 ; d < N/2 ; d++) {
						if(matrix[i][j+d] != matrix[i][j-d+N-1]) {//팰린드롬 아니면
							check = 0;
							break;
						}
					}
					if(check == 1)//팰린드롬이면
						count ++;
				}
			}

			for (int j = 0; j < 8; j++) {
				for (int i = 0; i < 8 - N + 1; i++) {
					check=1;
					for(int d = 0 ; d < N/2 ; d++) {
						if(matrix[i+d][j] != matrix[i-d+N-1][j]) {//팰린드롬 아니면
							check = 0;
							break;
						}
					}
					if(check == 1)//팰린드롬이면
						count ++;
				}
			}

			System.out.println("#" + test_case + " " + count);
		}

	}
}
