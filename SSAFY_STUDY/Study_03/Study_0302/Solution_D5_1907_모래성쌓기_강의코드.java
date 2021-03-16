package Study_0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_D5_1907_모래성쌓기_강의코드 {
	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;

		}
	}

	static int[] dr = { 0, 0, 1, 1, 1, -1, -1, -1 };
	static int[] dc = { 1, -1, 1, 0, -1, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int[][] map = new int[H][W];
			for (int r = 0; r < H; r++) {
				String str = sc.next();
				for (int c = 0; c < W; c++) {
					if (str.charAt(c) != '.')
						map[r][c] = str.charAt(c) - '0';
				}
			}
			Queue<Node> que = new LinkedList<>();
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					// 바다라면
					if (map[r][c] == 0) {
						for (int d = 0; d < 8; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							if (nr < 0 || nc < 0 || nr >= H || nc >= W)
								continue;
							if (map[nr][nc] != 0) {
								map[nr][nc]--;
								if (map[nr][nc] == 0) {
									map[nr][nc] = -1;
									que.add(new Node(nr, nc));
								}
							}

						}
					}

				}
			}

			int ans = 0;
			while (!que.isEmpty()) {
				int size = que.size();
				for (int i = 0; i < size; i++) {
					Node node = que.poll();
					for (int d = 0; d < 8; d++) {
						int nr = node.r + dr[d];
						int nc = node.c + dc[d];
						if (nr < 0 || nc < 0 || nr >= H || nc >= W)
							continue;
						if (map[nr][nc] > 0) {
							map[nr][nc]--;
							if (map[nr][nc] == 0) {
								map[nr][nc] = -1;
								que.add(new Node(nr, nc));
							}
						}

					}
				}
				ans++;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
