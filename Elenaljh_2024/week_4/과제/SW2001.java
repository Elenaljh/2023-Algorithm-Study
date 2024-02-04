package 과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW2001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int testCase = 1; testCase <= t; testCase++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] map = new int[n+1][n+1];
            for (int i = 1; i < n+1; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j < n+1; j++) {
                    map[i][j] = map[i-1][j] + map[i][j-1] - map[i-1][j-1] + Integer.parseInt(st.nextToken());
                }
            }

            //최댓값 구하기
            int max = 0;
            int sum = 0;
            for (int i = m; i <= n; i++) {
                for (int j = m; j <= n; j++) {
                    sum = map[i][j] - map[i-m][j] - map[i][j-m] + map[i-m][j-m];
                    max = Math.max(max, sum);
                }
            }

            //값 저장
            sb.append("#").append(testCase).append(" ").append(max).append("\n");
        }

        //출력
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
