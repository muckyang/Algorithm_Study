package Pass_Feb_Week03;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D4_4111_무선단속카메라 {
	static int T, N, K;
	static int[] Camera;
	static int[] cut;
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			K = sc.nextInt();
			min = 0;
			Camera = new int[N];
			cut = new int[N];

			for (int i = 0; i < N; i++) {
				Camera[i] = sc.nextInt();

			}
			// 받기 끝
			Arrays.sort(Camera);
			for (int i = 0; i < N - 1; i++) {
				cut[i] = Camera[i + 1] - Camera[i];
			}
			Arrays.sort(cut);

			for (int i = 0; i < N - K +1 ; i++) {
				min += cut[i];
			}
			System.out.println("#" + test_case  + " " + min);
		}
	}

}
