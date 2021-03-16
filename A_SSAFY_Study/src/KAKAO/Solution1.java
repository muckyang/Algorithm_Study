package KAKAO;

public class Solution1 {

	public static void main(String[] args) {
		int ly = 3;
		int lx = 0;
		int ry = 3;
		int rx = 2;
		int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		String hand = "left";
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < numbers.length; i++) {
			int y = (numbers[i] - 1) / 3;
			int x = (numbers[i] - 1) % 3;
			if (numbers[i] == 0) {
				y = 3;
				x = 1;
				if (dist(rx, ry, x, y) < dist(lx, ly, x, y)) {
					rx = x;
					ry = y;
					sb.append("R");
				} else if (dist(rx, ry, x, y) > dist(lx, ly, x, y)) {
					lx = x;
					ly = y;
					sb.append("L");
				} else {
					if (hand.equals("right") ){
						rx = x;
						ry = y;
						sb.append("R");
					} else {
						lx = x;
						ly = y;
						sb.append("L");
					}
				}
			} else {
				if (x == 2) {
					rx = x;
					ry = y;
					sb.append("R");
				} else if (x == 0) {
					lx = x;
					ly = y;
					sb.append("L");
				} else {
					if (dist(rx, ry, x, y) < dist(lx, ly, x, y)) {
						rx = x;
						ry = y;
						sb.append("R");
					} else if (dist(rx, ry, x, y) > dist(lx, ly, x, y)) {
						lx = x;
						ly = y;
						sb.append("L");
					} else {
						if (hand.equals("right")) {
							rx = x;
							ry = y;
							sb.append("R");
						} else {
							lx = x;
							ly = y;
							sb.append("L");
						}
					}
				}
			}
		}
		System.out.println(sb.toString());

	}

	private static int dist(int kx, int ky, int x, int y) {
		int num = 0;
		num += Math.abs(ky - y);
		num += Math.abs(kx - x);
		return num;
	}
}
