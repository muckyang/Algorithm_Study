package Pass_Feb_Week02;
import java.util.Scanner;

public class Solution_Unknown_5656_벽돌깨기{
	static int T;
	static int N, W, H;
	static int[][] map;
	static int min;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void ping(int[][] mat, int N, int c) {
		numOfBlock(mat);
		if (N == c) {
			return;
		}
		int[][] matrix = new int[H][W];
		for (int j = 0; j < W; j++) {
			for (int i = 0; i < H; i++) { // 값만 복사해줌
				System.arraycopy(mat[i], 0, matrix[i], 0, W);
			}
			for (int i = 0; i < H; i++) {
				if (matrix[i][j] != 0) {
					matrix = Boom(matrix, i, j, matrix[i][j] - 1); // 터질범위 미리 줄여줌
					matrix[i][j] = 0;
					matrix = BlockClaer(matrix);
			
					ping(matrix, N, c + 1);
					break;
				}
			}
		}
	}

	public static void numOfBlock(int[][] mat) {// 남은 블럭 수 세기
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (mat[i][j] != 0)
					cnt++;
			}
		}
		min = Math.min(min, cnt);
	}

	public static int[][] Boom(int[][] matrix, int x, int y, int size) {
		matrix[x][y] = 0;
		for (int d = 0; d < 4; d++) {
			matrix = BoomLine(matrix, x, y, size, dx[d], dy[d]);
		}
		return matrix;
	}

	public static int[][] BoomLine(int[][] mat, int x, int y, int size, int dx, int dy) {
		for (int i = 0; i < size; i++) {
			x += dx;
			y += dy;
			if (x >= 0 && y >= 0 && x < H && y < W) {// 맵이 0인걸만나도 이동해서 터트림
				if (mat[x][y] != 0) {
					Boom(mat, x, y, mat[x][y] - 1);
					mat[x][y] = 0;
				}
			}
		}
		return mat;
	}
	
	public static int[][] BlockClaer(int[][] mat) {
		for (int j = 0; j < W; j++) {//옆으로 돔
			int idx = H-1;
			for (int i = H - 1; i >= 0; i--) {
				
				if (mat[i][j] != 0) {
					mat[idx][j] = mat[i][j];
					idx--;
				}
			}
			for(int k = 0; k <=idx;k++)
				mat[k][j]=0;
		}
		return mat;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			min = Integer.MAX_VALUE;// 남은 블럭수 세는것
			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++)
					map[i][j] = sc.nextInt();

			}

			ping(map, N, 0);
			System.out.println("#" + test_case + " " + min);
		}
	}
}

