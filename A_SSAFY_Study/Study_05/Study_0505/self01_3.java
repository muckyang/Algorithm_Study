package Study_0505;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class self01_3 {
	public static void main(String[] args) {
		long su = 104444400L;
		List<Integer> list = new LinkedList<>();
		for (long i = su; (i / 10 != 0) || (i % 10 != 0); i /= 10) {
			list.add((int) (i % 10));
		}
		int[] answer = new int[list.size()];
		int cnt = 0;
		for (int k : list) {
			answer[cnt] = k;
			cnt++;
		}
		for (int i = 0; i < answer.length; i++)
			System.out.print(answer[i]);
		// return answer;
	}
}
