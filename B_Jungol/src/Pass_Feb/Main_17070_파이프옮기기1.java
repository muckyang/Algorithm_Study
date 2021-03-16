	package Pass_Feb;
	
	import java.util.Scanner;
	
	public class Main_17070_파이프옮기기1 {
		static int N, cnt;
		static boolean[][] visited;
		// 0이면 가로 1이면 세로 2이면 대각선
		static int[] dx = { 1, 0, 1 };
		static int[] dy = { 0, 1, 1 };
	
		public static void func(int x, int y,int back) {//back 은 이전에 온 파이프 모양
			if (x == N && y == N) {
				cnt++;
				return;
			} else {
				for (int d = 0; d < 3; d++) {
					if (d == 0 && back!=1) {// 세로확인
						int ix = dx[d] + x;
						int jy = dy[d] + y;
						if (jy < N + 1 && ix < N + 1 && visited[ix][jy] == false) {
							visited[ix][jy] = true;
							func(ix, jy,d);
							visited[ix][jy] = false;
						}
					} else if (d == 1 && back!=0) {// 세로확인
						int ix = dx[d] + x;
						int jy = dy[d] + y;
						if (jy < N + 1 && ix < N + 1 && visited[ix][jy] == false) {
							visited[ix][jy] = true;
							func(ix, jy,d);
							visited[ix][jy] = false;
						} 
					}else if(d==2){//대각선 확인
						int ix = dx[d] + x;
						int jy = dy[d] + y;
						if (jy < N + 1 && ix < N + 1 && visited[ix][jy] == false 
								&& visited[x+dx[0]][y+dy[0]] == false
								&& visited[x+dx[1]][y+dy[1]] == false) {
							visited[ix][jy] = true;
							func(ix, jy,d);
							visited[ix][jy] = false;
						} 
					}
				}
			}
	
		}
	
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			cnt = 0;
			visited = new boolean[N + 1][N + 1];
			for(int i = 1 ; i < N+1 ; i++) {
				for(int j = 1 ; j < N+1 ; j++) {
					if(sc.nextInt() == 1) {
						visited[i][j] = true;
					}
				}
			}
			
			visited[1][1] = visited[1][2] = true;
			func(1, 2, 1);
			System.out.println(cnt);
		}
	}
