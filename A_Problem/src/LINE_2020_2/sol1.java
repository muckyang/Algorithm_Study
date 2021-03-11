package LINE_2020_2;

public class sol1 {
	public static void main(String[] args) {
		int[][] boxes = { { 1, 2 }, { 2, 1 }, { 3, 3 }, { 4, 5 }, { 5, 6 }, { 7, 8 } };
		System.out.println(solution(boxes));
	}

	public static int solution(int[][] boxes) {
		int answer = -1;
		int size = boxes.length;
		int v[] = new int[1000001];

		for (int i = 0; i < size; i++) {
			int a = boxes[i][0];
			int b = boxes[i][1];
			v[a]++;
			v[b]++;
		}
		int cc = 0;
		for (int i = 0; i < v.length; i++) {
			if (v[i] == 0)
				continue;
			else if (v[i] % 2 == 0)
				cc += v[i] / 2;
		}
		answer = size - cc;
		return answer;
	}
}
