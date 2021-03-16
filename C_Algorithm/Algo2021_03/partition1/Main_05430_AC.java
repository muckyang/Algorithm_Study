package partition1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_05430_AC {
	static int T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String s = br.readLine();

			boolean fe = true;// 진행방향 t -> , f <-
			int front = 0;
			int end = Integer.parseInt(br.readLine());
			String numS = br.readLine();
			numS = numS.substring(1, numS.length() - 1);
			System.out.println(numS);
			int[] arr = new int[end];
			StringTokenizer st = new StringTokenizer(numS, ",");
			int cnt = 0;
			while (st.hasMoreTokens()) {
				arr[cnt++] = Integer.parseInt(st.nextToken());
			}
		}

	}
}
