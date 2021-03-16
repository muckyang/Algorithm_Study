package Study_1010;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_19238_스타트택시 {
	static int N, M, Amount;// map크기, 승객수, 초기연료량
	static int[][] map;
	static boolean[][] v;
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 }; // 상,좌,우,하 순으로 찾으면 행,열번호 순으로 찾을 수 있음.
	static int target = 0; // 목적지에 도달한 승객수
	static Customer[] customer;
	static int b_r, b_c;// 백준이의 위치
	static boolean xGo;// 연료로 갈수 없음

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		Amount = sc.nextInt();
		map = new int[N][N];
		customer = new Customer[M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		b_r = sc.nextInt();
		b_c = sc.nextInt();
		int count = 2;
		for (int i = 0; i < M; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int nr = sc.nextInt();
			int nc = sc.nextInt();
			customer[i] = new Customer(r - 1, c - 1, nr - 1, nc - 1);
			map[r - 1][c - 1] = count++; // 승객 위치 저장 ( 승객 위치 - 2 해서 customer배열에서 찾으면 된다 )
		}
//      for(int i=0;i<N;i++) {
//         for(int j=0;j<N;j++) {
//            System.out.print(map[i][j]+" ");
//         }
//         System.out.println();
//      }

		search(b_r - 1, b_c - 1); // 가까운 승객 찾기.

		if (xGo || target < M)
			System.out.println(-1);
		else if (target == M)
			System.out.println(Amount);
	}

	private static void search(int r, int c) { // 승객 찾는 메소드

//      System.out.println("승객 움직임 끝!, Amount "+Amount);
		v = new boolean[N][N];
		boolean[][] nv = new boolean[N][N];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));
		boolean isSearch = false;
		while (!q.isEmpty()) {
			// System.out.println("AMOUNT: "+Amount);
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point cp = q.poll();
				v[cp.r][cp.c] = true;
				if (map[cp.r][cp.c] > 1) { // 택시에 자리에 승객이 있으면
					if (Amount < 0) {
						xGo = true;// 다음으로 갈수 없음.
						return;
					}
					Customer cust = customer[map[cp.r][cp.c] - 2];
					isSearch = true;
					map[cp.r][cp.c] = 0; // 승객 태워감.
					search_d(cust); // 찾은 승객의 목적지를 찾음
					break;
				}
				for (int d = 0; d < 4; d++) {
					int nr = cp.r + dr[d];
					int nc = cp.c + dc[d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 1 || v[nr][nc] || nv[nr][nc])
						continue;
					nv[nr][nc] = true;
					// System.out.println("taxi : " + r+", "+c+" next : "+nr+", "+nc);
					q.add(new Point(nr, nc));// que에 다음 갈 곳으로 넣는다.
					if (map[nr][nc] > 1) { // 승객이 있으면
						Amount--;
						if (Amount < 0) {
							xGo = true;// 다음으로 갈수 없음.
							return;
						}
						Customer cust = customer[map[nr][nc] - 2];
						isSearch = true;
						map[nr][nc] = 0; // 승객 태워가니까 0으로 만들어줌.
						search_d(cust); // 승객의 목적지 찾으러감
						break;
					}
				}
				if (isSearch)
					break;
			}
			if (isSearch)
				break;
			if (xGo)
				break;
			Amount--;
			if (Amount < 0) {
				xGo = true;
				break;
			}
		}
	}

	private static void search_d(Customer cust) { // 승객의 도착지 찾음
		// System.out.println("taxi만 움직임 끝!, Amount "+Amount);
		int distance = 0;
		boolean isSearch = false;
		v = new boolean[N][N];// 방문 위치 다시 초기화
		boolean[][] nv = new boolean[N][N];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(cust.sr, cust.sc));
		while (!q.isEmpty()) {
			// System.out.println("AMOUNT: "+Amount);
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point cp = q.poll();
				v[cp.r][cp.c] = true;
				for (int d = 0; d < 4; d++) {
					int nr = cp.r + dr[d];
					int nc = cp.c + dc[d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 1 || v[nr][nc] || nv[nr][nc])
						continue;
					nv[nr][nc] = true;
					q.add(new Point(nr, nc));// que에 다음 갈 곳으로 넣는다.
					// System.out.println("customer : " + cust.sr+", "+cust.sc+" next : "+nr+",
					// "+nc);
					if (nr == cust.sdr && nc == cust.sdc) {// 다음으로 갈 곳이 목적지이면
						// System.out.println("SEARCH DESTINATION");
						distance++;
						Amount--;
						if (Amount < 0) {
							xGo = true;// 다음으로 갈수 없음.
							return;
						}
						Amount = Amount + (distance * 2);
						target++;
						isSearch = true;
						break;
					}
				}
				if (isSearch)
					break;
			}
			if (isSearch)
				break;
			distance++;
			Amount--;
			if (Amount <= 0) {
				xGo = true;
				break;
			}
		}
		if (!isSearch) {
			xGo = true;
			return;
		}
//      System.out.println("DDDD"+distance +" AAAA"+Amount);
//      System.out.println();
		if (target == M)
			return;
		if (target < M)
			search(cust.sdr, cust.sdc);
	}

	public static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static class Customer {
		int sr, sc;// 고객 위치
		int sdr, sdc;// 고객 목적지

		public Customer(int sr, int sc, int sdr, int sdc) {
			super();
			this.sr = sr;
			this.sc = sc;
			this.sdr = sdr;
			this.sdc = sdc;
		}
	}
}
