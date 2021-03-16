package Study_0311;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1463_1로만들기 {
	static int N, res;
	static int v[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		res = Integer.MAX_VALUE;
		N = sc.nextInt();
		v = new int[N];
		Arrays.fill(v, Integer.MAX_VALUE);
		solve(N, 0);
		System.out.println(res);
	}

	private static void solve(int num, int count) {
		if (num == 1) {
			if (res > count)
				res = count;
			return;
		}
		if (num % 3 == 0 && count < v[num / 3]) {
			v[num / 3] = count;
			solve(num / 3, count + 1);
		}
		if (num % 2 == 0 && count < v[num / 2]) {
			v[num / 2] = count;
			solve(num / 2, count + 1);
		}
		if (count < v[num - 1]) {
			v[num - 1] = count;
			solve(num - 1, count + 1);
		}
	}
}
