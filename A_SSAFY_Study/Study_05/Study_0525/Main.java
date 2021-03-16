package Study_0525;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main{

   static int N, M, K;
   static int[][] map;
   static int[][] tree;
   static int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 };
   static int[] dx = { -1, 0, 1, -1, 1, -1, 0, 1 };

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();// N*N
      M = sc.nextInt();// 나무 수
      K = sc.nextInt();// 년 후
      map = new int[N + 1][N + 1];
      for (int i = 1; i <= N; i++) {
         for (int j = 1; j <= N; j++) {
            map[i][j] = sc.nextInt();
         }
      }
      tree = new int[N + 1][N + 1];
      for (int i = 1; i <= N; i++) {
         for (int j = 1; j <= N; j++) {
            tree[i][j] = 5;
         }
      }

      PriorityQueue<Point> que = new PriorityQueue<>();
      for (int i = 0; i < M; i++) {
         int y = sc.nextInt();
         int x = sc.nextInt();
         int z = sc.nextInt();
         que.offer(new Point(y, x, z));
      }

      while (K > 0) {
         // 봄
         int size = que.size();
         Queue<Point> tmp = new LinkedList<>();// 우선순위 큐는 계속 앞의 애들이 들어가서 같은 것을 반복하기 때문에 임시 큐를 생성
         int[][] die = new int[N + 1][N + 1];// 양분변동되는 것 담을 배열
         for (int i = 0; i < size; i++) {
            Point p = que.poll();
            int r = p.y;
            int c = p.x;
            int tage = p.age;
            if (tree[r][c] < tage) {// 땅에 양분이 부족할 때(나이만큼 없을 때)
               die[r][c] += tage/2;
               continue;
            }
            tree[r][c] -= tage;
            tage += 1;
            tmp.offer(new Point(r, c, tage));
         }

         // 여름
         for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
               if (die[i][j] != 0) {
                  tree[i][j] += die[i][j];
               }
            }
         }

         // 가을
         int size2 = tmp.size();
         for (int s = 0; s < size2; s++) {
            Point p2 = tmp.poll();
            int r = p2.y;
            int c = p2.x;
            int tage = p2.age;
            if (tage % 5 == 0) {// 나무 나이 5배수이면
               for (int d = 0; d < 8; d++) {
                  int nr = r + dy[d];
                  int nc = c + dx[d];
                  if (!safe(nr, nc))
                     continue;
                  que.offer(new Point(nr, nc, 1));
               }
            }
            que.offer(new Point(r, c, tage));// 다시 넣어주기
         }

         // 겨울
         for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
               tree[i][j] += map[i][j];
            }
         }

         K--;
         

      }
      System.out.println(que.size());
   }

   private static boolean safe(int y, int x) {
      if (y >= 1 && y <= N && x >= 1 && x <= N)
         return true;
      else
         return false;
   }

   static class Point implements Comparable<Point> {
      int y;
      int x;
      int age;

      public Point(int y, int x, int age) {
         super();
         this.y = y;
         this.x = x;
         this.age = age;
      }

      @Override
      public String toString() {
         return "Point [y=" + y + ", x=" + x + ", age=" + age + "]";
      }

      @Override
      public int compareTo(Point o) {
         if (this.age > o.age)// 들어온 게 작으면
            return 1;// 앞으로
         else if (this.age < o.age)// 들어온 게 크면
            return -1;// 뒤로
         return 0;
      }
   }
}