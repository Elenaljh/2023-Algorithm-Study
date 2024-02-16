package 과제;
/*
과제: 미로2
 */
import java.io.*;
import java.util.*;
public class SW1227 {
    static int EX, EY;
    static boolean[][] visited;
    static int[][] map;
    static Queue<Integer[]> q = new ArrayDeque<>();
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            sb.append("#").append(Integer.parseInt(br.readLine())).append(" ");
            map = new int[100][100];
            visited = new boolean[100][100];
            for (int i = 0; i < 100; i++) {
                String str = br.readLine();
                for (int j = 0; j < 100; j++) {
                    int part = str.charAt(j) - '0';
                    map[i][j] = part;
                    if (part == 2) {
                        q.add(new Integer[]{i, j});
                        visited[i][j] = true;
                    } else if (part == 3) {
                        EX = i; EY = j;
                    }
                }
            }
            if (bfs()) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        System.out.println(sb);
    }

    static boolean bfs() {
        boolean flag = false;
        while (!q.isEmpty()) {
            Integer[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100) {
                    if ((map[nx][ny] == 0 || map[nx][ny] == 3) && !visited[nx][ny]) {
                        if (nx == EX && ny == EY) {
                            flag = true;
                        }
                        q.add(new Integer[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        if (flag) return true;
        else return false;
    }
}
