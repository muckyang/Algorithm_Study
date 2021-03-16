package Study_0203;

import java.util.Scanner;
import java.util.Set;

public class Solution_D4_2819_격자판의숫자이어붙이기 {
	static int T;
	static int[][] matrix;
	static int[] su;
	static String s;
	static int cnt;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void func(int x, int y, int count, String s) {
		if (count == 7) {
			if (su[Integer.parseInt(s)] == 0) {
				cnt++;
				su[Integer.parseInt(s)] = 1;
			}
			return;
		} else {
			for (int d = 0; d < 4; d++) {
				if (x + dx[d] >= 0 && y + dy[d] >= 0 && x + dx[d] < 4 && y + dy[d] < 4) {
					func(x+dx[d],y+dy[d],count+1,s+matrix[x+dx[d]][y+dy[d]]);
				}
			}
            
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
	
		matrix = new int[4][4];
		
		for (int test_case = 1; test_case <= T; test_case++) {
			cnt = 0;
			su = new int[9999999];// 최대 7자리 이므로 0으로 시작해도 모두 커버가능함
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {// 시작지점 설정
					matrix[i][j] = sc.nextInt();

				}
			}

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {// 시작지점 설정
					s = Integer.toString(matrix[i][j]);
					func(i, j, 1, s);
				}
			}
            
			System.out.println("#" + test_case + " " + cnt);
		}
	}
}

