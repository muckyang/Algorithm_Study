package todolist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12869_뮤탈리스크 {
	static int N;
	static int hp[];
	static int demage[] = { 9, 3, 1 };
	static int target[][] = { { 0, 1, 2 }, { 0, 2, 1 }, { 1, 2, 0 }, { 1, 0, 2 }, { 2, 0, 1 }, { 2, 1, 0 } };// 6*3
	static int cache[][][][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		hp = new int[N];
		cache = new int[61][61][61][30];/// A,B,C/타격수
		for (int i = 0; i < N; i++)
			hp[i] = Integer.parseInt(st.nextToken());
		
		System.out.println(solve(hp[0],hp[1],hp[2],0));
	}

	public static int solve(int a, int b, int c, int cnt) {
		if (a < 0)
			a = 0;
		if (b < 0)
			b = 0;
		if (c < 0)
			c = 0;
		if (a + b + c == 0)
			return cnt = cache[a][b][c][cnt];
		if (cache[a][b][c][cnt] != 0)
			return cache[a][b][c][cnt];
		int res = Integer.MAX_VALUE;
		for (int d = 0; d < 6; d++) {
			int ap = a - demage[target[d][0]];
			int bp = b - demage[target[d][1]];
			int cp = c - demage[target[d][2]];
			res = Math.min(solve(ap, bp, cp, cnt + 1), res);
		}
		return res = cache[a][b][c][cnt];
	}
}
