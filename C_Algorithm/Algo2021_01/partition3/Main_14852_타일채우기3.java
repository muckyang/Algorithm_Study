package partition3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//https://sudeky.tistory.com/124

public class Main_14852_타일채우기3 {
	static int N;
	static int cache[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cache = new int[N + 1];
		cache[1] = 2;
		System.out.println(solve(N));
	}

	private static int solve(int num) {
		int res = 0;
		if (num == 0)
			return 1;
		if (cache[num] != 0)
			return cache[num];
		if (num > 1) {
			res += solve(num - 2) * 3;
		}
		res += solve(num - 1) * 2;
		return cache[num] = res % 1000000007;
	}
}
