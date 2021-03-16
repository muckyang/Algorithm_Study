package partition1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_07795_먹을것인가먹힐것인가 {
	static int T, A, B;
	static int arrA[];
	static int arrB[];

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			int res = 0;
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			arrA = new int[A];
			arrB = new int[B];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < A; i++) {
				arrA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < B; i++) {
				arrB[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arrA);
			Arrays.sort(arrB);
			int fIdx = 0;
			int eIdx = B - 1;

			for (int i = 0; i < A; i++) {
				res += getCount(fIdx, eIdx, arrA[i]);
			}
			sb.append(res).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int getCount(int fIdx, int eIdx, int value) {

		if (fIdx + 1 == eIdx || fIdx == eIdx) {
			if (arrB[eIdx] < value)
				return eIdx + 1;
			else if (arrB[fIdx] < value)
				return fIdx + 1;
			else
				return fIdx;
		} else {
			int next = (fIdx + eIdx) / 2;
			if (arrB[next] < value) {
				return getCount(next, eIdx, value);
			} else {
				return getCount(fIdx, next, value);
			}
		}
	}
}
