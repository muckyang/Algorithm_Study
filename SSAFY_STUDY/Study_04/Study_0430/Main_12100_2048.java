package Study_0430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12100_2048 {
	static int N;
	static int map[][];
	static int temp[][];
	static int max;
	static int turn[];
	
	// 최대 5번 이동 한후 최대값?
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		turn = new int[5];
		max = Integer.MIN_VALUE;
		StringTokenizer st = new StringTokenizer("");
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
			}
		}
		perm(0);
		System.out.println(max);
	}

	private static void perm(int count) {
		if (count == 5) {
			temp = new int[N][N];
			for (int i = 0; i < N; i++)
				System.arraycopy(map[i], 0, temp[i], 0, N);
			for (int i = 0; i < 5; i++) {
				slide(turn[i]);
			}
			max();
			return;
		}
		for (int i = 0; i < 4; i++) {
			turn[count] = i;
			perm(count + 1);
		}
	}

	private static void max() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (max < temp[i][j])
					max = temp[i][j];
			}

		}
	}

	private static void slide(int t) {
		int[] list;
		boolean[] v;
		if (t == 0) {// 하
			for (int j = 0; j < N; j++) {
				list = new int[N];
				v = new boolean[N];
				int cnt = N - 1;
				for (int i = N - 1; i >= 0; i--) {
					if (temp[i][j] != 0) {
						if (cnt != N - 1 && list[cnt + 1] == temp[i][j] && !v[cnt + 1]) {
							v[cnt + 1] = true;
							list[cnt + 1] *= 2;
						} else {
							list[cnt] = temp[i][j];
							cnt--;
						}
					}
				}
				for(int i= 0 ; i < N ; i++)
					temp[i][j] = list[i];
			}
			
		} else if (t == 1) { // 상
			for (int j = 0; j < N; j++) {
				list = new int[N];
				v = new boolean[N];
				int cnt = 0;
				for (int i = 0; i < N; i++) {
					if (temp[i][j] != 0) {
						if (cnt != 0 && list[cnt -1] == temp[i][j] && !v[cnt - 1]) {
							v[cnt - 1] = true;
							list[cnt - 1] *= 2;
						} else {
							list[cnt] = temp[i][j];
							cnt++;
						}
					}
				}
				for(int i= 0 ; i < N ; i++)
					temp[i][j] = list[i];
			}
		} else if (t == 2) { // 우
			for (int i = 0; i < N; i++) {
				list = new int[N];
				v = new boolean[N];
				int cnt = N - 1;
				for (int j = N - 1; j >= 0; j--) {
					if (temp[i][j] != 0) {
						if (cnt != N - 1 && list[cnt + 1] == temp[i][j] && !v[cnt + 1]) {
							v[cnt + 1] = true;
							list[cnt + 1] *= 2;
						} else {
							list[cnt] = temp[i][j];
							cnt--;
						}
					}
				}
				for(int j= 0 ; j < N ; j++)
					temp[i][j] = list[j];
			}
		} else if (t == 3) { // 좌
			for (int i = 0; i < N; i++) {
				list = new int[N];
				v = new boolean[N];
				int cnt = 0;
				for (int j = 0; j < N; j++) {
					if (temp[i][j] != 0) {
						if (cnt != 0 && list[cnt -1] == temp[i][j] && !v[cnt - 1]) {
							v[cnt - 1] = true;
							list[cnt - 1] *= 2;
						} else {
							list[cnt] = temp[i][j];
							cnt++;
						}
					}
				}
				for(int j= 0 ; j < N ; j++)
					temp[i][j] = list[j];
			}
		}
	}
}
