package Main_02001_to_4000;

import java.util.Scanner;

public class Main_2804_크로아티아알파벳 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] list = new char[s.length()];
		int count = 0;
		int len = 0;
		for (int i = 0; i < s.length(); i++)
			list[i] = s.charAt(i);

		while (count != s.length()) {
			if ((list[count] == 'c' || list[count] == 's' || list[count] == 'z') && count + 1 <= s.length()) {
				if (count + 1 < s.length() &&("" + list[count] + list[count + 1]).equals("" + list[count] + "=")) {
					count += 2;
				} else if (count + 1 < s.length() && ("" + list[count] + list[count + 1]).equals("c-")) {
					count += 2;
				} else {
					count++;
				}

			} else if (list[count] == 'd') {
				if (count + 1 < s.length() && ("" + list[count] + list[count + 1]).equals("d-")) {
					count += 2;
				} else if (count + 2 < s.length()
						&& ("" + list[count] + list[count + 1] + list[count + 2]).equals("dz=")) {
					count += 3;
				} else {
					count++;
				}

			} else if (list[count] == 'l' || list[count] == 'n') {
				if (count + 1 < s.length() && ("" + list[count] + list[count + 1]).equals("" + list[count] + "j")) {
					count += 2;
				} else {
					count++;
				}
			} else {
				count++;
			}
			len++;
		}
		System.out.println(len);
	}
}
