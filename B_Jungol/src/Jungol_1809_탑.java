import java.util.Scanner;
import java.util.Stack;

public class Jungol_1809_탑 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] list = new int[N];
		int[] len = new int[N];

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
			if (stack.isEmpty()) {//스택 비어있는 경우
				stack.add(i);
				len[i] = 0;
			} else if ( list[stack.peek()] < list[i]) {// 더 긴것이 나오면 스택에 더 큰게 있을때 까지 pop
				while(!stack.isEmpty() && list[stack.peek()] < list[i]) {
					stack.pop();
				}
				if(stack.isEmpty()) {
					stack.add(i);
					len[i] = 0;
				}else {
					len[i] =stack.peek()+1;
					stack.add(i);
				}
			}else if( list[stack.peek()] == list[i]) {// 같은경우
				while(!stack.isEmpty() &&  list[stack.peek()] < list[i]) {
					stack.pop();
				}
				if(stack.isEmpty()) {
					stack.add(i);
					len[i] = 0;
				}else {
					len[i] = stack.peek()+1;
					stack.add(i);
				}
			}else {//peek보다 작은것이 올 경우
				len[i] = stack.peek()+1;
				stack.add(i);
			}
		}
		for(int i = 0 ; i < list.length ; i++) {
			System.out.print(len[i] +  " ");
		}
	}
}
