package Study_0504;

import java.util.Scanner;

public class Algo1_대전_6_김영남 {
	static int T, Money, time;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			Money = sc.nextInt();
			time = sc.nextInt();
			int sum = Money * time;
			
			int a = sum / 400;//4달러로 줄 수 있는것 다줌
			sum %= 400;// 4달러로 나눈 나머지로 변경
			
			int b = sum / 100; // 1달러로 줄 수 있는것 다줌
			sum %= 100;// 1달러로 나눈 나머지로 변경
			int c = sum / 10; // 10 센트로 줄수 있는것 다줌
			sum %= 10;// 10센트로 나눈 나머지로 변경
			if (sum == 0)// 남은값이 0으로 떨어질때
				System.out.println("#" + t + " " + a + " " + b + " " + c);
			else// 나머지가 남은경우 
				System.out.println("#" + t + " " + -1);

		}
	}
}
