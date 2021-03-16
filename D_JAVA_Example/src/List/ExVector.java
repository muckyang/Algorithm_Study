package List;

import java.util.Vector;

//ArrayList와 동일한 내부구조를 갖지만 멀티스레드 환경에서 동기화된다는 점이 다르고
//단일 스레드에서도 동기화가 되기에 조금 느리다는 단점이 있다.

//선형구조이며 인덱스로 관리하기 때문에 검색이 빠르다는 장점이 있지만,
//추가 삭제시 모든 인덱스를 관리해주어야 하기에 오래걸린다는 단점이 있다.

public class ExVector {
	public static void main(String[] args) {
		Vector<Integer> list = new Vector<>();
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

		System.out.println(cnt);
	}
}
