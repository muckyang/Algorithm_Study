package COUPANG_2020_상반기;

public class Solution2 {
	static int temp[];
	static int list[];
	static int answer;

	public static void main(String[] args) {
//		int[] arr = { 2, 5, 3, 8, 1 };
//		int arr_len = 5;
//		int k = 3;
//		int t = 11;
		int[] arr = { 1,1,2,2 };
		int arr_len = 4;
		int k = 2;
		int t = 3;
//		int[] arr = { 1,2, 3, 2 };
//		int arr_len = 4;
//		int k = 2;
//		int t = 2;
		System.out.println(solution(arr, arr_len, k, t));
	}

	public static int solution(int[] arr, int arr_len, int k, int t) {
		answer = 0;
		temp = new int[arr_len];
		list = arr;
		combi(0, 0, 0, arr_len, k, t);
		return answer;
	}

	public static void combi(int st, int cnt, int sum, int arr_len, int k, int t) {
		if (st > arr_len)
			return;
		if (cnt >= k) {
			answer++;
		}
		for (int i = st; i < arr_len; i++) {
			if (sum + list[i] > t)
				continue;
			combi(i + 1, cnt + 1, sum + list[i], arr_len, k, t);
		}

	}
}
