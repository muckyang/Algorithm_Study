import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class Jungol_1809_탑3 {
 
	  

	   public static void main(String[] args) throws IOException {
	      BufferedReader bf = new BufferedReader(
	    		  new InputStreamReader(System.in));
	      int T = Integer.parseInt(new StringTokenizer(bf.readLine()).nextToken());
	      int []arr = new int[T];
	      int [] result = new int[T];
	      String s = bf.readLine();
	      StringTokenizer st = new StringTokenizer(s);

	      for (int t = 0; t < T; t++) {
	         arr[t] = Integer.parseInt(st.nextToken());
	      }

	      for (int i = T - 1; i >= 0; i--) {
	         for (int j = i - 1; j >= 0; j--) {
	            if (arr[j] > arr[i]) {
	               result[i] = j + 1;
	               break;
	            }
	         }
	      }

	     for(int i = 0 ; i < T ; i++) { 
	    	 System.out.print( result[i] + " ");
	     }
	   }
	}