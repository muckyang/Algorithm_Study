package Study_0624;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_9237_이장님초대 {
	static int N, res;
	static int tree[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		tree = new int[N];
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(tree);
		res = 1;
		int day = 1;
		for(int i = N-1 ; i >= 0;i--,day++) {
			if(day+tree[i] > res )
				res = day+tree[i];
		}
		System.out.println(res+1);
	}
}
