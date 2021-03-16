package Study_0305;

import java.util.Scanner;

public class Solution_D4_4796_의석이의우뚝선산 {
	static int T, N;
	static int[] list;
	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			res = 0;
			N = sc.nextInt();
			list = new int[N];
			int lcount = 0;
			int rcount = 0;
			int up = 0;
			for (int i = 0; i < N; i++) {
				list[i] = sc.nextInt();
				if (i == 0)
					continue;
				if (up == 0) { // 처음, 평행
					if (list[i - 1] < list[i]) { // 커지는경우
						lcount++;
						up = 1;
					} else if (list[i - 1] > list[i]) {
						up = -1;// 어차피 우뚝설려면 올라갔다 내려와야함
					
					} else {// 같을때
						continue;
					}
				}else if (up == 1) {// 올라가는중
					if (list[i - 1] < list[i]) { // 커지는경우
						lcount++;
					} else if (list[i - 1] > list[i]) {
						rcount++;
						up = -1;// 어차피 우뚝설려면 올라갔다 내려와야함
						if (i == N - 1)
							res += lcount;
					} else {// 같을때
						lcount = 0;// 날아감..
						up = 0;
					}
				}else if (up == -1) {// 내려가는중
					if (list[i - 1] < list[i]) { // 커지는경우
						res += lcount * rcount;
						lcount = 1;
						rcount = 0;
						up = 1;
					} else if (list[i - 1] > list[i]) {
						rcount++;
						if (i == N - 1)
							res += rcount * lcount;
					} else {// 같을때
						res += lcount * rcount;
						lcount = 0;
						rcount = 0;
						up = 0;
					}
				}
			}

			System.out.println("#" + tc + " " + res);
		}
	}
}
