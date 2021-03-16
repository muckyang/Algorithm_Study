package Study_0414;

import java.util.Scanner;

public class Prim_하나로 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] adj = new int[V][V];
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			adj[a][b] = c;
			adj[b][a] = c;
		}
		boolean[] check = new boolean[V];
		int[] key = new int[V]; // 현재 선택된 정점들로부터 도달 할 수 있는 최소거리

		int[] p = new int[V]; // 최소 신장트리의 구조를 저장할 배열

		// 아무거나 하나 선택 ! (처음선택되는 친구가 루트이므로 , 부모 없음, 거리는 0 인경로)
		p[0] = -1;
		key[0] = 0;
		for (int i = 0; i < V - 1; i++) {
			// 안골라진 친구들 중에서 key가 가장 적은 친구들 뽑자.
			int min = Integer.MAX_VALUE;

			int index = -1;
			for (int j = 0; j < V; j++) {
				if (!check[j] && key[j] < min) {
					index = j;
					min = key[j];
				}
			}
			check[index] = true;
			for (int j = 0; j < V; j++) {
				if (!check[j] && adj[index][j] != 0 && key[j] > adj[index][j]) {
					p[j] = index;
					key[j] = adj[index][j];
				}
			}
		}
		int result = 0;
		for (int i = 0; i < V; i++)
			result += key[i];
		System.out.println(result);
		System.out.println(result);

	}
}
