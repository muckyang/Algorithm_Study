package partition1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9663_N_Queen {
	static int N;
	static int[] xarr;
	static int[] yarr;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		xarr = new int[N];
		yarr = new int[N];
		res = 0;
		solve(0);
		System.out.println(res);
	}

	private static void solve(int cnt) {
		if (cnt == N) {
			res++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (check(cnt, i)) {
				yarr[cnt] = cnt;
				xarr[cnt] = i;
				solve(cnt + 1);
			}
		}
	}

	private static boolean check(int y, int x) {
		for (int k = 0; k < y; k++) {
			int qy = yarr[k];
			int qx = xarr[k];
			int absy = Math.abs(y - qy);
			int absx = Math.abs(x - qx);
			if (absy == absx || y == qy || x == qx)
				return false;
		}
		return true;
	}

}
