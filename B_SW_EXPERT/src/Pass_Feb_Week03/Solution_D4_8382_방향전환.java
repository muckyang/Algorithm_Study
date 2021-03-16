package Pass_Feb_Week03;

import java.util.Scanner;

public class Solution_D4_8382_방향전환 {
	static int T;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int sx = sc.nextInt();
			int sy = sc.nextInt();
			int ex = sc.nextInt();
			int ey = sc.nextInt();

			int valuex = sx - ex;
			int valuey = sy - ey;
			int c = Math.abs(Math.abs(valuex) - Math.abs(valuey));
			if (c >= 2) {
				int result = 0;
				if (c % 2 == 0) {
					result = c + Math.abs(valuex) + Math.abs(valuey);
				} else {
					result = c + Math.abs(valuex) + Math.abs(valuey) - 1;
				}

				System.out.println("#" + test_case + " " + result);
			} else {
				System.out.println("#" + test_case + " " + (Math.abs(valuex) + Math.abs(valuey)));
			}

		}
	}
}
