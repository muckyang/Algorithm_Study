package LINE_2020_2;

import java.util.Deque;
import java.util.LinkedList;

public class sol2 {

	public static void main(String[] args) {

		int[] ball = {11, 2, 9, 13, 24};
		int[] order = {9, 2, 13, 24, 11 };
		int[] result = solution(ball, order);
	}

	public static int[] solution(int[] ball, int[] order) {
		int[] answer = new int[ball.length];
		Deque<Integer> list = new LinkedList<>();
		for (int i = 0; i < ball.length; i++) {
			list.add(ball[i]);
		}
		int count = 0;
		boolean[] v = new boolean[300001];
		for (int i = 0; i < order.length; i++) {
			int now = order[i];

			v[now] = true;

			if (now == list.getFirst()) {
				while (!list.isEmpty()) {
					if (v[list.getFirst()]) {
						answer[count] = list.pollFirst();
						count++;
					} else {
						break;
					}
				}
			} else if (now == list.getLast()) {
				while (!list.isEmpty()) {
					if (v[list.getLast()]) {
						answer[count] = list.pollLast();
						count++;

					} else {
						break;
					}
				}
			}
		}
		return answer;
	}
}
