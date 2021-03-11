package NAVER_2020_2_1;

public class Solution3 {
	static int stick[] = { 6, 2, 5, 5, 4, 5, 6, 3, 7, 6 };
	// 막대 7개  // 12, 13, 15,177, 21, 31 012 
	static int su[];

	public static void main(String[] args) {
//		int k = 5;
//		int k = 6;
		int k = 11;
//		int k =1;
//		int k =0;
		System.out.println(solution(k));
	}

	public static int solution(int n) {
		int answer = 0;
		su = new int[100];
		for (int i = 0; i < 100; i++)
			su[i] = -1;
		su[0] = 0;
		answer = solve(n, 0);
		return answer;
	}

	public static int solve(int number, int depth) {
		// n = 7
		int ans = 0;// number개 의 막대로 만들 수 있는 모든 숫자 조합 수
		
		if (su[number] != -1) {
			return su[number];
		}
		
		for (int i = 0; i < 10; i++) {
//			int k = number - stick[i];//숫자 만들고 남은 막대 갯수
			if (number - stick[i] < 0)
				continue;

			if (depth == 0 && i == 0) {//0을 만들게 되는 경우 n=6
				if (number - stick[i] == 0)
					ans++;
				continue;
			}
			
			if (number - stick[i] == 0) {
				ans++;
			} else {
				ans += solve(number - stick[i], depth + 1);
			}
		}
		
		su[number] = ans;
		return ans;
	}
}
