package 과제;

import java.io.*;
import java.util.*;

public class B16935 {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < r; i++) {
            int command = Integer.parseInt(st.nextToken());
            int numRow = map.length;
            int numCol = map[0].length;
            switch (command) {
                case 1:
                    first(numRow, numCol);
                    break;
                case 2:
                    second(numRow, numCol);
                    break;
                case 3:
                    third(numRow, numCol);
                    break;
                case 4:
                    fourth(numRow, numCol);
                    break;
                case 5:
                    fifth(numRow, numCol);
                    break;
                case 6:
                    sixth(numRow, numCol);
            }
        }

        int numRow = map.length;
        int numCol = map[0].length;
        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numCol; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void first(int n, int m) {
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            copy[n-i-1] = map[i];
        }
        map = copy;
    }
    static void second(int n, int m) {
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = map[i][m-j-1];
            }
        }
        map = copy;
    }
    static void third(int n, int m) {
        int[][] copy = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[j][n-i-1] = map[i][j];
            }
        }
        map = copy;
    }
    static void fourth(int n, int m) {
        int[][] copy = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[m-j-1][i] = map[i][j];
            }
        }
        map = copy;
    }
    static void fifth(int n, int m) {
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i < n/2 && j < m/2) { //1
                    copy[i][j+m/2] = map[i][j];
                } else if (i < n/2 && j >= m/2) { //2
                    copy[i+n/2][j] = map[i][j];
                } else if (i >= n/2 && j >= m/2) { //3
                    copy[i][j-m/2] = map[i][j];
                } else { //4
                    copy[i-n/2][j] = map[i][j];
                }
            }
        }
        map = copy;
    }

    static void sixth(int n, int m) {
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i < n/2 && j < m/2) { //1
                    copy[i+n/2][j] = map[i][j];
                } else if (i < n/2 && j >= m/2) { //2
                    copy[i][j-m/2] = map[i][j];
                } else if (i >= n/2 && j >= m/2) { //3
                    copy[i-n/2][j] = map[i][j];
                } else { //4
                    copy[i][j+m/2] = map[i][j];
                }
            }
        }
        map = copy;
    }
}
