package 숙제;
/*
알파벳
 */

import java.io.*;
import java.util.*;
public class B1987 {
    static int R, C, MAX = 1;
    static Character[][] map;
    static int[][] visited;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static List<Character> alphabets = new ArrayList<>();
    static Queue<Integer[]> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new Character[R][C];
        visited = new int[R][C];
        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }
        for (int i = 0; i < R; i++) Arrays.fill(visited[i], -1);
        q.add(new Integer[]{0,0});
        visited[0][0] = 1;
        alphabets.add(map[0][0]);

        bfs();
        System.out.println(MAX);
    }

    static void bfs() {
        while(!q.isEmpty()) {
            Integer[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (visited[nx][ny] == -1 && !alphabets.contains(map[nx][ny])) { //같은 계층에서 추가된 알파벳의 경우 따로 관리해줘야 함
                        q.add(new Integer[]{nx, ny});
                        visited[nx][ny] = visited[now[0]][now[1]] + 1;
                        alphabets.add(map[nx][ny]);
                        MAX = Integer.max(visited[nx][ny], MAX);
                    }
                }
            }
        }
    }
}
