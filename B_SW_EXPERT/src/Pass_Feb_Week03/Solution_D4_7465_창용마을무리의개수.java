package Pass_Feb_Week03;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Solution_D4_7465_창용마을무리의개수 {
	static int T, N, M;
	static int[][] link;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			link = new int[N][N];
			for (int i = 0; i < M; i++) {
				int x = sc.nextInt() - 1;
				int y = sc.nextInt() - 1;
				link[x][y] = 1;
				link[y][x] = 1;
			}
			// 입력 끝
//			for(int i = 0 ; i < N ; i++) {
//				for(int j = 0 ; j < N ; j++) {
//					System.out.print(link[i][j] + " ");
//				}
//				System.out.println();
//			}
			int union = 1;
			int list[] = new int[N];
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if (link[i][j] == 1) {
						if (list[i] == 0 && list[j] == 0) {
							list[i] = union;
							list[j] = union;
							union++;
						} else if (list[i] == 0 || list[j] == 0) {
							int low = list[i] > list[j] ? list[i] : list[j];
							list[i] = low;
							list[j] = low;
						} else if (list[i] == list[j]) {
							continue;
						} else {
							int low = list[i];
							int high = list[j];
							for (int k = 0; k < N; k++) {
								if (list[k] == low)
									list[k] = high;
							}

						}
					}

				}

			}
			int cnt = 0;
			boolean[] check = new boolean[N];
			for (int i = 0; i < N; i++) {
				if (list[i] == 0) {
					cnt++;
				} else if (!check[list[i]]) {
					cnt++;
					check[list[i]] = true;
				}
			}
			System.out.println("#" + test_case + " " + cnt);

		}
	}
}
