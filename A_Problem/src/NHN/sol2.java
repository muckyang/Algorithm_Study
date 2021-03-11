package NHN;

public class sol2 {
	private static void solution(int day, int width, int[][] blocks) {
		// TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
		int[] map = new int[width];
		int cement = 0;
		for (int d = 0; d < day; d++) {
			int st = 0;
			int ed = 1;
			int stmax = map[st] + blocks[d][0];
			int edmax = map[ed] + blocks[d][1];
			int sum = 0;
			for (int i = 1; i < width; i++) {
				if (map[i] + blocks[d][i] > stmax) {
					cement+=sum;
					sum = 0;
					
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] blocks = { { 6, 2, 11, 0, 3, 5 }, { 6, 3, 0, 9, 0, 5 } };
		solution(2, 6, blocks);
	}
}
