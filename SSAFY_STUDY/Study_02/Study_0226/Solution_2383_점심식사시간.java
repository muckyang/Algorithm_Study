package Study_0226;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution_2383_점심식사시간 {
	static int N;
	static int[][] matrix;
	static int pcount, res;
	static int[] px;
	static int[] py;
	static int alist[];
	static int blist[];
	static int asx, asy, bsx, bsy, va, vb;
	static boolean[] astair;
	static PriorityQueue<Point> aque;
	static PriorityQueue<Point> bque;

	private static class Point implements Comparable<Point> {
		int x;
		int y;
		int dist; // 계단 까지의 거리

		public Point(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Point o) {
			return this.dist - o.dist;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			res = Integer.MAX_VALUE;
			asx = asy = bsx = bsy = -1;
			pcount = 0;
			px = new int[10];
			py = new int[10];
			aque = new PriorityQueue<>();
			bque = new PriorityQueue<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int k = sc.nextInt();
					if (k == 1) {// 사람위치
						px[pcount] = i;
						py[pcount] = j;
						pcount++;
					} else if (k > 1) {// 계단위치
						if (asx == -1) {
							asx = i;
							asy = j;
							va = k;
						} else {
							bsx = i;
							bsy = j;
							vb = k;
						}
					}
				}
			}
//
//			for (int i = 0; i < pcount; i++) {
//				System.out.println(px[i] + " , " + py[i]);
//			}
//
//			System.out.println(asx + " , " + asy + " , " + va);
//			System.out.println(bsx + " , " + bsy + " , " + vb);

			// 입력 확인 완료
			astair = new boolean[pcount];
//			System.out.println("pcount : " + pcount);
			combi(0, 0);
			System.out.println("#" + test_case + " " + res);

		}
	}

	private static void combi(int start, int cnt) {

		if (cnt >= 0) {
			
//			aque.add(new Point(1,3,2));
//			aque.add(new Point(1,4,2));
//			aque.add(new Point(1,1,4));
			for (int i = 0; i < pcount; i++) {
				if (astair[i]) {
					int abs = Math.abs(px[i] - asx) + Math.abs(py[i] - asy);
					aque.add(new Point(px[i], py[i], abs));
				} else {
					int abs = Math.abs(px[i] - bsx) + Math.abs(py[i] - bsy);
					bque.add(new Point(px[i], py[i], abs));
				}
			}
			
			
			
			
			
//			System.out.print("aque : ");
//			int k = aque.size();
//			for(int i = 0; i < k ;i++)
//				System.out.print(aque.poll().dist + " ");
//			System.out.println();
//			k = bque.size();
//			System.out.print("bque : ");
//			for(int i = 0; i < k;i++)
//				System.out.print(bque.poll().dist + " ");
//			System.out.println();

			// combi로 맞게 구분됨
			moveAll();
		}
		if (cnt == pcount) {
			return;
		}
		for (int i = start; i < pcount; i++) {
			astair[i] = true;
			combi(i + 1, cnt + 1);
			astair[i] = false;
		}

	}

	private static void moveAll() {
		int inTimes = 0;
		int inBTimes = 0;
		Queue<Point> aq = new LinkedList<Point>();
		Queue<Integer> endtime = new LinkedList<Integer>();
		Queue<Point> bq = new LinkedList<Point>();
		while (!aque.isEmpty()) {
			Point p = aque.poll();
			if (inTimes < p.dist)
				inTimes = p.dist;
			if (aq.size() != 3) {
				aq.add(p);
				endtime.add(inTimes + va);// 나오는시간
			} else {
				while (aq.size() == 3) {// 길이 3인동안
					inTimes++;
					if (endtime.peek() == inTimes) {
						while(endtime.peek() != inTimes) {
							aq.poll();
							endtime.poll();
							if(aq.isEmpty())
								break;
						}
						aq.add(p);
						endtime.add(inTimes + va);
						break;
					}
				}
			}
			if (aque.isEmpty()) {
				while (!aq.isEmpty()) {
					inTimes++;
					while(endtime.peek() != inTimes) {
						aq.poll();
						endtime.poll();
						if(aq.isEmpty())
							break;
					}
				}
			}

		}

		while (!bque.isEmpty()) {
			Point p = bque.poll();
			if (inBTimes < p.dist)
				inBTimes = p.dist;
			if (bq.size() != 3) {
				bq.add(p);
				endtime.add(inBTimes + vb);// 나오는시간
			} else {
				while (bq.size() == 3) {// 길이 3인동안
					inBTimes++;
					if (endtime.peek() == inBTimes) {
						while(endtime.peek() != inBTimes) {
							bq.poll();
							endtime.poll();
							if(bq.isEmpty())
								break;
						}
						bq.add(p);
						endtime.add(inBTimes + vb);
						break;
					}
				}
			}
			if (bque.isEmpty()) {
				while (!bq.isEmpty()) {
					inBTimes++;
					while(endtime.peek() != inBTimes) {
						bq.poll();
						endtime.poll();
						if(bq.isEmpty())
							break;
					}
				}
			}

		}
		int times = inTimes > inBTimes ? inTimes : inBTimes;
		if (res > times)
			res = times;

	}
}
