package Algo12_Week2;
//17848KB , 296ms
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20166_문자열지옥에빠진호석_DP {
	static int N, M, K;
	static char[][] map;
	static int[][][] dp;
	static int dy[] = { 0, -1, 0, 1, 1, 1, -1, -1 };
	static int dx[] = { -1, 0, 1, 0, 1, -1, -1, 1 };
	static String s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			s = br.readLine();

			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < K; i++) {
			s = br.readLine();
			dp = new int[N][M][s.length()];
			for (int k = 0; k < N; k++)
				for (int k2 = 0; k2 < M; k2++)
					Arrays.fill(dp[k][k2], -1);
			int sum = 0;
			for (int jy = 0; jy < N; jy++) {
				for (int ix = 0; ix < M; ix++) {
					sum += solve(jy, ix, 0);
				}
			}
			sb.append(sum).append("\n");

		}
		System.out.println(sb.toString());

	}

	private static int solve(int y, int x, int su) {
		int sum = 0;
		if(dp[y][x][su]!=-1)
			return dp[y][x][su];
		if (s.charAt(su) != map[y][x])
			return 0;
		if (s.length() - 1 == su)
			return 1;
		
		for (int d = 0; d < 8; d++) {
			int jy = y + dy[d];
			int ix = x + dx[d];
			if (jy == -1)
				jy = N - 1;
			if (jy == N)
				jy = 0;
			if (ix == -1)
				ix = M - 1;
			if (ix == M)
				ix = 0;
			sum += solve(jy, ix, su + 1);
		}
		return dp[y][x][su] = sum;

	}
}
