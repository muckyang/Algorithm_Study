package partition3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11727_2xn타일링2 {
	static int N;
	static int cache [];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cache= new int[N+1];
		
		System.out.println(solve(N));
	}
	private static int solve(int num) {
		int res = 0;
		if(num == 0)
			return 1;
		if(cache[num] != 0)
			return cache[num]%10007;
		
		if(num >1) {
			res+= solve(num-2)*2;
		}
		res += solve(num-1);
		return  cache[num]=res%10007;
	}
}
