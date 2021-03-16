package Study_0702;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_19235_모노미노도미노 {
	static int N;
	static int blue[][];
	static int green[][];
	static boolean[][] v;
	// . ,ㅡ ,|
	static int domino[][][] = { { { 1, 0 }, { 0, 0 } }, { { 1, 1 }, { 0, 0 } }, { { 1, 0 }, { 1, 0 } } };// 3,2,2
	static Queue<Point> q;
	static int score;
	static int count;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

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
		score = 0;
		count = 0;
		blue = new int[4][6];
		green = new int[6][4];
		N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			solve(i + 1, t, x, y);

		}

		for (int i = 0; i < 4; i++) {
			for (int j = 2; j < 6; j++) {
				if (blue[i][j] != 0)
					count++;
				if (green[j][i] != 0)
					count++;
			}
		}
		System.out.println(score);
		System.out.println(count);
	}

	private static void print() {
		for (int i = 0; i < 4; i++) {
			System.out.print("        ");
			for (int j = 0; j < 6; j++) {
				System.out.print(blue[i][j] + " ");
			}
			System.out.println();
		}
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(green[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void solve(int index, int t, int x, int y) {
// 추가 하기
//		System.out.println("------------add---------");
		badd(index, t, x);
		gadd(index, t, y);

//		System.out.println("------------sort---------");
		// 행 삭제 &정렬 후 초과 시 밀어내기
		bsort(index);
		gsort(index);
//		print();
	}

	private static void gsort(int index) {
		boolean check = true;
		gpull();
		while (check) {
			check = false;
			for (int j = 0; j < 6; j++) {
				int c = 0;
				for (int i = 0; i < 4; i++) {
					if (green[j][i] != 0) {
						c++;
					}
				}
				if (c == 4) {// 줄이 채워저있다면?
					score++;
					for (int i = 0; i < 4; i++) {
						green[j][i] = 0;
						check = true;// 한번 더 체크 할 것
					}
				}
			}
			gpull();
		}
		// 다 정리후에 연한곳에 남아있다면 제거
		gcut();
	}

	private static void gcut() {
		int temp[][] = new int[6][4];
		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < 4; i++) {
				if (green[k][i] != 0) {
					int del = 2 - k;
					for (int l2 = 2; l2 < 6; l2++)
						for (int l = 0; l < 4; l++)
							temp[l2][l] = green[l2 - del][l];
					green = new int[6][4];
					for (int l = 0; l < 6; l++)
						System.arraycopy(temp[l], 0, green[l], 0, 4);
					return;
				}
			}
		}
	}

	private static void gpull() {
		v = new boolean[6][4];
		q = new LinkedList<>();
		for (int i = 5; i >= 0; i--) {
			for (int j = 0; j < 4; j++) {
				if (green[i][j] != 0) {
					q.add(new Point(i, j)); // 일단 싹다 넣음

				}
			}
		}
		int[][] temp = new int[6][4];
		while (!q.isEmpty()) {
			Point p = q.poll();
			if (v[p.x][p.y])
				continue;
			v[p.x][p.y] = true;
			int plusx = Integer.MAX_VALUE;
			int dist = 0;

			for (int j = p.x; j < 5; j++) {
				if (temp[j + 1][p.y] == 0)
					dist++;
				else
					break;
			}

			plusx = Math.min(plusx, dist);

			for (int d = 0; d < 4; d++) {
				int ix = p.x + dx[d];
				int jy = p.y + dy[d];

				if (!gsafe(ix, jy) || v[ix][jy] || green[ix][jy] != green[p.x][p.y])
					continue;
				dist = 0;
				v[ix][jy] = true;
				for (int j = ix; j < 5; j++) {
					if (temp[j + 1][jy] == 0)
						dist++;
					else
						break;
				}

				plusx = Math.min(plusx, dist);
				if (plusx != Integer.MAX_VALUE) {
					temp[ix + plusx][jy] = green[p.x][p.y];
				}

			}
			if (plusx != Integer.MAX_VALUE) {
				temp[p.x + plusx][p.y] = green[p.x][p.y];
			}
		}
		for (int i = 0; i < 6; i++)
			System.arraycopy(temp[i], 0, green[i], 0, 4);
	}

	private static void bsort(int index) {
		boolean check = true;
		bpull();
		while (check) {
			check = false;
			for (int j = 0; j < 6; j++) {
				int c = 0;
				for (int i = 0; i < 4; i++) {
					if (blue[i][j] != 0) {
						c++;
					}
				}
				if (c == 4) {// 줄이 채워저있다면?
					score++;
					for (int i = 0; i < 4; i++) {
						blue[i][j] = 0;
						check = true;// 한번 더 체크 할 것
					}
				}
			}
			// 6행 다 돌고 나서 당기기
			bpull();

		}
		// 다 정리후에 연한곳에 남아있다면 제거
		bcut();
	}

	private static void bcut() {
		int temp[][] = new int[4][6];
		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < 4; i++) {
				if (blue[i][k] != 0) {
					int del = 2 - k;
					for (int l = 0; l < 4; l++)
						for (int l2 = 2; l2 < 6; l2++)
							temp[l][l2] = blue[l][l2 - del];
					blue = new int[4][6];
					for (int l = 0; l < 4; l++)
						System.arraycopy(temp[l], 0, blue[l], 0, 6);
					return;
				}
			}
		}
	}

	private static void bpull() {
		v = new boolean[4][6];
		q = new LinkedList<>();
		for (int j = 5; j >= 0; j--) {
			for (int i = 0; i < 4; i++) {
				if (blue[i][j] != 0) {
					q.add(new Point(i, j)); // 일단 싹다 넣음

				}
			}
		}
		int[][] temp = new int[4][6];
		while (!q.isEmpty()) {
			Point p = q.poll();
			if (v[p.x][p.y])
				continue;
			v[p.x][p.y] = true;
			int plusy = Integer.MAX_VALUE;
			int dist = 0;

			for (int j = p.y; j < 5; j++) {
				if (temp[p.x][j + 1] == 0)
					dist++;
				else
					break;
			}

			plusy = Math.min(plusy, dist);

			for (int d = 0; d < 4; d++) {
				int ix = p.x + dx[d];
				int jy = p.y + dy[d];

				if (!bsafe(ix, jy) || v[ix][jy] || blue[ix][jy] != blue[p.x][p.y])
					continue;
				dist = 0;
				v[ix][jy] = true;
				for (int j = jy; j < 5; j++) {
					if (temp[ix][j + 1] == 0)
						dist++;
					else
						break;
				}

				plusy = Math.min(plusy, dist);
				if (plusy != Integer.MAX_VALUE) {
					temp[ix][jy + plusy] = blue[p.x][p.y];
				}

			}
			if (plusy != Integer.MAX_VALUE) {
				temp[p.x][p.y + plusy] = blue[p.x][p.y];
			}

		}
		for (int i = 0; i < 4; i++)
			System.arraycopy(temp[i], 0, blue[i], 0, 6);
	}

	private static boolean bsafe(int ix, int jy) {
		if (ix >= 0 && jy >= 0 && ix < 4 && jy < 6)
			return true;
		return false;
	}

	private static boolean gsafe(int ix, int jy) {
		if (ix >= 0 && jy >= 0 && ix < 6 && jy < 4)
			return true;
		return false;
	}

	private static void badd(int index, int t, int x) {
		q = new LinkedList<>();
		int temp[][] = new int[4][6];
		for (int i = 0; i < 4; i++)
			System.arraycopy(blue[i], 0, temp[i], 0, 6);

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				if (domino[t][i][j] == 1) {
					temp[i + x][j] = index;
				}
			}
		}

		for (int j = 5; j >= 0; j--) {
			for (int i = 0; i < 4; i++) {
				if (temp[i][j] == index) {
					q.add(new Point(i, j)); // 행중 가장 먼 index값 기준
				}
			}
		}
		int plusy = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Point p = q.poll();
			int dist = 0;
			for (int j = p.y; j < 5; j++) {
				if (temp[p.x][j + 1] == 0)
					dist++;
				else
					break;
			}
			plusy = Math.min(plusy, dist);
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				if (domino[t][i][j] == 1 && plusy != Integer.MAX_VALUE) {
					blue[i + x][j + plusy] = index;
				}
			}
		}
	}

	private static void gadd(int index, int t, int y) {
		q = new LinkedList<>();
		int temp[][] = new int[6][4];
		for (int i = 0; i < 6; i++)
			System.arraycopy(green[i], 0, temp[i], 0, 4);

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				if (domino[t][i][j] == 1) {
					temp[i][j + y] = index;
				}
			}
		}
		for (int i = 5; i >= 0; i--) {
			for (int j = 0; j < 4; j++) {
				if (temp[i][j] == index) {
					q.add(new Point(i, j)); // 열중 가장 먼 index값 기준
				}
			}
		}
		int plusx = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Point p = q.poll();
			int dist = 0;
			for (int i = p.x; i < 5; i++) {
				if (temp[i + 1][p.y] == 0)
					dist++;
				else
					break;
			}
			
			plusx = Math.min(plusx, dist);
		}

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				if (domino[t][i][j] == 1 && plusx != Integer.MAX_VALUE) {
					green[i + plusx][y + j] = index;
		
				}
			}
		}
	}
}
