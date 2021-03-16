package Algo12_Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_10726_이진수표현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String res = "";
			int number = Integer.parseInt(br.readLine());
			int front = number / 100;
			int back = number % 100;
			if ((front > 12 || front == 0) && (back > 12 || back == 0)) {
				res = "NA";
			} else if (!(front > 12 || front == 0) && (back > 12 || back == 0)) {
				res = "MMYY";
			} else if ((front > 12 || front == 0) && !(back > 12 || back == 0)) {
				res = "YYMM";
			} else if (!(front > 12 || front == 0) || !(back > 12 || back == 0)) {
				res = "AMBIGUOUS";
			} 
			System.out.println("#" + t + " " + res);
		}
	}

}
