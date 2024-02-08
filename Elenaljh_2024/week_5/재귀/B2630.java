package 재귀;

import java.util.*;
import java.io.*;
/*
색종이 만들기
 */
public class B2630 {
    static int white, blue, paper[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        countPapers(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }

    static void countPapers(int r, int c, int n) {
        int color = paper[r][c]; //1은 파랑, 0은 하양
        if (inspect(r, c, n, color)) {
            if (color == 1) blue++;
            if (color == 0) white++;
            return;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                countPapers(r+(i*n/2), c+(j*n/2), n/2);
            }
        }

    }

    static boolean inspect(int r, int c, int n, int color) {
        for (int i = r; i < r+n; i++) {
            for (int j = c; j < c+n; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
