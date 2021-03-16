package Study_0516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16235_나무재테크 {
	static int N, M, K;
	static int map[][];
	static int add[][];
	static int dx[] = { 0, 1, 0, -1, 1, 1, -1, -1 };
	static int dy[] = { 1, 0, -1, 0, 1, -1, 1, -1 };

	static PriorityQueue<Tree> pq;
	static Queue<Tree> nq;
	static Queue<Tree> dq;

	public static class Tree implements Comparable<Tree> {
		int x, y, age;

		public Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		pq = new PriorityQueue<>();
		nq = new LinkedList<>();
		dq = new LinkedList<>();
		map = new int[N][N];
		add = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = 5;
				add[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {// M 개의 나무 좌표와 나이
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int age = Integer.parseInt(st.nextToken());
			pq.add(new Tree(x, y, age));
		}

		for (int k = 0; k < K; k++) {// K년 후의 값
			spring();
			summer();
			fall();
			winter();
		}
		System.out.println(pq.size());
	}

	private static void spring() {
		while (!pq.isEmpty()) {
			Tree t = pq.poll();
			if (map[t.x][t.y] < t.age)// 양분 부족한 경우
				dq.add(new Tree(t.x, t.y, t.age));
			else {
				map[t.x][t.y] -= t.age;
				nq.add(new Tree(t.x, t.y, t.age + 1));
			}
		}
	}

	private static void summer() {
		while (!dq.isEmpty()) {
			Tree t = dq.poll();
			map[t.x][t.y] += t.age / 2;
		}
	}

	private static void fall() {
		while (!nq.isEmpty()) {
			Tree t = nq.poll();
			if (t.age % 5 == 0) {
				for (int d = 0; d < 8; d++) {
					int ix = t.x + dx[d];
					int jy = t.y + dy[d];
					if (!safe(ix, jy))
						continue;
					pq.add(new Tree(ix, jy, 1));
				}
			}
			pq.add(t);
		}
	}

	private static boolean safe(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		return false;
	}

	private static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] += add[i][j];
			}
		}
	}

}
