package LINE_2020_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class sol6 {

	   public static void main(String[] args) {
	      // TODO Auto-generated method stub
	      String[] companies = { "A fabdec 2", "B cebdfa 2", "C ecfadb 2" };
	      String[] applicants = { "a BAC 1", "b BAC 3", "c BCA 2", "d ABC 3", "e BCA 3", "f ABC 2" };
	      System.out.println(solution(companies, applicants));
	   }

	   public static String[] solution(String[] companies, String[] applicants) {
	      String[] answer = {};
	      int C = companies.length;
	      int A = applicants.length;

	      char[][] want = new char[26][26];
	      int[] wantcnt = new int[26];
	      for (int i = 0; i < C; i++) {
	         String[] sarr = companies[i].split(" ");
	         char[] c = sarr[1].toCharArray();
	         for (int idx = 0; idx < A; idx++) {
	            want[(sarr[0].charAt(0)) - 'A'][idx] = c[idx];
	         }
	         wantcnt[(sarr[0].charAt(0)) - 'A'] = Integer.valueOf(sarr[2]);
	      }

	      char[][] go = new char[26][26];
	      int[] gocnt = new int[26];
	      for (int i = 0; i < A; i++) {
	         String[] sarr = applicants[i].split(" ");
	         char[] c = sarr[1].toCharArray();
	         for (int idx = 0; idx < C; idx++) {
	            go[(sarr[0].charAt(0)) - 'a'][idx] = c[idx];
	         }
	         gocnt[(sarr[0].charAt(0)) - 'a'] = Integer.valueOf(sarr[2]);
	      }

	      boolean[] isfin = new boolean[26];
	      boolean[][] isapp = new boolean[26][26];
	      int cur = 0;
	      Queue<Integer> q = new LinkedList<>();
	      for (int i = 0; i < 26; i++) {
	         q.add(i);
	      }
	      int appcnt = 0;
	      while (!q.isEmpty()) {
	         while (!q.isEmpty()) {
	            int i = q.poll();
	            if (isfin[i])
	               continue;
	            if (go[i][cur] == '\u0000')
	               continue;
	            System.out.print(i+" ");
	            isapp[go[i][cur] - 'A'][i] = true;
	         } // 모든 지원자 cur지망에 지원

	         
	         appcnt++;
	         for (int i = 0; i < 26; i++) { // 회사 돌면서 맥스값 이하사람들은 지원 취소 및 큐에 넣기
	            if (want[i][0] == '\u0000')
	               continue;
	            int cnt = wantcnt[i]; // 회사 원하는 수
	            for (int j = 0; j < A; j++) {
	               if (isapp[i][want[i][j] - 'a']) {
	                  if (cnt == 0) {
	                     isapp[i][want[i][j] - 'a'] = false;
	                     if (gocnt[want[i][j] - 'a'] == appcnt) {
	                        isfin[want[i][j] - 'a'] = true;
	                        System.out.println("f");
	                        System.out.println(want[i][j] - 'a');
	                     } else {
	                        q.add(want[i][j] - 'a');
	                     }
	                  }
	                  cnt--;
	               }
	            }
	         }
	         cur++;
	      }
	      return answer;
	   }


}
