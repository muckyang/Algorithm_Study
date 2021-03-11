package NAVER_2020_2_2;

import java.util.LinkedList;

public class sol2 {
	static int[][] res;

	public static void main(String[] args) {
		int[][] blocks = { { 0, 50 }, { 0, 22 }, { 2, 10 }, { 1, 4 }, { 4, -13 } };
		int []ress = solution(blocks);
		for(int i = 0 ; i< ress.length;i++)
			System.out.print(ress[i] + " ");
	}

	public static int[] solution(int[][] blocks) {
		LinkedList<Integer> list = new LinkedList<>();
		res = new int[blocks.length][blocks.length];
		for (int i = 0; i < blocks.length; i++) {
			res[i][blocks[i][0]] = blocks[i][1];
			
			goLeft(i, blocks[i][0]);
			goRight(i, blocks[i][0]);
			for(int j = 0; j<=i ;j++)
				list.add(res[i][j]);
		
		}
		int[] result = new int[list.size()];
		int cnt= 0;
		for(int i : list) {
			result[cnt]=i;
			cnt++;
		}
		
		return result;
	}

	private static void goRight(int depth, int now) {
		if(depth == 0 || depth == now)
			return;
		res[depth][now+1] = res[depth-1][now] - res[depth][now];
		goRight(depth,now+1);
		
	}

	private static void goLeft(int depth, int now) {
		if(depth == 0 || now==0)
			return;
		res[depth][now-1] = res[depth-1][now-1] - res[depth][now];
		goLeft(depth,now-1);
	}

}
