package Main_00001_to_2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1756_피자굽기 {
	static int D, N;
	static int shape[];
	static int index[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		D = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		shape = new int[D + 1];
		index = new int[N];
		int min = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= D; i++) {
			int su = Integer.parseInt(st.nextToken());
			if (su < min)
				min = su;
			shape[i] = min;
		}
		st = new StringTokenizer(br.readLine());
		int in = D;
		boolean check =false;
		for (int i = 0; i < N; i++) {
			int pizza = Integer.parseInt(st.nextToken());
			for (int j = in; j > 0; j--) {
				if (shape[j] < pizza)
					continue;
				else {
					index[i] = j;
					in = j - 1;
					if(i == N-1)
						check = true;
					break;
				}
			}
		}
		if(check)
			System.out.println(index[N-1]);
		else
			System.out.println(0);
	}
}
