package partition1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
///시간초과 해결해야함
public class Main_16916_부분문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String trg = br.readLine();
		char c = trg.charAt(0);
		for (int i = 0; i < str.length() - trg.length(); i++) {
			
			if(str.charAt(i) == c ) {
				if(trg.equals(str.substring(i, i+trg.length()))) {
					System.out.println(1);
					return;
				}
			}
		}
		System.out.println(0);
	}
}
