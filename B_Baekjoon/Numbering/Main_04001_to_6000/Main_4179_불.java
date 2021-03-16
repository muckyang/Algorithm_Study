	package Main_04001_to_6000;
	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.LinkedList;
	import java.util.Queue;
	import java.util.StringTokenizer;
	
	public class Main_4179_불 {
		static int R, C;
		static int map[][];
		static boolean v[][];
		static int dx[] = { 1, 0, -1, 0 };
		static int dy[] = { 0, -1, 0, 1 };
		static Queue<Point> fq;
		static Queue<Point> jq;
		static int sx, sy;
		static int res;
	
		static boolean out;
	
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
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			v = new boolean[R][C];
			fq = new LinkedList<>();
			jq = new LinkedList<>();
			for (int i = 0; i < R; i++) {
				String s = br.readLine();
				for (int j = 0; j < C; j++) {
					char c = s.charAt(j);
					if (c == '#') {
						map[i][j] = -1;
					} else if (c == '.') {
	
					} else if (c == 'F') {
						map[i][j] = 1;
						fq.add(new Point(i, j));
					} else if (c == 'J') {
						v[i][j] = true;
						jq.add(new Point(i, j));
					}
	
				}
			}
			res = 0;
			bfs();
			System.out.println(out ? res : "IMPOSSIBLE");
		}
	
		private static void bfs() {
			while (!jq.isEmpty()) {
				
				int fsize = fq.size();
				for (int i = 0; i < fsize; i++) {
					Point p = fq.poll();
					for (int d = 0; d < 4; d++) {
						int ix = p.x + dx[d];
						int jy = p.y + dy[d];
						if (safe(ix, jy) && map[ix][jy] == 0) {
							map[ix][jy] = 1;
							fq.add(new Point(ix, jy));
						}
					}
				}
				int jsize = jq.size();
				for (int i = 0; i < jsize; i++) {
					Point p = jq.poll();
					if (end(p.x, p.y)) {
						out = true;
						res++;
						return;
					}
					for (int d = 0; d < 4; d++) {
						int ix = p.x + dx[d];
						int jy = p.y + dy[d];
						if (safe(ix, jy) && map[ix][jy] == 0 && !v[ix][jy]) {
							v[ix][jy] = true;
							jq.add(new Point(ix, jy));
	
						}
					}
				}
				res++;
			
			}
		}
	
		private static boolean end(int x, int y) {
			if (x == 0 || x == R - 1 || y == 0 || y == C - 1)
				return true;
			return false;
		}
	
		private static boolean safe(int ix, int jy) {
			if (ix >= 0 && jy >= 0 && ix < R && jy < C) {
				return true;
			}
			return false;
		}
	}
