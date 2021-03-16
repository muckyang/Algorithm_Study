package Algo12_Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20055_컨베이어벨트위의로봇 {
	static int N, K;
	static int[] belt;
	static boolean[] onRobot;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		belt = new int[N * 2];
		onRobot = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N*2; i++)
			belt[i] = Integer.parseInt(st.nextToken());
		int brokenNum = 0;
		int res = 0;
		while (brokenNum < K) {
			res++;
			// 벨트 이동
			int temp = belt[N * 2 - 1];
			for (int i = N * 2 - 1; i > 0; i--) {
				belt[i] = belt[i - 1];
			}
			belt[0] = temp;
			
			for (int i = N - 1; i > 0; i--) {
				onRobot[i] = onRobot[i-1];
			}
			onRobot[0] = false;
			// 로봇 이동
			if (onRobot[N - 1]) {
				onRobot[N - 1] = false;
			}
			for (int i = N - 2; i >= 0; i--) {
				if (onRobot[i]&&!onRobot[i + 1] && belt[i + 1] > 0) {// 다음위치가 비어있다면?
					belt[i + 1]--;
					if (belt[i + 1] == 0)
						brokenNum++;
					onRobot[i] = false;
					onRobot[i + 1] = true;
				}
			}
			// 로봇 탑승
			if (belt[0] > 0) {
				belt[0]--;
				if (belt[0] == 0)
					brokenNum++;
				onRobot[0] = true;
			}
			// 부서진거 확인
		}

		System.out.println(res);
	}
}
