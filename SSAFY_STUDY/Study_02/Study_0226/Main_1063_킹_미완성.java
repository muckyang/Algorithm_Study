package Study_0226;

import java.util.Scanner;

public class Main_1063_킹_미완성 {
	static int kx, ky, sx, sy, N;
	//					 우 / 좌 / 상 /하 / 좌상 / 좌하 / 우싱 / 우하
	static int[] dx = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static int[] dy = { 1, -1, 0, 0, -1, -1, 1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		ky = s1.charAt(0) - 65;
		kx = s1.charAt(1) - 49;
		s1 = sc.next();
		sy = s1.charAt(0) - 65;
		sx = s1.charAt(1) - 49;
		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int d = -1;
			s1 = sc.next();
			if (s1.equals("R")) {
				d = 0;
			}
			if (s1.equals("L")) {
				d = 1;
			}
			if (s1.equals("T")) {
				d = 2;
			}
			if (s1.equals("B")) {
				d = 3;
			}
			if (s1.equals("LT")) {
				d = 4;
			}
			if (s1.equals("LB")) {
				d = 5;
			}
			if (s1.equals("RT")) {
				d = 6;
			}
			if (s1.equals("RB")) {
				d = 7;
			}
			func(d);
		}
		String kxy = "";
		kxy += (char) (ky + 65);
		kxy += (char) (kx + 49);

		String sxy = "";
		sxy += (char) (sy + 65);
		sxy += (char) (sx + 49);

		System.out.println(kxy);
		System.out.println(sxy);

	}

	private static void func(int d) {
		int ikx = kx + dx[d];
		int iky = ky + dy[d];
		int isx = sx + dx[d];
		int isy = sy + dy[d];
		if (safe(ikx, iky)) {
			if (ikx != sx && iky != sy) {
				kx += dx[d];
				ky += dy[d];
				return;
			}
			if (ikx == sx && iky == sy && safe(isx, isy)) {
				sx += dx[d];
				sy += dy[d];
				kx += dx[d];
				ky += dy[d];
				return;
			}
			
		}

	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < 8 && y < 8) {
			return true;
		}
		return false;
	}
}
