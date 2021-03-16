package Study_0626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2819_상근이의로봇 {
	static int N, O;
	static int sx, sy;
	static StringBuilder sb;
	static int xlist[];
	static int ylist[];

	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static long sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		xlist = new int[N];
		ylist = new int[N];
		O = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		sum = 0L;
		sx = sy = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			xlist[i] = Integer.parseInt(st.nextToken());
			ylist[i] = Integer.parseInt(st.nextToken());
		}
		String s = br.readLine();
		for (int i = 0; i < O; i++) {
			char c = s.charAt(i);
			int num = -1;
			if (c == 'S') {
				num = 0;
			} else if (c == 'J') {
				num = 1;
			} else if (c == 'I') {
				num = 2;
			} else if (c == 'Z') {
				num = 3;
			}
		}
		
	}
}
