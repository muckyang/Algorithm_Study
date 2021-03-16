package Month02_Week02;

import java.util.Scanner;

public class Main_11724_연결요소의개수 {
	static int N, K;
	static int[][] matrix;
	static int[] visited;
	static int union;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		matrix = new int[N][N];
		visited = new int[N];
		for (int i = 0; i < K; i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			matrix[x][y] = 1;
			matrix[y][x] = 1;
		}
	
		union = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[i][j] == 1) {
					func(i, j);
				}
			}
		}
		int c = 0;
		int vcount[] = new int[N];

		for (int i = 0; i < N; i++) {
			if(visited[i] == 0) {
				c++;
			}else if (vcount[visited[i]] == 0) {
				c++;
				vcount[visited[i]] = 1;
			}
		}
		System.out.println(c);

	}

	private static void func(int x, int y) {
		if (visited[x] == 0 && visited[y] == 0) {
			visited[x] = visited[y] = union;
			union++;
		} else if (visited[x] == 0 || visited[y] == 0) {
			int low = visited[x] > visited[y] ? visited[x] : visited[y];
			visited[x] = visited[y] = low;
		} else if (visited[x] == visited[y]) {

		} else {
			int low = visited[x];
			int high = visited[y];
			for (int i = 0; i < visited.length; i++) {
				if (visited[i] == high)
					visited[i] = low;
			}
		}

	}
}
