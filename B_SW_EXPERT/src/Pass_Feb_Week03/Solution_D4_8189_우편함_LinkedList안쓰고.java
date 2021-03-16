package Pass_Feb_Week03;

import java.util.Scanner;

public class Solution_D4_8189_우편함_LinkedList안쓰고 {
	static int T;
	static int N, A, B;
	static int[] post;
	static int[] del;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			A = sc.nextInt();
			B = sc.nextInt();
			post = new int[N];
			for (int i = 0; i < N; i++) {
				post[i] = sc.nextInt();
			}
			int postc = 0;// 몇번쨰 편지 까지 받았는지 표시
			del = new int[N];
			
			System.out.print("#" + test_case + " ");
			for (int time = 1; time < 3000; time++) { // 시간은 1씩 증가
				if (postc == post.length && first(del) == -1)
					break;

				while (postc < post.length && post[postc] == time) {
					del[postc] = post[postc];
					postc++;
				}
				if ( first(del) != -1 && del[first(del)] + B <= time) {
					int k = num(del) / 2;
					while (num(del) != k) {
						del[first(del)] = 0;
						System.out.print(time + " ");
					}
				}

				if (first(del) != -1 && num(del) >= A) {
					int k = num(del) / 2;
					while (num(del) != k) {
						del[first(del)] = 0;
						System.out.print(time + " ");
					}
				}
				
				
			}
			// 큐에 잘 들어감
			System.out.println();

		}
	}

	private static int first(int[] dellist) {
		for (int i = 0; i < dellist.length; i++) {
			if (dellist[i] != 0)
				return i;
		}
		return -1;
	}
	
	private static int num(int[] dellist) {
	int cnt = 0;
		for (int i = 0; i < dellist.length; i++) {
			if (dellist[i] != 0)
				cnt++;
		}
		return cnt;
	}
}
