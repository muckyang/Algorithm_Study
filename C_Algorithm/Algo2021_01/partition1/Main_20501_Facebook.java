package partition1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_20501_Facebook {
	static ArrayList<Integer>[] al;
	static int N, Q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		al = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			al[i] = new ArrayList<>();
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				al[i].add(s.charAt(j) - '0');
			}
		}

		Q = Integer.parseInt(br.readLine());
		for (int i = 0; i < Q; i++) {
			int cnt = 0;
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			for (Integer k : al[from]) {
				if (al[k].get(to) == 1)
					cnt++;
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());

	}
}
