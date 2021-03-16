package Month02_Week02;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_7562_나이트의이동 {
	static int T;
	static int I;
	static boolean[][] visited;
	static int sx, sy, ex, ey;
	static int dx[] = { 1, 2, -2, -1, 1, 2, -2, -1 };
	static int dy[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int check, ans;
	static Queue<Integer> que;

	public static void BFS() {
		int jump = 0;
		while (!que.isEmpty()) {
			int k = que.size() / 2;
			for (int i = 0; i < k; i++) {
				int x = que.poll();
				int y = que.poll();
				visited[x][y] = true;

				if (x == ex && y == ey) {
					ans = jump;
					return;
				}

				for (int d = 0; d < 8; d++) {
					int ix = x + dx[d];
					int jy = y + dy[d];
					if (ix >= 0 && jy >= 0 && ix < I && jy < I && visited[ix][jy] == false) {
						que.offer(ix);
						que.offer(jy);

						visited[ix][jy] = true;
					}
				}
			}
			jump++;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			I = sc.nextInt();
			sx = sc.nextInt();
			sy = sc.nextInt();
			ex = sc.nextInt();
			ey = sc.nextInt();
			que = new LinkedList<>();
			check = 0;
			visited = new boolean[I][I];
			que.offer(sx);
			que.offer(sy);
			BFS();

			System.out.println(ans);

		}
	}

}
