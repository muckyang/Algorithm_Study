package partition2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_02293_동전1 {
	static int N, K;
	static int[] list;
	static int[][] cache;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new int[N];
		cache = new int[10001][N];
		Arrays.fill(cache[0], 1);
		for(int i =1; i< 10001;i++)
			Arrays.fill(cache[i], -1);
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(solve(K, 0));
	}

	private static int solve(int target, int cnt) {
		if (cache[target][cnt] != -1)
			return cache[target][cnt];
		int res = 0;
		for (int i = cnt; i < N; i++) {
			if (target - list[i] >= 0)
				res += solve(target - list[i], i);
		}

		return cache[target][cnt] = res;
	}
}
