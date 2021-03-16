package Study_0326;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution_D4_7465 {
   static int T, N, M;
   static int[] arr;

   public static class Point {
      int u;
      int v;

      public Point(int u, int v) {
         this.u = u;
         this.v = v;
      }
   }

   public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      T = sc.nextInt();
      for (int t = 1; t <= T; t++) {
         N = sc.nextInt();
         M =sc.nextInt();

         arr = new int[N + 1];
         for (int i = 1; i <= N; i++) {
            arr[i] = i;
         }
         
         PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
               if(o1.u < o2.u) {
                  return -1;
               } else if(o1.u > o2.u) {
                  return 1;
               }
               return 0;
            }
         });
         
         for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            q.offer(new Point(u, v));
            q.offer(new Point(v, u));
         }
         
         while(!q.isEmpty()) {
            Point p = q.poll();
            union(p.u, p.v);
         }
         
         for (int i = 1; i <= N; i++) {
            find(arr[i]);
         }
         
         TreeSet<Integer> list = new TreeSet<>();
         list.clear();
         for (int i = 1; i <= N; i++) {
            list.add(arr[i]);
            System.out.println(arr[i]);
         }
         System.out.println("#" + t + " " + list.size());
      }
   }

   public static void union(int u, int v) {
      int m1 = find(u);
      int m2 = find(v);
      if (m1 == m2) {
         return;
      }
      arr[m1] = m2;
      return;
   }

   public static int find(int n) {
      if (arr[n] == n) {
         return n;
      }
      return arr[n] = find(arr[n]);
   }
}