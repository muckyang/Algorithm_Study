package partition3;

public class Solution_도둑질 {

	public static void main(String[] args) {
		int[] money = { 1, 2, 3, 1, 5 };
		System.out.println(solution(money));
	}

	static int cache1[][];
	static int cache2[][];
	static int don[];

	public static int solution(int[] money) {
		int res = 0;
		don = money.clone();
		cache1= new int[3][money.length];/// 0번째 선택여부 , 점프 수
		cache2= new int[3][money.length];/// 0번째 선택여부 , 점프 수
		res = solve1(0, 0, 0);// 0 선택
		return res;
	}

	private static int solve1(int last, int jump, int sum) {
		int res = 0;

//		if (now < 0) {// 처음
//			solve(0, now + 2, sum + don[0]);
//			solve(0, now + 3, sum + don[0]);
//		}
		// now 건너뛰기
	
		return res;
	}

}
