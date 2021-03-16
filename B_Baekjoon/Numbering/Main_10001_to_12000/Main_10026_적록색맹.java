package Main_10001_to_12000;

import java.util.Scanner;

public class Main_10026_적록색맹 {
	static int N;
	static char[][] matrix;
	static boolean[][] visited;
	static int normalc;
	static int mengc;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		matrix = new char[N][N];
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < N; j++) {
				matrix[i][j] = s.charAt(j);
			}
		}
		visited = new boolean[N][N];
		normalc = func();
		System.out.print(normalc + " ");
		/// r->g로 변환
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[i][j] == 'R')
					matrix[i][j] = 'G';
			}
		}
		visited = new boolean[N][N];
		mengc = func();
		System.out.println(mengc);

	}

	private static int func() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					visited[i][j] = true;
					count++;
					check(i, j, matrix[i][j]);
				}
			}
		}
		return count;
	}

	private static void check(int x, int y, char color) {
		for (int d = 0; d < 4; d++) {
			int ix = x + dx[d];
			int jy = y + dy[d];
			if (ix >= 0 && jy >= 0 && ix < N && jy < N && !visited[ix][jy] && matrix[ix][jy] == color) {
				visited[ix][jy] = true;
				check(ix, jy, color);
			}
		}

	}
}
