package partition4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14717_앉았다 {
	static int A, B;
	static int select[];
	static boolean[] card;
	static int point;
	static double win, all;

	static double res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		card = new boolean[20];
		card[A - 1] = true;
		card[B + 9] = true;
		point = solve(A, B);
		select = new int[2];
		all = 0;
		win = 0;
		permu(0, 0);
		res = win / all;
		System.out.printf("%.3f", res);
	}

	private static void permu(int cnt, int now) {
		if (cnt == 2) {
			all++;
			if (solve(select[0], select[1]) < point)
				win++;
			return;
		}
		for (int i = now; i < 20; i++) {
			if (!card[i]) {
				card[i] = true;
				select[cnt] = (i % 10) + 1;
				permu(cnt + 1, i + 1);
				card[i] = false;
			}
		}
	}

	private static int solve(int y, int x) {
		if (y == x) {
			return y * 10 + y;
		}
		return (y + x) % 10;
	}

}
