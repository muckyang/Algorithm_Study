package Ing;

import java.util.Scanner;

public class Solution_D3_1244_최대상금 {
	static int[] list;

	//같은수가 존재하는지 체크
	public static boolean isDupl(int[] list) {
		int[] arr = new int[10];
		for (int i = 0; i < list.length; i++) {
			arr[list[i]]++;
			if (arr[list[i]] > 1)
				return true;
		}
		return false;
	}

	
	public static void func(int change, int now, int count, boolean dupl) {
		int temp;
		int max_v = -1;

		if (count == change) {//횟수 도달시 리턴
			return;
		} else if (now == list.length) { // 현재상태가 가장 값이 높은데 횟수가 남은경우
			if ((change - count) % 2 == 0 || dupl) { // 리스트에 숫자중복이 있거나 횟수가 짝수번 남은 경우
				return;
			} else { // 마지막 두자리만 변경해서 손해를 최소화 한다.
				temp = list[list.length - 1];
				list[list.length - 1] = list[list.length - 2];
				list[list.length - 2] = temp;
				return;
			}
		} else {
			//가장 큰 값 찾기
			max_v = now;
			for (int i = now; i < list.length; i++) {
				max_v = list[max_v] <= list[i] ? i : max_v; // 등호를 빼면 동일값 있을시 먼저나오는게 선택됨 
			}

			if (max_v == now) {// 현재위치에 가장 큰 값이 온 경우. 다음자리로 패스
				func(change, now + 1, count, dupl);

			} else {// 가장 큰 값과 현재 타겟자리 값 swap해줌  
				temp = list[now];
				list[now] = list[max_v];
				list[max_v] = temp;
				func(change, now + 1, count + 1, dupl);// 변경 1회 발생 count + 1
			} 
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T;
		T = sc.nextInt();
		String S;
		int change;
		int result;
		for (int test_case = 1; test_case <= T; test_case++) {
			S = sc.next();
			change = sc.nextInt();
			list = new int[S.length()];//문자열 길이만큼 배열생성
			
			int K = Integer.parseInt(S); // 문자열을 int로 변환
			for (int i = 0; i < S.length(); i++) {
				
				if (S.charAt(i) == 48) {// 값이 0인 경우 예외처리
					list[i] = 0;
					K = (int) (K % Math.pow(10, (S.length() - i - 1)));
					continue;
				}
				//1~9값 몫, 나머지로 구분하고 진행
				list[i] = (int) (K / Math.pow(10, (S.length() - i - 1)));
				K = (int) (K % Math.pow(10, (S.length() - i - 1)));
			}
			
			func(change, 0, 0, isDupl(list));

			String S_result = " ";
			for (int i = 0; i < list.length; i++) {
				S_result += (int) list[i]; // 문자열 붙이기
			}

			System.out.println("#" + test_case + S_result);
		}
	}

}

//INPUT
//10
//123 1
//2737 1
//757148 1
//78466 2
//32888 2
//777770 5
//436659 2
//431159 7
//112233 3
//456789 10


//OUTPUT
//#1 321
//#2 7732
//#3 857147
//#4 87664
//#5 88832
//#6 777770
//#7 966354
//#8 954311
//#9 332211
//#10 987645
