package todolist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16571_알파틱택토 {

	static int[] map;
	static int xcount, ocount;
	static int[][] line = { { 0, 1, 2 }, { 0, 3, 6 }, { 0, 4, 8 }, { 2, 4, 6 }, { 2, 5, 8 }, { 6, 7, 8 } ,{3,4,5},{1,4,7}};
	static int res; // 0 : x승 , 1 : 무승부, 2 : o승

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[9];
		res = xcount = ocount = 0;
		boolean[] visit = new boolean[9];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i * 3 + j] = Integer.parseInt(st.nextToken());
				if (map[i * 3 + j] != 0) {
					visit[i * 3 + j] = true;
				}
				if (map[i * 3 + j] == 1) {
					xcount++;
				} else if (map[i * 3 + j] == 2) {
					ocount++;
				}
			}
		}
		System.out.println(xcount + " " + ocount);
		if (xcount == ocount) {// x가 놓을차례
			res = solve(xcount + ocount, 1, map, visit);
			if (res == 0)
				System.out.println("W");
			if (res == 1)
				System.out.println("D");
			if (res == 2)
				System.out.println("L");
		} else {// o가 놓을차례
			res = solve(xcount + ocount, 2, map, visit);
			if (res == 2)
				System.out.println("W");
			if (res == 1)
				System.out.println("D");
			if (res == 0)
				System.out.println("L");

		}

	}

	private static int solve(int sum, int turn, int[] m, boolean[] v) {
		int goal = 1;
		print(m);
		for (int i = 0; i < 8; i++) {
			if (m[line[i][0]] == 0)
				continue;
			for (int j = 0; j < 3; j++) {
				if (m[line[i][j]] != m[line[i][0]])
					break;
				if (j == 2) {
					if (m[line[i][0]] == 1) {
						System.out.println("x승리");
						return 0;
					}
					else {
						System.out.println("o승리");
						return 2;
					}
				}
			}
		}
		// 승패체크
		if (sum == 9) {// 무승부
			System.out.println("무승부");
			return 1;
		}
		for (int i = 0; i < 9; i++) {
			if (v[i])
				continue;
			boolean[] temp_v = v.clone();
			int[] temp_m = m.clone();
			temp_v[i] = true;
			temp_m[i] = turn;
			if (turn == 1) {
				goal = Math.min(goal, solve(sum + 1, 2, temp_m, temp_v));
			} else {
				goal = Math.max(goal, solve(sum + 1, 1, temp_m, temp_v));
			}
		}
		return goal;

	}

	private static void print(int[] m) {
		for (int i = 0; i < 9; i++) {
			System.out.print(m[i] + " ");
			if (i % 3 == 2)
				System.out.println();
		}
		System.out.println();
	}
}
