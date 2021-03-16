package partition1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main_04358_생태학_Hash {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> hm = new HashMap();
		List<String> list = new ArrayList<String>();
		int N = 0;
		String s = "";
		while ((s=br.readLine()) != null) {
			if (hm.containsKey(s)) {
				hm.put(s, hm.get(s) + 1);
			} else {
				hm.put(s, 1);
				list.add(s);
			}
			N++;
		}
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			String target = list.get(i);
			sb.append(target).append(" ").append(String.format("%.4f", ((double) hm.get(target) / (double) N) *100) ).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

}
