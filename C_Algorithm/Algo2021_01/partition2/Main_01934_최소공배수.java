package partition2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_01934_최소공배수 {
	static int T, A, B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(st.nextToken());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			sb.append(A*B/solve()).append("\n");
		}
		System.out.println(sb.toString());
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
			}else {
				return a;
			}
			
		}
	}
}
