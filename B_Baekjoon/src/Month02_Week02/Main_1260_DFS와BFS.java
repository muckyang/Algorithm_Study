package Month02_Week02;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1260_DFS와BFS {
	static int matrix[][];
	static int matrix_b[][];
	static int flag[];
	static int flag_b[];
	static int N, C, C_b, sp, x, y;
	static Queue<Integer> que;
	static int k = 0;
	static int cntt;
	public static void DFS(int mat[][], int[] f, int sp, int count) {
		if (count == 0) {
			return;
		} else {
			for (int i = 0; i < N; i++) {
				if (mat[sp][i] == 1 && f[i] == 0) {
					f[i] = 1;
					System.out.print(i + 1 + " ");
					DFS(mat, f, i, count - 1);
				}
			}
		}
	}

	public static void BFS(int mat[][], int f[], int sp, int count) {
		int check = 0;
		for (int i = 0; i < N; i++) {
			if ((mat[sp][i] == 1 && f[i] == 0)) { // 아직 방문 안함 간선 남아있음
				f[i] = 1;
				que.offer(i);
			}
		}
		while (!que.isEmpty()) {
			if(check== 0) {
				check=1;
				cntt++;
			}
			System.out.print(que.peek() + 1 + " ");
			BFS(mat, f, que.poll(), count);
		
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		C = C_b = sc.nextInt();
		sp = sc.nextInt() - 1;

		matrix = new int[N][N];
		flag = new int[N];
		cntt=0;
		que = new LinkedList<>();
		for (int i = 0; i < C; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			matrix[x - 1][y - 1] = 1;
			matrix[y - 1][x - 1] = 1;
		}
		flag[sp] = 1;
		System.out.print(sp + 1 + " ");
		DFS(matrix, flag, sp, C);
		System.out.println();
		
		flag = new int[N];
		flag_b = new int[N];
		flag_b[sp] = 1;
		System.out.print(sp + 1 + " ");
		BFS(matrix, flag_b, sp, C_b);
		System.out.println();
		System.out.println(cntt);
	}
}
