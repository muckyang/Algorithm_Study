package Study_0910;

public class Kakao_2020_가사검색 {

	public static void main(String[] args) {
		String[] words = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
//		String[] words = { "j", "e", "f", "fz", "fr", "ko" };
		String[] queries = { "fro??", "????o", "fr???", "fro???", "?????" };
		int[] result = solution(words, queries);
	}

	public static class Trie {
		boolean isTerminal;
		int cnt;
		Trie[] child;

		public Trie() {
			this.isTerminal = false;
			this.cnt = 0;
			this.child = new Trie[26];
		}
	}

	public static int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];
		Trie[] fftrie = new Trie[10001];
		Trie[] bbtrie = new Trie[10001];
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			int ssize = word.length();
			if (fftrie[ssize] == null)
				fftrie[ssize] = new Trie();
			Trie ftrie = fftrie[ssize];
			fftrie[ssize].cnt++;
			if (bbtrie[ssize] == null)
				bbtrie[ssize] = new Trie();
			Trie btrie = bbtrie[ssize];
			for (int j = 0; j < word.length(); j++) {
				char c1 = word.charAt(j);
				char c2 = word.charAt(word.length() - 1 - j);
				if (ftrie.child[c1 - 'a'] == null) {
					ftrie.child[c1 - 'a'] = new Trie();
				}
				if (btrie.child[c2 - 'a'] == null) {
					btrie.child[c2 - 'a'] = new Trie();
				}
				ftrie = ftrie.child[c1 - 'a'];
				btrie = btrie.child[c2 - 'a'];
				ftrie.cnt++;
				btrie.cnt++;
				if (j == word.length() - 1) {
					ftrie.isTerminal = true;
					btrie.isTerminal = true;
				}
			}
		}
		for (int i = 0; i < queries.length; i++) {
			int size = queries[i].length();
			if(fftrie[size]==null)
				fftrie[size] = new Trie();
			int k = 0;
			int res = 0;
			if(queries[i].charAt(0) == '?' && queries[i].charAt(size-1) == '?') {
				res = fftrie[size].cnt;
				System.out.println("1 " +i);
			}else if (queries[i].charAt(0) != '?') {// 접두사로 찾기
				System.out.println("2 " +i);
				char c = queries[i].charAt(0);
				if (fftrie[size] == null) {
					answer[i] = res;
					continue;
				}
				Trie ftrie = fftrie[size];
				while (c != '?') {
					if (ftrie.child[c - 'a'] == null) {
						res = 0;
						break;
					}
					res = ftrie.cnt;
					ftrie = ftrie.child[c - 'a'];
					k++;
					if (k == size)
						break;
					c = queries[i].charAt(k);

				}

			} else{ // 잡미사로 찾기
				System.out.println("3 " +i);
				
				k = size - 1;
				char c = queries[i].charAt(k);
				if (bbtrie[size] == null) {
					answer[i] = res;
					continue;
				}
				Trie btrie = bbtrie[size];
				while (c != '?') {
					if (btrie.child[c - 'a'] == null) {
						res = 0;
						break;
					}
					res = btrie.cnt;
					btrie = btrie.child[c - 'a'];
					k--;
					c = queries[i].charAt(k);

				}

			}
			answer[i] = res;
		}

		return answer;
	}
}
