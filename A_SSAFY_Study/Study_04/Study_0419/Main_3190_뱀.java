package Study_0419;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_3190_뱀 {
	static int N, K, L;// 처음엔 오른쪽으로 향하고있음
	// x 초가 되면 방향변환 
	static int dx[] = { 0, 1, 0, -1 };// D = ++ , L = --
	static int dy[] = { 1, 0, -1, 0 };
	static int map[][];
	static int move[];
	static char c[];
	static int length, time;
	static Queue<Snake> q;

	static class Snake {
		int x;
		int y;

		public Snake(int x, int y) {
			this.x = x;
			this.y = y;

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int d = 0;
		int time = 0;

		length = 1;
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < K; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			map[x][y] = 1;
		}

		L = sc.nextInt();
		move = new int[L];
		c= new char[L];
		q = new LinkedList<>();

		q.add(new Snake(0, 0));
		map[0][0] = 2;
		
		Snake head = new Snake(0, 0);

		for (int i = 0; i < L; i++) {
			move[i] = sc.nextInt();
			c[i] = sc.next().charAt(0);
		}
		int cnt = 0;
		while (true) {
			time++;
			
			int ix = head.x + dx[d];
			int jy = head.y + dy[d];

			if (!safe(ix, jy) || map[ix][jy] == 2) {
				break;
			} else if (map[ix][jy] == 1) {
				q.add(new Snake(ix, jy));
				map[ix][jy] = 2;
				head.x = ix;
				head.y = jy;
			} else if (map[ix][jy] == 0) {
				q.add(new Snake(ix, jy));
				map[ix][jy] = 2;
				head.x = ix;
				head.y = jy;
				Snake p = q.poll();
				map[p.x][p.y] = 0;
			}
			if (cnt != L && move[cnt] == time) {
				if (c[cnt] == 'L') {
					d--;
					if (d == -1)
						d = 3;
				} else if (c[cnt] == 'D') {
					d++;
					if (d == 4)
						d = 0;
				}
				cnt++;
			}
		}
		System.out.println(time);
	}

	private static boolean safe(int ix, int jy) {
		if (ix >= 0 && jy >= 0 && ix < N && jy < N)
			return true;
		return false;
	}
}
