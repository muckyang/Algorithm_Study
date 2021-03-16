package Study_0329;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_3678_카탄의지배자_노답 {
	static int T, N;
	static int map[][];
	static int count[];

	public static void main(String[] args) {
		int cnt = 0;
		count = new int[6];
		map = new int[20][];
		map[0] = new int[1];
		map[0][0] = 1;
		map[1] = new int[6];
		map[1][0] = 2;
		map[1][1] = 3;
		map[1][2] = 4;
		map[1][3] = 5;
		map[1][4] = 2;
		map[1][5] = 3;
		count[1] = 1;
		count[2] = 2;
		count[3] = 2;
		count[4] = 1;
		count[5] = 1;
		cnt = 7;
		for (int i = 2; cnt < 10000; i++) {
			map[i] = new int[(int) (6 * Math.pow(2, i - 1))];
			for (int j = 0; j < 6 * Math.pow(2, i - 1); j++) {
				boolean banlist[] = new boolean[6];

				if (j == 0) {// 시작 (처음것과 끝것
					banlist[map[i - 1][(int) (6 * Math.pow(2, i - 2)) - 1]] = true;
					banlist[map[i - 1][0]] = true;
				} else if (j == (int) (6 * Math.pow(2, i - 1)) - 1) { // 마지막
					banlist[map[i][0]] = true;
					banlist[map[i][j - 1]] = true;
					banlist[map[i - 1][j / 2]] = true;
				} else {
					banlist[map[i][j - 1]] = true;
					if (j % 2 == 0 && i % 2 == 0) {
						banlist[map[i - 1][j / 2]] = true;
						banlist[map[i - 1][j / 2 - 1]] = true;
					}else if (j % 2 != 0 && i % 2 != 0) {
						banlist[map[i - 1][j / 2]] = true;
						banlist[map[i - 1][j / 2 + 1]] = true;
					} else {
						banlist[map[i - 1][j / 2]] = true;
					}
				}
				int min = Integer.MAX_VALUE;
				int ssu = 1;
				for (int su = 1; su <= 5; su++) {
					if (!banlist[su]) {
						if (min > count[su]) {
							min = count[su];
							ssu = su;
						}
					}
				}
				count[ssu]++;
				map[i][j] = ssu;
				cnt++;

				if (cnt == 10000)
					break;

			}
		}
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			N = sc.nextInt() - 1;
			int i = 0;
			if (N > 0) {
				i++;
				N--;
			}
			while (true) {
				if (N >= (int) (6 * Math.pow(2, i - 1))) {
					N = N - (int) (6 * Math.pow(2, i - 1));
					i++;
				} else {
					break;
				}
			}
			System.out.println(map[i][N]);
		}
	}
}
