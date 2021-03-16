package Study_0904;

import java.util.LinkedList;
import java.util.List;

public class ex2 {

	static boolean[][] gi;
	static boolean[][] bo;
	static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[][] build_frame = { { 0, 0, 0, 1 }, { 2, 0, 0, 1 }, { 4, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 },
				{ 2, 1, 1, 1 }, { 3, 1, 1, 1 }, { 2, 0, 0, 0 }, { 1, 1, 1, 0 }, { 2, 2, 0, 1 } };
		solution(n, build_frame);
	}

	public static int[][] solution(int n, int[][] build_frame) {
		List<int[]> list = new LinkedList<>();
		N = n + 1;
		gi = new boolean[N][N];
		bo = new boolean[N][N];
		for (int i = 0; i < build_frame.length; i++) {
			int x = build_frame[i][0];
			int y = build_frame[i][1];
			int a = build_frame[i][2];
			int b = build_frame[i][3];
			if (b == 1) {// 설치
				if (a == 0) {// 기둥
					if (y == 0 || bo[y][x] || (x - 1 >= 0 && bo[y][x - 1]) || (y - 1 >= 0 && gi[y - 1][x])) {
						gi[y][x] = true; // 기둥 바닥
					}
				} else {// 보
					if ((y - 1 >= 0 && gi[y - 1][x]) || (y - 1 >= 0 && x + 1 < N && gi[y - 1][x + 1])
							|| (x - 1 >= 0 && x + 1 < N && bo[y][x - 1] && bo[y][x + 1])) {
						bo[y][x] = true;
					}
				}
			} else {// 삭제
				if (a == 0) {// 기둥
					gi[y][x] = false;
					if (!checkgi(y + 1, x) || !checkbo(y, x) || !checkbo(y, x - 1))
						gi[y][x] = true;
				} else {// 보
					bo[y][x] = false;
					if (!checkbo(y, x - 1) || !checkbo(y, x + 1) || !checkgi(y, x) || !checkgi(y, x + 1))
						bo[y][x] = true;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (gi[j][i]) {
					int[] el = { i, j, 0 };
					list.add(el);
				}
				if (bo[j][i]) {
					int[] el = { i, j, 1 };
					list.add(el);
				}
			}
		}

		int[][] answer = new int[list.size()][3];
		for (int i = 0; i < list.size(); i++) {
			answer[i][0] = list.get(i)[0];
			answer[i][1] = list.get(i)[1];
			answer[i][2] = list.get(i)[2];
		}
		return answer;
	}

	static boolean checkgi(int y, int x) {
		if (y < 0 || x < 0 || y >= N || x >= N)
			return true;
		if (!gi[y][x])
			return true;
		if (y == 0 || bo[y][x] || (x - 1 >= 0 && bo[y][x - 1]) || (y - 1 >= 0 && gi[y - 1][x])) {
			return true;
		} else
			return false;
	}

	static boolean checkbo(int y, int x) {
		if (y < 0 || x < 0 || y >= N || x >= N)
			return true;
		if (!bo[y][x])
			return true;
		if ((y - 1 >= 0 && gi[y - 1][x]) || (y - 1 >= 0 && x + 1 < N && gi[y - 1][x + 1])
				|| (x - 1 >= 0 && x + 1 < N && bo[y][x - 1] && bo[y][x + 1])) {
			return true;
		} else
			return false;
	}

}
