package Study_0625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

///// 물고기 이동시 증식 / 
public class Main_19236_청소년상어_2 {
	static int dx[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dy[] = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static Queue<Shark> q;
	static int fishmap[][];
	static Fish[] farr;
	static int res;

	public static class Shark {
		int x, y, sum, dist;
		Fish fa[];
		int fm[][];

		public Shark(int x, int y, int sum, int dist) {
			this.x = x;
			this.y = y;

			this.sum = sum;
			this.dist = dist;
			fa = new Fish[17];
			fm = new int[4][4];
		}
	}

	public static class Fish {
		int x, y, value, dist;

		public Fish(int x, int y, int value, int dist) {
			this.x = x;
			this.y = y;
			this.value = value;
			this.dist = dist;

		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		q = new LinkedList<>();
		fishmap = new int[4][4];
		farr = new Fish[17];
		res = 0;
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int index = Integer.parseInt(st.nextToken());
				int dist = Integer.parseInt(st.nextToken()) - 1;
				farr[index] = new Fish(i, j, index, dist);
				fishmap[i][j] = index;
			}
		}
//		for(int i = 1 ; i < 17;i++)
//			System.out.println(farr[i].dist + " ");
		int findex = fishmap[0][0];
		Shark shark = new Shark(0, 0, findex, farr[findex].dist);
		fishmap[0][0] = -1;
		farr[findex] = null;
		for (int i = 0; i < 4; i++)
			System.arraycopy(fishmap[i], 0, shark.fm[i], 0, 4);
		System.arraycopy(farr, 0, shark.fa, 0, 17);
		q.add(shark);
//		printmap(shark.fm);
		solve();
		System.out.println(res);

	}

	private static void solve() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Shark p = q.poll();
				if (p.sum > res)
					res = p.sum;
				// 물고기 이동
				
				moveFish(p.fm, p.fa);
				System.out.println("물고기 이동후");
				printmap(p.fm);
				// 상어이동
				moveShark(p);
			}
		}
	}

	private static void moveShark(Shark p) {
		int weight = 0;
		while (true) {
			weight++;
			System.out.println(p.x + " " + p.y + " " + p.dist);
			int tx = p.x + dx[p.dist] * weight;
			int ty = p.y + dy[p.dist] * weight;
			Fish[] Ftemp = new Fish[17];
			int[][] fmap = new int[4][4];

			for (int i = 0; i < 4; i++)
				System.arraycopy(p.fm[i], 0, fmap[i], 0, 4);
			System.arraycopy(p.fa, 0, Ftemp, 0, 17);

			if (!safe(tx, ty))
				break;
			if (p.fm[tx][ty] == 0 || p.fm[tx][ty] ==-1)
				continue;
			if (p.fa[p.fm[tx][ty]] == null)
				continue;

			Shark add = new Shark(tx, ty, p.fm[tx][ty] + p.sum, p.fa[p.fm[tx][ty]].dist);
			for (int i = 0; i < 4; i++)
				System.arraycopy(fmap[i], 0, add.fm[i], 0, 4);
			System.arraycopy(Ftemp, 0, add.fa, 0, 17);
//			add.fa[p.fm[p.x][p.y]].dist = p.fa[p.fm[tx][ty]].dist;
////			add.fa[p.fm[p.x][p.y]].x = p.fa[p.fm[tx][ty]].x;
////			add.fa[p.fm[p.x][p.y]].y = p.fa[p.fm[tx][ty]].y;
			add.fa[p.fm[tx][ty]] = null;
			add.fm[tx][ty] = -1;
			add.fm[p.x][p.y] = 0;
			System.out.println("상어이동시");
			printmap(add.fm);

			q.add(add);

		}

	}

	private static void moveFish(int[][] fm, Fish[] fa) {
		for (int i = 1; i <= 16; i++) {
			if (fa[i] == null)
				continue;

			Fish now = fa[i];
			int t = now.dist;
			for (int d = 0; d < 8; d++) {
				int ix = now.x + dx[t];
				int jy = now.y + dy[t];
				// 갈 방향이 범위밖이나 상어인 경우 반시계로 45도 회전
				if (!safe(ix, jy) || fm[ix][jy] == -1) {
					t++;
					if (t == 8)
						t = 0;
					continue;
				}
				// 빈곳이라면?
				if (fm[ix][jy] == 0) {
					fm[ix][jy] = now.value;
					fm[now.x][now.y] = 0;
					fa[i].x = ix;
					fa[i].y = jy;
					fa[i].dist = t;
				} else { // 이미 다른 물고기가 있다면 서로 맞교환
					int temp = fm[ix][jy];
					fm[ix][jy] = fm[now.x][now.y];
					fm[now.x][now.y] = temp;

					int tempx = fa[temp].x;
					int tempy = fa[temp].y;
					fa[temp].x = fa[i].x;
					fa[temp].y = fa[i].y;
					fa[i].x = tempx;
					fa[i].y = tempy;
					fa[i].dist = t;
				}
				break;

			}
		}
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < 4 && y < 4)
			return true;
		return false;
	}

	private static void printmap(int[][] fmap) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(fmap[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}

}
