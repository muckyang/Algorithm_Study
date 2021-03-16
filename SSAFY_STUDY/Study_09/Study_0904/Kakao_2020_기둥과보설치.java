package Study_0904;

public class Kakao_2020_기둥과보설치 {
	static boolean map[][][];
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };
	static int resSize;
	static int[][] result;

	public static void main(String[] args) {
		int n = 5;
//		int[][] build_frame = { { 1, 0, 0, 1 }, { 1, 1, 1, 1 }, { 2, 1, 0, 1 }, { 2, 2, 1, 1 }, { 5, 0, 0, 1 },
//				{ 5, 1, 0, 1 }, { 4, 2, 1, 1 }, { 3, 2, 1, 1 } };
//		int[][] build_frame = { { 0, 0, 0, 1 }, { 0, 1, 0, 1 }, { 0, 2, 0, 1 }, { 0, 3, 0, 1 }, { 0, 4, 0, 1 },
//				{ 2, 1, 1, 1 }, { 3, 1, 1, 1 }, { 2, 2, 0, 1 } };
		int[][] build_frame = { { 0, 0, 0, 1 }, { 0, 0, 0, 0 } };
		solution(n, build_frame);
	}

	public static int[][] solution(int n, int[][] build_frame) {
		map = new boolean[2][n + 1][n + 1];
		resSize = 0;
		for (int i = 0; i < build_frame.length; i++) {// 작업 수 만큼 반복함
			int x = build_frame[i][0];
			int y = build_frame[i][1]; // 좌표
			int a = build_frame[i][2];// 0 기둥 (|), 1보(ㅡ)
			int b = build_frame[i][3];// 0 삭제 , 1건설
			if (b == 0) {
				map[a][y][x] = del(x, y, a, n);
				if (!map[a][y][x])
					resSize--;
			} else {
				map[a][y][x] = add(x, y, a, n);
				if (map[a][y][x])
					resSize++;
			}

		}

		result = new int[resSize][3];
		print(map, n);
		return result;
	}

	private static boolean del(int x, int y, int a, int n) {
		boolean canDelete = false;
		map[a][y][x] = false;

		if (a == 0) { // 기둥 삭제
			if (x > 0 && y < n && map[1][y + 1][x - 1]) {
				if (!add(x - 1, y + 1, 1, n)) // 왼쪽 보
					canDelete = true;
			}
			if (y < n && map[0][y + 1][x]) {
				if (!add(x, y + 1, 0, n))
					canDelete = true;
			}
			if (y < n && map[1][y + 1][x]) {
				if (!add(x, y + 1, 1, n))
					canDelete = true;
			}
		} else { // 보 삭제
			if (!add(x, y, 0, n) && map[0][y][x]) // 바로위 기둥
				canDelete = true;
			if (x > 0) {
				if (!add(x - 1, y, 1, n) && map[1][y][x - 1])
					canDelete = true;
			}
			if (x < n) {
				if (!add(x + 1, y, 0, n) && map[0][y][x + 1])
					canDelete = true;
			}
			if (x < n) {
				if (!add(x + 1, y, 1, n) && map[1][y][x + 1])
					canDelete = true;
			}
		}

		return canDelete;
	}

	private static boolean add(int x, int y, int a, int n) {
		boolean canAdd = false;
		if (a == 0) { // 기둥 추가
			if (y == 0 || ((x > 0 && map[1][y][x - 1]) || (map[1][y][x]) || (y > 0 && map[0][y - 1][x]))) {// 가능
				// 바닥과 닿았거나 기둥위에 있거나 보 하나와 닿아있는경우
				canAdd = true;
			}
		} else { // 보 추가
			if (((x > 0 && map[1][y][x - 1]) && (x < n && map[1][y][x + 1])) || (y > 0 && map[0][y - 1][x])
					|| (x < n && y > 0 && map[0][y - 1][x + 1])) {// 가능
				// 양쪽 보가 연결되어 있거나 기둥하나와 인접한 경우
				canAdd = true;
			}
		}
		return canAdd;
	}

	private static void print(boolean[][][] map, int n) {
		int count = 0;
		for (int j = 0; j < n + 1; j++) {
			for (int i = 0; i < n + 1; i++) {
				for (int b = 0; b < 2; b++) {
					if (map[b][i][j]) {
						result[count][0] = j;
						result[count][1] = i;
						result[count][2] = b;
						System.out.println(j + " , " + i + " ," + b);

						count++;
					}
				}
			}
		}

	}

}
