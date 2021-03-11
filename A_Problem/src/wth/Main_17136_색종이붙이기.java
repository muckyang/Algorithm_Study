package wth;

import java.util.Scanner;

public class Main_17136_색종이붙이기 {
	static int[] papercount;
	static int[][] matrix;
	static int count, checkpoint;
	static int result = Integer.MAX_VALUE;

	public static void dfs(int x, int y, int count) {
		if (y == 10) {
			y = 0;
			x++;
		}
		if (x == 10) {
			if (result > count)
				result = count;
			return;
		}



		if (matrix[x][y] == 1) {
			for (int size = 5; size > 0; size--) { // 5부터 점점줄어들면서 계산해봄
				if (x + size - 1 < 10 && y + size - 1 < 10 && sizecheck(x, y, size) && papercount[size - 1] > 0) {
					one_to_zero(x, y, size);
					dfs(x, y + 1, count + 1);
					zero_to_one(x, y, size);
				}
			}
		} else {
			dfs(x,y+1,count);
		}

	}

	public static boolean sizecheck(int x, int y, int size) {
		for (int i = x; i < size + x; i++) {
			for (int j = y; j < size + y; j++) {
				if (matrix[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public static void zero_to_one(int x, int y, int size) {
		papercount[size - 1]++;
		for (int i = x; i < size + x; i++) {
			for (int j = y; j < size + y; j++) {
				matrix[i][j] = 1;
			}
		}
	}

	public static void one_to_zero(int x, int y, int size) {
		papercount[size - 1]--;
		for (int i = x; i < size + x; i++) {
			for (int j = y; j < size + y; j++) {
				matrix[i][j] = 0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		papercount = new int[5]; // 배열 안의 값이 5보다 커지면 안됨
//		result = Integer.MAX_VALUE;//전역변수에 해줌
		checkpoint = 0;
		for (int i = 0; i < 5; i++) {
			papercount[i] = 5;
		}

		matrix = new int[10][10];
		count = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		dfs(0, 0, 0);

		if (result == Integer.MAX_VALUE)
			result = -1;
		System.out.println(result);
	}
}
