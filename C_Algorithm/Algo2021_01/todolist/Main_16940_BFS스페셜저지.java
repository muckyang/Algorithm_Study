package todolist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16940_BFS스페셜저지 {
	static int N;
	static StringTokenizer st;
	static LinkedList<Integer>[] ls;
	static LinkedList<LinkedList<Integer>> depthlist;
	static int [][] deptharr;
	static boolean v[];
	static Queue<Integer> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		ls = new LinkedList[N + 1];
		depthlist = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			ls[i] = new LinkedList<>();
		}
		for (int i = 1; i < N; i++) { // N-1 개의 간선
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			ls[from].add(to);
			ls[to].add(from);
		}
		v = new boolean[N + 1];
		q = new LinkedList<>();
		q.add(1);
	
		getAnswer();
		deptharr = new int [depthlist.size()][];
		for(int i = 0 ; i < depthlist.size();i++) {
			deptharr[i]= new int [depthlist.get(i).size()];
			int cnt = 0;
			for (int k : depthlist.get(i)) {
				deptharr[i][cnt] = k;
				cnt++;
			}
		}
		st = new StringTokenizer(br.readLine());
		System.out.println(solve());
	}

	private static int solve() {
		int cnt = 0;
		while (cnt < depthlist.size()) {
			int size = depthlist.get(cnt).size();
			int [] aarr = new int [size];
			for (int i = 0; i < size; i++) {
				aarr[i] = Integer.parseInt(st.nextToken());
				
			}
			if(cnt == 0&& aarr[0]!=1)
				return 0;
				
			Arrays.sort(aarr);
			for(int i = 0 ; i < size ; i++) {
				if(aarr[i] < deptharr[cnt][i])
					return 0;
			}
			cnt++;
		}
		return 1;
	}

	private static void getAnswer() {
		int depth = 0;
		while (!q.isEmpty()) {
			depthlist.add(new LinkedList<>());
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int p = q.poll();
				v[p] = true;
				depthlist.get(depth).add(p);
				for (Integer k : ls[p]) {
					if (!v[k])
						q.add(k);
				}
			}
			Collections.sort(depthlist.get(depth));
			depth++;

		}
	}
}