package Uncomplete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AMain_5022_연결 {
	static int N, M;
	static int map[][];
	static int[] x;
	static int[] y;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		res = Integer.MAX_VALUE;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		solve();
		System.out.println(res == Integer.MAX_VALUE ? "IMPOSSIBLE" : res);
	}

	private static void solve() {
		// TODO Auto-generated method stub
		
	}
}