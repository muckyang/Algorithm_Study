package partition1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_09935_문자열폭발 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String target = br.readLine();
		char arr[] = new char[str.length()];
		char answer[] = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
		}
		int pointer = 0;
		char endC = target.charAt(target.length() - 1);
		for (int i = 0; i < str.length(); i++) {
			char now = arr[i];
			answer[pointer] = now;	
			pointer++;

			if (endC == now) {
				// 삭제여부판단
				if (pointer >= target.length()) {
					String compStr = String.valueOf(answer, pointer - target.length(), target.length());
					// 폭발 일어날 때
					if (target.equals(compStr)) {
						if (true) {
							pointer -= target.length();
							continue;
						}
					}
				}

			}
		
		}

		if (pointer == 0)
			System.out.println("FRULA");
		else {
			String s = String.valueOf(answer, 0, pointer);
			System.out.println(s);
		}
	}
}
