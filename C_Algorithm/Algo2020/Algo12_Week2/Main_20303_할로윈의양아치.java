package Algo12_Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
//56856, 1080
public class Main_20303_할로윈의양아치 {
	static int N, M, K;
	static LinkedList<Integer>[] list;
	static LinkedList<Sum> sum;
	static int candy[];
	static int cache[];
	static boolean v[];
	static Sum temp;

	static int res;

	public static class Sum {
		int people;
		int candy;

		public Sum(int people, int candy) {
			this.people = people;
			this.candy = candy;
		}

		@Override
		public String toString() {
			return "Sum [people=" + people + ", candy=" + candy + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new LinkedList[N];
		candy = new int[N];
		cache = new int[K + 1];
		sum = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			candy[i] = Integer.parseInt(st.nextToken());
			list[i] = new LinkedList<>();
		}
		v = new boolean[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			list[from].add(to);
			list[to].add(from);
		}
		for (int i = 0; i < N; i++) {
			if (!v[i]) {
				temp = new Sum(0, 0);
				go(i);
				sum.add(temp);
			}
		}
		for (int i = 0; i < sum.size(); i++) {
			Sum group = sum.get(i);
			for (int j = K-1; j >= group.people; j--) {
				if (cache[j] < cache[j-group.people] + group.candy) {
                	cache[j] = cache[j-group.people] + group.candy;
                }
			}
		}
		System.out.println(cache[K-1]);
	}

	private static void go(int now) {
		if (!v[now]) {
			v[now] = true;
			temp.people++;
			temp.candy += candy[now];
			for (Integer k : list[now]) {
				go(k);
			}
		}
	}
}
