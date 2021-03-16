package Algo12_Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2093_일곱난쟁이 {
	static int[] arr;
	static int[] list;
	static boolean check;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		list = new int[7];
		check = false;
		for (int i = 0; i < 9; i++)
			arr[i] = Integer.parseInt(br.readLine());
		solve(0, 0, 0);
		System.out.println(sb.toString());
	}

	private static void solve(int start, int sum, int cnt) {
		if (cnt == 7 && sum == 100) {
			Arrays.sort(list);
			for (int k : list)
				sb.append(k).append("\n");
			check = true;
			return;
		}
		if (check || cnt >= 7 || sum > 100)
			return;
		for (int i = start; i < 9; i++) {
			list[cnt] = arr[i];
			solve(i + 1, sum + arr[i], cnt + 1);
		}
	}
}