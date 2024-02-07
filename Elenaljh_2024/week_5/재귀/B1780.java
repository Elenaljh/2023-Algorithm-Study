package 재귀;
/*
https://www.acmicpc.net/problem/1780
종이의 개수
 */
import java.io.*;
import java.util.*;

public class B1780 {
    static int minus, zero, plus;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        paper(0, 0, 9);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }
    static void paper(int r, int c, int n) {
        int num = map[r][c];
        boolean same = inspect(r, c, n, num);

        //같으면 반환
        if (same) {
            if (num == -1) minus++;
            if (num == 0) zero++;
            if (num == 1) plus++;
            return;
        }

        //다르면 종이 9조각으로 나누기
        paper(r, c, n/3);
        paper(r+n/3, c, n/3);
        paper(r+2*n/3, c, n/3);
        paper(r, c+n/3, n/3);
        paper(r+n/3, c+n/3, n/3);
        paper(r+2*n/3, c+n/3, n/3);
        paper(r, c+2*n/3, n/3);
        paper(r+n/3, c+2*n/3, n/3);
        paper(r+2*n/3, c+2*n/3, n/3);
    }

    static boolean inspect(int r, int c, int n, int flag) {
        for (int i = r; i < r+n; i++) {
            for (int j = c; j < c+n; j++) {
                if (map[i][j] != flag) {
                    return false;
                }
            }
        }
        return true;
    }
}
