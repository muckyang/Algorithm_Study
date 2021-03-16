package Month02_Week02;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Zelda implements Comparable<Zelda> {

	int x;
	int y;
	int value;// 값

	public Zelda(int x, int y, int value) {
		super();
		this.x = x;
		this.y = y;
		this.value = value;
	}

	@Override
	public int compareTo(Zelda target) {
		if (this.value > target.value) {
			return 1;
		} else if (this.value < target.value) {
			return -1;
		}
		return 0;
	}

}

public class Main_4485_녹색옷입은젤다 {
	static int[][] matrix;
	static int[][] min;
	static boolean[][] visited;
	static int N, result;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static PriorityQueue<Zelda> que;

	public static void func(int x, int y) {
		visited[x][y] = true;
		min[x][y] = matrix[x][y];
		que.add(new Zelda(x, y, matrix[x][y]));
		/// 첫 사이클
		while (true) {
			Zelda z = que.poll();
			visited[z.x][z.y] = true;
			
			if (z.x == N - 1 && z.y == N - 1)
				return;
			
			for (int d = 0; d < 4; d++) {
				int ix = z.x + dx[d];
				int jy = z.y + dy[d];
				
				if (ix >= 0 && jy >= 0 && ix < N && jy < N && visited[ix][jy] == false   ) {
					int min_v = Math.min(min[z.x][z.y] + matrix[ix][jy], min[ix][jy]);
					min[ix][jy] = min_v;
					que.add(new Zelda(ix, jy, min_v));

				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1;; test_case++) {
			N = sc.nextInt();
			result = 0;
			if (N == 0)
				return;
			
			que = new PriorityQueue<>();
			matrix = new int[N][N];
			min = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = sc.nextInt();
				}
				Arrays.fill(min[i], Integer.MAX_VALUE);
			}

			func(0, 0);
			System.out.println("Problem " + test_case + ": " + min[N - 1][N - 1]);
			que.clear();
		}
	}
}
