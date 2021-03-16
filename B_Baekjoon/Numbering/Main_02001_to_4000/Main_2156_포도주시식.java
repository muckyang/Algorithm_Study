package Main_02001_to_4000;

import java.util.Scanner;

public class Main_2156_포도주시식 {
	static int N;
	static int[] list;
	static int[] cache;
	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		list = new int[N];
		cache = new int[N];// 선택시 최대값
		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		if (N > 0)
			cache[0] = list[0];
		if (N > 1)
			cache[1] = list[0] + list[1];
		if (N > 2) {
			cache[2] = Math.max(list[1] + list[2], list[0] + list[2]);
			cache[2] = Math.max(cache[2], list[0] + list[1]);
		}
		
		for (int i = 3; i < N; i++) {
			cache[i] = Math.max(list[i] + cache[i-2], list[i] + list[i-1] + cache[i-3]);
			cache[i] = Math.max(cache[i], cache[i-1]);
		}
		int res = 0;
		for (int i = 0; i < N; i++) {
			if (res < cache[i])
				res = cache[i];
		}
		System.out.println(res);
	}
}
