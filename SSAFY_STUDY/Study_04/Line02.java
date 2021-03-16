import java.util.LinkedList;
import java.util.Queue;

public class Line02 {
	public static void main(String[] args) {
		String road = "001100100";
		int n = 5;
		int su = n;
		int first = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		int len = 0;
		int res = 0;
		for (int i = 0; i < road.length(); i++) {
			int c = road.charAt(i);
			if (c == '1') {
				len++;
			} else {
				if (su == 0 && n != 0) {
					first = q.poll();
					len -= first +1 ;
					q.add(i);
					su++;
				}
				if (su > 0) {
					len++;
					q.add(i);
					su--;
				}
				if( n== 0){
					len = 0;
				}
			}
			if (res < len)
				res = len;
		}
		System.out.println(res);

	}
}
