package partition3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_01744_수묶기 {
	static int N;
	static int plus[];
	static int minus[];
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		plus = new int[N];
		minus = new int[N];
		int mcnt = 0;
		boolean haveZero = false;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num > 0) {
				plus[i] = num;
			} else if (num < 0) {
				mcnt++;
				minus[i] = num;
			} else {
				haveZero = true;
			}
		}
		res = 0;
		Arrays.sort(plus);// 오름차순
		Arrays.sort(minus);
		int plusnum = 1;
		int cnt = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (plus[i] == 0)
				break;
			else if (plus[i] == 1)
				res++;
			else {
				cnt++;
				plusnum *= plus[i];
				if (cnt == 2) {
					cnt = 0;
					res += plusnum;
					plusnum = 1;
				}

			}
		}
		if (cnt > 0)
			res += plusnum;
		cnt = 0;
		int minnum = 1;
		for (int i = 0; i < N; i++) {
			if (minus[i] == 0)
				break;
			else {
				cnt++;
				minnum *= minus[i];
				if (cnt == 2) {
					cnt = 0;
					res += minnum;
					minnum = 1;
				}
			}
		}
		if (cnt > 0) {// 음수가 홀수개면 가장 작은 수 를 더해줄 것
			if (!haveZero)// 0 이있다면 -는 사라지게 됨
				res += minnum;
		}
		System.out.println(res);
	}
}
