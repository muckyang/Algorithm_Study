package SSAFY;

import java.util.LinkedList;
import java.util.List;

public class sol1 {
	public static int solution(List<Integer> arr) {
		int res = 0;
		int asum = 0;
		for (int i : arr) {
			asum += i;
		}
		int bsum = 0;
		int mid = 0;
		int cnt = 0;
		for (int i : arr) {
			if (cnt == 0) {
				mid = i;
				asum-=i;
			} else if (bsum == asum) {
				return cnt-1;
			} else {
				asum -= i;
				bsum += mid;
				mid = i;
			}
			cnt++;
		}
		return cnt;

	}

	public static void main(String[] args) {
		List<Integer> arr = new LinkedList<>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(6);
		System.out.println(solution(arr));

	}
}
