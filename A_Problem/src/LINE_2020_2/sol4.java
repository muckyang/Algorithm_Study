package LINE_2020_2;

public class sol4 {
	static int dy[] = { -1, 0, 1, 0 };
	static int dx[] = { 0, 1, 0, -1 };
	static int n;

	public static void main(String[] args) {
		int[][] maze = { { 0, 1, 0, 1 }, { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 1, 0, 1, 0 } };
		System.out.println(solution(maze));
	}

	public static int solution(int[][] maze) {
		int answer = 0;
		int head = 0;
		n = maze.length;

		int y = 0;
		int x = 0;
		while (true) {
		
			if (x == n - 1 && y == n - 1) {
				break;
			}
			for (int d = 0; d < 4; d++) {
				int go = head + d - 1;
				if (go >= 4) {
					go -= 4;
				} else if (go < 0) {
					go = 4 + go;
				}
				int jy = y + dy[go];
				int ix = x + dx[go];
				if (safe(jy, ix) || maze[jy][ix] == 1)
					continue;
				x = ix;
				y = jy;
				head = go;
				break;

			}

			answer++;
		}
		return answer;
	}

	private static boolean safe(int jy, int ix) {
		if (ix >= n || jy >= n || ix < 0 || jy < 0)
			return true;
		return false;
	}
}
