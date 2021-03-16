package Algo12_Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15658_연산자끼워넣기2 {
	static int N;
	static int[] key;
	static int[] num;
	static int[] temp;
	static int min, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		num = new int[N];
		temp = new int[N - 1];
		key = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			key[i] = Integer.parseInt(st.nextToken());
		}
		solve(0);
		System.out.println(max);
		System.out.println(min);
	}

	private static void solve(int cnt) {
		if (cnt == N - 1) {
			int su = num[0];
			for (int i = 0; i < N - 1; i++) {
				if (temp[i] == 0) {
					su += num[i + 1];
				} else if (temp[i] == 1) {
					su -= num[i + 1];
				} else if (temp[i] == 2) {
					su *= num[i + 1];
				} else {
					if (num[i + 1] == 0)
						return;
					boolean b = false;
					if (su > 0) {
						b = true;
					}
					su = Math.abs(su) / num[i + 1];
					if (!b)
						su *= -1;
				}
			}
			max = Math.max(max, su);
			min = Math.min(min, su);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (key[i] > 0) {
				temp[cnt] = i;
				key[i]--;
				solve(cnt + 1);
				key[i] ++;
			}
		}
	}

}
