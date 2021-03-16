package Algo12_Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20167_꿈틀꿈틀호석애벌레 {
	static int N, K;
	static int energy[];
	static int cache[];
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		energy = new int[N];
		cache = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			energy[i] = Integer.parseInt(st.nextToken());
		}
		res = solve(0);
		System.out.println(res);

	}

	private static int solve(int now) {
		// 먹을 때
		if(now > N)
			return 0;
		int sum = 0;
		int next = now;
		for (int k = now; k < N; k++) {
			sum += energy[k];
			if (sum >= K)
				break;
			next++;
		}
		int var1 = -1;
		if (sum >= K)
			var1 = solve(next + 1) + sum - K;
		// 안먹을 때
		int var2 = solve(now + 1);
		
		return Math.max(var1, var2);

	}

}
