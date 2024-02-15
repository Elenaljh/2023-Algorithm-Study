package 스터디;

/*
N-Queen
https://www.acmicpc.net/problem/9663
 */
import java.io.*;
public class B9663 {
    static int n, count=0;
    static int[] chess;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        chess = new int[n];
        queen(0);
        System.out.println(count);
    }

    static void queen(int depth) {
        if (depth == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            chess[depth] = i; //index: 행, i: 열
            if (!inspect(depth)) continue;
            queen(depth+1);
        }
    }

    static boolean inspect(int depth) {
        if (depth == 0) return true;
        //신규 row = depth, col = chess[depth]
        for (int i = depth-1; i >= 0; i--) {
            //비교대상 col = chess[i], row = i
            int alpha = Math.abs(depth-i); //행의 변화량
            int beta = Math.abs(chess[depth]-chess[i]); //열의 변화량
            if (chess[depth] == chess[i] || alpha==beta) return false;
        }
        return true;
    }
}
