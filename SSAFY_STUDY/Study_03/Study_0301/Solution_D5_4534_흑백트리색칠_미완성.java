package Study_0301;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_D5_4534_흑백트리색칠_미완성 {
	static final int MOD = 1000000007;
	static int N;
	static List<Integer>[] adj;// 트리지만 그래프 처럼 ㅡ표현함
	static long[][] memo;// 색상 , 정점 번호

	private static long dfs(int v, int color,int parent) {
		//memo[color][v] 값이 존재한다면 , 리턴
		if(memo[color][v]!=0)
			return memo[color][v];
		
		long ret = 1L;
		if( color ==0) {
			for(int i = 0 ; i <adj[v].size();i++) {
			}
		}
		
		//color가  0(흑)
		//자식노드들을 백(1)으로 칠한 경우의 경우의 수들의 곱
		
		//자식노드들을 백(1)으로 칠한 경우의 경우의 수들의 곱
		
		return ret;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			adj = new ArrayList[N + 1];
			for (int i = 0; i <= N; i++)
				adj[i] = new ArrayList<>();
			memo = new long[2][N + 1];
			for (int i = 0; i < N; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				adj[a].add(b);
				adj[b].add(a);
			}
			long ans = (dfs(1, 0, -1) + dfs(1, 1, -1)) % MOD;
			System.out.println("#" + tc + " " + ans);
		}
	}
}
