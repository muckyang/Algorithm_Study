package Pass_Feb;
import java.util.Scanner;

public class Main_2804_크로스워드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		int ATarget = -1;
		int BTarget = -1;

		for (int i = 0; i < B.length(); i++) {
			for (int j = 0; j < A.length(); j++) {
				if (B.charAt(i) == A.charAt(j)) {
					ATarget = i;
					BTarget = j;
					break;
				}
			}
			if (ATarget != -1)
				break;
		}

		for (int i = 0; i < B.length(); i++) {
			for (int j = 0; j < A.length(); j++) {
				if (i == ATarget)
					System.out.print(A.charAt(j));
				else if( j == BTarget)
					System.out.print(B.charAt(i));
				else
					System.out.print(".");

			}
			System.out.println();
		}
	}
}
