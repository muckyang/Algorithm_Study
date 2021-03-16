package Main_14001_to_16000;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_15686_치킨배달 {
	static int N, K;
	static int map[][];
	static int res;
	static int hc, cc;// 집의수 ,치킨집수
	static List<Point> hlist;
	static List<Point> clist;
	static List<Point> checklist;
	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][N];
		hlist = new LinkedList<>();
		clist = new LinkedList<>();
		hc = cc = 0;
		res = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int k = sc.nextInt();
				map[i][j] = k;
				if (k == 1) {
					hlist.add(new Point(i, j));
					hc++;
				}
				if (k == 2) {
					clist.add(new Point(i, j));
					cc++;
				}
			}
		}
		checklist = new LinkedList<>();
		combi(0, 0);// start , count
		System.out.println(res);
	}

	private static void combi(int start, int count) {
		if (count == K) { // 체크하기
			int sum = 0;
			int min = Integer.MAX_VALUE;
			for (int h = 0; h < hc; h++) {
				min = Integer.MAX_VALUE;
				int hx = hlist.get(h).x;
				int hy = hlist.get(h).y;
				for (int i = 0; i < K; i++) {
					int cx = checklist.get(i).x;
					int cy = checklist.get(i).y;
					int su = Math.abs(hx-cx) + Math.abs(hy-cy);
					if(min > su) {
						min = su;
					}
				}
				sum += min;
			}
			if (res > sum)
				res = sum;
			return;
		}
		for (int i = start; i < cc; i++) {
			checklist.add(clist.get(i));
			combi(i + 1, count + 1);
			checklist.remove(count);
		}

	}
}
