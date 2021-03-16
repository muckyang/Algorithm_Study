package Study_0227;

import java.util.Scanner;

public class Main_5373_큐빙 {
	static int T;
	static char[][] top_Mat;// w
	static char[][] bot_Mat;// y
	static char[][] left_Mat;// g
	static char[][] right_Mat;// b
	static char[][] front_Mat;// r
	static char[][] back_Mat;// o

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			top_Mat = new char[3][3];
			bot_Mat = new char[3][3];
			left_Mat = new char[3][3];
			right_Mat = new char[3][3];
			front_Mat = new char[3][3];
			back_Mat = new char[3][3];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					top_Mat[i][j] = 'w';
					bot_Mat[i][j] = 'y';
					left_Mat[i][j] = 'g';
					right_Mat[i][j] = 'b';
					front_Mat[i][j] = 'r';
					back_Mat[i][j] = 'o';

				}
			}
		}
	}
}
