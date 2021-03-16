package Pass_Feb_Week02;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution_D3_1244_최대상금_예지 {

	static int trans;
	static int[] list;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			char[] input = sc.next().toCharArray();
			trans = sc.nextInt();
			list = new int[input.length];
			Integer[] ll = new Integer[list.length];
			for (int i = 0; i < list.length; i++) {
				list[i] = input[i] - '0';
				ll[i] = input[i] - '0';
			}

			max = 0;

			if (list.length / 2 <= trans) {
				if ((trans - list.length / 2) % 2 == 0) { // 교환 횟수 - 길이/2)%2 가 떨어질 때 ????
					Arrays.sort(ll, Collections.reverseOrder());
				} else {
					Arrays.sort(ll, Collections.reverseOrder());
					int tmp = ll[ll.length - 1];
					ll[ll.length - 1] = ll[ll.length - 2];
					ll[ll.length - 2] = tmp;
				}
				int sum = getSum(ll);
				max = Math.max(sum, max);//최대값 정립 
			} else
				change(0, 0, list);

			System.out.println("#" + tc + " " + max);
		}
	}

	public static void change(int count, int now, int[] board) {
		if (count == trans) {
			int sum = getSum(board);
			max = Math.max(sum, max);
			return;
		}
		for (int i = 0; i < board.length; i++) {
			if (i == now)
				continue;
			int tmp = board[now];
			board[now] = board[i];
			board[i] = tmp;
			for (int j = 0; j < board.length; j++) {
				if (now + j >= board.length)
					continue;
				change(count + 1, now + j, board);
			}
			tmp = board[now];
			board[now] = board[i];
			board[i] = tmp;
		}
	}

	public static int getSum(int[] board) {
		int num = 1;
		int sum = 0;
		for (int i = board.length - 1; i >= 0; i--) {
			sum += board[i] * num;
			num *= 10;
		}
		return sum;
	}

	public static int getSum(Integer[] board) {
		int num = 1;
		int sum = 0;
		for (int i = board.length - 1; i >= 0; i--) {
			sum += board[i] * num;
			num *= 10;
		}
		return sum;
	}
}
//////예외 안먹히는 베스트 코드로 생각되는데 어렵..



