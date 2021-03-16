package Algo12_Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//메모리 : 43908kb, 시간: 352ms
public class Main_20181_꿈틀꿈틀호석애벌레_효율성 {
	static int N, K;
	static long energy[];
	static EndPoint[] ep;
	static long cache[];
	static long res;

	public static class EndPoint {
		int index;
		long E;
		public EndPoint(int index, long E) {
			this.index = index;
			this.E = E;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		energy = new long[N];
		cache = new long[N];
		ep = new EndPoint[N];

		st = new StringTokenizer(br.readLine());
		int stp = 0;
		int sumE = 0;
		for (int i = 0; i < N; i++) {
			ep[i] = new EndPoint(0, 0);
			cache[i] = -1;
			energy[i] = Long.parseLong(st.nextToken());
			sumE += energy[i];
			while (sumE >= K) {
				ep[stp].index = i;
				ep[stp].E = sumE - K;
				sumE -= energy[stp];
				stp++;
			}
		}
		for(int i = 0 ; i < N;i++)
		res = solve(0);
		System.out.println(res);

	}

	private static long solve(int now) {
		// 먹을 때
		if (now >= N)
			return 0;
		if (cache[now] >= 0)
			return cache[now];
		
		long var1 = 0;
		if (ep[now].E > 0) {
			EndPoint next = ep[now];
			var1 = solve(next.index + 1) + next.E;
		}
		// 안먹을 때
		long var2 = solve(now + 1);

		return cache[now] = Math.max(var1, var2);

	}

}
