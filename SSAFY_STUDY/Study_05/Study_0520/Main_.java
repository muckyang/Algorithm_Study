package Study_0520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_ {
	   static int N, M;
	   static int[][] map;
	   static boolean[][] flag;
	   static int[] order;
	   static int[] dx = { 0, 1, 0, -1 };
	   static int[] dy = { -1, 0, 1, 0 };
	   static int cameraCnt, deadzone, deadzonecnt, min;
	   static List<Point> list;

	   public static void main(String[] args) throws IOException {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      StringTokenizer st = new StringTokenizer(br.readLine());
	      list = new LinkedList<Point>();
	      N = Integer.parseInt(st.nextToken());
	      M = Integer.parseInt(st.nextToken());

	      map = new int[N][M];
	      flag = new boolean[N][M];
	      deadzone = 0;
	      min = Integer.MAX_VALUE;

	      for (int i = 0; i < N; i++) {
	         st = new StringTokenizer(br.readLine());
	         for (int j = 0; j < M; j++) {
	            map[i][j] = Integer.parseInt(st.nextToken());
	            if (map[i][j] == 0) {
	               deadzone++;
	            } else if (map[i][j] != 0 && map[i][j] < 6) {
	               list.add(new Point(i, j, map[i][j], 0));
	            }
	         }
	      }
	      cameraCnt = list.size();
	      order = new int[cameraCnt];
	      Permi(0);
	      System.out.println(min);
	   }

	   private static void Permi(int count) {
	      if (count == cameraCnt) {
	         flag = new boolean[N][M];
	         GameStart();
	         if(min>deadzonecnt)
	            min = deadzonecnt;
	         return;
	      }

	      for (int i = 0; i < 4; i++) {
	         order[count] = i;
	         Permi(count + 1);
	      }

	   }
	   

	   private static void GameStart() {
	      deadzonecnt = deadzone;
	      int size = list.size();
	      for (int s = 0; s < size; s++) {
	         int dir = order[s];
	         Point p = list.get(s);
	         if (p.cameraType == 1) {
	            int ix = p.x + dx[dir];
	            int iy = p.y + dy[dir];
	            while (safe(iy, ix)) {
	               if(map[iy][ix] == 6)
	                  break;
	               if (!flag[iy][ix] && map[iy][ix] == 0) {
	                  flag[iy][ix] = true;
	                  deadzonecnt--;
	               }
	               ix += dx[dir];
	               iy += dy[dir];
	            }
	         } else if (p.cameraType == 2) {
	            for (int i = 0; i < 2; i++) {
	               dir += i+1;
	               if(dir > 3)
	                  dir -= 4;
	               int ix = p.x + dx[dir];
	               int iy = p.y + dy[dir];
	               while (safe(iy, ix)) {
	                  if(map[iy][ix] == 6)
	                     break;
	                  if (!flag[iy][ix] && map[iy][ix] == 0) {
	                     flag[iy][ix] = true;
	                     deadzonecnt--;
	                  }
	                  ix += dx[dir];
	                  iy += dy[dir];
	               }
	            }
	         } else if (p.cameraType == 3) {
	            for (int i = 0; i < 2; i++) {
	               dir += i;
	               if(dir == 4)
	                  dir = 0;
	               int ix = p.x + dx[dir];
	               int iy = p.y + dy[dir];
	               while (safe(iy, ix)) {
	                  if(map[iy][ix] == 6)
	                     break;
	                  if (!flag[iy][ix] && map[iy][ix] == 0) {
	                     flag[iy][ix] = true;
	                     deadzonecnt--;
	                  }
	                  ix += dx[dir];
	                  iy += dy[dir];
	               }
	               
	            }
	         } else if (p.cameraType == 4) {
	            for (int i = 0; i < 3; i++) {
	               dir += 1;
	               if(dir > 3)
	                  dir = 0;
	               int ix = p.x + dx[dir];
	               int iy = p.y + dy[dir];
	               while (safe(iy, ix)) {
	                  if(map[iy][ix] == 6)
	                     break;
	                  if (!flag[iy][ix] && map[iy][ix] == 0) {
	                     flag[iy][ix] = true;
	                     deadzonecnt--;
	                  }
	                  ix += dx[dir];
	                  iy += dy[dir];
	               }
	               
	            }
	         } else if (p.cameraType == 5) {
	            for (int d = 0; d < 4; d++) {
	               int ix = p.x + dx[d];
	               int iy = p.y + dy[d];
	               while (safe(iy, ix)) {
	                  if(map[iy][ix] == 6)
	                     break;
	                  if (!flag[iy][ix] && map[iy][ix] == 0) {
	                     flag[iy][ix] = true;
	                     deadzonecnt--;
	                  }
	                  ix += dx[d];
	                  iy += dy[d];
	               }
	               
	            }
	         }
	      }
	   }

	   static boolean safe(int y, int x) {
	      if (x >= 0 && y >= 0 && x < M && y < N)
	         return true;
	      else
	         return false;
	   }

	   static class Point {
	      int y;
	      int x;
	      int cameraType;
	      int dir;

	      public Point(int y, int x, int cameraType, int dir) {
	         super();
	         this.y = y;
	         this.x = x;
	         this.cameraType = cameraType;
	         this.dir = dir;
	      }
	   }

	}