package Study_1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19236_청소년상어_Sol {
	static int map[][];
	static Fish[] fish;
	static Shark shark;
	static int dy[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dx[] = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int cnt, res;

	public static class Fish {
		int y, x, index;
		int direction;

		public Fish(int y, int x, int index, int direction) {
			this.y = y;
			this.x = x;
			this.index = index;
			this.direction = direction;
		}
	}

	public static class Shark {
		int y, x, sum;
		int direction;

		public Shark(int y, int x, int sum, int direction) {
			this.y = y;
			this.x = x;
			this.sum = sum;
			this.direction = direction;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[4][4];
		fish = new Fish[17];
		StringTokenizer st;
		res = 0;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken()) - 1;
				map[i][j] = num;
				fish[num] = new Fish(i, j, num, direction);
			}
		}
		res += map[0][0];
		map[0][0] = -1;
		shark = new Shark(0, 0, res, fish[res].direction);
		fish[res] = null;

		solve(shark, fish, map, 0);

		System.out.println(res);
	}

	public static void solve(Shark sh, Fish[] templist, int[][] maped, int cnt) {
		cnt++;
		Fish[] fish_arr = new Fish[17];
		for (int i = 1; i <= 16; i++) {
			if (templist[i] == null)
				continue;
			fish_arr[i] = templist[i];
		}
		int[][] tempmap = new int[4][4];
		for (int i = 0; i < 4; i++)
				System.arraycopy(maped[i], 0, tempmap[i], 0, 4); 

		for (int i = 1; i <= 16; i++) {
			Fish now = fish_arr[i];
			if (now == null) {
				continue;
			}

			for (int d = 0; d < 8; d++) {
				int df = d + fish_arr[i].direction;
				if (df >= 8)
					df -= 8;
				int jy = now.y + dy[df];
				int ix = now.x + dx[df];
				if (safe(jy, ix) || tempmap[jy][ix] == -1)
					continue;

				if (tempmap[jy][ix] == 0) { // 이동
					tempmap[jy][ix] = tempmap[now.y][now.x];
					tempmap[now.y][now.x] = 0;
					fish_arr[i] = new Fish(jy, ix, i, df);
				} else {// 교체
					fish_arr[tempmap[jy][ix]] = new Fish(now.y, now.x, tempmap[jy][ix],
							fish_arr[tempmap[jy][ix]].direction);
					fish_arr[i] = new Fish(jy, ix, i, df);
					int temp = tempmap[now.y][now.x];
					tempmap[now.y][now.x] = tempmap[jy][ix];
					tempmap[jy][ix] = temp;
				}

				break;
			}
		}
		for (int i = 1; i < 4; i++) {// 상어이동
			int jy = sh.y + dy[sh.direction] * i;
			int ix = sh.x + dx[sh.direction] * i;
			if (safe(jy, ix) || tempmap[jy][ix] == 0)
				continue;
			int before = tempmap[jy][ix];
			int sum = sh.sum + before;

			int dire = fish_arr[before].direction;
			Shark sh_temp = new Shark(jy, ix, sum, dire);

			fish_arr[before] = null;
			tempmap[jy][ix] = -1;
			tempmap[sh.y][sh.x] = 0;
			res = Math.max(res, sum);

			solve(sh_temp, fish_arr, tempmap, cnt + 1);
			fish_arr[before] = new Fish(jy, ix, before, dire);
			tempmap[jy][ix] = before;
			tempmap[sh.y][sh.x] = -1;
		}

	}

	public static boolean safe(int y, int x) {
		if (y < 0 || x < 0 || y >= 4 || x >= 4)
			return true;
		return false;
	}

	public static void print(int[][] maper) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++)
				System.out.print(maper[i][j] + " ");
			System.out.println();
		}
	}
}
