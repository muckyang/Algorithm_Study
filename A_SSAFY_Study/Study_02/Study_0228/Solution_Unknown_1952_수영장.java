package Study_0228;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_Unknown_1952_수영장 {
	static int T, res;
	static int day, month, quarter, year;
	static int[] goCount;
	static int[] qlist;
	static int[] payMonth;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			day = sc.nextInt();
			month = sc.nextInt();
			quarter = sc.nextInt();
			year = sc.nextInt();
			res = year;
			int sumday = 0;
			goCount = new int[12];
			payMonth = new int[12];
			for (int i = 0; i < 12; i++) {
				goCount[i] = sc.nextInt();
				sumday += goCount[i];
				payMonth[i] = goCount[i] * day;
			}

			sumday *= day;
			if (res > sumday)
				res = sumday;

			for (int i = 0; i < 12; i++) {
				if (payMonth[i] > month) {
					payMonth[i] = month;
				}
			}

			qlist = new int[4];
			Arrays.fill(qlist, Integer.MAX_VALUE);
			combi(0, 0);
			System.out.println("#" + test_case + " " + res);
		}
	}

	private static void combi(int start, int count) {
		if (count > 4)
			return;

		int sumpay = 0;
		int c = 0;
		for (int i = 0; i < 12; i++) {
			if (qlist[c] == i) {
				c++;
				sumpay += quarter;
				i += 2;
				continue;
			}
			sumpay += payMonth[i];
		}
		if (sumpay < res)
			res = sumpay;
		// 금액확인

		for (int i = start; i < 12; i++) {
			qlist[count] = i;
			combi(i + 3, count + 1);
			qlist[count] = Integer.MAX_VALUE;
		}

	}
}
