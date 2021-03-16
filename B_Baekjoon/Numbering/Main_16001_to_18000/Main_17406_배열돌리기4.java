package Main_16001_to_18000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4 {
	static int N, M, K; // K = 회전연산수
	static int[][] matrix;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] list;
	static int[] pre; 
	static int min;

	private static void line(int flag, int c) {
		if (c == K) {
			int mat[][] = new int[N][M];
			for (int i = 0; i < N; i++) {
				System.arraycopy(matrix[i], 0, mat[i], 0, matrix[i].length);
			}
			for (int i = 0; i < K; i++) {
				rotate(mat, list[pre[i]][0], list[pre[i]][1], list[pre[i]][2]);
			}
			checkmin(mat); // 회전 다하고 최소값 갱신
			return;
		} else {
			for (int i = 0; i < K; i++) {
				if ((flag & (1 << i)) == 0) {
					pre[c] = i;
					line(flag | (1 << i), c + 1);
				}
			}
		}
	}

	private static void rotate(int[][] mat, int sx, int sy, int size) {
		for (int i = 1; i <= size; i++) {
			int x = sx - i;
			int y = sy - i;
			int temp = mat[x][y];
			for (int d = 0; d < 4;) {

				int ix = x + dx[d];
				int jy = y + dy[d];
				if (ix == sx - i && jy == sy - i) {
					mat[x][y] = temp;
					break;
				}
				if (ix > sx + i || jy > sy + i || jy < sy - i || ix < sx - i) {
					d++;
				} else {
					mat[x][y] = mat[ix][jy];
					x = ix;
					y = jy;
				}
			}
		}
	}

	private static void checkmin(int[][] mat) {
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += mat[i][j];
			}
			if (min > sum)
				min = sum;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String k = br.readLine();
		StringTokenizer st = new StringTokenizer(k);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		list = new int[K][3];
		pre = new int[K];
		min = Integer.MAX_VALUE;
		matrix = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s);
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			list[i][0] = x - 1;
			list[i][1] = y - 1;
			list[i][2] = size;
		}
		// input 정리 끝
		// 순서를 임의로 정해도 된다? ㅋㅋ
		line(0, 0);

		System.out.println(min);
	}
}
