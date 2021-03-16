package partition1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_2470_두용액 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Long> dq = new ArrayDeque<>();

		int N = Integer.parseInt(st.nextToken());
		long arr[] = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		for (Long l : arr) {
			dq.offer(l);
		}
		long res = Long.MAX_VALUE;
		long start = dq.pollFirst();
		long end = dq.pollLast();
		res = Math.abs(start + end);
		for (int i = 0; i < N-2; i++) {
			
		}

	}
}
