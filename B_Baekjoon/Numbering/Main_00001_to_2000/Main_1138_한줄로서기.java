package Main_00001_to_2000;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main_1138_한줄로서기 {
	static int N;
	static int[] list;
	static Stack<Integer> stack;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			stack.add(sc.nextInt());
		}
		LinkedList<Integer> link = new LinkedList<>();
		int cnt =N;
		while(!stack.isEmpty()) {
			int k = stack.pop();
			link.add(k,cnt);
			cnt--;
		}
		for(int i = 0 ; i < N; i++)
			System.out.print(link.poll() + " ");
	}
}
