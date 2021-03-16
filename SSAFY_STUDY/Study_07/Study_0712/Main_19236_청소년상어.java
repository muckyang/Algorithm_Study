package Study_0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19236_청소년상어 {

	static int res;

	static int dt[][] = { { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 } };

	public static class Fish {
		int x, y, t;

		public Fish(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}

	public static void main(String[] args) throws IOException {
		int map[][];
		Fish fl[];
		int sum = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[4][4];
		fl = new Fish[17]; // 0 번 물고기가 상어라고 침
		fl[0] = new Fish(-1, -1, 0);
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken()) - 1;
				map[i][j] = num;
				fl[num] = new Fish(i, j, t);
			}
		}
		res = 0;
		// 먹기 시작
		int ff = map[0][0];// 첫 물고기 위치
		fl[0] = fl[ff];
		fl[ff] = null;
		map[0][0] = 0;// 상어위치 0 // 빈곳은 -1로 할 예정
		sum += ff;
		solve(map, fl, sum);

	}

	private static void solve(int[][] map, Fish[] fl, int sum) {
		// 물고기 움직임
		moveFish(map, fl);
		print(map);
		// 상어 움직임
		// moveShark();
	}

	private static void print(int map[][]) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
					System.out.print(map[i][j] + " ");
			}
			System.out.println();
			
		}
	}

	private static void moveFish(int[][] map, Fish[] fl) {
		for (int i = 1; i < 17; i++) {
			Fish f = fl[i];
			if(f==null)
				continue;
			for (int d = 0; d < 8; d++) {
				int ix = f.x + dt[f.t][0];
				int jy = f.y + dt[f.t][1];
				if (!safe(ix, jy) || map[ix][jy] == 0) {// 상어거나 외부로 벗어날 경우	
					f.t += 1;
					if (f.t == 8)
						f.t -= 8;
					continue;
				}
				if (map[ix][jy] == -1) {// 빈곳일때!
					map[ix][jy] = i;
					map[f.x][f.y] = -1;
					fl[i] = new Fish(ix, jy, f.t);
					break;
				} else {// 이미 물고기가 있는경우
					Fish next = fl[map[ix][jy]];
					fl[map[ix][jy]] = f;
					fl[map[f.x][f.y]] = next;
					map[f.x][f.y] = map[ix][jy];
					map[ix][jy] = i;
					Fish temp = f;
					f = next;
					next = temp;
					break;
				}
			}
		}
	}

	private static boolean safe(int x, int y) {
		// TODO Auto-generated method stub
		if (x >= 0 && y >= 0 && x < 4 && y < 4)
			return true;
		return false;
	}
}
