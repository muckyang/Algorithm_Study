package Study_0225;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_17140_이차원배열과연산_미완성 {
	static int tx, ty, tc;// target x,y,count;
	static int[][] matrix;
	static PriorityQueue<Point> que;

	private static class Point implements Comparable<Point>{
		int num;
		int c;

		public Point(int num, int c) {
			this.num = num;
			this.c = c;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		tx = sc.nextInt();
		ty = sc.nextInt();
		tc = sc.nextInt();
		matrix = new int [3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
	
		
	
	}
}
