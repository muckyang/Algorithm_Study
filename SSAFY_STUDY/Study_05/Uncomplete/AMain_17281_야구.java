package Uncomplete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AMain_17281_야구 {
	static int N;
	static int list[][];
	static int player[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		list = new int[N][9];
		player = new int[9];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		player[0] = 4;
		solve(1, 8);

	}

	private static void solve(int cnt, int flag) {
		if (cnt == 9) {
			int outc = 0;
			Queue<Integer> q = new LinkedList<>();
			
			
					
			return;
		}
		for (int i = 1; i <= 9; i++) {
			if (player[cnt] == 0 && (flag & (1 << i - 1)) == 0) {
				player[cnt] = i;
				solve(cnt + 1, (flag | (1 << i - 1)));
				player[cnt] = 0;
			}
		}
	}
}
