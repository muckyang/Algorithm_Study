package Study_0218;
import java.util.Scanner;
public class Solution_D4_4408_자기방으로돌아가기 {

	    static int T, N;
	    static int[] dupc;
	  
	    public static void func(int sp, int ep, int chai) {
	        if (chai > 0) {
	            for (int i = 0; i <= chai; i++) {
	                dupc[sp + i]++;
	            }
	        } else {
	            for (int i = 0; i <= -chai ; i++) {
	                dupc[ep + i]++;
	            }
	        }
	    }
	  
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        T = sc.nextInt();
	        for (int test_case = 1; test_case <= T; test_case++) {
	            N = sc.nextInt();
	            dupc = new int[200];
	            for (int i = 0; i < N; i++) {
	                int s = sc.nextInt();
	                int e = sc.nextInt();
	                if (s % 2 == 0) {
	                    s = s / 2 - 1;
	                } else {
	                    s = s / 2;
	                }
	                if (e % 2 == 0) {
	                    e = e / 2 - 1;
	                } else {
	                    e = e / 2;
	                }
	  
	                int chai =  e-s;
	                func(s, e, chai);
	  
	            }
	            int max = 0;
	            for (int i = 0; i < 200; i++) {
	                if (max < dupc[i])
	                    max = dupc[i];
	            }
	            System.out.println("#" + test_case + " " + max);
	        }
	    }
	}