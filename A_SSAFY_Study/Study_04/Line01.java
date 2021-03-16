import java.util.StringTokenizer;

public class Line01 {
	
	static int list[];
	static int res;
	static boolean check;
    public static void main(String[] args) {
    	String InputString = "123";
		list = new int[4];
		
		res = 0;
		check = true;

		for(int i = 0 ; i < InputString.length() ; i++) {
			char c = InputString.charAt(i);
			if (c == '(') {
				list[0]++;
			} else if (c == ')') {
				if (list[0] == 0) {
					check = false;
					break;
				} else {
					list[0]--;
					res++;
				}
			}else if (c == '[') {
				list[1]++;
			} else if (c == ']') {
				if (list[1] == 0) {
					check = false;
					break;
				} else {
					list[1]--;
					res++;
				}
			}else if (c == '{') {
				list[2]++;
			} else if (c == '}') {
				if (list[2] == 0) {
					check = false;
					break;
				} else {
					list[2]--;
					res++;
				}
			}else if (c == '<') {
				list[3]++;
			} else if (c == '>') {
				if (list[3] == 0) {
					check = false;
					break;
				} else {
					list[3]--;
					res++;
				}
			}

		}
		if (check)
			System.out.println(res);
		else
			System.out.println(-1);

	}
//		static int list[];
//		static int res;
//		static boolean check;
//	
//		public static void main(String[] args) {
//			list = new int[4];
//			String InputString = "if (Count of eggs is 4.) {Buy milk.}";
//			StringTokenizer st = new StringTokenizer(InputString);
//			res = 0;
//			check = true;
//	
//			while (st.hasMoreTokens()) {
//				char c = st.nextToken().charAt(0);
//				if (c == '(') {
//					list[0]++;
//				} else if (c == ')') {
//					if (list[0] == 0) {
//						check = false;
//						break;
//					} else {
//						list[0]--;
//						res++;
//					}
//				}else if (c == '[') {
//					list[1]++;
//				} else if (c == ']') {
//					if (list[1] == 0) {
//						check = false;
//						break;
//					} else {
//						list[1]--;
//						res++;
//					}
//				}else if (c == '{') {
//					list[2]++;
//				} else if (c == '}') {
//					if (list[2] == 0) {
//						check = false;
//						break;
//					} else {
//						list[2]--;
//						res++;
//					}
//				}else if (c == '<') {
//					list[3]++;
//				} else if (c == '>') {
//					if (list[3] == 0) {
//						check = false;
//						break;
//					} else {
//						list[3]--;
//						res++;
//					}
//				}
//	
//			}
//			if (check)
//				System.out.println(res);
//			else
//				System.out.println(-1);
//	
//		}
}
