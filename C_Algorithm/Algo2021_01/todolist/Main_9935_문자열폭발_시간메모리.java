package todolist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9935_문자열폭발_시간메모리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String target = br.readLine();
		String res = "";
		for (int i = 0; i < str.length(); i++) {
			res += str.charAt(i);
			
			if (res.endsWith(target)) {
				res =res.substring(0,res.length()-target.length());
			}
		}
		if (res.length() == 0)
			System.out.println("FRULA");
		else
			System.out.println(res);
	}
}
