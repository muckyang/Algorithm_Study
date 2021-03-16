package KAKAO;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution4 {
	static int R, C;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static int map[][];
	static Queue<Road> q;
	static int pay[][];
	static int answer;

	public static class Road {
		int x, y, d;
		int pay;

		public Road(int x, int y, int d, int pay) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.pay = pay;

		}
	}

	public static void main(String[] args) {
		int board[][]  = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};

		answer = Integer.MAX_VALUE;
		map = board;
		R = board.length;
		C = board[0].length;
		q = new LinkedList<>();
		pay = new int[R][C];

		for (int i = 0; i < R; i++)
			Arrays.fill(pay[i], Integer.MAX_VALUE);
		pay
		[0][0] = 0 ;
		q.add(new Road(0, 0, -1, 0));
		solve();
		print();
		System.out.println(answer);
		// return answer;
	}

	private static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (pay[i][j] == Integer.MAX_VALUE)
					System.out.print(0);
				else
					System.out.print(pay[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void solve() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Road p = q.poll();

				if (p.x == R - 1 && p.y == C - 1) {
					answer = Math.min(p.pay, answer);
					continue;
				}

				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					int nowpay = p.pay;
					if (!safe(ix, jy) || map[ix][jy] == 1)
						continue;
					if (d != p.d && p.d != -1)
						nowpay += 500;
					if (pay[ix][jy] >= nowpay + 100) {
						pay[ix][jy] = nowpay + 100;
						q.add(new Road(ix, jy, d, nowpay + 100));
					}

				}
			}
		}
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < R && y < C)
			return true;
		return false;
	}
}
