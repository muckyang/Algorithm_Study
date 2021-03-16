package partition1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16719_ZOAC {

	static String arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		arr = new String[s.length()];
		for (int i = arr.length - 1; !s.equals(""); i--) {
			arr[i] = s;
			int del = delIdx(s);
			s = s.substring(0, del) + s.substring(del + 1, s.length());
		}
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb.toString());

	}

	public static int delIdx(String s) {
		int snum = 'A' - 1;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= snum) {// 더 크면 꼐속
				snum = s.charAt(i);

			} else {
				return i - 1;
			}
		}
		return s.length() - 1;
	}
}
