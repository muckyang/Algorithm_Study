package Study_0517;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1473_미로탈출 {
	static int N, M;
	static char map[][];
	static int v[][][];

	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
			
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		v = new int[2][N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(v[0][i], Integer.MAX_VALUE);
			Arrays.fill(v[1][i], Integer.MAX_VALUE);
		}
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = s.charAt(j);
				map[i][j] = c;
			}
		}
		char [][]Cmap=  new char [N][M];
		for(int i = 0 ; i  < N ; i++)
			System.arraycopy(map[i], 0, Cmap[i], 0, M);
		
		dfs(0,0,0,Cmap);

	}

	private static void dfs(int i, int j,int time, char[][] cmap) {
	}

}
