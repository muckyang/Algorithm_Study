package Algo12_Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class  Main_20157_화살을쏘자{
	static int N;
	static int[][] balloon;
	static boolean v[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// 1~100000
		balloon = new int[2][N];
		v = new boolean[N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			balloon[0][i] = Integer.parseInt(st.nextToken());
			balloon[1][i] = Integer.parseInt(st.nextToken());
		}
	}
}
