package Study_0629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1389_케빈베이컨의6단계법칙 {
	static int N, M;
	static ArrayList<Integer> plist[];
	static int len[];
	static int v[];
	static Queue<Integer> q;
	static int res;

	public static class People {
		int index;
		int sum;

		public People(int index, int sum) {
			this.index = index;
			this.sum = sum;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		plist = new ArrayList[N];
		q = new LinkedList<>();
		len = new int[N];
		for (int i = 0; i < N; i++) {
			plist[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken()) - 1;
			int from = Integer.parseInt(st.nextToken()) - 1;
			plist[to].add(from);
			plist[from].add(to);
		}

		for (int i = 0; i < N; i++) {
			v = new int[N];
//			q.add();
//			solve(i);
		}
	}
}
