package Study_0421;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main_17837_새로운게임2_재인 {

	static int N, K, ans;
	static boolean isfin;
	static int[][] map;
	static List<Mal>[][] info;
	static List<Mal> list = new LinkedList<>();
	static int[] dy = { 0, 0, 0, -1, 1 };
	static int[] dx = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][N];
		info = new List[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				info[i][j] = new LinkedList<>();
			}
		}
		for (int i = 0; i < K; i++) {
			int y = sc.nextInt() - 1;
			int x = sc.nextInt() - 1;
			int d = sc.nextInt();
			Mal mal = new Mal(i, y, x, d);
			info[y][x].add(mal);
			list.add(mal);
		}
		isfin = false;
		while (!isfin) {
			turn();
			ans++;
			if (ans == 1000)
				break;
		}
		System.out.println(ans == 1000 ? -1 : ans);

	}

	static void turn() {
		for (int i = 0; i < K; i++) {
			Mal cur = list.get(i);
			int ny = cur.y + dy[cur.d];
			int nx = cur.x + dx[cur.d];

			if (ny < 0 || nx < 0 || ny >= N || nx >= N || map[ny][nx] == 2) {
				if (cur.d == 1 || cur.d == 3)
					cur.d += 1;
				else
					cur.d -= 1;
				ny = cur.y + dy[cur.d];
				nx = cur.x + dx[cur.d];
				if (ny < 0 || nx < 0 || ny >= N || nx >= N || map[ny][nx] == 2) {
					continue; // 파란색이나 바깥이면 그대로
				}
			}
			if (map[ny][nx] == 0) {
				if (info[cur.y][cur.x].size() > 1) {
					int idx = info[cur.y][cur.x].indexOf(cur);
					int size = info[cur.y][cur.x].size();
					int y = cur.y;
					int x = cur.x;
					for (int j = 0; j < size - idx; j++) {
						Mal del = info[y][x].remove(idx);
						info[ny][nx].add(del);
						del.y = ny;
						del.x = nx;
					}
				} else {
					info[ny][nx].add(info[cur.y][cur.x].remove(0));
					cur.y = ny;
					cur.x = nx;
				}
				if (info[ny][nx].size() >= 4) {
					isfin = true;
					return;
				}
			} else if (map[ny][nx] == 1) {
				if (info[cur.y][cur.x].size() > 1) {
					int idx = info[cur.y][cur.x].indexOf(cur);
					int size = info[cur.y][cur.x].size();
					for (int j = 0; j < size - idx; j++) {
						Mal del = info[cur.y][cur.x].remove(info[cur.y][cur.x].size() - 1);
						info[ny][nx].add(del);
						del.y = ny;
						del.x = nx;
					}
				} else {
					info[ny][nx].add(info[cur.y][cur.x].remove(0));
					cur.y = ny;
					cur.x = nx;
				}
				if (info[ny][nx].size() >= 4) {
					isfin = true;
					return;
				}
			}
		}
	}

	static class Mal {
		int n, y, x, d;

		public Mal(int n, int y, int x, int d) {
			super();
			this.n = n;
			this.y = y;
			this.x = x;
			this.d = d;
		}

	}

}
