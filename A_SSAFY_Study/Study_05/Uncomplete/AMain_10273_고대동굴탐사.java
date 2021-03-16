package Uncomplete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
//DP , 위상정렬 
public class AMain_10273_고대동굴탐사 {
	static int T, N, E;
	static int pay[];
	static int sum[];
	static List<Link>[] link;
	static Queue<Cave> q;
	
	public static class Link {
		int to;
		int spend;

		public Link(int to,int spend) {
			this.to = to;
			this.spend = spend;
		}
	}
	
	public static class Cave {
		int x,y;
		Cave prev;
		public Cave() {
			
			this.prev = null;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			pay = new int[N];
			sum = new int[N];
			Arrays.fill(sum, Integer.MAX_VALUE);
			link = new LinkedList[N];
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				pay[i] = Integer.parseInt(st.nextToken());
				link[i] = new LinkedList<>();
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int spend = Integer.parseInt(st.nextToken());
			}
		}
	}
}
