import java.util.LinkedList;
import java.util.Queue;

public class Solution04 {
	static int map[][];
	static boolean v[][];
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static Queue<Point> q;

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;

		}
	}

	public static void main(String[] args) {
		int[][] macaron = { { 1, 1 }, { 2, 1 }, { 1, 2 }, { 3, 3 }, { 6, 4 }, { 3, 1 }, { 3, 3 }, { 3, 3 }, { 3, 4 },
				{ 2, 1 } };
		String [] answer = new String[6];
		map = new int[6][6];
		q = new LinkedList<>();
		for (int i = 0; i < macaron.length; i++) {
			dropmac(macaron[i][0] - 1, macaron[i][1]);// (x,y) x번쨰위치에 y색깔 마카롱 떨굼
			while(true) {
				if(!boom()) {
					break;
				}
				dropAll();
			
			}
		}
		
		for(int i = 0 ; i <6;i++) {
			answer[i] = "";
			for(int j = 0 ; j <6;j++) {
				answer[i]+=map[i][j];
			}
		}
//		return answer;
		for(int i = 0 ; i < 6;i++) 
			System.out.println(answer[i].toString());
	}

	private static void dropmac(int loca, int color) {
		map[0][loca] = color;
		for (int i = 1; i < 6; i++) {
			if (map[i][loca] == 0) {
				map[i][loca] = color;
				map[i-1][loca] = 0;
			} else {
				return;
			}

		}
	}

	private static boolean boom() {
		boolean check = false;
		v = new boolean[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (map[i][j] != 0 && !v[i][j]) {
					v[i][j] = true;
					int color = map[i][j];
					q.add(new Point(i, j));
					if(bfs(color,i,j)) {
						check= true;
					}
				}
			}
		}
		return check;
	}

	private static boolean bfs(int color,int x,int y) {
		boolean pop[][] = new boolean[6][6];
		pop[x][y] = true;
		int cnt = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				pop[p.x][p.y] = true;
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int jy = p.y + dy[d];
					if (safe(ix, jy) && !v[ix][jy] && map[ix][jy] == color) {
						cnt++;
						v[ix][jy] = true;
						pop[ix][jy] = true;
						q.add(new Point(ix, jy));
					}
				}
			}

		}
		if (cnt > 2) {
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					if (pop[i][j]) {
						map[i][j] = 0;
					}
				}
			}
			return true;
		}
		return false;
	}

	private static void dropAll() {

		for (int j = 0; j < 6; j++) {
			int[] temp = new int[6];
			int index = 5;
			for (int i = 5; i >= 0; i--) {
				if (map[i][j] != 0) {
					temp[index] = map[i][j];
					index--;
				}
		
			}
			for(int i = 0 ; i < 6;i++) {
				map[i][j] = temp[i];
			}
		}
	}

	private static boolean safe(int ix, int jy) {
		if (ix >= 0 && jy >= 0 && ix < 6 && jy < 6) {
			return true;
		}
		return false;
	}

}
