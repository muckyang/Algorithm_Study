package REMIND.COMPLETE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_17143_낚시왕 {
	static int R, C, M;
	static Shark map[][];
	static boolean v[][];
	static int dx[] = { 0, -1, 1, 0, 0 };// 위 아래 오른 왼
	static int dy[] = { 0, 0, 0, 1, -1 };
	static PriorityQueue<Shark> pq;
	static int res;

	public static class Shark implements Comparable<Shark> {
		int x;
		int y;
		int size;
		int speed;
		int direction;

		public Shark(int x, int y, int size, int speed, int direction) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.speed = speed;
			this.direction = direction;
		}

		@Override
		public int compareTo(Shark o) {
			return o.size - this.size;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pq = new PriorityQueue<>();
		map = new Shark[R][C];
		v = new boolean[R][C];
		res = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int speed = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			map[x][y] = new Shark(x, y, size, speed, direction);
		}
		for (int i = 0; i < C; i++) {
			// 낚시꾼 낚시!
			for (int j = 0; j < R; j++) {
				if (map[j][i] != null) {
					res += map[j][i].size;
					map[j][i] = null;
					break;
				}
			}
			moveShark();
			print();
		}
		System.out.println(res);
	}

	private static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == null)
					System.out.print("0 ");
				else
					System.out.print(map[i][j].size + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void moveShark() {
		// 이동중인 상어 모두 넣기
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != null) {
					pq.add(map[i][j]);
				}
			}
		}
		// 이동!
		map = new Shark[R][C];
		while (!pq.isEmpty()) {
			Shark s = pq.poll();
			int speed = s.speed;
			int size = s.size;
			Shark temp = move(s);
			temp.speed = speed;
			temp.size = size;
			if (map[temp.x][temp.y] == null) {
				map[temp.x][temp.y] = temp;
			}

		}
	}

	private static Shark move(Shark s) {
		if (s.direction == 1) {// 위
			if (s.speed * dx[s.direction] + s.x < 0) {
				s.speed -= s.x;
				s.direction = 2;
				s.x = 0;
				s = move(s);
			} else {
				s.x += s.speed * dx[s.direction];
			}
		} else if (s.direction == 2) {// 아래
			if (s.speed * dx[s.direction] + s.x > R - 1) {
				s.speed -= (R - 1 - s.x);
				s.direction = 1;
				s.x = R - 1;
				s = move(s);
			} else {
				s.x += s.speed * dx[s.direction];
			}
		} else if (s.direction == 3) {// 오른
			if (s.speed * dy[s.direction] + s.y > C - 1) {
				s.speed -= (C - 1 - s.y);
				s.direction = 4;
				s.y = C - 1;
				s = move(s);
			} else {
				s.y += s.speed * dy[s.direction];
			}
		} else if (s.direction == 4) {// 왼
			if (s.speed * dy[s.direction] + s.y < 0) {
				s.speed -= s.y;
				s.direction = 3;
				s.y = 0;
				s = move(s);
			} else {
				s.y += s.speed * dy[s.direction];
			}
		}
		return s;
	}

}
