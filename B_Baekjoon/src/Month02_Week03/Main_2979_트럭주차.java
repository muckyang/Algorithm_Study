package Month02_Week03;

import java.util.Scanner;

public class Main_2979_트럭주차 {
	static int A, B, C;
	static int[] list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt() * 2;
		C = sc.nextInt() * 3;
		list = new int[101];
		for (int i = 0; i < 3; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			for (int k = s; k < e; k++) {
				list[k]++;
			}
		}

		int price = 0;
		for (int i = 1; i < 101; i++) {
			if(list[i] == 1)
				price+=A;
			if(list[i] == 2)
				price+=B;
			if(list[i] == 3)
				price+=C;
		}

		System.out.println(price);
		
	}
}
