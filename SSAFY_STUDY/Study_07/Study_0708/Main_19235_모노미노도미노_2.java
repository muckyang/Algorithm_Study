package Study_0708;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_19235_모노미노도미노_2 {
	static int N;
	static int [][][] Map = new int [2][6][5];
	static int [][] Height = new int [2][4];
	static int i;
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (i = 1; i <= N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(temp.nextToken());
			int x = Integer.parseInt(temp.nextToken());
			int y = Integer.parseInt(temp.nextToken());
			move(x, y, t, 0);
			if(t == 2) {
				move(y, x, 3, 1);
			}else if(t == 3) {
				move(y, x, 2, 1);
			}else {
				move(y, x, 1, 1);
			}
		}

		System.out.println(result);
		int count = 0;
		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if(Map[k][i][j] > 0) count++;
				}
			}
		}
		System.out.println(count);
	}

	static void move(int x, int y, int t, int m) {
		if(t == 1) {//한개짜리일때
			Map[m][Height[m][y]][y] = i;
			Height[m][y]++;
		}else if(t == 2) {//가로모양일때 
			Map[m][Integer.max(Height[m][y], Height[m][y+1])][y] = i;
			Map[m][Integer.max(Height[m][y], Height[m][y+1])][y+1] = i;
			Height[m][y] = Integer.max(Height[m][y], Height[m][y+1]) + 1;
			Height[m][y+1] = Integer.max(Height[m][y], Height[m][y+1]);
		}else {
			Map[m][Height[m][y]][y] = i;
			Map[m][Height[m][y]+1][y] = i;
			Height[m][y] += 2;
		}
		clear(m);
		push(m);
	}

	static void push(int m) {
		while(Integer.max(Height[m][0], Height[m][1]) > 4 || Integer.max(Height[m][2], Height[m][3]) > 4) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					Map[m][i][j] = Map[m][i+1][j];					
					if(i == 4) {
						Map[m][5][j] = 0;
					}
				}
			}
			for (int i = 0; i < 4; i++) {				
				if(Height[m][i] > 0)	
					Height[m][i]--;
			}			
		}
	}

	static void clear(int m) {
		boolean f = true;
		while(f) {
			f = false;
			for (int i = 0; i < 4; i++) {
				//한줄이 다 차있는 경우
				if(Map[m][i][0] > 0 && Map[m][i][1] > 0 && Map[m][i][2] > 0 && Map[m][i][3] > 0) {
					result++;
					Map[m][i][0] = Map[m][i][1] = Map[m][i][2] = Map[m][i][3] = 0;
					f = true;
				}
			}
			if(f) reMove(m);
		}

	}

	static void reMove(int m) {
		for (int i = 1; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				if(Map[m][i][j] > 0) {
					if(Map[m][i][j] == Map[m][i][j+1]) {
						int temp = Map[m][i][j];
						Map[m][i][j] = 0;
						Map[m][i][j+1] = 0;
						int t = i;
						//가로모양으로 이어진 것 내려옴
						while(t >= 0 && Map[m][t][j] == 0 && Map[m][t][j+1] == 0) {
							t--;
						}
						t++;
						Map[m][t][j] = temp;
						Map[m][t][j+1] = temp;
						j++;
					}else if(Map[m][i][j] != Map[m][i][j+1]){
						int temp = Map[m][i][j];
						Map[m][i][j] = 0;
						int t = i;
						while(t >= 0 && Map[m][t][j] == 0 ) {
							t--;
						}
						t++;
						Map[m][t][j] = temp;
					}
				}
			}
		}
		recheckHeight(m);
	}
//높이 정립
	
	static void recheckHeight(int m) {
		for (int j = 0; j < 4; j++) {
			for (int i = 5; i >= 0; i--) {
				if(Map[m][i][j] > 0) {
					Height[m][j] = i+1;
					break;
				}
				else if(i == 0) Height[m][j] = 0;
			}
		}
	}

}