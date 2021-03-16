import java.util.Scanner;
 
public class Jungol_1169_주사위던지기1 {
	 static int[] num;
	 
	    public static void func1(int N, int R, int count) {
	 
	        if (R == count) {
	            for (int s : num)
	                System.out.print(s + " ");
	            System.out.println();
	        } else {
	            for (int i = 1; i <= N; i++) {
	                num[count] = i;
	                func1(N, R, count + 1);
	            }
	        }
	    }
	 
	    public static void func2(int N, int R, int flag, int count) {
	        if (R == count) {
	            for (int s : num)
	                System.out.print(s + " ");
	            System.out.println();
	        } else {
	            for (int i = flag; i <= N; i++) {
	                num[count] = i;
	                func2(N, R, i, count + 1);
	 
	            }
	        }
	    }
	 
	    public static void func3(int N, int R, int flag, int count) {
	        if (R == count) {
	            for (int s : num)
	                System.out.print(s + " ");
	            System.out.println();
	        } else {
	            for (int i = 1; i <= N; i++) {
	                if( (flag & 1 << i) != 0) {
	                    continue;
	                }
	                if((flag & 1<<i) == 0 ) {
	                    num[count] = i;
	                    func3(N, R, flag | 1 << i, count + 1);
	                }
	            }
	        }
	    }
	 
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int N, M; // 2<= N <=5
	 
	        N = sc.nextInt();// 주사위 던진수
	        M = sc.nextInt();// 게임모드
	        num = new int[N];
	        // M=1 전체 경우
	        // M=2 순열
	        // M=3 조합
	        switch (M) {
	        case 1:
	            func1(6, N, 0);
	            break;
	 
	        case 2:
	            func2(6, N, 1, 0);
	            break;
	 
	        case 3:
	            func3(6, N, 0, 0);
	            break;
	 
	        default:
	            System.out.println(" 입력오류");
	 
	        }
	    }
}
