
public class Line3 {
	public static void main(String[] args) {
		String answer_sheet = "24551";
		String[] sheets = { "24553", "24553", "24553", "24553" };
		int proNum = answer_sheet.length();
		int stNum = sheets.length;
		boolean TF[][] = new boolean[stNum][proNum];
		for (int i = 0; i < stNum; i++) {
			for (int j = 0; j < proNum; j++) {
				if (answer_sheet.charAt(j) == sheets[i].charAt(j)) {
					TF[i][j] = true;
				}
			}
		}
		int res = 0;
		int sumList[][] = new int[stNum][stNum];
		int maxLink[][] = new int[stNum][stNum];

		for (int i = 0; i < stNum; i++) {
			for (int j = i + 1; j < stNum; j++) {
				boolean backcheck = false;
				int LinkC = 0;
				for (int k = 0; k < proNum; k++) {
					if (sheets[i].charAt(k) == sheets[j].charAt(k) && !TF[i][k]) {
						sumList[i][j]++;

						LinkC++;
						if (maxLink[i][j] < LinkC)
							maxLink[i][j] = LinkC;
					} else {
						LinkC = 0;
					}
				}
			}
		}
		for (int i = 0; i < stNum; i++) {
			for (int j = i + 1; j < stNum; j++) {
//				System.out.println(i + " , " + j + " : " + sumList[i][j] + " max : " + maxLink[i][j]);
				res = Math.max(res, sumList[i][j] + (maxLink[i][j] * maxLink[i][j]));
			}
		}
		System.out.println(res);

	}
}
