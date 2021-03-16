package Study_0522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_Unknown_2112_보호필름 {
	static int T, D, W, K;
	static int[][] film;
	static int[] list;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int testcase = 1; testcase <= T; testcase++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			film = new int[D][W];
			list = new int[W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			res = Integer.MAX_VALUE;
			solve(0, 0); // 현재row , 횟수
			System.out.println("#" + testcase + " " + (res == Integer.MAX_VALUE ? K : res));
		}
	}

	private static void solve(int row, int count) {
		if (row == D) {
			if (check())
				res = Math.min(res, count);
			return;
		}

		if (count >= res) {
			return;
		}
		// 부분집합
		// 투약하지 않았을 때
		list[row] = 0;
		solve(row + 1, count); // 투약하지 않아서 count는 그대로

		// a 약품을 투여했을 때
		list[row] = 1;
		solve(row + 1, count + 1);

		// b 약품을 투여했을 때
		list[row] = 2;
		solve(row + 1, count + 1);
	}

	private static boolean check() {
		int count; // 연속된 셀을 세는 카운트
		int cur, next; // 검사할 현제 셀과 다음셀
		for (int i = 0; i < W; i++) { // 열
			count = 1;
			for (int j = 0; j < D - 1; j++) { // 행
				cur = film[j][i];
				next = film[j + 1][i];
				if (list[j] > 0) { // 현재 행에 약품을 투여
					cur = list[j] - 1; // a:0, b:1 => a:1 b:2
				}
				if (list[j + 1] > 0) { // next 행에 약품을 투여
					next = list[j + 1] - 1; // a:0, b:1 => a:1 b:2
				}
				if (cur == next) { // 연속 된 경우
					count++;
					if (count >= K)
						break;
				} else { // 연속 되지 않은 경우
					count = 1;
				}
			}
			if (count < K)
				return false;
		}
		return true;
	}
}
