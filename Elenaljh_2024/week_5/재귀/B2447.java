package 재귀;
/*
별찍기 10
https://www.acmicpc.net/problem/2447
 */

import java.util.*;
import java.io.*;
public class B2447 {
    static boolean[][] picture;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        picture = new boolean[n][n];
        draw(0, 0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j]) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void draw(int r, int c, int n) {
        if (n == 1) {
            picture[r][c] = true;
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                draw(r+(i*n/3), c+(j*n/3), n/3);
            }
        }
    }

}
