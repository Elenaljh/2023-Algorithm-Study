package 과제;
/*
색종이
https://www.acmicpc.net/problem/2563
 */

import java.io.*;
import java.util.*;

public class B2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); //색종이 개수
        int count = 0; //색종이 넓이
        boolean[][] paper = new boolean[100][100];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            for (int j = row; j < row+10; j++) {
                for (int k = col; k < col+10; k++) {
                    if (!paper[j][k]) {
                        count++;
                        paper[j][k] = true;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
