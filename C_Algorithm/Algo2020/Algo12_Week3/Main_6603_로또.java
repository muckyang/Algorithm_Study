package Algo12_Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603_로또 {
	static int N;
	static int arr[];
	static int temp[];
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N];
			temp = new int[N];
			if (N == 0)
				break;

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			solve(0, 0);
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}

	private static void solve(int start, int cnt) {
		if (cnt == 6) {
			for (int i = 0; i < cnt; i++) {
				sb.append(temp[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < N; i++) {
			temp[cnt] = arr[i];
			solve(i + 1, cnt + 1);
		}

	}
}
