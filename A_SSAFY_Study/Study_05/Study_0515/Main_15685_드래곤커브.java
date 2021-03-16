package Study_0515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_15685_드래곤커브 {
	static int N;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static boolean v[][];

	static Stack<Integer>[] list;

	public static class Dragon {
		int x, y, d, g;

		public Dragon(int x, int y, int d, int g) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.g = g;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		v = new boolean[101][101];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			list = new Stack[10];
			list[0] = new Stack<>();
			list[0].add(d);
			v[x][y] = true;

			int ix = x + dx[d];
			int jy = y + dy[d];
			v[ix][jy] = true;

			for (int gen = 1; gen <= g; gen++) {
				list[gen] = list[gen-1];
				int size = list[gen - 1].size() - 1;
				System.out.println("size :"+size);
				for (int k = size; k >= 0; k--) {
					int dk = list[gen - 1].get(k);
					dk = (dk - 1) < 0 ? 4 + (dk -1): dk;
					ix += dx[dk];
					jy += dy[dk];
					v[ix][jy] = true;
					list[gen].add(dk);
				}
			}
			print();
		}

	}

	private static void print() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(v[i][j] ? 1 : 0 );
			}
			System.out.println();
		}
		System.out.println();
	}
}
