package Study_0521;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_1339_단어수학 {
	static int N;
	static HashMap<Character, Integer> hs;
	static int[] cnt;
	static char[] clist;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		hs= new HashMap<>();
		clist = new char[10];
		cnt = new int[10];
		int count = 0 ;
		res = 0 ;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				int power = (int)Math.pow(10, s.length() - (j + 1));
				if(!hs.containsKey(c)) {
					hs.put(c, power);
					clist[count] = c;
					count ++;
				}else {
					int num  = hs.get(c);
					hs.replace(c, num + power);
				}
			}
		}
		for(int i = 0 ; i < 10; i++) {
			if(!hs.containsKey(clist[i]))
				break;
			cnt[i] = hs.get(clist[i]);
		}
		Arrays.sort(cnt);
		for(int i = 0;i<10;i++) {
			res += cnt[i] * i;
		}
		System.out.println(res);
	}
}
