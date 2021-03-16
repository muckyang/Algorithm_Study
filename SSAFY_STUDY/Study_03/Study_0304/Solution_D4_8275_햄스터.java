package Study_0304;

import java.util.Scanner;

public class Solution_D4_8275_햄스터 {
	static int T, N, X, M;
	static int[] cage;// 중복순열
	static int[][] input;
	static int max;// 햄스터 배치 여러가지 가능하다면 합이 최대가 되는경우를위해
	static String ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();// 총 우리수
			X = sc.nextInt();// 각 우리에 최대 마릿수
			M = sc.nextInt();// 체크 횟수
			ans = "";
			max = -1;
			cage = new int[N + 1];
			input = new int[N][3];// left , right , sum

			for (int i = 0; i < M; i++) {
				input[i][0] = sc.nextInt();// l
				input[i][1] = sc.nextInt();// r
				input[i][2] = sc.nextInt();// s
			}

			perm(1, 0);// 1번 케이지부터
			System.out.println("#" + tc + " " + ((max == -1) ? max : ans));
		}
	}

	static void perm(int idx, int sum) {
		if (idx == cage.length) {
			if (check()) {
				if (max < sum) {// 이미 오름차순으로 만들었기 떄문에 등호없이 해주면 완벽함.
					max = sum;
					ans = "";
					for (int i = 1; i <= N; i++) {
						ans += cage[i];
						ans += " ";
					}
				
				}
			}
			// 수에 맞춰져있는지 확인
			return;
		}
		for (int i = 0; i <= X; i++) {
			cage[idx] = i;
			perm(idx + 1, sum + i);
		}

	}

	static boolean check() {
		for (int i = 0; i < M; i++) {
			int tmp = 0;
			for (int j = input[i][0]; j <= input[i][1]; j++) {
				tmp += cage[j];
			}
			if (tmp != input[i][2]) {
				return false;
			}
		}
		return true;
	}

}
