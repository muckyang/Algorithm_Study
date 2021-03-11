package KAKAO_2020_2;

import java.util.StringTokenizer;

public class sol5 {

	public static void main(String[] args) {
		String play_time = "00:02:00";
		String adv_time = "00:00:59";
		String[] logs = { "00:01:59-00:02:00"};
		System.out.println(solution(play_time, adv_time, logs));

	}

	 public static String solution(String play_time, String adv_time, String[] logs) {
			String answer = "";
			int[] count = new int[100 * 60 * 60+1];

			int playtime = stoi(play_time);
			int advtime = stoi(adv_time);
			for (int i = 0; i < logs.length; i++) {
				String all = logs[i];
				String arr[] = all.split("-");
				count[stoi(arr[0])]++;
				count[stoi(arr[1])]--;
			}
			int sp = 0;
			int res = 0;
			int sumCast = 0;
			int ecounter = 0;
			for (int i = 0; i < advtime+1; i++) {
				ecounter += count[i];
				sumCast += ecounter;
			}

			int scounter = 0;
			res = sumCast;
	        for (int i = 1; i < playtime - advtime+1; i++) {
	            scounter += count[i-1];
	            sumCast -= scounter;
	            ecounter += count[i + advtime-1];
	            sumCast += ecounter;
	            if (sumCast > res) {
	                sp = i;
	                res = sumCast;
	            }
	        }
			String hour = "" + sp / 3600;
			String min = "" + ((sp / 60) % 60);
			String sec = "" + ((sp % 60) % 60);
			if (hour.length() == 0) {
				hour = "00";
			} else if (hour.length() == 1) {
				hour = "0" + hour;
			}
			if (min.length() == 0) {
				min = "00";
			} else if (min.length() == 1) {
				min = "0" + min;
			}
			if (sec.length() == 0) {
				sec = "00";
			} else if (sec.length() == 1) {
				sec = "0" + sec;
			}
			answer = hour + ":" + min + ":" + sec;

			return answer;
		}

		public static int stoi(String s) {
			int res = 0;
			StringTokenizer st = new StringTokenizer(s, ":");
			for (int i = 0; i < 3; i++) {
			res += (Math.pow(60, 2-i))*Integer.parseInt(st.nextToken());
				
			}
			return res;
		}
}
