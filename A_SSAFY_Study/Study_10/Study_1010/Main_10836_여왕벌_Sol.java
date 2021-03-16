package Study_1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10836_여왕벌_Sol {
	static int N, M;
	static int map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		int[] upsu = new int[3];
		int[] add = new int[N * 2 - 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			upsu[0] = Integer.parseInt(st.nextToken());
			upsu[1] = Integer.parseInt(st.nextToken());
			upsu[2] = Integer.parseInt(st.nextToken());

			int cnt = 0;
			int index = 0;
			while (cnt < 3) {
				if (upsu[cnt] == 0) {
					cnt++;
					continue;
				}

				add[index] += cnt;
				index++;
				upsu[cnt]--;
			}
		}
		for (int i = 0; i < N * 2 - 1; i++) {
			if (i >= N) {
				for (int k = 0; k < N; k++) {
					map[k][i - N + 1] += add[i];
				}

			} else {
				map[i][0] += add[i];
			}
		}
		resPrint();

	}

	public static void resPrint() {
		StringBuilder sb = new StringBuilder();
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]+1).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
