package 과제;

import java.io.*;
import java.util.*;
public class B11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //표 크기
        int m = Integer.parseInt(st.nextToken()); //테스트케이스

        int[][] numbers = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                numbers[i][j] = numbers[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }
        int sum;
        for (int t = 0; t < m; t++) {
            sum = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = x1; i <= x2; i++) {
                sum += numbers[i][y2] - numbers[i][y1-1];
            }
            sb.append(sum).append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
