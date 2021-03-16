package partition1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_02479_두용액 {
	static int N;
	static int arr[];
	static int absMin;
	static int ans1, ans2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		absMin = Integer.MAX_VALUE;
		Arrays.sort(arr);
		ans1 = arr[0];
		ans2 = arr[N - 1];
		absMin = Math.abs(ans1 + ans2);
		int sp = 0;
		int ep = N - 1;
		while (ep - sp > 1) {
			int comp1 = Math.abs(arr[sp + 1] + arr[ep]);
			int comp2 = Math.abs(arr[sp] + arr[ep - 1]);
			if (comp1 > comp2) {
				ep--;
				if (absMin > comp2) {
					ans1 = arr[sp];
					ans2 = arr[ep];
					
					absMin = comp2;
				}
			} else {
				sp++;
				if (absMin > comp1) {
					ans1 = arr[sp];
					ans2 = arr[ep];
					absMin = comp1;
				}
			}

		}
		System.out.println(ans1 + " " + ans2);

	}
}
