package Study_0521;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_16637_괄호추가하기 {
	static int N;
	static List<Character> clist;
	static List<Integer> nlist;
	static int[] permu;
	static int[] minus;
	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		String s = sc.next();
		nlist = new ArrayList<>();
		clist = new ArrayList<>();
		permu = new int[N / 2];
		Arrays.fill(permu, Integer.MAX_VALUE);

		res = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			if (i % 2 == 0)
				nlist.add(Integer.parseInt(s.charAt(i) + ""));
			else
				clist.add(s.charAt(i));
		}

		solve(0, 0);
		System.out.println(res);
	}

	private static void solve(int cnt, int flag) {
		if (cnt == N / 2) {
			List<Integer> number = new ArrayList<>();
			number.addAll(nlist);
			List<Character> cchar = new ArrayList<>();
			cchar.addAll(clist);
			minus = new int[N / 2];
			int sum = 0;
			int index = 0;
			int count = 0;
			while (cchar.size() != 0) {
				for (int i = 0; i < N / 2; i++) {
					if (permu[i] == count) {
						index = i;
						count++;
						for (int j = 0; j < N / 2; j++) {
							if (index < j)
								minus[j]++;
						}
						index -= minus[i];
						break;
					}
				}
				int n1 = number.remove(index);
				int n2 = number.remove(index);
				char c1 = cchar.remove(index);
				number.add(index, solve(n1, n2, c1));

			}
			sum = number.get(0);
			if (res < sum)
				res = sum;
			return;
		}
		for (int i = 0; i < N / 2; i++) {
			if (permu[cnt] == Integer.MAX_VALUE && (flag & (1 << i)) == 0) {
				permu[cnt] = i;
				solve(cnt + 1, flag | (1 << i));
				permu[cnt] = Integer.MAX_VALUE;
			}
		}
	}

	private static Integer solve(int n1, int n2, char c1) {
		if (c1 == '-')
			return n1 - n2;
		else if (c1 == '+')
			return n1 + n2;
		else
			return n1 * n2;
	}
}
