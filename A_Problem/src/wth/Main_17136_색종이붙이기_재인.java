package wth;

import java.util.Scanner;

public class Main_17136_색종이붙이기_재인 {

	static int[][] paper;
	static int min = Integer.MAX_VALUE;
	static int[] sak = { 5, 5, 5, 5, 5 };

	public static void dfs(int y, int x, int cnt) {
		if (x == 10) {
			x = 0;
			y++;
		}
		if (y == 10) {
			if (min > cnt)
				min = cnt;
			return;
		}
		// 종료조건 끝

		if (paper[y][x] == 1) { // 1이 적혀 있다면?
			for (int s = 4; s >= 0; s--) { // 큰거부터 차례대로 확인
				if (sak[s] != 0) {// s+1 크기의 종이가 없다면 불가능
					if (find(s, y, x)) {
						sak[s]--; // 남은 종이수 줄임
						fill(s, y, x, 0);
						dfs(y, x + 1, cnt + 1);
						fill(s, y, x, 1);
						sak[s]++;
					}
				}
			}
		} else { //현재위치가 1이 아니라면 ? 
			x++; // x를 증가
			if (x == 10) {// 10되면 다음 줄로 이동
				x = 0;
				y++;
			}
			dfs(y, x, cnt);
		}
	}

	public static void fill(int s, int y, int x, int c) {
		for (int i = y; i < y + s + 1; i++) {
			for (int j = x; j < x + s + 1; j++) {

				paper[i][j] = c;

			}
		}
	}

	public static boolean find(int s, int y, int x) {
		for (int i = y; i < y + s + 1; i++) {
			for (int j = x; j < x + s + 1; j++) {
				//종이 넘어가거나 놓을곳에 하나라도 1이아니하면 false
				if (i < 0 || j < 0 || i >= 10 || j >= 10 || paper[i][j] != 1) 
					return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		paper = new int[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				paper[i][j] = sc.nextInt();
			}
		}
		dfs(0, 0, 0);

		if (min == Integer.MAX_VALUE)
			min = -1;
		System.out.println(min);
	}

}