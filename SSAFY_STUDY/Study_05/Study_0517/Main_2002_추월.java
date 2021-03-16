package Study_0517;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2002_추월 {
	static int N;
	static List<String> in;
	static List<String> out;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		in = new LinkedList<>();
		out = new LinkedList<>();
		int cnt = 0;
		
		for (int i = 0; i < N; i++)
			in.add(br.readLine());
		for (int i = 0; i < N; i++)
			out.add(br.readLine());

		for (int i = 0; i < N; i++) {
			String s= out.get(0);
			int index1 = out.indexOf(s);
			int index2 = in.indexOf(s);
			if(index1 != index2)
				cnt++;
			out.remove(0);
			in.remove(index2);
		}
		System.out.println(cnt);
	}
}
