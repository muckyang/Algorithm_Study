package KAKAO_2020_2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class sol3 {
	public static void main(String[] args) {
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };
		int[] res = solution(info, query);
	}

	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		LinkedList<Integer>[][][][] list = new LinkedList[3][2][2][2];
		for (int l = 0; l < 3; l++) { // 0 cpp 1 java 2 python
			for (int j = 0; j < 2; j++) { // 0 cpp 1 java 2 python
				for (int g = 0; g < 2; g++) { // 0 cpp 1 java 2 python
					for (int f = 0; f < 2; f++) { // 0 cpp 1 java 2 python
						list[l][j][g][f] = new LinkedList<>();
					}
				}
			}
		} // 초기화
		for (int i = 0; i < info.length; i++) {// 정보 파싱
			int lan = -1, jik = -1, gyeong = -1, food = -1;
			StringTokenizer st = new StringTokenizer(info[i]);
			for (int k = 0; k < 4; k++) {
				String s = st.nextToken();
				if (k == 0) {
					if (s.equals("cpp"))
						lan = 0;
					else if (s.equals("java"))
						lan = 1;
					else if (s.equals("python"))
						lan = 2;
				} else if (k == 1) {
					if (s.equals("frontend"))
						jik = 0;
					else if (s.equals("backend"))
						jik = 1;
				} else if (k == 2) {
					if (s.equals("junior"))
						gyeong = 0;
					else if (s.equals("senior"))
						gyeong = 1;
				} else if (k == 3) {
					if (s.equals("chicken"))
						food = 0;
					else if (s.equals("pizza"))
						food = 1;
				}
			}
			String s = st.nextToken();
			list[lan][jik][gyeong][food].add(Integer.parseInt(s));
		}
		for (int i = 0; i < query.length; i++) {// 쿼리 파싱
			String sarr[];
			sarr = query[i].split(" and ");
			int lan = -1, jik = -1, gyeong = -1, food = -1;

			if (sarr[0].equals("cpp"))
				lan = 0;
			else if (sarr[0].equals("java"))
				lan = 1;
			else if (sarr[0].equals("python"))
				lan = 2;

			if (sarr[1].equals("frontend"))
				jik = 0;
			else if (sarr[1].equals("backend"))
				jik = 1;

			if (sarr[2].equals("junior"))
				gyeong = 0;
			else if (sarr[2].equals("senior"))
				gyeong = 1;
			String ssarr[] = sarr[3].split(" ");
			if (ssarr[0].equals("chicken"))
				food = 0;
			else if (ssarr[0].equals("pizza"))
				food = 1;
			int point = Integer.parseInt(ssarr[1]);

			for (int l = 0; l < 3; l++) {
				if (lan != -1 && lan != l)
					continue;
				for (int j = 0; j < 2; j++) {
					if (jik != -1 && jik != j)
						continue;
					for (int g = 0; g < 2; g++) {
						if (gyeong != -1 && gyeong != g)
							continue;
						for (int f = 0; f < 2; f++) {
							if (food != -1 && food != f)
								continue;
							int cnt = 0;
							Collections.sort(list[l][j][g][f]);
//							for (int go = 0; go < list[l][j][g][f].size(); go++) {
//								if (list[l][j][g][f].get(go) >= point) {
							for (int k : list[l][j][g][f]) {
								if (k >= point) {
									answer[i] += list[l][j][g][f].size() - cnt;
									break;
								}
								cnt++;
							}
						}
					}
				}
			}
		}

		return answer;
	}
}
