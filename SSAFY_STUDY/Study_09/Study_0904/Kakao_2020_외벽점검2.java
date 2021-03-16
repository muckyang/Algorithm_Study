package Study_0904;

import java.util.Arrays;

public class Kakao_2020_외벽점검2 {
	static int res;
	static boolean wall[];
	static int check[];
	static int wrap[];

	public static void main(String[] args) {
		int n = 40;
		int[] weak = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31 };
		int[] dist = { 1,1,1,1,1,1,1,1 };
//		int[] weak = {0,2,6,9,10};
//		int[] dist = {1,1,1};
		System.out.println(solution(n, weak, dist));

	}

	public static int solution(int n, int[] weak, int[] dist) {
		int answer = 0;
		res = -1;
		wall = new boolean[n];
		check = new int[weak.length];
		wrap = new int[weak.length];
		Arrays.sort(dist);
		for (int i = 0; i < weak.length; i++) {
			wall[weak[i]] = true;
		}
		for (int i = 1; i <= dist.length; i++) {
			perm(0, i, weak, dist, n);// count , 선택할수 있는 지점 수, 지점수
			if (res != -1) {
				return res;
			}
		}

		return res;
	}

	private static void perm(int cnt, int end, int[] weak, int[] dist, int n) {
		if (res != -1) {
			return;
		}
		if (cnt == end) {// 갯수 일치
			boolean[] temp = new boolean[n];
			System.arraycopy(wall, 0, temp, 0, n);
			for (int i = 0; i < end; i++) {
				int sp = wrap[i];// start point
				int d = dist[dist.length - 1 - i];// 범위
				int cover = d + sp;
				if (cover >= n) { // 원점을 넘어가는 경우
					for (int k = check[i] + 1;; k++) {
						if (k == weak.length) {
							cover -= n;
							k = -1;
							continue;
						}
						if (weak[k] > cover)
							break;
						if (temp[weak[k]])
							temp[weak[k]] = false;
					}
				} else {
				
					for (int k = check[i] + 1;; k++) {
						if (k == weak.length || weak[k] > cover)
							break;
						if (temp[weak[k]])
							temp[weak[k]] = false;
					}

				}
			}
			for (int i = 0; i < weak.length; i++) {
				if (temp[weak[i]]) {
					return;
				}
			}
			res = end;
			return;
		}
		for (int i = 0; i < weak.length; i++) {
			if (wall[weak[i]]) {
				wall[weak[i]] = false;
				check[cnt] = i;
				wrap[cnt] = weak[i];
				perm(cnt + 1, end, weak, dist, n);
				wall[weak[i]] = true;

			}
		}

	}

	public static void solve(int sp, int cnt, int index, int[] weak, int[] dist, int n, boolean c) {

		int d = dist[dist.length - cnt - 1];// 커버할 수 있는 범위
		for (int j = sp; d >= 0; j++, d--) {
			if (j == n) {
				j = 0;
			}
			if (j == weak[index]) {
				index++;
				if (index == weak.length)
					index = 0;
				if (wall[j] != c)
					wall[j] = c;
			}
		}

	}
}
