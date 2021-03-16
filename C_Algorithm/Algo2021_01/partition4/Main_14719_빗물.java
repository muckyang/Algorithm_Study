package partition4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14719_빗물 {
	static int H, W;
	static int map[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		map = new int[W];
		for (int i = 0; i < W; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		int high = map[0];
		int dist = 0;
		int res = 0;
		int cnt = 0;
		while (cnt < W-1) {
			cnt++;
			int next = map[cnt];
			if (next >= high) {
				high = next;
				dist = cnt;
			} else {
				res += high - next;
				if (cnt == W - 1) {
					int backmax = next;
					while (true) {
						backmax = Math.max(backmax, map[cnt]);
						res -= high - backmax;
						cnt--;
						if (cnt == dist)
							break;
					}
					break;
				}
			}
		}
		System.out.println(res);
	}
}
