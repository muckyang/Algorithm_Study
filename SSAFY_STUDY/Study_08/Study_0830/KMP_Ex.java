package Study_0830;

public class KMP_Ex {
	public static void main(String[] args) {
		//pi 배열 만들기
		char []list;
		String s = "ABABACA";
		list = s.toCharArray();
		int []pi = new int [s.length()];
		
		
		int j = 0;
		for(int i = 1; i <list.length; i ++) {
			if(j>0 && list[i] != list[j]) {
				j= pi[j-1];
			}
			
			if(list[i] == list[j]) {
				pi[i] = ++j;
			}
		}
		for(int i = 0; i < list.length;i++)
		System.out.print(pi[i] + " " );
	}
}
