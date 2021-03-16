package Pass_Feb_Week03;

import java.util.Scanner;

public class Solution_D3_5515_2016년요일맞추기 {
	static int T;
	static int month[] = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int sm, sd, day;
			sm = sd = 1;
			day = 4;
			int em, ed;
			em = sc.nextInt();
			ed = sc.nextInt();
			int pass = 0;
			for (int i = sm; i < em; i++) {
				switch (em) {
				case 2:
					pass += 29;
					break;
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					pass += 31;
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					pass += 30;
					break;
				default:
					break;
				}
			}
			pass = (sd + pass - 1 + day) % 7;
			System.out.println("#" + test_case + " " + pass);
		}
	}
}
