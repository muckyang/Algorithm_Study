package Study_0419;

import java.util.Scanner;

public class Main_14500_테트로미노 {
	static int N, M;
	static int map[][];
	static int max;

	static int dx[][] = { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 2, 3 }, { 1, 1, 2 }, { 1, 1, 2 }, { -1, -1, -2 },
			{ -1, -1, -2 }, { 0, -1, -1 }, { 0, 1, 1 }, { 0, -1, -1 }, { 0, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 },
			{ -1, -1, -1 }, { -1, -1, -1 }, { 0, 1, 2 }, { 0, -1, -2 }, { 0, 1, 2 }, { 0, -1, -2 }, { 0, 0, 1 },
			{ 0, 0, -1 }, { 0, 1, -1 }, { 0, -1, 1 } };
	static int dy[][] = { { 0, 1, 1 }, { 1, 2, 3 }, { 0, 0, 0 }, { 0, 1, 1 }, { 0, -1, -1 }, { 0, 1, 1 }, { 0, -1, -1 },
			{ 1, 1, 2 }, { -1, -1, -2 }, { -1, -1, -2 }, { 1, 1, 2 }, { 0, 1, 2 }, { 0, -1, -2 }, { 0, 1, 2 },
			{ 0, -1, -2 }, { 1, 1, 1 }, { 1, 1, 1 }, { -1, -1, -1 }, { -1, -1, -1 }, { 1, -1, 0 }, { 1, -1, 0 },
			{ 1, 0, 0 }, { -1, 0, 0 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
//		int x = 4;
//		int y = 4;
//		for (int i = 0; i < 23; i++) {
//			map = new int[9][9];
//			map[4][4] = 1;
//			for (int d = 0; d < 3; d++) {
//				int ix = x + dx[i][d];
//				int jy = y + dy[i][d];
//				map[ix][jy] = 1;
//			}
//			for (int a = 0; a < 9; a++) {
//				for (int b = 0; b < 9; b++) {
//					System.out.print(map[a][b] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
		
	}
}
