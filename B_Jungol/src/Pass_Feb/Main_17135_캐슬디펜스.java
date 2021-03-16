package Pass_Feb;

import java.util.Scanner;

public class Main_17135_캐슬디펜스 {
	static int N, M, D,result;
	static int[][] matrix;

	class Point {
		int x;
		int y;

	}

	public static void func(int start, int archer) {
		if (archer == 3) {
			int[][] mat = new int[N+1][M];
			for (int i = 0; i <= N; i++) {
				System.arraycopy(matrix[i], 0, mat[i], 0, matrix[i].length);
			}

			int max = gowar(mat);// 복사해서 넣어야 할듯?
			result = Math.max(max, result);
			return;
		}

		for (int i = start; i < M; i++) {
			matrix[N][i] = 1;
			func(i + 1, archer + 1);
			matrix[N][i] = 0;
		}
	}

	public static int gowar(int[][] mat) {
		int kill = 0;
		int[] arc = new int[3]; // 궁수 가로축 좌표
		int count = 0;

		// 아처위치는 고정
		for (int j = 0; j < M; j++) {
			if (mat[N][j] == 1)
				arc[count++] = j;
		}

		while (true) {
			int check = 0;
			for (int j = 0; j < M; j++) {
				for (int i = 0; i < N; i++) {
					if (mat[i][j] == 1) {
						check = 1;
					}
				}
			}
			if (check == 0)
				return kill;
			// 매 초 0으로 초기화

			int[] mindist = new int[3];
			int[] minx = new int[3];
			int[] miny = new int[3];

			for (int i = 0; i < 3; i++) {
				mindist[i] = Integer.MAX_VALUE;
				minx[i] = -1;
				miny[i] = -1;
			}

			for (int j = 0; j < M; j++) {
				for (int i = 0; i < N; i++) {
					if (mat[i][j] == 1) {
						for (int d = 0; d < 3; d++) {
							int nowdist = N - i + Math.abs(arc[d] - j);
							if (mindist[d] > nowdist && nowdist <= D) {
								mindist[d] = nowdist;
								minx[d] = i;
								miny[d] = j;
							}
						}
					}
				}
			}
			// 죽일 괴물 뽑았음

			for (int d = 0; d < 3; d++) {
				if (minx[d] != -1 && miny[d] != -1 && mat[minx[d]][miny[d]] == 1) {
					kill++;
					mat[minx[d]][miny[d]] = 0;
				}
			}
			/// 킬수 증가

			for (int i = N - 1; i >= 0; i--) {
				for (int j = 0; j < M; j++) {
					if (i == 0)
						mat[i][j] = 0;
					else
						mat[i][j] = mat[i - 1][j];
				}
			}
			// 한칸씩 아래로 이동
		}
	}

	public static void dist(Point a, Point m) {// 아처좌표 , 몬스터좌표

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt(); // 공격 거리
		result = 0;
		matrix = new int[N + 1][M]; // N번째 행은 성
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		func(0, 0);
		System.out.println(result);
	}
}
