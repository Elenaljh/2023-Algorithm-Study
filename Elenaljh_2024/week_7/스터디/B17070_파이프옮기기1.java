package 스터디;

import java.io.*;
import java.util.*;

public class B17070_파이프옮기기1 {
    static int N, COUNT = 0;
    static int[][] house;
    static int[] dx = new int[]{0, 1, 1}; //오른쪽, 대각선 아래, 아래
    static int[] dy = new int[]{1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        house = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        perm(0, 1, 0);

        System.out.println(COUNT);
    }

    static void perm(int x, int y, int status) {
        if (x == N-1 && y == N-1) {
            COUNT++;
            return;
        }

        if (status == 0) { //현재 파이프 방향: 가로
            if (checkRight(x, y)) {
                house[x][y+1] = 5;
                perm(x, y+1, 0);
                house[x][y+1] = 0;
            }
            if (checkHorizontal(x, y)) {
                house[x+1][y+1] = 5;
                perm(x+1, y+1, 1);
                house[x+1][y+1] = 0;
            }
        } else if (status == 1) { //현재 파이프 방향: 대각선
            if (checkRight(x, y)) {
                house[x][y+1] = 5;
                perm(x, y+1, 0);
                house[x][y+1] = 0;
            }
            if (checkDown(x, y)) {
                house[x+1][y] = 5;
                perm(x+1, y, 2);
                house[x+1][y] = 0;
            }
            if (checkHorizontal(x, y)) {
                house[x+1][y+1] = 5;
                perm(x+1, y+1, 1);
                house[x+1][y+1] = 0;
            }
        } else { //현재 파이프 방향: 세로
            if (checkDown(x, y)) {
                house[x+1][y] = 5;
                perm(x+1, y, 2);
                house[x+1][y] = 0;
            }
            if (checkHorizontal(x, y)) {
                house[x+1][y+1] = 5;
                perm(x+1, y+1, 1);
                house[x+1][y+1] = 0;
            }
        }
    }

    static boolean checkRight(int x, int y) {
        int nx = x + dx[0];
        int ny = y + dy[0];
        if (nx < N && ny < N && house[nx][ny] == 0) return true;
        return false;
    }

    static boolean checkDown(int x, int y) {
        int nx = x + dx[2];
        int ny = y + dy[2];
        if (nx < N && ny < N && house[nx][ny] == 0) return true;
        return false;
    }

    static boolean checkHorizontal(int x, int y) {
        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= N || ny >= N || house[nx][ny] != 0) return false;
        }
        return true;
    }


}
