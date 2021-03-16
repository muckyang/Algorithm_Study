package partition2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//solution!! 
public class Main_20544_공룡게임 {
	static int N;
	static int cache[][][][];
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		res = 0;
		cache = new int[2][3][3][N];// 2유무, 연속여부 (0,1,2) , 이전높이 , 위치

		System.out.println(solve(0, 0, 0, 0));
	}

	private static int solve(int two, int linear, int before, int num) {
		if (num == N - 1) {
			if (two > 0)
				return 1;
			else
				return 0;
		}
		if (cache[two][linear][before][num] != 0)
			return cache[two][linear][before][num];
		int cnt = 0;
		cnt += solve(two, 0, 0, num + 1);
		cnt %= 1000000007;
		if (linear <= 1) {
			cnt += solve(two, linear + 1, 1, num + 1);
			cnt %= 1000000007;
			if (before < 2) {
				cnt += solve(1, linear + 1, 2, num + 1);
				cnt %= 1000000007;
			}
		}
		return cache[two][linear][before][num] = cnt % 1000000007;
	}
}
