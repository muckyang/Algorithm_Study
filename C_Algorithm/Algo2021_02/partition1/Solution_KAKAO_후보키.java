package partition1;

import java.io.IOException;
import java.util.HashSet;

public class Solution_KAKAO_후보키 {
	public static void main(String args[]) throws IOException {
		String relation[][] = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };
		System.out.println(solution(relation));
	}

	static boolean v[];// 선택여부
	static HashSet<String> hs;
	static int typenum, column;
	static String[][] rel;
	static int answer;

	public static int solution(String[][] relation) {
		answer = 0;
		rel = relation.clone();
		column = relation.length;
		typenum = relation[0].length;
		int max = (int) Math.pow(2, typenum);
		v = new boolean[max ];
		solve(max-1);// 선택 컬럼 수,진행 컬럼 , 비트마스크

		return answer;
	}

	private static int solve(int bit) {
		int flag = 0;
		if (bit != 0) {
			if (v[bit])// 이미 후보키 설정된 경우 셀 필요없음
				return 1;
			// 체크
			hs = new HashSet<>();
			for (int i = 0; i < column; i++) {
				String s = "";
				for (int j = 0; j < typenum; j++) {
					if (((1 << j) & bit) != 0) {
						s += rel[i][j] + "_";
					}
				}
				hs.add(s);
			}
			if (hs.size() == column) {
				v[bit] = true;
				for (int i = 0; i < typenum; i++) {// 있는것중 하나 삭제하고 확인하기!
					if (((1 << i) & bit) != 0) {
						if(solve(bit - (1 << i))>0)
							flag++;
					}
				}
				if (flag==0) {
					answer++;
					return 1;
				}
			}
			

		}
		return flag;

	}

}