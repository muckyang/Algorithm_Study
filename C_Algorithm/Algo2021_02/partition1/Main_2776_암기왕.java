package partition1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_2776_암기왕 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			HashSet<Integer>hs = new HashSet<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				hs.add(Integer.parseInt(st.nextToken()));
			}
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				if(hs.contains(Integer.parseInt(st.nextToken()))) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
			}
		}
		System.out.println(sb.toString());
	}
}
