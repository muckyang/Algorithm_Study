package Study_0208;

import java.util.Scanner;

public class Main_1592_영식이와친구들 {
	static int[] count;// count [0] =1 로 시작함
	static int N, M, L;// 사람수 , M번 받은사람이 생기면 종료 , 받고 횟수 홀수이면 시계방향으로 L위치로 던짐
	static int result;

	public static void func(int getN) {// 받은사람 인자값
		int t;

		if (count[getN] % 2 == 1) // 시계방향
			t = 1;
		else // 반시계방향
			t = -1;

		int k = getN + (L * t);
		//System.out.println(getN + "  t: " + t + "   k : " + k);
		if (getN >= 0 && getN < N && count[getN] == M)// 받은수 채워지면 리턴
			return;

		if (k < 0) {
			k=N+k;
			count[k]++;
			result++;
			if (count[k] == M)
				return;
			func(k);
		} else if (N <= k) {
			k=k-N;
			count[k]++;
			result++;
			if (count[k] == M)
				return;
			func(k);
		} else {
			count[k]++;
			result++;
			if (count[k] == M)
				return;
			func(k);

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();
		result = 0;
		count = new int[N];
		count[0] = 1;

		func(0);// 받은사람 인자값
		System.out.println(result);
	}
}
