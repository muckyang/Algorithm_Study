package Pass_Feb_Week02;
import java.util.Scanner;
public class Solution_D3_4615_오셀로게임_재인 {

	   static int T, N, M;
	   static int[][] board;
	   static int bcnt, wcnt; //검은돌 수, 흰돌 수

	   public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);
	      T = sc.nextInt();
	      for (int t = 1; t <= T; t++) {
	         N = sc.nextInt();
	         M = sc.nextInt();
	         bcnt = 0;
	         wcnt = 0;
	         board = new int[N + 1][N + 1];// N + 1 개로 기준잡고 0 번쨰는 제외함
	         board[N / 2][N / 2] = 2;
	         board[N / 2][N / 2 + 1] = 1;
	         board[N / 2 + 1][N / 2] = 1;
	         board[N / 2 + 1][N / 2 + 1] = 2;
	         //기본 오셀로판 세팅 
	         
	         int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };
	         int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };

	         for (int i = 0; i < M; i++) {
	            int x = sc.nextInt();
	            int y = sc.nextInt();
	            int c = sc.nextInt(); // 흑돌 : 1 , 백돌 : 2
	            int ec; // 상대편 돌
	            if (c == 2)//놓을건 백돌
	               ec = 1;//상대는 흑돌
	            else
	               ec = 2;
	            board[y][x] = c;//놓을때 변경 일어남
	            

	            f: for (int d = 0; d < 8; d++) {//놓은 지점 기준으로 8방으로 탐색
	               int ny = y;
	               int nx = x;
	               boolean isen = false;//상대를 만났을경우 true로 변경
	               int encnt = 0; //카운트 값도 세어줌 
	               while (true) {
	                  ny += dy[d];
	                  nx += dx[d];
	                  if (ny < 1 || nx < 1 || ny >= N + 1 || nx >= N + 1 || board[ny][nx]==0)
	                     continue f;
	                  //벽을만나거나 아무것도 없는 칸을 만나게된다면 무시하고 다음 8 방 체크하러감 

	                  if (board[ny][nx] != ec && !isen) {//상대안만났는데,다음이 상대도 아닐경우
	                     break;
	                  } else if (board[ny][nx] == ec) {//상대를 만난경우 
	                     isen = true;//상대만나서 true로 변경
	                     encnt++;//카운트 증가
	                  } else if (board[ny][nx] == c && isen) {
	                     for (int j = 0; j < encnt; j++) {//상대가 있던 수만큼 반복하면서 변경해줌
	                        ny -= dy[d];
	                        nx -= dx[d];
	                        board[ny][nx] = c;
	                     }
	                     break;
	                  }
	               }
	            }
	         }

	         for (int i = 1; i < N + 1; i++) {
	            for (int j = 1; j < N + 1; j++) {
	               if (board[i][j] == 1) {
	                  bcnt++;
	               } else if (board[i][j] == 2) {
	                  wcnt++;
	               }
	            }
	         }

	         System.out.println("#" + t + " " + bcnt + " " + wcnt);
	      }
	   }

	
}
