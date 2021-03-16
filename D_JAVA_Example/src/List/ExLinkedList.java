package List;

import java.util.LinkedList;
//각 노드가 데이터와 포인터로 이루어져 있음.
// 삽입,삭제시에 빠른 장점이 있지만 검색할때도 순차적으로 검색하기에 느리다는 단점이 있다. 

public class ExLinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
//		int N = 10000;
		int N = 100000;
//		int N = 1000000;
		for (int i = 0; i < N; i++) {
			list.add(i);
		}
		int cnt = 0;

		System.out.println("For Each");
		long start = System.currentTimeMillis();
		for (Integer k : list) {
			cnt+=k;
		}
		System.out.println("연산시간 : " + (System.currentTimeMillis() - start));

		
		System.out.println("Get Method");
		start = System.currentTimeMillis();
		for (int k = 0; k < N; k++) {
			cnt+= list.get(k);
		}
		System.out.println("연산시간 : " + (System.currentTimeMillis() - start));

		
		System.out.println("Add Method");
		start = System.currentTimeMillis();
		for (int k = 0; k < 10000; k++) {
			list.add(k,k);
		}
		System.out.println("연산시간 : " + (System.currentTimeMillis() - start));

		System.out.println(""+ cnt);
	}
}
