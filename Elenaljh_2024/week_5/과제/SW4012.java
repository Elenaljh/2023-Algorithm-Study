package 과제;
/*
요리사
 */
import java.io.*;
import java.util.*;
public class SW4012 {
    static boolean[] isSelected;
    static int[][] table;
    static int min, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t<=T; t++) {
            //입력
            n = Integer.parseInt(br.readLine());
            table = new int[n][n];
            isSelected = new boolean[n];
            min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    table[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //로직
            cook(0, 0);
            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }

    static void cook(int cnt, int start) {
        if (cnt == n/2) {
            int diff = calcDiffAbs();
            min = Integer.min(min, diff);
            return;
        }
        for (int i = start; i < n; i++) {
            isSelected[i] = true;
            cook(cnt+1,i+1);
            isSelected[i] = false;
        }
    }

    static int calcDiffAbs() {
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isSelected[i] == true && isSelected[j] == true) {
                    sumA += table[i][j];
                } else if (isSelected[i] == false && isSelected[j] == false){
                    sumB += table[i][j];
                }
            }
        }
        return Math.abs(sumA - sumB);
    }
}
