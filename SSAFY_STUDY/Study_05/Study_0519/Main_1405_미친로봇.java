package Study_0519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1405_미친로봇 {
	static int N;
	static boolean v[][];
	static double per[];
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static double sum;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		per = new double[4];
		v = new boolean[30][30];
		v[15][15] = true;
		sum = 0.0;
		N = Integer.parseInt(st.nextToken());
		
		for (int d = 0; d < 4; d++)
			per[d] = (Integer.parseInt(st.nextToken()) * 1.0) / 100;
		
		solve(15, 15, 1.0, 0);
		System.out.println(sum);
	}

	private static void solve(int x, int y, double percent, int cnt) {
		if (cnt == N) {
			sum += percent;
			return;
		}
		for (int d = 0; d < 4; d++) {
			int ix = x + dx[d];
			int jy = y + dy[d];
			
			if (!v[ix][jy]) {
				v[ix][jy] = true;
				solve(ix, jy, percent * per[d], cnt + 1);
				v[ix][jy] = false;
			}
		}
	}
}