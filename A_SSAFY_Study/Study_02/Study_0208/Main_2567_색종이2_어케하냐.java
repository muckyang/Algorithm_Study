package Study_0208;
import java.util.Scanner;

public class Main_2567_색종이2_어케하냐 {
	static int N;
	static int[][] matrix;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		matrix = new int[102][102];//테두리 설정
		int count = 0;
		for (int k = 0; k < N; k++) {
			int x = sc.nextInt() + 1;
			int y = sc.nextInt() + 1;
			for (int i = x; i < 10 + x; i++) {
				for (int j = y; j < 10 + y; j++) {
					matrix[i][j] = 1;
				}
			}
		}

		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if (matrix[i][j] == 1) {
					for (int d = 0; d < 4; d++) {
						int ix = i + dx[d];
						int jy = j + dy[d];
						if (matrix[ix][jy] == 0)
							count++;

					}
				}
			}
		}
		System.out.println(count);
	}
}