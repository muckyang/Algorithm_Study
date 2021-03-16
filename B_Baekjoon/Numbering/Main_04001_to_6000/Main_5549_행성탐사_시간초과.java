package Main_04001_to_6000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5549_행성탐사_시간초과 {
	static int N, M, K;
	static char map[][];
	static int list[][];
	static int sx, sy, ex, ey;
	static int jc, oc, ic;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		list = new int[4][K];
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				char c = s.charAt(j);
				map[j][i] = c;
			}
		}

//		for (int k = 0; k < K; k++) {
//			st = new StringTokenizer(br.readLine());
//			list[0][k] = Integer.parseInt(st.nextToken()) - 1;
//			list[1][k] = Integer.parseInt(st.nextToken()) - 1;
//			list[2][k] = Integer.parseInt(st.nextToken()) - 1;
//			list[3][k] = Integer.parseInt(st.nextToken()) - 1;
//		}
//		
//		for (int k = 0; k < K; k++) {
//			jc = oc = ic = 0;
//			for (int i = list[1][k]; i <= list[3][k]; i++) {
//				for (int j = list[0][k]; j <= list[2][k]; j++) {
//					if (map[i][j] == 'J') {
//						jc++;
//					} else if (map[i][j] == 'O') {
//						oc++;
//					} else if (map[i][j] == 'I') {
//						ic++;
//					}
//
//				}
//			}
//			System.out.println(jc + " " + oc + " " + ic);
//		}
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			sx = Integer.parseInt(st.nextToken()) - 1;
			sy = Integer.parseInt(st.nextToken()) - 1;
			ex = Integer.parseInt(st.nextToken()) - 1;
			ey = Integer.parseInt(st.nextToken()) - 1;
			jc = oc = ic = 0; 
			for (int i = sx; i <= ex; i++) {
				for (int j = sy; j <= ey; j++) {
					if (map[j][i] == 'J') {
						jc++;
					} else if (map[j][i] == 'O') {
						oc++;
					} else if (map[j][i] == 'I') {
						ic++;
					}

				}
			}
			System.out.println(jc + " " + oc + " " + ic);

		}

	}
}
