package Study_0322;

import java.util.Scanner;

public class Main_3943_헤일스톤수열 {
	static int N, num;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int tc = 0; tc < N; tc++) {
			num = sc.nextInt();
			max = num;
			solve(num);
			System.out.println(max);
		}
	}

	private static void solve(int n) {
		if (max < n)
			max = n;
		if (n == 1)
			return;
		else {
			if (n % 2 == 0) {
				solve(n / 2);
			} else {
				solve(n * 3 + 1);
			}
		}
	}
}
