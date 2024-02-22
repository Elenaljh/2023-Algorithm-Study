package 숙제;
/*
알파벳
 */

import java.io.*;
import java.util.*;
public class B1987 {
    static int R, C, MAX = 0;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) map[i] = br.readLine().toCharArray();

        visited[0][0] = true;
        dfs(1, 0,0, 1<<map[0][0]-'A');
        System.out.println(MAX);
    }

    static void dfs(int depth, int r, int c, int bit) {
        MAX = Integer.max(MAX, depth);
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                if (!visited[nx][ny] && (bit&1<<map[nx][ny]-'A') == 0) {
                    dfs(depth+1, nx, ny, bit|(1<<map[nx][ny]-'A'));
                    visited[nx][ny] = false;
                }
            }
        }
    }


}
