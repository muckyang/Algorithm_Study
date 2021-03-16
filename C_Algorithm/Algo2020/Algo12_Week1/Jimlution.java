package Algo12_Week1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Jimlution {
   static int N, M;
   static boolean[][] visit;
   static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
   static Posi[][] map;

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer tk = new StringTokenizer(br.readLine());
      N = Integer.parseInt(tk.nextToken());
      M = Integer.parseInt(tk.nextToken());
      map = new Posi[N][M];
      visit = new boolean[N][M];
      for (int i = 0; i < N; i++) {
         String input = br.readLine();
         for (int j = 0; j < M; j++) {
            map[i][j] = new Posi(i, j, input.charAt(j) - '0', 0, false);
         }
      }
//      for (int i = 0; i < N; i++) {
//         for (int j = 0; j < M; j++) {
//
//            System.out.print(map[i][j].dist);
//         }
//         System.out.println();
//      }

      // bfs
      bfs();
//      System.out.println("----------");
//      for (int i = 0; i < N; i++) {
//         for (int j = 0; j < M; j++) {
//            System.out.print(map[i][j].dist+" ");
//         }
//         System.out.println();
//      }
      System.out.println(map[N - 1][M - 1].dist == 0 ? -1 : map[N - 1][M - 1].dist + 1);
   }

   private static void bfs() {
      Queue<Posi> que = new LinkedList<>();
      que.offer(new Posi(0, 0, 0, 0, false));
      boolean[][] visit = new boolean[N][M];
      visit[0][0] = true;
      ArrayList<Posi> list;
      while (!que.isEmpty()) {
         int size = que.size();
         for (int s = 0; s < size; s++) {
            Posi p = que.poll();
            for (int i = 0; i < 4; i++) {
               int ny = p.y + dir[i][0];
               int nx = p.x + dir[i][1];
               if (check(ny, nx)) {
                  if (map[ny][nx].val == 0) {
                     que.add(new Posi(ny, nx, map[ny][nx].val, p.dist + 1, p.wall));
                     map[ny][nx] = new Posi(ny, nx, map[ny][nx].val, p.dist + 1, p.wall);
                     visit[ny][nx] = true;
                  } else if (map[ny][nx].val == 1) {
                     if (!p.wall) {
                        que.add(new Posi(ny, nx, map[ny][nx].val, p.dist + 1, true));
                        map[ny][nx] = new Posi(ny, nx, map[ny][nx].val, p.dist + 1, true);
                        visit[ny][nx] = true;
                     }
                  }
               }
            }

         }

         for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
               System.out.print(map[i][j].wall + " ");
            }
            System.out.println();
         }
         System.out.println();
      }

   }

   private static boolean check(int ny, int nx) {
      if (ny >= 0 && nx >= 0 && ny < N && nx < M)
         return true;
      return false;
   }

   static class Posi {
      int y;
      int x;
      int val;
      int dist;
      boolean wall;

      public Posi(int y, int x, int val, int dist, boolean wall) {
         super();
         this.y = y;
         this.x = x;
         this.wall = wall;
         this.dist = dist;
         this.val = val;
      }

   }

}