package Main_16001_to_18000;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main_17837_새로운게임2 {
	static int N, K;
	static int map[][];
	static int dx[] = { 0, 0, 0, -1, 1 };// 1부터 방향 진행
	static int dy[] = { 0, 1, -1, 0, 0 };
	static Horse[] horses;
	static List<Integer>[][] h;
	static boolean isEnd;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][N];
		h = new LinkedList[N][N];
		horses = new Horse[K];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				h[i][j] = new LinkedList<>();
			}
		}

		for (int i = 0; i < K; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			int d = sc.nextInt();
			horses[i] = new Horse(x, y, d, 0);
			h[x][y].add(i);
		}

		// 입력 및 설정 완료
		cnt = 0;
		isEnd = false;
		solve();

		if (isEnd)
			System.out.println(cnt);
		else
			System.out.println(-1);
	}

	private static void solve() {
		while (true) {
			cnt++;
			// 움직이는로직 (이 안에서 4층이상 형성되는 순간 isEnd = true; 하고 리턴.
			for (int i = 0; i < K; i++) {
				// 이동할 곳
				Horse ho = horses[i];
				go(ho, true);
				if (isEnd)
					return;
			}
			if (cnt == 1000 || isEnd)// 1000번해도 끝나지않으면 빠져나감
				return;
		}
	}

	private static void go(Horse ho, boolean check) {
		int x = ho.x;
		int y = ho.y;
		int floor = ho.floor;
		
		int nx = ho.x + dx[ho.d];
		int ny = ho.y + dy[ho.d];
		
		if (!safe(nx, ny) || map[nx][ny] == 2) {
			if (check) {
				int hindex = h[x][y].get(ho.floor);
				// 방향 반대로 변경
				if (horses[hindex].d % 2 == 0 ) {
					horses[hindex].d -= 1;
				} else {
					horses[hindex].d += 1;
				}
				go(horses[hindex], false);
			} else {// 이동안함
				return;
			}
		} else if (map[nx][ny] == 0) {
			int size = h[ho.x][ho.y].size();
		
			for (int i = floor; i < size; i++) {
				int hindex = h[x][y].remove(floor);
				horses[hindex].x = nx;
				horses[hindex].y = ny;
				horses[hindex].floor = h[nx][ny].size();
				h[nx][ny].add(hindex);
			}
			if (h[nx][ny].size() >= 4) {
				isEnd = true;
				return;
			}

		} else if (map[nx][ny] == 1) {
			int size = h[ho.x][ho.y].size();
			for (int i = size - 1; i >= floor; i--) {
				int hindex =  h[x][y].remove(i);
				horses[hindex].x = nx;
				horses[hindex].y = ny;
				horses[hindex].floor = h[nx][ny].size();
				h[nx][ny].add(hindex);
				
			}
			if (h[nx][ny].size() >= 4) {
				isEnd = true;
				return;
			}
		}
	
	}


	private static boolean safe(int nx, int ny) {
		if (nx >= 0 && ny >= 0 && nx < N && ny < N)
			return true;
		return false;
	}

	static class Horse {
		int x;
		int y;
		int d;
		int floor;

		public Horse(int x, int y, int d, int floor) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.floor = floor;

		}
	}
}
