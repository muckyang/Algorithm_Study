package Study_1020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10816_숫자카드2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int []nlist=new int[20000001];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nlist[Integer.parseInt(st.nextToken())+10000000]++;
		}
		st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			sb.append(nlist[Integer.parseInt(st.nextToken())+10000000]).append(" ");
		System.out.println(sb.toString());
	}
}
