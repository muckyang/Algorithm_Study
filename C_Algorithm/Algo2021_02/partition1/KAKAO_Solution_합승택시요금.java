package partition1;
//플로이드 와샬로 풀림..
public class KAKAO_Solution_합승택시요금 {
	public static void main(String[] args) {
		int[][] fares = { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, { 3, 1, 41 }, { 5, 1, 24 }, { 4, 6, 50 },
				{ 2, 4, 66 }, { 2, 3, 22 }, { 1, 6, 25 } };
		int result = solution(6, 4, 6, 2, fares);
		// 82
		System.out.println(result);
	}

	static int[][] price;

	static int res;

	public static class Point {
		int to;
		int weight;

		public Point(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

	}

	public static class Pay implements Comparable<Pay> {
		int from;
		int weight;

		public Pay(int from, int weight) {
			this.from = from;
			this.weight = weight;
		}

		public int compareTo(Pay p) {
			return this.weight - p.weight;
		}

	}

	public static int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = 0;
		s = s - 1;
		a = a - 1;
		b = b - 1;
		price = new int[n][n];
		res = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				price[i][j] = Integer.MAX_VALUE;

			}
		}

		for (int i = 0; i < fares.length; i++) {
			int st = fares[i][0] - 1;
			int ed = fares[i][1] - 1;
			int weight = fares[i][2];
			price[st][ed] = weight;
			price[ed][st] = weight;
		}
		for (int k = 0; k < n; k++) {
			for (int j = 0; j < n; j++) {
				for (int i = 0; i < n; i++) {
					if(price[i][k] == Integer.MAX_VALUE || price[k][j] == Integer.MAX_VALUE )
						continue;
					if (price[i][j] > price[i][k] + price[k][j]) {
						price[i][j] = price[i][k] + price[k][j];
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			int stom = price[s][i];
			int mtoa = price[i][a];
			int mtob = price[i][b];

			if (stom == Integer.MAX_VALUE || mtoa == Integer.MAX_VALUE || mtob == Integer.MAX_VALUE)
				continue;
			res = Math.min(res, stom + mtoa + mtob);

		}
		return res;
	}


}
