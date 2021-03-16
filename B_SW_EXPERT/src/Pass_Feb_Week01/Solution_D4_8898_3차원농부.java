package Pass_Feb_Week01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_D4_8898_3차원농부 {

	public static void main(String[] args) throws IOException {

		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		String t_String;
		int T;
		// T=sc.nextInt();
		T = Integer.parseInt(r.readLine());
		int N, M;
		int c1, c2;
		int horse_z;
		int[] cow_list;
		int[] horse_list;
		int mindist = 100000000;
		int mincount = 0;
		for (int test_case = 1; test_case <= T; test_case++) {
			
			StringTokenizer s = null;
			s = new StringTokenizer(r.readLine());
			N = Integer.parseInt(s.nextToken());
			M = Integer.parseInt(s.nextToken());
			cow_list = new int[N];
			horse_list = new int[M];

			s = new StringTokenizer(r.readLine());
			c1 = Integer.parseInt(s.nextToken());
			c2 = Integer.parseInt(s.nextToken());
			int p = c1 - c2;
			s = new StringTokenizer(r.readLine());

			for (int i = 0; i < N; i++) {
				cow_list[i] = Integer.parseInt(s.nextToken());

			}

			Arrays.sort(cow_list);
			s = new StringTokenizer(r.readLine());
			for (int j = 0; j < M; j++) {
				horse_list[j] = Integer.parseInt(s.nextToken());
			}
			Arrays.sort(horse_list);
			int dist;
			for (int i = 0; i < M; i++) {

				for (int j = 0; j < N; j++) {

					dist = Math.abs(horse_list[i] - cow_list[j]);
					if (mindist > dist) {
						mindist = dist;
						mincount = 1;
					} else if (mindist == dist) {
						mincount++;
						if (j < N - 1) {
							if (dist < Math.abs(horse_list[i] - cow_list[j + 1]))
								break;
						}
					}
				}
			}
			mindist = mindist + Math.abs(p);
			System.out.println("#" + test_case + " " + mindist + " " + mincount);
			cow_list = new int[500000];
			mindist = 100000000;
			mincount = 0;
		}
	}
}
