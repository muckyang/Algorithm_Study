package partition2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_02609_최대공약수와최소공배수 {
	static int A, B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		int res = solve();
		System.out.println(res);
		System.out.println(A * B / res);
	}

	private static int solve() {
		int a = A;// 작은수로 만들기
		int b = B;
		while (true) {
			if (a > b) {
				int temp = a;
				a = b;
				b = temp;
			}
			if (b % a != 0) {
				b = b % a;
			} else {
				return a;
			}

		}
	}
}
