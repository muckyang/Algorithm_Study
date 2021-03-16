package Study_0306;

import java.util.Scanner;

public class Main_1102_발전소 {
	static int N;
	static int[][] matrix;
	static String status;
	static int turnOn;
	static long res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		String s = sc.next();
		status = "";
		turnOn = 0;
		for (int i = 0; i < N; i++) {
			if (s.charAt(i) == 'Y') {
				status = '1' + status;
				turnOn++;
			} else {
				status = '0' + status;
			}
		}
		int P = sc.nextInt();

		res = Integer.MAX_VALUE;
		bitMask(P - turnOn, Long.parseLong(status), 0);
		if (res == Integer.MAX_VALUE)
			res = -1;
		System.out.println(res);
	}

	private static void bitMask(int P, long mask, long value) {
		if (P <= 0) {
			if (res > value) {
				res = value;
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((mask & (1 << i)) != 0) { // 커버 된경우
			for (int j = 0; j < N; j++) {
					if ((mask & (1 << j)) == 0) {
						bitMask(P - 1, (mask | (1 << j)), value + matrix[i][j]);
					} 
				}
			}
			
		}
	}
}
