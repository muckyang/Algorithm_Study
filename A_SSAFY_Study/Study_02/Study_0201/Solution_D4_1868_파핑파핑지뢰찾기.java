package Study_0201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
 
 
public class Solution_D4_1868_파핑파핑지뢰찾기 {
    static int[][] matrix;
    static char[][] mine;
    static boolean[][] flag;
    static int[] dx = {  0, 1, 0,-1, 1,-1,-1, 1 };
    static int[] dy = { -1,0, 1, 0,-1,-1, 1, 1 };
 
    static int T;
    static int N;
    static int count;
 
    public static int check_8Way(int x, int y, int check) {
        int count_this = 0;
        if (check == 1) {
            for (int d = 0; d < 8; d++) {
                if (x + dx[d] >= 0 && y + dy[d] >= 0 && x + dx[d] < N && y + dy[d] < N
                        && mine[x + dx[d]][y + dy[d]] == '*')
                    count_this++;
                 
            }
        } else {
            for (int d = 0; d < 8; d++) {// 8방에 0 이 있으면 
                if (x + dx[d] >= 0 && y + dy[d] >= 0 && x + dx[d] < N && y + dy[d] < N
                        && matrix[x + dx[d]][y + dy[d]] == 0)
                    count_this++;
            }
        }
        return count_this;
    }
 
    public static void DFS(int x, int y) {
 
        for (int d = 0; d < 8; d++) {
            if (x + dx[d] >= 0 && y + dy[d] >= 0 && x + dx[d] < N && y + dy[d] < N 
                    && matrix[x + dx[d]][y + dy[d]] == 0
                    && flag[x + dx[d]][y + dy[d]] == false) {
                flag[x + dx[d]][y + dy[d]] = true;
                DFS(x + dx[d], y + dy[d]);
            }
        }
        return;
 
    }
 
    public static void main(String[] args) throws NumberFormatException, IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            count = 0;
            matrix = new int[N][N];
            flag = new boolean[N][N];
            mine = new char[N][N];
 
            for (int i = 0; i < N; i++) { // 지뢰 입력받음
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    mine[i][j] = s.charAt(j);
                }
            }
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (mine[i][j] == '*') { // 지뢰라면
                        matrix[i][j] = -1;
                        flag[i][j] = true;
                    } else {
                        if ( mine[i][j] == '.'  && check_8Way(i, j, 1) > 0) { //지뢰가 하나라도 있으면
                            matrix[i][j] = 1;
                            count++;
                        }
                     
                    }
 
                }
            }
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (flag[i][j] == false && matrix[i][j] == 1
                            && check_8Way(i, j, 0) == 0) {// 0이 하나도 없으면(단독클릭)
                        flag[i][j] = true;
                    } else if (flag[i][j] == false && matrix[i][j] == 1
                            && check_8Way(i, j, 0) != 0) {
                        count--;
                        flag[i][j] = true;
                    }
 
                }
            }
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j ++) {
                    if (matrix[i][j] == 0 && flag[i][j] == false) {
                        count++;
                        flag[i][j] = true;
                        DFS(i, j);
                    }
                }
            }
 
 
            System.out.println("#" + test_case + " " + count);
        }
    }
 
}