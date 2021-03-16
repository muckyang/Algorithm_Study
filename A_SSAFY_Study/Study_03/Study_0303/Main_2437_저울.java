package Study_0303;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2437_저울 {
	static int N;
	static int[] list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		list = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		Arrays.sort(list);
		int res = 0;
		if (list[0] != 1) {
			res = 1;
			System.out.println(res);
			return;
		}

		int sum = 1;
		for (int i = 1; i < N; i++) {
			if(sum+1 >=list[i]) {
				sum+=list[i];
			}else {
				break;
			}
		}

		System.out.println(sum + 1);
	}
}
