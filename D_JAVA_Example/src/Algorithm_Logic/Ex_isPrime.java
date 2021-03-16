package Algorithm_Logic;

import java.util.Scanner;

// 소수 판별
// N이 2 ~ Math.sqrt(N) 으로 나누어 떨어진다면 N은 소수가아니다.

public class Ex_isPrime {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int N = sc.nextInt();
		System.out.println(isPrime(N));
	}

	private static String isPrime(int n) {
		for (int i = 2; i < (int) Math.sqrt(n); i++) {
			if (n % i == 0)
				return n + "은 소수가 아닙니다.";
		}
		return n + "은 소수가 맞습니다.";
	}

}
