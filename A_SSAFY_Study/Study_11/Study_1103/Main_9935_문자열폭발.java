package Study_1103;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Main_9935_문자열폭발 {
	public static void main(String[] args) {
		HashMap<Character, Integer > map = new HashMap<>();
//		map.put("송복민", 167);
//		System.out.println(map.get("송복민"));
//		map.put("송복민", 170);
//		System.out.println(map.get("송복민"));

//		if(map.containsKey("김영남")) {
//			System.out.println("있음");
//		}

		String s = "루루다루에다루";
		int size = 0; 
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
				map.put(c, 1);
		}
		System.out.println(map.size());
		
		//종류가 3개다..
		
//		int count [] = new int[size];
//		size = 0 ;
//		Iterator<Character> it = map.keySet().iterator();
//		while(it.hasNext()){
//			char cc = it.next();
//			System.out.println(cc);
//			System.out.println(map.get(cc));
//			count[size] = map.get(cc);
//			size++;
//		}
//		System.out.println(Arrays.toString(count));
	
		
	}
}
