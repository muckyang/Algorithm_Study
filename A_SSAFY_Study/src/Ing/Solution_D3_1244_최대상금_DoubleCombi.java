package Ing;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1244_최대상금_DoubleCombi {

	static int[] list;
	static int T;
	static String number;
	static int R, max;

	// 같은수가 존재하는지 체크
	public static boolean isDupl(int[] list) {
		int[] arr = new int[10];
		for (int i = 0; i < list.length; i++) {
			arr[list[i]]++;
			if (arr[list[i]] > 1)
				return true;
		}
		return false;
	}

	public static void nCr(int N, int R, int start, int count) {
		if (R == count) {
			max = Math.max(max, Integer.parseInt(Arrays.toString(list)));
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (list[j] > list[i]) {
					for (int d = start; d < N; d++) {
						int temp = list[i];
						list[i] = list[j];
						list[j] = temp;
						nCr(N, R, d, count + 1);
						temp = list[i];
						list[i] = list[j];
						list[j] = temp;

					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			number = sc.next();
			max = Integer.MIN_VALUE;
			int N = number.length();

			list = new int[N];

			for (int i = 0; i < N; i++) {
				list[i] = number.charAt(i) - 48;
			}

			R = sc.nextInt();
			nCr(N, R, 0, 0);

			System.out.println("#" + test_case + " " + max );
		}
	}

}

//INPUT
//10
//123 1
//2737 1
//757148 1
//78466 2
//32888 2
//777770 5
//436659 2
//431159 7
//112233 3
//456789 10

//OUTPUT
//#1 321
//#2 7732
//#3 857147
//#4 87664
//#5 88832
//#6 777770
//#7 966354
//#8 954311
//#9 332211
//#10 987645
