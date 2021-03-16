package Study_0502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14891_톱니바퀴 {

	static int K;
	static int gear[][];
	static int spin[];
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gear = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			for (int j = 0; j < 8; j++) {
				char c = s.charAt(j);
				gear[i][j] = c - '0';
			}
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		for (int k = 1; k <= K; k++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			spin = new int[4];
			spin[0] = spin[1] = spin[2] = spin[3] = 0;
			spin[index] = d;
			rcheck(index, d);
			lcheck(index, d);
			for (int i = 0; i < 4; i++) {
				if (spin[i] != 0) {
					spin(i, spin[i]);
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			if (gear[i][0] == 1) {
				sum += (1 << i);

			}
		}
		System.out.println(sum);
	}
	private static void lcheck(int index, int d) {
		if (index == 0 || gear[index - 1][2] == gear[index][6]) {
			return;
		}
		spin[index - 1] = (d == 1 ? -1 : 1);
		lcheck(index - 1, (d == 1 ? -1 : 1));
	}

	private static void rcheck(int index, int d) {
		if (index == 3 || gear[index + 1][6] == gear[index][2]) {
			return;
		}
		spin[index + 1] = (d == 1 ? -1 : 1);
		rcheck(index + 1, (d == 1 ? -1 : 1));

	}

	private static void spin(int index, int d) {
		if (d == 1) { // 정방향회전
			int temp = gear[index][7];
			for (int i = 6; i >= 0; i--)
				gear[index][i + 1] = gear[index][i];
			gear[index][0] = temp;
		} else if (d == -1) {
			int temp = gear[index][0];
			for (int i = 0; i < 7; i++)
				gear[index][i] = gear[index][i + 1];
			gear[index][7] = temp;
		}
	}
}
