package Algo12_Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_10505_소득불균형 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st =new StringTokenizer(br.readLine());
			int sum = 0 ;
			LinkedList<Integer> list = new LinkedList<>();
			for(int i = 0 ; i < N; i++) {
				int number = Integer.parseInt(st.nextToken());
				sum+=number;
				list.add(number);
			}
			double avg = sum / list.size();
			int cnt= 0 ; 
			for(Integer k : list) {
				if((double)k<=avg)
					cnt++;
			}
			System.out.println("#" + t + " " + cnt);
		}

	}
}
