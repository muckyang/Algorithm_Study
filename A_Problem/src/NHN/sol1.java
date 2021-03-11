package NHN;

public class sol1 {
	private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames,
			int[] numOfMovesPerGame) {
		// TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
		StringBuilder sb = new StringBuilder();
		int count[] = new int[numOfAllPlayers];
		boolean v[] = new boolean[numOfAllPlayers];

		int list[] = new int[numOfAllPlayers - 1];

		for (int i = 0; i < numOfQuickPlayers; i++) {
			v[namesOfQuickPlayers[i] - 'A'] = true;

		}
		for (int i = 1; i < numOfAllPlayers; i++) {
			list[i - 1] = i;
		}

		count[0]++;// A
		int now = 0;
		int sule= 0;
		for (int i = 0; i < numOfGames; i++) {
			int next = numOfMovesPerGame[i] + now;
			
			while (next < 0) {
				next += (numOfAllPlayers - 1);
			}
			if (next > 0) {
				next %= (numOfAllPlayers - 1);
			}
			
			if (!v[list[next]]) {
				int temp = sule;
				sule = list[next];
				list[next] = temp;
				count[sule]++;
			} else {
				count[sule]++;
			}
			now = next;
		}
		char end = (char) (sule + 'A');
		for (int i = 0; i < numOfAllPlayers -1; i++) {
			if(list[i] == end)
				continue;
			char c = (char) (list[i] + 'A');
			sb.append(c).append(count[list[i]]).append("\n");
		}
		sb.append(end).append(count[sule]).append("\n");
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		char Quick[] = new char[2];
		int[] numOfMovesPerGame = new int[3];
		Quick[0] = 'B';
		Quick[1] = 'C';
		numOfMovesPerGame[0] = 3;
		numOfMovesPerGame[1] = -2;
		numOfMovesPerGame[2] = 3;

		solution(6, 2, Quick, 3, numOfMovesPerGame);
	}
}
