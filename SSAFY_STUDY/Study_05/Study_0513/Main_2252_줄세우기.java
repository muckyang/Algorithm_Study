package Study_0513;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2252_줄세우기 {
	static int N, M;
	static int topo[];
	static Queue<Integer> q;
	static List<Integer>[] list;
	static StringBuilder sb ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		topo = new int[N];
		q = new LinkedList<>();

		list = new LinkedList[N];
		for (int i = 0; i < N; i++)
			list[i] = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			list[s].add(e);
			topo[e]++;
		}
		for (int i = 0; i < N; i++) {
			if (topo[i] == 0) {
				q.add(i);
				sb.append(i+1).append(" ");
				topo[i]= -1;
			}
		}
		
		solve();
		System.out.println(sb.toString());
	}

	private static void solve() {
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0 ; i  < size ; i++) {
				Integer k = q.poll();
				for(Integer l : list[k]) {
					topo[l]--;
					if (topo[l] == 0) {
						q.add(l);
						sb.append(l+1).append(" ");
						topo[l]= -1;
					}
				}
			}
		}
	}

}
