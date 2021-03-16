package Month02_Week03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2630_색종이만들기 {
	static int N;
	static int[][] matrix;
	static Queue<Point> que;
	static int wc, bc;
	static int[] dx = { 0, 0, 1, 1 };
	static int[] dy = { 0, 1, 0, 1 };

	static class Point {
		int x;
		int y;
		int size;

		public Point(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}

	}

	private static void bfs() {
		while (!que.isEmpty()) {
			int c = que.size();
			for (int d = 0; d < c; d++) {
				Point p = que.poll();
				if (p.size == 1) {
					if (matrix[p.x][p.y] == 0)
						wc++;
					else
						bc++;
					continue;
				}
				int check = 0;
				int pxy = matrix[p.x][p.y];
				for (int i = p.x; i < p.x + p.size; i++) {
					for (int j = p.y; j < p.y + p.size; j++) {
						if (matrix[i][j] != pxy)// 하나라도 다르다면 또 나누어야 함.
							check = 1;
					}
				}
				if (check == 0) {// 다 같은 경우
					if (matrix[p.x][p.y] == 0)
						wc++;
					else
						bc++;
					continue;
				} else {
					for (int k = 0; k < 4; k++) {
						que.add(new Point(p.x + dx[k] * p.size / 2, p.y + dy[k] * p.size / 2, p.size / 2));
					}
				}

			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		que = new LinkedList<Point>();
		matrix = new int[N][N];
		wc = bc = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		que.offer(new Point(0, 0, N));

		bfs();
		System.out.println(wc);
		System.out.println(bc);
		
	}

}
