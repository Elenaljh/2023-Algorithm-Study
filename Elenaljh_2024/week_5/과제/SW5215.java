package 과제;
/*
햄버거 다이어트
 */

import java.io.*;
import java.util.*;

public class SW5215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            //입력
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //재료 수
            int L = Integer.parseInt(st.nextToken()); //제한 칼로리
            int[][] table = new int[N][2]; //맛점수, 칼로리 표
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                table[i][0] = Integer.parseInt(st.nextToken()); //맛점수
                table[i][1] = Integer.parseInt(st.nextToken()); //칼로리
            }

            //로직 - 비트마스킹 사용
            int max = 0, cal, happiness;
            for (int i = 1; i < (1<<N); i++) {
                cal = 0; happiness = 0;
                for (int j = 0; j < N-1; j++) {
                    if ((i&(1<<j)) != 0) {
                        happiness += table[j][0];
                        cal += table[j][1];
                    }
                }
                if (cal <= L) {
                    max = Integer.max(max, happiness);
                }
            }
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}
