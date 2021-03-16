package Study_0208;

import java.util.Scanner;

public class Main_8320_직사각형 {
	static int N;
	static boolean[][] matrix;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		matrix = new boolean[N][N];
		int re = N;
		for (int i = 2; i < N; i++) {
			for (int j = 2; j < N; j++) {
				if(i*j <= N && matrix[j][i] == false) {
					matrix[i][j] = true;
					re++;
				}
			}
		}
		
		System.out.println(re);
	}
}
