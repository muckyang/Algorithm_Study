package todolist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1107_리모콘 {
	static int N, target;
	static boolean v[];
	static int min;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		target = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			v[Integer.parseInt(st.nextToken())] = true;
		}
		if (target > 100) {
			min = target - 100;
		} else {
			min = 100 - target;
		}
//		min = Math.min(min, min_Channel());
//		min = Math.min(min, max_Channel());
		System.out.println(min);
	}

	private static void getChannel() {
		String Starget = target + "";
		String next= "";
		String prev= "";
		
		for (int i = 0; i < Starget.length(); i++) {
			if(v[Starget.charAt(i)]) {
				break;
			}
			next+=Starget.charAt(i);
			prev+=Starget.charAt(i);
		}

	}

}
