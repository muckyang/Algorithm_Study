package Uncomplete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AMain_2878_캔디캔디 {
	static long M;
	static int N, cnt;// 캔디 , 사람

	static long div;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Long.parseLong(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		cnt = 1;
		div = two64(2L);
		System.out.println(div);
	}

	private static long two64(long su) {
		if (cnt > 64)
			return 1L;
		System.out.println(cnt);
		cnt++;
		return two64(su) * 2;
	}
}
