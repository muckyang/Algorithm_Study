package Main_16001_to_18000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17822_원판돌리기 {
	static int N, M, T;// 원수 , 한원의 적힌 숫자 수 , 회전 수
	static int X, D, K;
	static int map[][];
	static boolean v[][];
	static int res, sum, count;
	static double avg;
	static boolean check;
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static Queue<Point> q;

	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < T; i++) {
			avg = 0.0;
			count = 0;
			check = false;
			st = new StringTokenizer(br.readLine());
			X = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			rotate(X, D, K);
			v = new boolean[N + 1][M + 1];
			q = new LinkedList<>();
			sum = 0;
			if (!isBoom()) {
				avg = 1.0 * sum / count;
				for (int a = 1; a <= N; a++) {
					for (int b = 1; b <= M; b++) {
						if (map[a][b] != 0) {
							if (map[a][b] > avg)
								map[a][b]--;
							else if (map[a][b] < avg)
								map[a][b]++;
						}
					}
				}

			}

		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				res += map[i][j];
			}
		}
		System.out.println(res);
	}

	private static void print() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				System.out.print(map[i][j]+ " ");
			}
			System.out.println();
		}

	}

	private static boolean isBoom() {
		boolean boom = false;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] != 0) {
					count++;
					sum += map[i][j];
					if (!v[i][j]) {
						v[i][j] = true;
						q.add(new Point(i, j));
						if (bfs(map[i][j]))
							boom = true;
					}
				}
			}
		}

		return boom;
	}

	private static boolean bfs(int number) {
		boolean c = false;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (ix == N + 1)
						continue;
					if (ix == 0)
						continue;
					if (jy == M + 1)
						jy = 1;
					if (jy == 0)
						jy = M;
					if (!v[ix][jy] && map[ix][jy] == number) {
						v[ix][jy] = true;
						map[ix][jy] = 0;
						map[p.x][p.y] = 0;
						c = true;
						q.add(new Point(ix, jy));
					}
				}

			}
		}
		return c;
	}

	private static void rotate(int x, int d, int k) {
		int index = x;
		int temp[] = new int[M + 1];
		while (index <= N) {
			if (d == 1) {// 반시계방향 , 역방향
				for (int j = 0; j < M; j++) {
					int num = (j + k) % M;
					temp[j + 1] = map[index][num + 1];
				}
			} else {// 시계방향 , 정방향
				for (int j = 0; j < M; j++) {
					int num = (j - k);
					if (num < 0) {
						num = M + num;
					}

					temp[j + 1] = map[index][num + 1];
				}
			}
			System.arraycopy(temp, 0, map[index], 0, M + 1);
			index += x;
		}
	}
}
