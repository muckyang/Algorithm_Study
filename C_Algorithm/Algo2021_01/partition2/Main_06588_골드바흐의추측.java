package partition2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_06588_골드바흐의추측 {
	static int K;
	static boolean c[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		c = new boolean[1000000 + 1];
		c[0] = c[1] = c[2] = true;
		solve();
		while (true) {
			K = Integer.parseInt(br.readLine());
			if (K == 0)
				break;
			int a = 0;
			int temp = 3;
			while (K > temp) {
				if (!c[K - temp] && !c[temp]) {
					a = K - temp;
					break;
				}
				temp+=2;
			}
			if (a != 0)
				sb.append(K).append(" = ").append(temp).append(" + ").append(a).append("\n");
			else
				sb.append("Goldbach's conjecture is wrong.\n");
		}
		System.out.println(sb.toString());
	}

	private static void solve() {
		for (int i = 3; i <= 1000; i++) {
			if (!c[i])
				for (int k = i + i; k <=1000000; k += i) {
					c[k] = true;
				}
		}
	}
}
