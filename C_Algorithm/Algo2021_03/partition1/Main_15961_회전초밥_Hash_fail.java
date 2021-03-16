package partition1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main_15961_회전초밥_Hash_fail {
	static int N, d, k, c;// 갯수 종류 연속 쿠폰
	static int sushi[];
	static HashMap<Integer, Integer> hm;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		hm = new HashMap<>();
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		sushi = new int [N];
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < k; i++) {
			int eat = sushi[i];
			Integer num = hm.get(eat);
			if (num == null)
				hm.put(eat, 1);
			else
				hm.put(eat, num + 1);
		}
		answer = 0;

		for (int i = 0; i < N; i++) {
			int del = sushi[i];
			int ins = sushi[(i + k) % N];
			System.out.println("del :"  + del + "  ins : "+ins);
			Integer dcnt = hm.get(del);
			Integer icnt = hm.get(ins);

			if (dcnt==1) 
				hm.remove(del);
			else 
				hm.put(del, dcnt - 1);
			
			if (icnt == null)
				hm.put(ins, 1);
			else
				hm.put(ins, icnt + 1);
			Iterator<Integer> it = hm.keySet().iterator();
			while(it.hasNext()) {
				Integer k = it.next();
				System.out.print(k+":"+ hm.get(k) + " ");
			}
			System.out.println();
			System.out.println(hm.size() + bonus());
			answer = Math.max(answer, hm.size() + bonus());
		}

		System.out.println(answer);
	}

	private static int bonus() {
		if (hm.containsKey(c)) {
			return 0;
		}
		return 1;
	}
}
