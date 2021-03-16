package Study_0510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9328_열쇠 {
	static int T, N, M;
	static char map[][];
	static boolean v[][];
	static boolean key[];
	static Queue<Point> q;
	static List<Point>[] door;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static int res;

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());
		for (int testcase = 0; testcase < T; testcase++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N + 2][M + 2];
			v = new boolean[N + 2][M + 2];
			key = new boolean[26];

			q = new LinkedList<>();
			door = new LinkedList[26];
			for (int i = 0; i < 26; i++) {
				door[i] = new LinkedList<>();
			}
			String s = "";
			res = 0;
			for (int i = 0; i <= N + 1; i++) {
				if (i != 0 && i != N + 1)
					s = br.readLine();
				for (int j = 0; j <= M + 1; j++) {
					if (i == 0 || j == 0 || i == N + 1 || j == M + 1)
						map[i][j] = '.';
					else {
						map[i][j] = s.charAt(j - 1);
					}
				}
			}
			s = br.readLine();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == '0')
					break;
				else {
					key[c - 'a'] = true;
				}
			}
			q.add(new Point(0, 0));
			v[0][0] = true;
			solve();
			System.out.println(res);
		}
	}

	private static void solve() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (!safe(ix, jy) || map[ix][jy] == '*' || v[ix][jy])
						continue;
					v[ix][jy] = true;
					if (map[ix][jy] == '.') { // 갈 수 있을떄
						q.add(new Point(ix, jy));
					} else if (map[ix][jy] == '$') {// 문서일때 res++
						res++;
						q.add(new Point(ix, jy));
					} else if (0 <= map[ix][jy] - 'a' && map[ix][jy] - 'z' <= 0) {// 열쇠일때
						int num = map[ix][jy] - 'a';
						if (!key[num]) { // 이전에 없던 키라면 ?
							key[num] = true;
							for (int k = 0; k < door[num].size(); k++) { // 문 열림 !
								int kx = door[num].get(k).x;
								int ky = door[num].get(k).y;
								q.add(new Point(kx, ky));
							}
						}
						q.add(new Point(ix, jy));
					} else if (0 <= map[ix][jy] - 'A' && map[ix][jy] - 'Z' <= 0) { // 문일때
						int num = map[ix][jy] - 'A';
						if (!key[num]) {// 아직 없는 키 라면 ?
							door[num].add(new Point(ix, jy));//
						} else {
							q.add(new Point(ix, jy));
						}
					}

				}

			}
		}

	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < N + 2 && y < M + 2)
			return true;
		return false;
	}

}