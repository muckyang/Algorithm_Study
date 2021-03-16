package Algo12_Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Songlution {

	static int T;
	static int n, m;
	static int[] parking;
	static int[] pvisit;
	static int[] car;
	static Queue<Integer> que;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			parking = new int[n];// 012
			pvisit = new int[n];// 012
			car = new int[m + 1];// 1234
			que = new LinkedList<Integer>();
			for (int nc = 0; nc < n; nc++) {
				parking[nc] = Integer.parseInt(br.readLine());
			}
			for (int mc = 1; mc <= m; mc++) {
				car[mc] = Integer.parseInt(br.readLine());
			}
			int coin = 0;
			for (int i = 0; i < 2 * m; i++) {
				int c = Integer.parseInt(br.readLine());
				// +
				if (c > 0) {
					// 대기차량이 있는지 확인
					int size = que.size();
					for (int s = 0; s < size; s++) {
						int dc = que.poll();
						isFull(dc);
					}
					isFull(c);
				}

				// -
				else if (c < 0) {
					c = -1 * c;
					// 해당 주차공간 빼기
					for (int j = 0; j < n; j++) {
						if (pvisit[j] == c) {
							coin = coin + (car[c] * parking[j]);
							pvisit[j] = 0;
							// 빼자마자 대기차량이 있는지 확인하고 채우기
							int size = que.size();
							for (int s = 0; s < size; s++) {
								int dc = que.poll();
								isFull(dc);
							}
						}
					}
				}
			}
			System.out.println("#" + t + " " + coin);
		}
	}

	private static void isFull(int c) {
		boolean flag = false;
		for (int j = 0; j < n; j++) {
			// 빈곳이 있으면 바로 주차
			if (pvisit[j] == 0) {
				pvisit[j] = c;
				flag = true;
				break;
			}
		}
		// 빈곳이 없으면 대기차량으로 가기
		if (!flag) {
			que.offer(c);
		}
	}
}