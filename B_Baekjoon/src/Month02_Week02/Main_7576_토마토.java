package Month02_Week02;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_7576_토마토 {
	static int N, M;
	static int[][] matrix;
	static boolean[][] flag;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int cnt, check;

	public static void BFS() {
		Queue<Integer> que = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matrix[i][j] == 1 && flag[i][j] == false) {
					flag[i][j] = true;
					que.offer(i);
					que.offer(j);
				}
			}
		}
		while (true) {
			if (que.isEmpty()) {
				cnt--;
				return;
			}
			cnt++;
			int q = que.size();
			for (int k = 0; k < q / 2; k++) {
				int x = que.poll();
				int y = que.poll();
				for (int d = 0; d < 4; d++) {
					int ix = x + dx[d];
					int jy = y + dy[d];
					if (ix >= 0 && jy >= 0 && ix < N && jy < M && matrix[ix][jy] == 0 && flag[ix][jy] == false) {
						matrix[ix][jy] = 1;
						que.offer(ix);
						que.offer(jy);
						flag[ix][jy] = true;

					}

				}

			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		cnt = 0;
		check = 1;
		matrix = new int[N][M];
		flag = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				matrix[i][j] = sc.nextInt();
				if (matrix[i][j] == 0)
					check = 0;
			}
		}
		BFS();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matrix[i][j] == 0)
					cnt = -1;
			}
		}
		System.out.println(cnt);
	}
}
