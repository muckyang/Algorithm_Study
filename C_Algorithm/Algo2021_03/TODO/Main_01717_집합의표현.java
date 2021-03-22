package TODO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
// 트리  +유니온파인드 써야한다고 함.
public class Main_01717_집합의표현 {
	static int N, M;
	static int team[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Integer> hm = new HashMap<>();
		hm.values();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		team = new int[N + 1];
		for (int i = 0; i < N; i++)
			team[i] = i;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			if (type == 0) {// 팀 병합
				int union = team[num1];
				int find = team[num2];
				if (union == find) {
					continue;
				}
				for (int k = 0; k < team.length; k++) {
					if (team[k] == find) {
						team[k] = union;
					}
				}
			} else {// 같은 팀인지 체크
				if (team[num1] == team[num2]) {
					sb.append("YES").append("\n");
				} else {
					sb.append("NO").append("\n");
				}
			}
		}
		System.out.println(sb.toString());
	}
}
