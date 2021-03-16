package Algo12_Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1476_날짜계산 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E, S, M;
		E = Integer.parseInt(st.nextToken())-1;
		S = Integer.parseInt(st.nextToken())-1;
		M = Integer.parseInt(st.nextToken())-1;

		for (int i = 0; i <= 15 * 28 * 19; i++) {
			if (i % 15 == E  && i % 28 == S && i % 19 == M) {
				System.out.println(i+1);
				break;
			}
		}

	}
}
