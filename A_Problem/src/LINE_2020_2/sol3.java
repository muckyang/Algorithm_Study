package LINE_2020_2;

public class sol3 {
	static int dres;
	static int num;

	public static void main(String[] args) {
//		int n = 73425;
		int n = 10007;
//		int n = 73425;

		int[] result = solution(n);
	}

	public static int[] solution(int n) {
		int[] answer = new int[2];
		dres = Integer.MAX_VALUE;
		solve(n, 0);
		answer[0] = dres;
		answer[1] = num;
		System.out.println(answer[0] + " ," + answer[1]);
		return answer;
	}

	private static void solve(int n, int depth) {
		String N = "" + n;
		if (N.length() < 2) {
			if (dres > depth) {
				dres = depth;
				num = n;
			}
			return;
		}
		for (int i = 0; i < N.length() - 1; i++) {
			String F = N.substring(0, i + 1);
			String B = N.substring(i + 1, N.length());

			if (B.length() != 1 && B.charAt(0) == '0') {
				continue;
			}
			solve(Integer.parseInt(F) + Integer.parseInt(B), depth + 1);

		}
	}

}
