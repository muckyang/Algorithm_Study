package Main_00001_to_2000;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_1021_회전화는큐 {
	static int N, M;
	static int[] poplist;
	static ArrayList<Integer> al;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		poplist = new int[M];
		al = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++)
			al.add(i);
		for (int i = 0; i < M; i++) {
			poplist[i] = sc.nextInt();
		}
		cnt = 0;
		for (int i = 0; i < M; i++) {
			
			if (al.get(0) == poplist[i]) {
				al.remove(0);
				continue;
			} else {
				int target = al.indexOf(poplist[i]);
				if (target < al.size() - target ) {// <<이쪽으로 미는게 빠를때
					int count = target ;
					cnt += count;
					for(int k = 0 ; k < count ; k ++) {
						int temp = al.remove(0);
						al.add(temp);
					}
					al.remove(0);
				}else {
					int count = al.size() -target ;
					cnt += count;
					for(int k = 0 ; k < count ; k ++) {
						int temp = al.remove(al.size()-1);
						al.add(0,temp);
					}
					al.remove(0);
				}
				
			}
			
		}
		System.out.println(cnt);
	}
}
