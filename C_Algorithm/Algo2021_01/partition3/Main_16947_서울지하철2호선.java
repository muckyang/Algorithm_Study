package partition3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//132364 KB, 520ms
public class Main_16947_서울지하철2호선 {
	static int N, rotateNum;
	static LinkedList<Integer> cycle;
	static int number[];
	static Queue<Integer> q;
	static LinkedList<Integer>[] ls;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		ls = new LinkedList[N + 1];
		number = new int[N + 1];
		cycle = new LinkedList<>();
		flag = false;
		for (int i = 1; i < N + 1; i++) {
			ls[i] = new LinkedList<>();
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			ls[from].add(to);
			ls[to].add(from);
		}
		cycle.add(1);// 1부터 넣고 찾기 시작
		number[1] = 1;
		getRotateNum(-1);
		for (int i = 1; i <= N; i++) {
			q = new LinkedList<>();
			q.add(i);
			sb.append(getDist()).append(" ");
		}
		System.out.println(sb.toString());

	}

	private static void getRotateNum(int root) {
		int last = cycle.getLast();
		for (Integer k : ls[last]) {
			if (flag)
				return;
			if (number[k] == 1 && root != k) {// 찾음
				number[k] = -1;
				flag = true;
				int size = cycle.size();
				for (int i = 0; i < size; i++) {
					int num = cycle.removeLast();
					if (number[num] == -1) {
						return;
					}
					number[num] = -1;
				}
			} else if (number[k] == 0) {
				cycle.add(k);
				number[k] = 1;
				getRotateNum(last);
				if (flag)
					return;
				cycle.removeLast();
			}
		}
	}

	private static int getDist() {
		int dist = 0;
		boolean v[] = new boolean[N + 1];
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int p = q.poll();
				v[p] = true;
				if (number[p] == -1)
					return dist;
				for (Integer k : ls[p]) {
					if (!v[k])
						q.add(k);
				}
			}
			dist++;
		}
		return 0;
	}
}
