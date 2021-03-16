package Study_0224;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_불_진용쓰 {
	static int R, C;
	static char[][] map;
	static int[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int sy, sx, fy, fx;
	static int result;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("Main_4179"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		Queue<int[]> queue = new LinkedList<int[]>();
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R + 2][C + 2];
		visited = new int[R + 2][C + 2];
		result = 0;

		for (int i = 0; i < map.length; i++) {
			map[i][0] = 'G';
			map[i][R + 1] = 'G';
			map[0][i] = 'G';
			map[C + 1][i] = 'G';
		}

		for (int i = 1; i < map.length - 1; i++) {
			String str = br.readLine();
			for (int j = 1; j < str.length() + 1; j++) {
				map[i][j] = str.charAt(j - 1);
			}
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 'F') {
					fy = i;
					fx = j;
					queue.offer(new int[] { fy, fx, 2 });
				} else if (map[i][j] == 'J') {
					sy = i;
					sx = j;
					queue.offer(new int[] { sy, sx, 1 });
				}
			}
		}
		bfs(queue);
		System.out.println(result == 0 ? "IMPOSSIBLE" : result);

	}

	private static void bfs(Queue<int[]> queue) {
		int tempY, tempX;
		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			if (temp[2] == 1) {
				map[temp[0]][temp[1]] = '.';
				for (int d = 0; d < 4; d++) {
					tempY = temp[0] + dy[d];
					tempX = temp[1] + dx[d];
					if ((map[tempY][tempX] == '.') && visited[tempY][tempX] == 0) {
						map[tempY][tempX] = 'J';
						visited[tempY][tempX] = visited[temp[0]][temp[1]] + 1;
						queue.offer(new int[] { tempY, tempX, 1 });
					} else if (map[tempY][tempX] == 'G') {
						result = visited[temp[0]][temp[1]] + 1;
						return;
					}
				}
			} else if (temp[2] == 2) {
				for (int d = 0; d < 4; d++) {
					tempY = temp[0] + dy[d];
					tempX = temp[1] + dx[d];
					if (map[tempY][tempX] == '.' || map[tempY][tempX] == 'J') {
						map[tempY][tempX] = 'F';
						queue.offer(new int[] { tempY, tempX, 2 });
					}
				}
			}
		}
	}

}
