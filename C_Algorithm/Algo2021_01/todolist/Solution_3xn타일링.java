package todolist;

public class Solution_3xn타일링 {
	public static void main(String[] args) {
		int n = 6;
		System.out.println(solution(n));
	}

	static int cache[];

	public static int solution(int n) {

		if (n % 2 == 1)
			return 0;
		cache = new int[n / 2 + 2];
		cache[0] = 1;
		cache[1] = 3;
		return solve(n / 2);
	}

	public static int solve(int n) {
		if (cache[n] != 0)
			return cache[n];

		return cache[n] = solve(n - 1) * 4 - solve(n - 2);

	}
}
