package Study_0926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//7
//A B C
//B D .
//C E F
//E . .
//F . G
//D . .
//G . .
public class Main_1991_트리순회 {
	static int N;
	static Edge[] list;

	public static class Edge {
		String word;
		Edge prev;
		Edge next;

		public Edge(String word) {
			this.word = word;

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String word = st.nextToken();
			String prev = st.nextToken();
			String next = st.nextToken();
			list[i] = new Edge(word);
		}
	}
}
