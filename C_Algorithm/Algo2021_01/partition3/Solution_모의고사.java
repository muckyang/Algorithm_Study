package partition3;

import java.util.Arrays;

public class Solution_모의고사 {

	static int res;
	static boolean wall[];
	static boolean[] temp;

	public static void main(String[] args) {
//		int n = 12;
//		int[] weak = { 1, 5, 6, 10 };
//		int[] dist = { 1, 2, 3, 4 };
		int n = 8;
		int[] weak = { 0, 2, 3, 4, 6, 7 };
		int[] dist = { 1, 2, 3 };
//		int[] weak = { 1, 3, 4, 9, 10 };
//		int[] dist = { 3,5,7};

		System.out.println(solution(n, weak, dist));
	}

	public static int solution(int n, int[] weak, int[] dist) {
		int answer = 0;
		res = -1;
		wall = new boolean[n];

		Arrays.sort(dist);
		for (int i = 0; i < weak.length; i++) {
			wall[weak[i]] = true;
		}
		for (int i = 1; i <= dist.length; i++) {
			perm(0, 0, i, weak, dist, n, wall);// count , 선택할수 있는 지점 수, 지점수
			if (res != -1) {
				return res;
			}
		}

		return res;
	}

	private static void perm(int start, int cnt, int end, int[] weak, int[] dist, int n, boolean[] cover) {
		if (res != -1) {
			return;
		}
		if (cnt == end) {// 갯수 일치

			for (int i = 0; i < weak.length; i++) {
				if (wall[weak[i]] && cover[weak[i]]) {
					return;
				}
			}
			res = end;
			return;
		}
		for (int i = start; i < weak.length; i++) {
			if (cover[weak[i]]) {
//				System.out.println(cnt);
				temp = cover.clone();
//				print(temp,n);
				solve(weak[i], cnt, i, weak, dist, n);
//				print(temp,n);
//				System.out.println("================================");
				perm(i + 1, cnt + 1, end, weak, dist, n, temp);
			}
		}

	}

	private static void print(boolean[] temp2, int n) {
		for (int i = 0; i < n; i++)
			System.out.print((temp2[i] ? 1 : 0) + " ");
		System.out.println();
	}

	public static void solve(int sp, int cnt, int index, int[] weak, int[] dist, int n) {

		int d = dist[dist.length - cnt - 1];// 커버할 수 있는 범위
		for (int j = sp; d >= 0; j++, d--) {
			if (j == n) {
				j = 0;
			}
			if (j == weak[index]) {
				index++;
				if (index == weak.length)
					index = 0;
				if (temp[j])
					temp[j] = false;
			}
		}

	}
}
