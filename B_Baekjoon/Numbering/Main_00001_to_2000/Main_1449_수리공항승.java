package Main_00001_to_2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1449_수리공항승 {
	static int N, C;
	static int[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		list = new int[N];
		s = br.readLine();
		st = new StringTokenizer(s, " ");

		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list);
		int cover = -1;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (cover < list[i]) {
				cover = list[i] + C - 1;
				cnt++;
			}
		}
		System.out.println(cnt);

	}
}
