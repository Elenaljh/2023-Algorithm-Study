package BFS;

import java.io.*;
import java.util.*;
public class B10026 {
    static int n;
    static boolean[][] visitedB, visitedN;
    static char[][] blind;
    static char[][] normal;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visitedB = new boolean[n][n]; visitedN = new boolean[n][n];
        blind = new char[n][n]; normal = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = line.charAt(j);
                normal[i][j] = c;
                if (c == 'R') {
                    blind[i][j] = 'G';
                } else {
                    blind[i][j] = c;
                }
            }
        }
        int resultN = 0; int resultB = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visitedN[i][j] && normal[i][j] == 'R') {
                    bfs(i, j, 'R', visitedN, normal);
                    resultN++;
                }
                if (!visitedN[i][j] && normal[i][j] == 'G') {
                    bfs(i, j, 'G', visitedN, normal);
                    resultN++;
                }
                if (!visitedN[i][j] && normal[i][j] == 'B') {
                    bfs(i, j, 'B', visitedN, normal);
                    resultN++;
                }
                if (!visitedB[i][j] && blind[i][j] == 'G') {
                    bfs(i, j, 'G', visitedB, blind);
                    resultB++;
                }
                if (!visitedB[i][j] && blind[i][j] == 'B') {
                    bfs(i, j, 'B', visitedB, blind);
                    resultB++;
                }
            }
        }
        System.out.println(resultN + " " + resultB);
    }

    static void bfs(int x, int y, char color, boolean[][] visited, char[][] map) {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Integer[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (!visited[nx][ny] && map[nx][ny] == color) {
                        q.add(new Integer[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
