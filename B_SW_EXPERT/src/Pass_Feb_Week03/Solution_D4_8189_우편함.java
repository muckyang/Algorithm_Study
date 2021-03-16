package Pass_Feb_Week03;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D4_8189_우편함 {
	static int T;
	static int N, A, B;
	static int[] post;
	static Queue<Integer> que;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			A = sc.nextInt();
			B = sc.nextInt();
			post = new int[N];
			System.out.print("#"+test_case + " ");
			for (int i = 0; i < N; i++) {
				post[i] = sc.nextInt();
			}
			int postc = 0;// 몇번쨰 편지 까지 받았는지 표시
			que = new LinkedList<Integer>();
			
			for (int time = 1; time < 2000; time++) { // 시간은 1씩 증가
				if(postc == post.length && que.isEmpty())
					break;
				
				while(postc < post.length && post[postc] == time ) {
					que.add(post[postc]);
					postc++;
				}
				
				if(!que.isEmpty() && que.peek() + B <= time) {
					int k = que.size() /2;
					while(que.size() != k) {
						que.poll();
						System.out.print(time + " ");
					}
				}
				
				if(!que.isEmpty() && que.size() >= A) {
					int k = que.size() /2;
					while(que.size() != k) {
						que.poll();
						System.out.print(time + " ");
					}
				}
			}
			//큐에 잘 들어감 
			System.out.println();

		}
	}
}
