package Uncomplete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AMain_2931_가스관 {
	static int N, M;
	static char map[][];
	static int dx[] = { 0, 1, 0, -1 };// 동남서북
	static int dy[] = { 1, 0, -1, 0 };
	static int pipeTF[][] = { { 0, 0, 0, 0 }, { 1, 1, 0, 0 }, { 0, 1, 1, 0 }, { 0, 0, 1, 1 }, { 1, 0, 0, 1 },
			{ 0, 1, 0, 1 }, { 1, 0, 1, 0 } }; // 들어오는 기준 0 이면 가능
	static int sx, sy, ex, ey;
	static Queue<Pipe> q;
	static Pipe res;

	public static class Pipe {
		int x, y;
		int d;
		char shape;
		Pipe del;

		public Pipe(int x, int y, int d, char shape) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.shape = shape;
			this.del = null;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		q = new LinkedList<>();
		res = null;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'Z') {
					ex = i;
					ey = j;
				} else if (map[i][j] == 'M') {
					sx = i;
					sy = j;
				}
			}
		}
		solve();
		System.out.println(res.x + " " + res.y + " " + res.shape);
	}

	private static void solve() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '.') {
					if (check4way(i, j))
						return;
				}
			}
		}
	}

	private static boolean check4way(int x, int y) {
		
		return false;
	}

//	private static void solve() {
//		while (!q.isEmpty()) {
//			int size = q.size();
//			for (int i = 0; i < size; i++) {
//				Pipe p = q.poll();
//				if (map[p.x][p.y] == 'Z') {
//					res = p.del;
//					return;
//				}
//				for (int d = 0; d < 4; d++) {
//					if (!canGo(p, d)) // 현위치에서 갈수 있는 방향만 가기
//						continue;
//					int ix = p.x + dx[d];
//					int jy = p.y + dy[d];
//					if (!safe(ix, jy)) // 범위 밖인지 여부
//						continue;
//					if (map[ix][jy] == '.') {
//						if (p.del == null) {
//							for (int k = 0; k < 7; k++) {
//								if (pipeTF[k][d] == 0) {// 받아짐
//									char sha = ' ';
//									
//									Pipe addp = new Pipe(ix,jy,d,);
//									q.add(addp);
//								}
//							}
//						} else {
//							continue;
//						}
//					}
//
//				}
//			}
//		}
//	}

	private static boolean canGo(Pipe p, int d) {
		char c = map[p.x][p.y];
		if (p.del != null && p.x == p.del.x && p.y == p.del.y)
			c = p.del.shape;
		if (c == 'M')
			return true;
		else if (c == '+' && p.d % 2 != d % 2)
			return true;
		else if (c == '-' && d % 2 == 0)
			return true;
		else if (c == '|' && d % 2 == 1)
			return true;
		else if (c == '1' && d < 2)// 동남
			return true;
		else if (c == '2' && (d == 0 || d == 3)) // 동북
			return true;
		else if (c == '3' && d > 1) // 서,북
			return true;
		else if (c == '4' && (d == 1 || d == 2)) // 남서
			return true;

		return false;
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		return false;
	}
}