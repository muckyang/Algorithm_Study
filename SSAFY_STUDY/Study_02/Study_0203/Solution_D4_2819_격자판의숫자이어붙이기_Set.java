package Study_0203;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution_D4_2819_격자판의숫자이어붙이기_Set {
	static int T;
	static String[][] matrix;
	static Set<String> set;
	// static int[] su;
	static String s;
	static int cnt;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void func(int x, int y, int count, String s) {
		if (count == 7) {
			set.add(s);
			return;
		} else {
			for (int d = 0; d < 4; d++) {
				if (x + dx[d] >= 0 && y + dy[d] >= 0 && x + dx[d] < 4 && y + dy[d] < 4) {
					func(x + dx[d], y + dy[d], count + 1, s + matrix[x + dx[d]][y + dy[d]]);
				}

			}

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		matrix = new String[4][4];

		for (int test_case = 1; test_case <= T; test_case++) {
			cnt = 0;
			set = new HashSet<>();
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {// 시작지점 설정
					matrix[i][j] = Integer.toString(sc.nextInt());

				}
			}

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {// 시작지점 설정

					func(i, j, 1, matrix[i][j]);

				}

			}
			System.out.println("#" + test_case + " " + set.size());
		}
	}
}
