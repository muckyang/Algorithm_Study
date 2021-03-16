package Study_0502;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1726_로봇_3 {

   static int M, N, ans;
   static int[][] map;
   static int sy, sx, sd, ey, ex, ed;
   static int[][][] visit;
   static int[] dy = { 0, 0, 1, -1 };
   static int[] dx = { 1, -1, 0, 0 };

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      M = sc.nextInt();
      N = sc.nextInt();
      ans = Integer.MAX_VALUE;
      map = new int[M][N];
      visit = new int[M][N][4];
      for (int i = 0; i < M; i++) {
         for (int j = 0; j < N; j++) {
            Arrays.fill(visit[i][j], Integer.MAX_VALUE);
         }
      }
      for (int i = 0; i < M; i++) {
         for (int j = 0; j < N; j++) {
            map[i][j] = sc.nextInt();
         }
      }
      sy = sc.nextInt() - 1;
      sx = sc.nextInt() - 1;
      sd = sc.nextInt() - 1;
      ey = sc.nextInt() - 1;
      ex = sc.nextInt() - 1;
      ed = sc.nextInt() - 1;
      bfs();
      System.out.println(ans);
   }

   static void bfs() {
      Queue<Point> q = new LinkedList<>();
      visit[sy][sx][sd] = 0;
      q.add(new Point(sy, sx, sd, 0));
      while (!q.isEmpty()) {
         Point cur = q.poll();
         if (cur.y == ey && cur.x == ex) {
            if (cur.d != ed) {
               if (cur.d == 0) {
                  if (ed == 1)
                     cur.cnt += 2;
                  else
                     cur.cnt += 1;
               } else if (cur.d == 1) {
                  if (ed == 0)
                     cur.cnt += 2;
                  else
                     cur.cnt += 1;
               } else if (cur.d == 2) {
                  if (ed == 3)
                     cur.cnt += 2;
                  else
                     cur.cnt += 1;
               } else {
                  if (ed == 2)
                     cur.cnt += 2;
                  else
                     cur.cnt += 1;
               }
            }
            ans = Math.min(ans, cur.cnt);
         }
         for (int d = 0; d < 4; d++) {
            f: for (int i = 1; i <= 3; i++) {
               int ncnt = cur.cnt;
               int ny = cur.y;
               int nx = cur.x;
               for (int j = 0; j < i; j++) {
                  ny += dy[d];
                  nx += dx[d];
                  if (ny < 0 || nx < 0 || ny >= M || nx >= N || map[ny][nx] == 1)
                     break f;
               }
               
               if (cur.d != d) {
                  if (cur.d == 0) {
                     if (d == 1)
                        ncnt += 2;
                     else
                        ncnt += 1;
                  } else if (cur.d == 1) {
                     if (d == 0)
                        ncnt += 2;
                     else
                        ncnt += 1;
                  } else if (cur.d == 2) {
                     if (d == 3)
                        ncnt += 2;
                     else
                        ncnt += 1;
                  } else {
                     if (d == 2)
                        ncnt += 2;
                     else
                        ncnt += 1;
                  }
               }
               ncnt++;
               if (visit[ny][nx][d] <= ncnt)
                  continue;
               visit[ny][nx][d] = ncnt;
               q.add(new Point(ny, nx, d, ncnt));
            }

         }
      }
   }

   static class Point {
      int y, x, d, cnt;

      public Point(int y, int x, int d, int cnt) {
         this.y = y;
         this.x = x;
         this.d = d;
         this.cnt = cnt;
      }
   }

}