package Study_0208;

import java.util.Scanner;

public class Solution_D3_1234_비밀번호 {
	static int N;
	static String result;
	static String[] list;

	public static void func(int x, int y) {
		if (x < 0 || y >= N)
			return;
		for (int i = 0; i < N; i++) {
			if (list[x] == "" || list[y] == "")
				func(x + 1, y + 1);

			if (list[x] == list[y]) {
				list[x] = list[y] = "";
				func(x - 1, y + 1);
			}

			func(x + 1, y + 1);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		T = sc.nextInt();

		for (int test_case = 1; test_case <= 10; test_case++) {

			N = sc.nextInt();
			list = new String[N];
			String s = sc.next();

			for (int i = 0; i < N; i++) {
				list[i] = "" + s.charAt(i);
			}
			for (int i = 0; i < N; i++) {
				System.out.print(list[i] + " ");
			}
			System.out.println();
			func(0, 1);

			for (int i = 0; i < N; i++) {
				result = result + list[i];
			}

			System.out.println("#" + test_case + " " + result);
		}

	}
}
