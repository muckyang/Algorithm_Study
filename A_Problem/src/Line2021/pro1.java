package Line2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class pro1 {

	public static void main(String[] args) {
		String[] table = { "SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
				"HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
				"GAME C++ C# JAVASCRIPT C JAVA" };
		String[] languages = { "PYTHON", "C++", "SQL" };
		int[] preference = { 7, 5, 5 };
		System.out.println(solution(table, languages, preference));
	}

	public static String solution(String[] table, String[] languages, int[] preference) {
		String answer = "";

		List<String> list = new ArrayList<String>();
		int max = 0;
		for (int i = 0; i < table.length; i++) {
			String s = table[i];
			StringTokenizer st = new StringTokenizer(s);
			String category = st.nextToken(); // 카테고리 지정
			int num = 5;
			int sum = 0;
			while (st.hasMoreTokens()) {
				String lan = st.nextToken();// 언어명 입력
				for (int j = 0; j < languages.length; j++) {
					if (languages[j].equals(lan)) {
						sum += num * preference[j];
					}
				}

				num--;
			}
			System.out.println(category + " : " + sum);
			if (sum > max) {
				list = new ArrayList<String>();
				max = sum;
				list.add(category);
//				answer = category;
				
			}else if(sum == max) {
				list.add(category);
			}
		}
		
		
		Collections.sort(list);
		answer = list.get(0);
		return answer;
	}
}
