package partition1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_20666_인물이와정수 {
	static int N, M, p;
	static LinkedList<Item>[] ls;
	static PriorityQueue<Stage>pq;
	
	static Stage[] stage;
	static long down[];
	static long res;

	public static class Item {
		int target;
		long level;

		public Item(int target, long level) {
			super();
			this.target = target;
			this.level = level;
		}

	}

	public static class Stage implements Comparable<Stage> {
		int index;
		long level;

		public Stage(int index, long level) {
			super();
			this.index = index;
			this.level = level;
		}

		@Override
		public int compareTo(Stage o) {
			if (this.level > o.level)
				return 1;
			return -1;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		res = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		stage = new Stage[N];
		ls = new LinkedList[N];
		pq=  new PriorityQueue<>();
		down = new long[N];
		for (int i = 0; i < N; i++) {
			ls[i] = new LinkedList<>();
			stage[i] = new Stage(i, Long.parseLong(st.nextToken()));
		}
		res = 0;
		st = new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken());
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			int item = Integer.parseInt(st.nextToken()) - 1;
			int target = Integer.parseInt(st.nextToken()) - 1;
			int up = Integer.parseInt(st.nextToken());
			ls[item].add(new Item(target, up));
			stage[target].level += up;
		}
		for(int i = 0 ; i < N;i++) {
			pq.add(stage[i]);
		}
		for (int i = 0; i < M; i++) {
			Arrays.sort(stage);
			Stage lowlevel = stage[0];
			long lv = lowlevel.level;
			int now = lowlevel.index;
			
			stage[0].level = Long.MAX_VALUE;
			for (Item item : ls[now]) {
				stage[item.target].level -= item.level;
			}
			res = Math.max(res, lv);
		}
		System.out.println(res);
	}
}
