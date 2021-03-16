package todolist;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Solution_외벽점검 {

	 static int res;
		static boolean wall[];
		static boolean[] temp;

		public static void main(String[] args) {
			int n = 12;

			int[] weak = { 1, 3, 4, 9, 10 };
			int[] dist = { 3,5,7};
			
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
				perm(0, i, weak, dist, n,wall);// count , 선택할수 있는 지점 수, 지점수
				if (res != -1) {
					return res;
				}
			}

			return res;
		}

		private static void perm( int cnt, int end, int[] weak, int[] dist, int n, boolean[] cover) {
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
			for (int i = 0; i < weak.length; i++) {
				if (cover[weak[i]]) {
					temp = cover.clone();
					solve(weak[i], cnt, i, weak, dist, n);
					perm( cnt + 1, end, weak, dist, n, temp);
				}
			}

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
