package Study_0712;

import java.util.LinkedList;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		List<Integer> list;
		list = new LinkedList<>();
		for (int i = 0; i < 3; i++) {
			list.add(i);
		}
		print(list);
		func(list);
		print(list);
	}

	private static void print(List<Integer> list) {
		for (int i = 0; i < 3; i++) {
			System.out.print(list.get(i));
		}
		System.out.println();
	}

	private static void func(List<Integer> list) {
		for (int i = 0; i < 3; i++) {
			list.set(i, i + 3);
		}
	}
}
