package Algo12_Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865_평범한배낭 {
	static int N, K;
	static int cache[];
	static int w[];
	static int v[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		w = new int[N+1];
		v = new int[N+1];
		cache = new int[1+K];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
	     for (int i = 1; i <= N; i++) {
	            for (int j = K; j >= w[i]; j--) {
	                if (cache[j] < cache[j-w[i]] + v[i]) {
	                	cache[j] = cache[j-w[i]] + v[i];
	                }
	            }
	        }
		System.out.println(cache[K]);
		
	}

	private static int solve(int index, int weight) {
		// TODO Auto-generated method stub
		return 0;
	}
}
