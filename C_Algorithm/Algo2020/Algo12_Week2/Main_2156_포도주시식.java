package Algo12_Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2156_포도주시식 {
	static int wine[];
	static int cache[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		wine = new int[N];
		cache = new int[N];
		for (int i = 0; i < N; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		if (N > 0)
			cache[0] = wine[0];
		if (N > 1)
			cache[1] = wine[0] + wine[1];
		if (N > 2) {
			cache[2] = Math.max(wine[1] + wine[2], wine[0] + wine[2]);
			cache[2] = Math.max(cache[2], wine[0] + wine[1]);
		}

		for (int i = 3; i < N; i++) {
			cache[i] = Math.max(wine[i] + cache[i - 2], wine[i] + wine[i - 1] + cache[i - 3]);
			cache[i] = Math.max(cache[i], cache[i - 1]);
		}
		int res = 0;
		for (int i = 0; i < N; i++) {
			if (res < cache[i])
				res = cache[i];
		}
		System.out.println(res);
	}
}
