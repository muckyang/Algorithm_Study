package Algorithm_Logic;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

// 약수 갯수 구하기
// 1 ~ Math.sqrt(N)까지의 수중에 나누어 떨어진다면 2개씩 더해줌
// 단, 제곱수인경우 1개만 더해준다.  
public class Ex_measureCount {
	static Scanner sc;
	static TreeSet<Integer> ts;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		ts = new TreeSet<>();
		System.out.print("정수를 입력하세요 : ");
		int N = sc.nextInt();
		System.out.println(divideCount(N));
		System.out.print("약수 리스트: ");
		for(Integer k : ts) {
			System.out.print(k + " ");
		}
	}

	private static String divideCount(int n) {
		int cnt = 0;
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				cnt++;
				ts.add(i);
				if (i * i != n) {
					ts.add(n/i);
					cnt++;
				}
			}
		}

		return "약수의 갯수는 " + cnt + "개 입니다.";

	}
}
