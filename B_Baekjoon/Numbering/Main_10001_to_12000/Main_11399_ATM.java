package Main_10001_to_12000;

import java.util.Arrays;
import java.util.Scanner;

public class Main_11399_ATM {
	static int N;
	static int[] list;
	static int sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		list = new int[N];
		sum = 0;
		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		Arrays.sort(list);
		for (int i = 0; i < N; i++) {
			sum += (list[i] *  (N-i));
		}
		System.out.println(sum);
	}
}
