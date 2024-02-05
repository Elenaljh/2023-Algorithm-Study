package BFS;
/*
https://www.acmicpc.net/problem/7569
토마토
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7569 {
    static int m, n, h;
    static int min = 0;
    static int[][][] tomatoes;
    static int[][][] days;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static int[] dz = new int[]{1, -1};
    static Queue<Integer[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        tomatoes = new int[h][n][m];
        days = new int[h][n][m];

        //tomatoes, days 초기화
        for (int z = 0; z < h; z++) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(days[z][i], -1);
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    tomatoes[z][i][j] = Integer.parseInt(st.nextToken());
                    if (tomatoes[z][i][j] == 1) {
                        days[z][i][j] = 0;
                        q.add(new Integer[]{z, i, j});
                    }
                }
            }
        }

        bfs();

        for (int z = 0; z < h; z++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (tomatoes[z][i][j] == 0 && days[z][i][j] == -1) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(min);

    }

    static void bfs() {
        while (!q.isEmpty()) {
            Integer[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[1] + dx[i];
                int ny = now[2] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (days[now[0]][nx][ny] == -1 && tomatoes[now[0]][nx][ny] == 0) {
                        q.add(new Integer[]{now[0], nx, ny});
                        days[now[0]][nx][ny] = days[now[0]][now[1]][now[2]] + 1;
                        min = days[now[0]][nx][ny];
                    }
                }
            }
            for (int z : dz) {
                int nz = now[0] + z;
                if (nz >= 0 && nz < h) {
                    if (days[nz][now[1]][now[2]] == -1 && tomatoes[nz][now[1]][now[2]] == 0) {
                        q.add(new Integer[]{nz, now[1], now[2]});
                        days[nz][now[1]][now[2]] = days[now[0]][now[1]][now[2]] + 1;
                        min = days[nz][now[1]][now[2]];
                    }
                }
            }
        }

    }
}
