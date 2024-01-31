package 과제;

import java.io.*;
import java.util.*;

public class SW1954 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < t; testCase++) {

            //초기 세팅
            boolean plus = true;
            int num = 1;
            int x = 0, y = 0;
            int n = Integer.parseInt(br.readLine());
            int[][] snail = new int[n][n];

            //맨 윗줄 출력
            for (int i = 0; i < n; i++) {
                snail[y][x] = num;
                x++;
                num++;
            }
            x--;
            plus = false;

            //나머지 출력
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n-i; j++) {
                    if (plus) {
                        y--;
                        snail[y][x] = num;
                        num++;
                    } else {
                        y++;
                        snail[y][x] = num;
                        num++;
                    }
                }
                for (int j = 0; j < n-i; j++) {
                    if (plus) {
                        x++;
                        snail[y][x] = num;
                        num++;
                    } else {
                        x--;
                        snail[y][x] = num;
                        num++;
                    }
                }
                plus = !plus;
            }

            sb.append("#").append(testCase+1).append("\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(snail[i][j]).append(" ");
                }
                sb.deleteCharAt(sb.length()-1);
                sb.append("\n");
            }

        } //end of TestCase
        System.out.println(sb);
    }
}
