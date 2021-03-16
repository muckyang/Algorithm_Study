package Study_1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3678_카탄의개척자 {
	static int N;
	static int katan[];
	static int map[][];
	static int dy[] = { -2, -1, -1, 2, 1, 1 };
	static int dx[] = { 0, -1, 1, 0, 1, -1 };
	static int su[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		su = new int[6];
		map = new int[2001][2001];
		katan = new int[10000];
		solve();
		N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			int k = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
			System.out.println(katan[k]);
		}
	}

	private static void solve() {
		int index = 0;
		int depth = 0;
		int x = 1000;
		int y = 1000;
		while (index < 10000) {
			depth++;
			int w = check(y, x);
			map[y][x] = w;

			katan[w]++;
			y--;
			x++;
			for (int rotate = 0; rotate < 6; rotate++) {
				for (int d = 0; d < depth; d++) {

				}

			}
		}
	}

	private static int check(int y, int x) {
		// TODO Auto-generated method stub
		return 0;
	}
}
