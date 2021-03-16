package Study_0312;

import java.util.StringTokenizer;

public class chulseok {
	public static void main(String[] args) {
		String s = "@임도현(대전6반), @박수철(대전6반), @노휘종(대전6반), @어석진(대전6반), @김호준(대전6반), @장진우(대전6반), @김민주(대전6반), @이진용(대전6반), @조용우(대전6반), @윤영현(대전6반), @장한별(대전6반), @정아영(대전6반), @박화중(대전6반), @손예지(대전6반), @전병규(대전6반), @송복민(대전6반), @유성준(대전6반), @김영남(대전6반), @김수현(대전6반), @이석기(대전6반), @김영호(대전6반), @이재인(대전6반), @길훈성(대전6반), @이동현(대전6반) and @이대길(대전6반) ";
		String[] list = { "손예지", "이진용", "노휘종", "윤영현", "정아영", "임도현", "이석기", "유성준", "길훈성", "김영남", "김수현", "김영호", "송복민",
				"이동현", "박화중", "장진우", "임지민", "김민주", "김호준", "어석진", "이재인", "이대길", "장한별", "박재림", "박수철", "전병규", "조용우" };
		boolean[] check = new boolean[27];
		StringTokenizer st = new StringTokenizer(s, " ");
		while (st.hasMoreTokens()) {
			String k = st.nextToken();
			if (k.equals("and"))
				continue;
			k = k.substring(1, 4);
			for (int i = 0; i < 27; i++) {
				if (k.equals(list[i]) && !check[i]) {
					check[i] = true;
					break;
				}
			}
		}
		System.out.println(list.length);
		for(int i = 0 ;  i < 27 ; i++) {
			if(!check[i])
				System.out.println(list[i]);
		}
	}
}
