package Study_0623;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18866_젊은날의생이여 {
	static int N;
	static int res;
	static int rh, rt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		res = 0;
		int h, t;
		st = new StringTokenizer(br.readLine());
		int happy = Integer.parseInt(st.nextToken());
		int tired = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			if (happy > h && h != 0)
				happy = h;
			if (tired < t && t != 0)
				tired = t;
			if (happy < h || tired > t)
				break;
			res++;
		}
		System.out.println(res == 0 ? -1 : res);
	}
}
