package Study_0505;

import java.util.Stack;

public class self01_2 {
	static int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
			{ 3, 5, 1, 3, 1 } };
	static int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
	static int answer = 0;
	static int N, M;
	static int bb[][];
	static Stack<Integer> stack;

	public static void main(String[] args) {
		N = board.length;
		M = board[0].length;
		bb = new int[N][M];
		for (int i = 0; i < board.length; i++) {
			System.arraycopy(board[i], 0, bb[i], 0, board[i].length);

		}
		stack = new Stack<>();
		for (int i = 0; i < moves.length; i++) {
			pick(moves[i] - 1);
		}
		System.out.println(answer*2);
		// return answer;
	}

	private static void pick(int j) {
		for (int i = 0; i < bb.length; i++) {
			if (bb[i][j] != 0) {
				if (!stack.isEmpty()) {
					int num = stack.pop();
					if (num == bb[i][j]) {
						answer++;
					} else {
						stack.push(num);
						stack.push(bb[i][j]);
					}
				} else {
					stack.push(bb[i][j]);
				}
				bb[i][j] = 0;
				return;
			}
		}
	}
}
