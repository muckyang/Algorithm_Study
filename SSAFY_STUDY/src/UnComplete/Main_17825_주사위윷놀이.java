package UnComplete;

import java.util.Scanner;

public class Main_17825_주사위윷놀이 {
	static int list[];
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int [4][20];
		for(int i = 0 ; i<20;i++) {
			map[0][i] = (i+1)*2;
		}
	}
}
