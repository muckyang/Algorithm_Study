package Study_0525;
import java.util.Scanner;

public class Solution {
    public static int result=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int iT=sc.nextInt();

        for (int T = 1; T <= iT; T++) {
            int N=sc.nextInt();
            int[] nums=new int[N]; // 0~n-1

            for (int i = 0; i < N; i++) {
                nums[i]=sc.nextInt();
            }
            result=0;
            boolean [] visited=new boolean[N];
            go(nums,visited,0,0,0);
            System.out.printf("#%d %s\n",T,result);
        }
    }
    public static void go(int[] nums, boolean[] visited, int left, int right, int count) {
        if(left<right) { return ;}
        if(count==nums.length) {
            result++; 
            return ;
        }
        for (int i = 0; i < visited.length; i++) {
            if(visited[i]) { continue ;}
            visited[i]=true;
            go(nums,visited,left+nums[i],right, count+1);
            go(nums,visited,left,right+nums[i], count+1);
            visited[i]=false;
        }
    }
}