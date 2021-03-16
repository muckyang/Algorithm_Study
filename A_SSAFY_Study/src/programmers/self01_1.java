package programmers;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class self01_1 {
	public static void main(String[] args) {
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		int[] answer = new int[commands.length];
		for (int i = 0; i < commands.length; i++) {
			List<Integer> list = new LinkedList<>();
			for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
				list.add(array[j]);
			}
			Collections.sort(list);
			answer[i] = list.get(commands[i][2] - 1);
		}
		for (int i = 0; i < commands.length; i++)
			System.out.println(answer[i]);
//		return answer;
	}
}
