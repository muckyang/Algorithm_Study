package Study_1020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1541_잃어버린괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String number = "";
		int sum = 0;
		boolean tf = false;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '+' || c == '-') {
				if (!tf) {
					sum += Integer.parseInt(number);
				} else {
					sum -= Integer.parseInt(number);
				}
				if (c == '-')
					tf = true;
				number = "";
			} else {
				number += c;
			}
		}
		if (!tf) {
			sum += Integer.parseInt(number);
		} else {
			sum -= Integer.parseInt(number);
		}
		System.out.println(sum);

	}
}
