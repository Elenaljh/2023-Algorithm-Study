package 스터디;
/*
별찍기 - 11
https://www.acmicpc.net/problem/2448
 */
import java.util.*;
import java.io.*;

public class B2448 {
    static boolean[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        map = new boolean[n][2*n-1];
        draw(n, 0, n-1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2*n-1; j++) {
                if (map[i][j]) sb.append("*");
                else sb.append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static void draw(int n, int r, int c) {
        //별그리기
        if (n == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = c-i; j <= c+i; j++) {
                    if (i == 1 && j == c) continue;
                    map[r+i][j] = true;
                }
            }
            return;
        }
        //n > 3*2^k (k>0)일때
        //1. 상단
        draw(n/2, r, c);
        //2. 좌측 하단, 우측 하단
        draw(n/2, r+n/2, c-1-(n-1)/2);
        draw(n/2, r+n/2, c+1+(n-1)/2);
    }
}
