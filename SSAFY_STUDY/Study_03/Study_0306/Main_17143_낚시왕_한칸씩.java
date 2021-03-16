package Study_0306;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_17143_낚시왕_한칸씩 {
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
				System.out.println(sk.size);
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
		for (int i = 0; i < sk.speed; i++) {
			if ((x == N - 1 && sk.d == 2) || (y == 0 && sk.d == 4)) {
				sk.d--;
			} else if ((x == 0 && sk.d == 1) || (y == M - 1 && sk.d == 3)) {
				sk.d++;
			}
			x += dx[sk.d];
			y += dy[sk.d];
			if (x < 0 || y < 0 || x >= N || y >= M) {
				x -= dx[sk.d];
				y -= dy[sk.d];
			}
		}
		sk.x = x;
		sk.y = y;
		
		return sk;
	}

}
