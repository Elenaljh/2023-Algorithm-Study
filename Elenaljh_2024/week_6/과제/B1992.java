package 과제;
/*
쿼드트리
https://www.acmicpc.net/problem/1992
 */
import java.io.*;
public class B1992 {
    static int[][] movie;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        movie = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                movie[i][j] = str.charAt(j) - '0';
            }
        }
        quadTree(0, 0, n);
        System.out.println(sb);
    }
    static void quadTree(int r, int c, int n) {
        if (inspect(r, c, n)) {
            if (movie[r][c] == 1) sb.append(1);
            if (movie[r][c] == 0) sb.append(0);
            return;
        }

        sb.append("(");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                quadTree(r+i*n/2, c+j*n/2, n/2);
            }
        }
        sb.append(")");
    }

    static boolean inspect(int r, int c, int n) {
        int color = movie[r][c];
        for (int i = r; i < r+n; i++) {
            for (int j = c; j < c+n; j++) {
                if (movie[i][j] != color) return false;
            }
        }
        return true;
    }
}
