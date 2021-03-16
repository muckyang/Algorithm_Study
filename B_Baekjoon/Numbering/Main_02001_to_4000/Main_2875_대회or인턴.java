package Main_02001_to_4000;

import java.util.Scanner;

public class Main_2875_대회or인턴 {
	static int N, M, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		int ingyeo = 0;

		if (N > 2 * M) {
			ingyeo += N - 2 * M;
			N -= ingyeo;
		} else if (M > N / 2) {
			ingyeo += M - N / 2;
			M -= ingyeo;
		}
		K -= ingyeo;
		while (K > 0) {
			K -= 3;
			N -= 2;
			M -= 1;
		}

		System.out.println(M);
	}
}
