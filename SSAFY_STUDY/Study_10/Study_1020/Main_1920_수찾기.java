package Study_1020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1920_수찾기 {

	static int N, M;
	static int nlist[];
	static int mlist[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		nlist = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nlist[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		mlist = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			mlist[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nlist);
		
		for (int i = 0; i < M; i++) {
			int res = 0;
			res = binarySearch(mlist[i], 0, N-1);
			sb.append(res).append("\n");
		}
		System.out.println(sb.toString());

	}

	private static int binarySearch(int su, int start, int end) {
		int size = end - start +1 ;
		if(size ==0)
			return 0;
		int center = size / 2 + start;
		int mid = nlist[size / 2 + start];
		if (size % 2 == 0) {// 짝수개라면
			if (mid == su)
				return 1;
			else if (mid < su) {
				return binarySearch(su, center + 1, end);
			} else {
				return binarySearch(su, start, center - 1);
			}
		} else {// 홀수개라면
			if (mid == su)
				return 1;
			if (size == 1)
				return 0;
			if (mid < su) {
				return binarySearch(su, center + 1, end);
			} else {
				return binarySearch(su, start, center - 1);
			}
		}
	}
}
