package Study_0306;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_17143_낚시왕_Complete {
	static int N, M, S;
	static int[][][] matrix; // weight,d,size
	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, 1, -1 };
	static PriorityQueue<Shark> pq;

	private static class Shark implements Comparable<Shark> {
		int x;
		int y;
		int speed;
		int d;
		int size;

		public Shark(int x, int y, int speed, int d, int size) {
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.d = d;
			this.size = size;
		}

		@Override
		public int compareTo(Shark o) {
			// TODO Auto-generated method stub
			return o.size - this.size;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		S = sc.nextInt();
		matrix = new int[3][N][M];
		pq = new PriorityQueue<Shark>();
		for (int i = 0; i < S; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			matrix[0][x][y] = sc.nextInt(); // w
			matrix[1][x][y] = sc.nextInt(); // d
			matrix[2][x][y] = sc.nextInt(); // size
		}
		int sum = 0;
		sum = solve(sum);
		System.out.println(sum);
	}

	private static int solve(int sum) {
		for (int wi = 0; wi < M; wi++) {// 낚시왕 가로이동
			boolean kill = false;
			for (int hi = 0; hi < N; hi++) { // 아래로 내려가면서 확인
				if (matrix[2][hi][wi] != 0 && !kill) {
					kill = true;
					sum += matrix[2][hi][wi];
					matrix[0][hi][wi] = 0;
					matrix[1][hi][wi] = 0;
					matrix[2][hi][wi] = 0;
					break;
				}
			}
			for (int h = 0; h < N; h++) { // 아래로 내려가면서 확인
				for (int w = 0; w < M; w++) {
					if (matrix[1][h][w] != 0)
						pq.add(new Shark(h, w, matrix[0][h][w], matrix[1][h][w], matrix[2][h][w]));
				}
			}
			// 낚시 완료
			matrix = new int[3][N][M];
			int size = pq.size();
			for (int i = 0; i < size; i++) {
				Shark sk = pq.poll();
				sk = move(sk);
				int x = sk.x;
				int y = sk.y;
				if (matrix[1][x][y] == 0) {
					matrix[0][x][y] = sk.speed;
					matrix[1][x][y] = sk.d;
					matrix[2][x][y] = sk.size;
				}
			}
		}
		return sum;
	}

	private static Shark move(Shark sk) {
		int x = sk.x;
		int y = sk.y;
		int d = sk.d;
		if ((x == N - 1 && d == 2) || (y == 0 && d == 4)) {
			d--;
		} else if ((x == 0 && d == 1) || (y == M - 1 && d == 3)) {
			d++;
		}

		if (d == 1) {
			int su = x + dx[d] * sk.speed;
			if (su < 0) {
				su *= -1;
				d++;
				int mok = su / (N - 1);
				int nam = su % (N - 1);
				if (mok % 2 == 1) {
					d--;
					x = N - 1 - nam;
				} else {
					x = nam;
				}
			} else {
				x = su;
			}
		} else if (d == 2) {
			int su = x + dx[d] * sk.speed;
			if (su > N - 1) {
				su -= N - 1;
				d--;
				int mok = su / (N - 1);
				int nam = su % (N - 1);
				if (mok % 2 == 1) {
					d++;
					x = nam;
				} else {
					x = N - 1 - nam;
				}
			} else {
				x = su;
			}
		} else if (d == 3) {
			int su = y + dy[d] * sk.speed;
			if (su > M - 1) {
				su -= M - 1;
				d++;
				int mok = su / (M - 1);
				int nam = su % (M - 1);
				if (mok % 2 == 1) {
					d--;
					y = nam;
				} else {
					y = M - 1 - nam;
				}
			} else {
				y = su;
			}
		} else if (d == 4) {
			int su = y + dy[d] * sk.speed;
			if (su < 0) {
				su *= -1;
				d--;
				int mok = su / (M - 1);
				int nam = su % (M - 1);
				if (mok % 2 == 1) {
					d++;
					y = M - 1 - nam;
				} else {
					y = nam;
				}
			} else {
				y = su;
			}
		}

		sk.x = x;
		sk.y = y;
		sk.d = d;
		return sk;
	}

}
