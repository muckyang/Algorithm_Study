package Main_00001_to_2000;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main_1427_소트인사이드 {

	static Integer[] list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		list=new Integer [s.length()];
		for (int i = 0; i < s.length(); i++) {
			list[i] = (int)s.charAt(i)-48;
		}
		Arrays.sort(list,Collections.reverseOrder());
		for(int i = 0; i < list.length;i++)
			System.out.print(list[i]);
	}
}
