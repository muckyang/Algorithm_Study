package Main_16001_to_18000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main_17413_단어뒤집기2 {
	static StringBuffer S, S1, E;

	public static void main(String[] args) throws IOException {
		S = new StringBuffer();
		S1 = new StringBuffer();
		E = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner sc = new Scanner(System.in);
		String s= br.readLine();
		S.append(s);
		int start = 0;
		int check = 0;
		for (int i = 0; i < S.length(); i++) {
			if (check == 0) {
				if (S.charAt(i)==' ') {
					E.append(S1.reverse());
					S1 = new StringBuffer();
					E.append(' ');
				} else if (S.charAt(i) == '<') {
					E.append(S1.reverse());
					S1 = new StringBuffer();
					E.append(S.charAt(i));
					check = 1;
				} else {
					S1.append(S.charAt(i));
				}
			} else {
				if (S.charAt(i) != '>')
					E.append(S.charAt(i));
				else if (S.charAt(i) == '>') {
					E.append(S.charAt(i));
					check = 0;
				}

			}
		}
		E.append(S1.reverse());
		System.out.println(E);
	}
}
