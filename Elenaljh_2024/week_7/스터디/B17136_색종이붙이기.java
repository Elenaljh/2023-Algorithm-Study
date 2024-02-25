package 스터디;

import java.util.*;
import java.io.*;
public class B17136_색종이붙이기 {
    static boolean flag = true;
    static int[][] paper = new int[10][10];
    static int MIN = Integer.MAX_VALUE;
    static int[] numberOfPapers = new int[]{0, 5, 5, 5, 5, 5};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        if (MIN == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(MIN);
    }

    static void dfs(int x, int y, int count) {
        if (x > 9) {
            MIN = Integer.min(MIN, count);
            return;
        }

        if (count >= MIN) return;

        if (paper[x][y] == 1) {
            for (int size = 5; size >= 1; size--) {
                if (numberOfPapers[size] > 0 && canAttach(x, y, size)) {
                    attach(x, y, size, 0); //붙이기

                    if (y+1 < 10) dfs(x, y+1, count+1); //탐사
                    else dfs(x+1, 0, count+1);

                    attach(x, y, size, 1); //떼기
                }
            }
        } else {
            if (y+1 < 10) dfs(x, y+1, count); //탐사
            else dfs(x+1, 0, count);
        }
    }

    static boolean canAttach(int x, int y, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (x+i >= 10 || y+j >= 10) return false;
                if (paper[x+i][y+j] == 0) return false;
            }
        }
        return true;
    }

    static void attach(int x, int y, int size, int color) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                paper[x+i][y+j] = color;
            }
        }
        if (color == 0) numberOfPapers[size]--;
        else numberOfPapers[size]++;
    }
}
