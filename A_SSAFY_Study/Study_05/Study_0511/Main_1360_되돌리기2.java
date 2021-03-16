package Study_0511;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1360_되돌리기2 {
	static int N;
	static int timels[];
	static StringBuilder[] dolist;
	static StringBuilder res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		res = new StringBuilder();
		String Do = "";
		char c = '_';
		dolist = new StringBuilder[N];
		timels = new int[N];
		int beforetime = 0;
		for (int i = 0; i < N; i++)
			dolist[i] = new StringBuilder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			Do = st.nextToken();
			// 추가하는 알파벳 a~z , 삭제하는 알파벳 A~Z
			if (Do.equals("type")) {
				c = st.nextToken().charAt(0);
				timels[i] = Integer.parseInt(st.nextToken());
				dolist[i].append(c); //
				res.append(c);
			} else {// undo
				beforetime = Integer.parseInt(st.nextToken());
				timels[i] = Integer.parseInt(st.nextToken());
				int cutline = timels[i] - beforetime;
					
				for (int t = i - 1; t >= 0 && timels[t] >= cutline; t--) {
					for (int k = dolist[t].length() - 1; k >= 0 && dolist[t] != null; k--) {
						char cc = dolist[t].charAt(k);
						if (0 <= cc - 'a' && cc - 'z' <= 0) {
							cc = (char) (cc - 'a' + 'A');
						} else {
							cc = (char) (cc - 'A' + 'a');
						}
						dolist[i].append(cc);
					}

				}
				for (int t = 0; t < dolist[i].length(); t++) {
					char cc = dolist[i].charAt(t);
					if (0 <= cc - 'a' && cc - 'z' <= 0)
						res.append(cc);
					else
						res.deleteCharAt(res.length()-1);
				}
			}
		}
		System.out.println(res);

	}
}
