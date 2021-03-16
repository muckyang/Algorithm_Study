package Study_0310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.SynchronousQueue;

public class Main_1149_RGB거리 {
	static int N;
	static int[][] rgb;
	static int[][] dp;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s = br.readLine();
		N = Integer.parseInt(s);
		rgb = new int[N][3];
		dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		dp[0][0] = rgb[0][0];
		dp[0][1] = rgb[0][1];
		dp[0][2] = rgb[0][2];

		for (int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + rgb[i][2];
		}
		min = Math.min(dp[N - 1][0], dp[N - 1][1]);
		min = Math.min(min, dp[N - 1][2]);
		System.out.println(min);
	}
}
