package partition2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20415_MVP다이아몬드Hard {
	static int N;
	static int tier[];
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		tier = new int[4];
		st= new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			tier[i] = Integer.parseInt(st.nextToken());
		}
		String s = br.readLine();
		int money = 0;
		int before = 0;
		res = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case 'B':
				money = tier[0] - before - 1;
				if(money<0) {
					before =0;
					res += money;
					break;
				}
				before = money;
				res += money;
				break;
			case 'S':
				money = tier[1] - before - 1;
				if(money<0) {
					before =0;
					res += money;
					break;
				}
				before = money;
				res += money;
				break;

			case 'G':	
				money = tier[2] - before - 1;
				if(money<0) {
					before =0;
					res += money;
					break;
				}
				before = money;
				res += money;
				break;

			case 'P':
				money = tier[3] - before - 1;
				if(money< 0) {
					before = 0;
					res += money;
					break;
				}
				before = money;
				res += money;
				break;
			case 'D':
				money =tier[3];
				if(money<0) {
					before=0;
					res += money;
					break;
				}
				before = money;
				res += money;
				break;
			}
		}
		System.out.println(res);
	}
}
