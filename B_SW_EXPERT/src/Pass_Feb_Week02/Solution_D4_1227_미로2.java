package Pass_Feb_Week02;

import java.util.Scanner;

public class Solution_D4_1227_미로2 {
	static int[][] matrix;
	static boolean[][] visited;
	static int N;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static int sx, sy, ex, ey;
	static int result, count;
	// 시작점은 2, 도착은 3

	public static void DFS(int x, int y) {

		if (x == ex && y == ey) {
			result = 1;
			return;
		} else {
			for (int d = 0; d < 4; d++) {
				int ix = x + dx[d];
				int jy = y + dy[d];

				if (ix >= 0 && jy >= 0 && ix < 100 && jy < 100 && (matrix[ix][jy] == 0 || matrix[ix][jy] == 3)
						&& visited[ix][jy] == false) {
					visited[ix][jy] = true;
					DFS(ix, jy);
					count++;
					if (result == 1)
						return;
				}

			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// T = sc.nextInt();
		for (int test_case = 1; test_case <= 10; test_case++) {
			N = sc.nextInt();
			matrix = new int[100][100];
			visited = new boolean[100][100];
			count = 0;
			sx = sy = ex = ey = -1;
			for (int i = 0; i < 100; i++) {
				String s = sc.next();
				for (int j = 0; j < 100; j++) {
					matrix[i][j] = s.charAt(j) - 48;
					if (matrix[i][j] == 2) {
						sx = i;
						sy = j;
					} else if (matrix[i][j] == 3) {
						ex = i;
						ey = j;
					}
				}
			}
			result = 0;
			visited[sx][sy] = true;
			DFS(sx, sy);

			System.out.println("#" + test_case + " " + result);
		}
	}
}
