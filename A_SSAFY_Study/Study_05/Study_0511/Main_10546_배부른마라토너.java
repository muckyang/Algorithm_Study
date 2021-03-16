package Study_0511;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10546_배부른마라토너 {
	static int N;
	static String prelist[];
	static String comlist[];
	static String res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		prelist = new String[N];
		comlist = new String[N-1];
		for (int i = 0; i < N; i++) {
			prelist[i] = br.readLine();
		}
		for (int i = 0; i < N-1; i++) {
			comlist[i] = br.readLine();
		}
		res = "";
		Arrays.sort(prelist);
		Arrays.sort(comlist);
		for (int i = 0; i < N-1; i++) {
			if(!prelist[i].equals(comlist[i])) {
				res = prelist[i];
				break;
			}
		}
		if(res.equals(""))
			res = prelist[N-1];
		System.out.println(res);
	}
}
