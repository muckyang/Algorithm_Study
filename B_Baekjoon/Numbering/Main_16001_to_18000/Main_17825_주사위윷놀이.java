package Main_16001_to_18000;

import java.util.Scanner;
//https://octorbirth.tistory.com/235
public class Main_17825_주사위윷놀이 {

	static int score[][];
	static boolean on[][];
	static boolean end[];
	static int max;
	static int go[];
	static int order[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		on = new boolean[5][20];
		end = new boolean[4];
		go = new int[10];
		order = new int[10];// 이동할 말 순서대로 저장
		int[][] score = { { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40 },
				{ 13, 16, 19 }, { 22, 24 }, { 28, 27, 26 }, { 25, 30, 35, 40 } };
		for (int i = 0; i < 10; i++) {
			go[i] = sc.nextInt();
		}
		max = 0;
		perm(0);
	}

	private static void perm(int count) {
		if (count == 10) { // 10개의 이동 순서 선택완료
			int res = game(order);
			max = Math.max(max, res);
			return;
		}
		for (int i = 0; i < 4; i++) {
			order[count] = i;
			perm(count + 1);
		}
	}

	private static int game(int[] olist	) {
		int res = 0 ;
		for(int i = 0 ; i < 10;i++) {
			int move_horse = olist[i];
			int move_dist = go[i];
//			if(move(move_horse,move_dist) == 0) //이미 말이 존재하는 곳으로 가거나 이미 도착한 말인경우
				return 0;
			
			
		}
		return res;
	}
}
