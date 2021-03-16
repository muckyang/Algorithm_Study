package Study_0910;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Kakao_2020_intern_매칭점수 {

	public static void main(String[] args) {
		String word = "muzi";
		String[] pages = {
				"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>",
				"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>" };
		System.out.println(solution(word, pages));
	}

	public static int solution(String word, String[] pages) {
		int answer = 0;
		word = word.toLowerCase();
		String[] mylink = new String[pages.length];
		int[] linkCnt = new int[pages.length];
		int[] wordCnt = new int[pages.length];
		double[] Score = new double[pages.length];

		ArrayList<String>[] al = new ArrayList[pages.length];
		for (int i = 0; i < pages.length; i++) {
			al[i] = new ArrayList<>();
			StringTokenizer st1 = new StringTokenizer(pages[i]);
			while (st1.hasMoreTokens()) {// 다 쓸때 까지
				String ss = st1.nextToken();
				StringTokenizer st2 = new StringTokenizer(ss);

				while (st2.hasMoreTokens()) {// 다 쓸때 까지
					String s = st2.nextToken();
					String sk = "";
					for (int k = 0; k < s.length(); k++) {
						if ((s.charAt(k) >= 'A' && s.charAt(k) <= 'Z') || (s.charAt(k) >= 'a' && s.charAt(k) <= 'z')) {
							sk += s.charAt(k);
						} else {
							if (sk.toLowerCase().equals(word)) {
								wordCnt[i]++;
							}
							sk = "";
						}

					}
					if (sk.toLowerCase().equals(word)) {
						wordCnt[i]++;
					}
					sk = "";
				}
				st2 = new StringTokenizer(ss);

				while (st2.hasMoreTokens()) {// 다 쓸때 까지
					String s = st2.nextToken();
					if (s.equals("<a")) {
						while (st2.hasMoreTokens()) {
							String s2 = st2.nextToken();
							String addr = "";
							for (int k2 = 0; k2 < s2.length(); k2++) {
								if (s2.charAt(k2) == '"') {
									addr += s2.charAt(k2);
									if (addr.equals("https://")) {
										addr = "";
										while (true) {
											k2++;
											addr += s2.charAt(k2);
											if (s2.charAt(k2) == '"') {
												al[i].add(addr);
												linkCnt[i]++;
												addr="";
												break;
											}
										}
									}
								}
							}
						}

					}
					if (s.equals("<meta")) {// 내주소 찾기
						while (st2.hasMoreTokens()) {
							String s2 = st2.nextToken();
							String addr = "";
							for (int k2 = 0; k2 < s2.length(); k2++) {
								if (s2.charAt(k2) == '"') {
									addr += s2.charAt(k2);
									if (addr.equals("https://")) {
										addr = "";
										while (true) {
											k2++;
											addr += s2.charAt(k2);
											if (s2.charAt(k2) == '"') {
												mylink[i] = addr;
												break;
											}
										}
									}
								}
							}

						}
					}
				}
			}

		}
		for (int a = 0; a < pages.length; a++) {
			double pers = wordCnt[a] * 1.0 / linkCnt[a];
			for (int b = 0; b < al[a].size(); b++) {
				for (int c = 0; c < pages.length; c++) {
					if (c == a)
						continue;
					if (al[a].get(b).equals(mylink[c])) {
						Score[a] += pers;
					}
				}
			}

			Score[a] += wordCnt[a];
		}
		double max = 0.0;
		for (int i = 0; i < pages.length; i++) {
			if (max < Score[i]) {
				max = Math.max(max, Score[i]);
				answer = i;
			}
		}
		return answer;
	}
}
