package partition3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16939_2x2x2큐브 {
	static int[] list;
	static int[] temp;
	static int[][] rotate = { { 1, 3, 5, 7, 9, 11, 24, 22 }, { 13, 14, 5, 6, 17, 18, 21, 22 },
			{ 3, 4, 17, 19, 10, 9, 16, 14 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new int[24];
		for (int i = 0; i < 24; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		boolean res = true;
		temp = new int[24];
		for (int i = 0; i < 3; i++) {
			res = true;
			System.arraycopy(list, 0, temp, 0, 24);
			for (int d = 0; d < 8; d += 2) {
				temp[rotate[i][d] - 1] = list[rotate[i][(d + 2) % 8] - 1];
				temp[rotate[i][(d + 1) % 8] - 1] = list[rotate[i][(d + 3) % 8] - 1];
			}
			for (int k = 0; k < 6; k++) {
				for (int k2 = 0; k2 < 4; k2++) {
					if (temp[k * 4 + k2] != temp[k * 4]) {
						res = false;
					}
				}
			}
			if (res)
				break;
			res = true;
			System.arraycopy(list, 0, temp, 0, 24);
			for (int d = 0; d < 8; d += 2) {
				temp[rotate[i][(d + 2) % 8] - 1] = list[rotate[i][(d) % 8] - 1];
				temp[rotate[i][(d + 3) % 8] - 1] = list[rotate[i][(d + 1) % 8] - 1];
			}
			for (int k = 0; k < 6; k++) {
				for (int k2 = 0; k2 < 4; k2++) {
					if (temp[k * 4 + k2] != temp[k * 4]) {
						res = false;
					}
				}
			}
			if (res)
				break;
			
		}
		System.out.println(res ? 1 : 0);
	}

}
