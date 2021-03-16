package partition3;

public class Solution_주식가격 {

	public static void main(String[] args) {
		int[] prices = { 1,2,3,2,3 };
		prices = solution(prices);
		for (int i = 0; i < prices.length; i++)
			System.out.print(prices[i] + " ");
		System.out.println();
	}

	public static int[] solution(int[] prices) {
		int[] res = new int[prices.length];
		for (int i = 0; i < prices.length ; i++) {
			int cnt = 0;
			for (int j = i + 1; j < prices.length; j++) {
				cnt++;
				res[i] = cnt;
				if (prices[i] > prices[j]) {
					break;
				}
				
			}
		}
		return res;
	}
}
