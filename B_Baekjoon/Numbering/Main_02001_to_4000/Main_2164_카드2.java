package Main_02001_to_4000;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2164_카드2 {
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i = 1 ; i < N+1 ;i++)
			que.add(i);
		int res =0;
		while(!que.isEmpty()) {
			res=que.poll();
			if(que.isEmpty())
				break;
			res=que.poll();
			que.add(res);
		}
		System.out.println(res);

	}
}
